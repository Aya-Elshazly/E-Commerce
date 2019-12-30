package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends PageBase{

	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Change password")
	WebElement changePassword;
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxtBox;
	@FindBy(id="NewPassword")
	WebElement newPasswordTxtBox;
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBox;
	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;
	@FindBy(css="div.result")
	public WebElement passwordChanged;
	
	public void openChangePasswordPage(){
		clickButton(changePassword);
	}
	public void changePassword(String oldPassword,String newPassword){
		setTextElement(oldPasswordTxtBox, oldPassword);
		setTextElement(newPasswordTxtBox, newPassword);
		setTextElement(confirmNewPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);
	}

}
