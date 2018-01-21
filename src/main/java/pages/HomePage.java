package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(RemoteWebDriver driver,ExtentTest test){
		
		this.driver=driver;
		this.test=test;
		
		if (verifyTitle("OrangeHM")) {
			
			reportStep("title not matched", "FAIL", "title");
		}
	}

	
	
}
