package utilitypom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenCap {
	static RemoteWebDriver driver;
	
	public static String takeSnap( String screenshotName){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String Destination="./reports/screenshots/"+screenshotName+".png";
		File dest=new File(Destination);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("couldnt copy from src file or empty source file");
		}
		System.out.println("screenshot taken");
		return Destination;
	}

}
