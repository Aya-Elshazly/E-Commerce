package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData=new Faker();
	String firstname=fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(8).toString();
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,password);
		System.out.println("user data is"+"  "+firstname+"  "+lastname+"  "+email+"  "+password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
	}
	

}
