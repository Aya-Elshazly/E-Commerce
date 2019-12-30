package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends PageBase{

	public searchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="small-searchterms")
	WebElement searchTextBox;
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String productName){
		setTextElement(searchTextBox, productName);
		clickButton(searchBtn);
	}
	public void openProductDetailsPage(){
		clickButton(productTitle);
	}
	public void productSearchUsingAutoSuggest(String searchTxt) throws InterruptedException{
		setTextElement(searchTextBox, searchTxt);
		Thread.sleep(3000);
		productList.get(0).click();
	}

}
