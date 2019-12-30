package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FullName")
	WebElement fullNameTxtBox;
	@FindBy(id="Email")
	WebElement emailTxtBox;
	@FindBy(id="Enquiry")
	WebElement enquiryTxtBox;
	@FindBy(css="input.button-1.contact-us-button")
	WebElement contactUsBtn;
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	public void contactUs(String fullname,String email,String message){
		setTextElement(fullNameTxtBox, fullname);
		setTextElement(emailTxtBox, email);
		setTextElement(enquiryTxtBox, message);
		clickButton(contactUsBtn);
	}

}
