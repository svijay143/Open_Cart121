package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class my_account_page extends BasePage {

	public my_account_page(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtmyaccount;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btncontinue;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlog_out;
	
	//Action methods
	
	public boolean myaccounttab()   // MyAccount Page heading display status
	{
		try {
			return (txtmyaccount.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void cliclogout()
	{
		btnlog_out.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
}
