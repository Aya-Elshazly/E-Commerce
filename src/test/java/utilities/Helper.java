package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	//take screenshot when test case fail
	public static void takesScreenshot(WebDriver driver,String screenShotName){
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+screenShotName+".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
			e.printStackTrace();
		}
	}

}
