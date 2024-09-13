package testCases;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import junit.framework.Assert;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test (groups= {"Regression", "Master"})
	public void verify_account_Registration()
	{
		
		try {
		logger.info("**** Starting TC001_AccountRegistrationTest");
		HomePage hp = new HomePage(driver);
		
		hp.Clickmyaccount();
		logger.info("Clicked on Myaccountlink");
		
		hp.ClickRegister();
		logger.info("Clicked on RegresterLink");
		
		AccountRegistrationPage acp= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		acp.SetFirstname(randomString().toUpperCase());
		acp.Setlasttname(randomString().toUpperCase());
		acp.Setemail(randomString()+"@gmail.com");
		acp.SetTelephone(randomNumber());
		
		String Password= randomAlphanumeric();
		acp.Setpassword(Password);
		acp.Confirmpassword(Password);
		
		acp.ClickCheckbox();
		acp.clickcontbtn();
		
		logger.info("Validating Expected message");
		String confirmationmsg =acp.getmsgconfirmation();
		
		if (confirmationmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test case falied");
			logger.debug("Debug_Logs");
			Assert.assertFalse(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
	}
}
