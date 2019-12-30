package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyaccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyaccountPage myaccountObject;
	String oldPassword="12345678";
	String newPassword="23456789";
	String fName="Aya";
	String lName="Elshazly";
	String email="aya.elshazly1@gmail.com";
	
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fName,lName,email,oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(priority=2)
	public void RegisteredUserCanChangePassword(){
		myaccountObject=new MyaccountPage(driver);
		registerObject.openMyAccount();
		myaccountObject.openChangePasswordPage();
		myaccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myaccountObject.passwordChanged.getText().contains("Password was changed"));
		
	}
	@Test(priority=3)
	public void RegisterUserCanLogout(){
		registerObject.userLogout();
	}
	@Test(priority=4)
	public void RegisteredUserCanLogin(){
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,newPassword);
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
		
	}

}
