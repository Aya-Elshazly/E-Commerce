package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException, FileNotFoundException, IOException, ParseException{
		JsonReader reader=new JsonReader();
		reader.jsonReader();
		homeObject=new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject=new UserRegistrationPage(driver);
		registerObject.userRegistration(reader.fname,reader.lname,reader.email,reader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.clickOnLoginBtn();
		loginObject=new LoginPage(driver);
		loginObject.userLogin(reader.email,reader.password);
		Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
	}

}
