package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.searchPage;

public class ChangeCurrencyTest extends TestBase{
	HomePage homeObject ; 
	ProductDetailsPage detailsObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	searchPage searchObject ; 

	@Test(priority=1)
	public void userCanChangeCurrency(){
		homeObject=new HomePage(driver);
		homeObject.changeCurrency();
		
	}
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException{
		searchObject = new searchPage(driver); 
		searchObject.productSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver); 
		Assert.assertEquals(detailsObject.productname.getText(), productName);
		Assert.assertTrue(detailsObject.productname.getText().contains("Ђ"));
		System.out.println(detailsObject.productname.getText());
		
	}

}
