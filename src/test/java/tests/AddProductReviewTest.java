package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.searchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	searchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	ProductReviewPage reviewObject ; 

	// 1- User Registration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws InterruptedException 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Moataz", "Nabil", "test199@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	// 2- Search For Product
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new searchPage(driver); 
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productname.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	// 3- Add review
	@Test(priority=3)
	public void RegisteredUserCanReviewProduct() throws InterruptedException 
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver); 
		reviewObject.AddProductReview("new reivew", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText()
				.contains("Product review is successfully added."));
	}

	// 4- User Logout
	@Test(priority=4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

}