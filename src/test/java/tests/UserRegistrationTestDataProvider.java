package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestDataProvider extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public static Object[][] userData(){
		return new Object[][]{
				{"Aya", "Elshazly", "aya.elshazly1183@gmail.com", "12345678"},
				{"Aya", "Elshazly", "aya.elshazly1169@gmail.com", "12345678"}
				};

	}
	@Test(priority=1,dataProvider="testData")
	public void userCanRegisterSucessfull(String fname,String lname,String email,String password) throws InterruptedException{
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
		registerObject.userLogout();
	}

	

}
