package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Log_in;
import testCases.BaseClass;
import PageObjects.my_account_page;
import utilities.Data_Providers;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC003_Login_DDT extends BaseClass {

	@Test (dataProvider= "Logindata", dataProviderClass=Data_Providers.class, groups= "Data driven")  //Getting data provider from the different class
	public void veryfy_login(String username, String password, String exp)
	{
		logger.info("****** Starting TC_002_Login Test ******");
		
		try{
		//HomePage
		HomePage hp= new HomePage(driver);
		hp.Clickmyaccount();
		hp.clicklogin();
		
		//Login page
		Log_in lin= new Log_in(driver);
		lin.entermail(username);
		lin.enterpass(password);
		lin.clicklogin();
		
		//myaccount
		
		my_account_page mac= new my_account_page(driver);
		
		boolean targetPage=mac.myaccounttab();
		
		if (exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				mac.cliclogout();
				mac.clickcontinue();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if (exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				mac.cliclogout();
				mac.clickcontinue();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
	}
}
