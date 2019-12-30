package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="gender-male")
	WebElement gender;
	
	@FindBy(id="FirstName")
	WebElement fNameTxtBox;
	
	@FindBy(id="LastName")
	WebElement lNameTxtBox;
	@FindBy(id="Email")
	WebElement emailTxtBox;
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	@FindBy(id="ConfirmPassword")
	WebElement confirmpasswordTxtBox;
	@FindBy(id="register-button")
	WebElement registerButton;
	@FindBy(linkText="Log out")
	public WebElement icoLogout;
	@FindBy(css="div.result")
	public WebElement successMessage ; 
	@FindBy(linkText="My account")
	public WebElement myaccount;
	
	public void userRegistration(String fname,String lname,String email,String password) throws InterruptedException {
		//fNameTxtBox.sendKeys(fname);
		gender.click();
		Thread.sleep(3000);
		setTextElement(fNameTxtBox, fname);
		setTextElement(lNameTxtBox, lname);
		setTextElement(emailTxtBox, email);
		setTextElement(passwordTxtBox, password);
		setTextElement(confirmpasswordTxtBox, password);
		registerButton.click();
	}
	public void userLogout(){
		clickButton(icoLogout);
	}
	public void openMyAccount(){
		clickButton(myaccount);
	}

}
