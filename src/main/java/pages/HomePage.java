package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		js=(JavascriptExecutor) driver;
		action=new Actions(driver);
	}

	@FindBy(xpath="//a[@class='ico-register']")
	WebElement register;
	@FindBy(linkText="Log in")
	WebElement loginBtn;
	@FindBy(linkText="Contact us")
	WebElement contactUsLink;
	@FindBy(id="customerCurrency")
	WebElement currencyDropdownList;
	
	@FindBy(linkText="Computers")
	WebElement computersMenu;
	@FindBy(linkText="Notebooks")
	WebElement notebooksMenu;


	public void openRegistrationPage(){
		clickButton(register);
	}
	public void clickOnLoginBtn(){
		clickButton(loginBtn);
	}
	public void openContactUsPage(){
		scrollToButton();
		clickButton(contactUsLink);
	}
	public void changeCurrency(){
		select=new Select(currencyDropdownList);
		select.selectByVisibleText("Euro");
	}
	public void selectNoteBookMenu() {
		
		action.moveToElement(computersMenu)
		.moveToElement(notebooksMenu)
		.click().build().perform();
	}

}
