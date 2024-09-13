package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.HomePage;
import PageObjects.Log_in;
import PageObjects.my_account_page;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;

public class TC002_Login_Test extends BaseClass {

	@Test (groups= {"Sanity", "Master"})
	public void veryfy_login()
	{
		logger.info("****** Starting TC_002_Login Test ******");
		
		try {
		//HomePage
		HomePage hp= new HomePage(driver);
		hp.Clickmyaccount();	
		hp.clicklogin();
		
		//Login page
		Log_in li= new Log_in(driver);
		li.entermail(p.getProperty("email"));
		li.enterpass(p.getProperty("password"));
	    
		li.clicklogin();
		
		//myaccount
		
		my_account_page mac= new my_account_page(driver);
		
		boolean targetPage=mac.myaccounttab();
		mac.cliclogout();
		mac.clickcontinue();
		
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_login_test****");
		}
	
		
	}
