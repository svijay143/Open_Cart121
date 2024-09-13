package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Log_in extends BasePage {

	public Log_in (WebDriver driver)
	{
		super(driver);
	}
	
	//All locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	//Action methods
	
	public void entermail(String email)
	{
		txtmail.sendKeys(email);
	}
	
	public void enterpass(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
}
