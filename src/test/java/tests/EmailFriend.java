package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.UserRegistrationPage;
import pages.searchPage;

public class EmailFriend extends TestBase{
	//1.user registration
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Aya", "Elshazly", "aya.elshazly5@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	//2.search for product
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException{
		searchObject=new searchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("mac");
		Assert.assertTrue(detailsObject.productname.getText().equalsIgnoreCase(productName));
		
	}
	//3.email a friend
	@Test(priority=3)
	public void registeredUserCanSendProductToFriend(){
		detailsObject=new ProductDetailsPage(driver);
		detailsObject.openSendEmail();
		emailObject=new EmailFriendPage(driver);
		emailObject.SendEmailToFriend("maha12@gmail.com", "mmmmmmmmmmmmm");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	//4.user can logout
	@Test(priority=4)
	public void RegisterUserCanLogout(){
		registerObject.userLogout();
	}
	
	

}
