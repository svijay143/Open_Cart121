package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators
	
	@FindBy(id="input-firstname")
	WebElement txtFirstname;
	
	@FindBy(id="input-lastname")
	WebElement txtlastname;
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-telephone")
	WebElement txttelephone;
	
	@FindBy(id="input-password")
	WebElement txtpwd;
	
	@FindBy(id="input-confirm")
	WebElement txtpwdconfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdpolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btncontinue;	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;	
	
	//Action methods
	
	public void SetFirstname (String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void Setlasttname (String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void Setemail (String mail)
	{
		txtemail.sendKeys(mail);
	}
	
	public void SetTelephone (String phone)
	{
		txttelephone.sendKeys(phone);
	}
	
	public void Setpassword (String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void Confirmpassword (String cpwd)
	{
		txtpwdconfirm.sendKeys(cpwd);
	}
	
	public void ClickCheckbox ()
	{
		chkdpolicy.click();
	}
	
	public void clickcontbtn ()
	{
		btncontinue.click();
	}
	
	public String getmsgconfirmation ()
	{
		return msgconfirmation.getText();
	}
	
}
