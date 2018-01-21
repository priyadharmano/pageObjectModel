package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilitypom.SupportClass;
import wrappers.BaseClass;

public class LoginPage extends SupportClass{
	
	public LoginPage(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if (verifyTitle("OrangeHRM")) {
			
			reportStep("title is matching", "PASS", "title");
		}
		
	}
	
	public LoginPage enterUsername(String data){
		//enterById("txtUsername", data);
		enterById("txtUsername", data, "username");
		return this;	
	}

	public LoginPage enterPassword(String data){
		
		enterById("txtPassword", data);
		return this;	
	}
	
	public HomePage clickLoginButton(){
		
		clickById("btnLogin");
		return new HomePage(driver, test);
	}
}
