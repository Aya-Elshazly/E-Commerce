package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration("Aya", "Elshazly", "aya.elshazly66@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods={"userCanRegisterSucessfull"})
	public void RegisterUserCanLogout(){
		registerObject.userLogout();
	}
	@Test(dependsOnMethods={"RegisterUserCanLogout"})
	public void RegisteredUserCanLogin(){
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		loginObject.userLogin("aya.elshazly11@gmail.com", "12345678");
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
		
	}

}
