package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	//Created a contructor and extends with BasePage methods
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Finding the locators
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnlogin;
	
	//Create action methods
	
	public void Clickmyaccount()
	{
		lnkMyaccount.click();
	}
	
	public void ClickRegister()
	{
		lnkRegister.click();
	}
	
	public void clicklogin()
	{
		lnlogin.click();
	}
}

