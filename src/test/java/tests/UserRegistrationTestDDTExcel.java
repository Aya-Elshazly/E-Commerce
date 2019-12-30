package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestDDTExcel extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="exceldata")
	public Object[][] userRegisterData() throws IOException{
		ExcelReader er=new ExcelReader();
	    return er.getExcelData();
		
	}
	
	@Test(priority=1,alwaysRun=true,dataProvider="exceldata")
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
	}
	

}
