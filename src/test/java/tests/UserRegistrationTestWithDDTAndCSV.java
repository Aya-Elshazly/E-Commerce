package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test(priority=1)
	public void userCanRegisterSucessfull() throws InterruptedException, IOException{
		String CSV_File=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserDataCSV.csv";
		reader=new CSVReader(new FileReader(CSV_File));
		String[] csvCell;
		while ((csvCell=reader.readNext())!=null) {
			String fname=csvCell[0];
			String lname=csvCell[1];
			String email=csvCell[2];
			String password=csvCell[3];


			homeObject=new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject=new UserRegistrationPage(driver);
			registerObject.userRegistration(fname,lname,email,password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			registerObject.userLogout();
			homeObject.clickOnLoginBtn();
			loginObject=new LoginPage(driver);
			loginObject.userLogin("aya.elshazly11@gmail.com", "12345678");
			Assert.assertTrue(registerObject.icoLogout.getText().contains("Log out"));
		}
	}


}
