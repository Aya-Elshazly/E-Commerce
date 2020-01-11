package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.TestProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestDDTPropertiesFile extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	String fname=TestProperties.userData.getProperty("firstname");
	String lname=TestProperties.userData.getProperty("lastname");
	String email=TestProperties.userData.getProperty("email");
	String password=TestProperties.userData.getProperty("password");


	

	
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods={"userCanRegisterSucessfull"})
	public void RegisterUserCanLogout(){
		registerObject.userLogout();
	}
	@Test(dependsOnMethods={"RegisterUserCanLogout"})
	public void RegisteredUserCanLogin() throws InterruptedException{
		Thread.sleep(2000);
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
		
	}

}
