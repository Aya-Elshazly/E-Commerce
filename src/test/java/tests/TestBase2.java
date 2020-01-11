package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.TestProperties;
import utilities.Helper;



public class TestBase2 {
	public static String BaseURL="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver=null;
    //sauce configuration
	public static final String USERNAME=TestProperties.sauceLabsData.getProperty("username");
	public static final String ACCESSKEY=TestProperties.sauceLabsData.getProperty("accesskey");
	public static final String SAUCEURL="http://"+USERNAME+":"+ACCESSKEY+
			TestProperties.sauceLabsData.getProperty("seleniumURL");
	@BeforeMethod 
	@Parameters(value={"browser"})
	public void setup(@Optional("chrome") String browser) throws MalformedURLException{
		driver=new ThreadLocal<>();
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		//selenium grid local
		//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		//run on saucelabs on cloud
		driver.set(new RemoteWebDriver(new URL(SAUCEURL), caps));
		getDriver().navigate().to(BaseURL);

	}
	public WebDriver getDriver(){
		return driver.get();
	}
	@AfterMethod
	public void stopDriver(){
		getDriver().quit();
		driver.remove();

	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			System.out.println("failed");
			System.out.println("Taking screenshot.......");
			Helper.takesScreenshot(getDriver(), result.getName());
			
		}
	}

}
