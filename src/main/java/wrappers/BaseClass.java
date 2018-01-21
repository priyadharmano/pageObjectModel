package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utilitypom.ReportExtentPom;

public class BaseClass extends ReportExtentPom implements PomInterface {

	public static  RemoteWebDriver driver;
	public String surl,primWindowHandle;
	
	
	public BaseClass(){
		
		Properties prop=new Properties();
		
		try {
			prop.load(new FileInputStream(new File("./objectprop/config.property")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		surl=prop.getProperty("url");
	}
	public void invokeApp(String browser) {
		
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				 driver=new ChromeDriver();
				 
			}
			
			else if (browser.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 
				 driver.get(surl);
				 
				 primWindowHandle=driver.getWindowHandle();
				 
				reportStep("the brower :"  +  browser  +"  is launched and url loaded", "PASS", browser);
		} catch (Exception e) {
			
			reportStep("the browser"+ browser +"  could not launched", "FAIL", browser);
		}
			 
		
		
	}

	public void enterById(String idVal, String data) {
		
		driver.findElementById(idVal).clear();
		driver.findElementById(idVal).sendKeys(data);
		
		reportStep("the data"+   data+"is entered successfuly in"+  idVal+  "elemnt", "PASS",data);
		
	}

	public void enterByXpath(String xpathVal, String data) {

		driver.findElementById(xpathVal).clear();
		driver.findElementById(xpathVal).sendKeys(data);
		
		reportStep("the data"+   data+"is entered successfuly in"+  xpathVal+  "elemnt", "PASS", data);
		
	}

	public void enterByName(String nameVal, String data) {

		driver.findElementById(nameVal).clear();
		driver.findElementById(nameVal).sendKeys(data);
		
		reportStep("the data"+   data+"is entered successfuly in"+  nameVal+  "elemnt", "PASS", data);
		
	}

	public void enterByClassName(String classVal, String data) {

		driver.findElementById(classVal).clear();
		driver.findElementById(classVal).sendKeys(data);
		
		reportStep("the data"+   data+"is entered successfuly in"+  classVal+  "elemnt", "PASS", data);
		
	}

	public boolean verifyTitle(String title) {
		
		boolean bReturn=false;
		if (driver.getTitle().equals(title)) {
			
			reportStep("title of the page matched with value"+ title, "PASS", title);
			bReturn=true;
		}
		else{
			
			reportStep("title of the page"+driver.getTitle()+"not matched with the value"+ title, "FAIL", title);
		}
		
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		
		String actualText=driver.findElementById(id).getText();
		
		if (actualText.equalsIgnoreCase(text)) {
			
			reportStep("text in the id field"+  id + "is matching with the given text"+  text, "PASS", actualText);
		} else {
			
			reportStep("text in the id field"+  id + "is not matching with the given text"+  text, "FAIL", actualText);
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		String actualText=driver.findElementByXPath(xpath).getText();
		
		if (actualText.equalsIgnoreCase(text)) {
			
			reportStep("text in the id field"+  xpath + "is matching with the given text"+  text, "PASS", actualText);
		} else {
			
			reportStep("text in the id field"+  xpath + "is not matching with the given text"+  text, "FAIL", actualText);
		}
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
	
		String actualText=driver.findElementByXPath(xpath).getText();
		
		if (actualText.contains(text)) {
			
			reportStep("text in the id field"+  xpath + "is contains  the given text"+  text, "PASS", actualText);
		} else {
			
			reportStep("text in the id field"+  xpath + "is not contains with the given text"+  text, "FAIL", actualText);
		}
		
		
	}

	public void verifyTextContainsById(String id, String text) {
	
		String actualText=driver.findElementByXPath(id).getText();
		
		if (actualText.contains(text)) {
			
			reportStep("text in the id field"+  id + "is contains  the given text"+  text, "PASS", actualText);
		} else {
			
			reportStep("text in the id field"+  id + "is not contains  the given text"+  text, "FAIL", actualText);
		}
		
		
	}

	public void clickById(String id) {
		
		try {
			driver.findElementById(id).click();
			
			reportStep("the element with id value"+   id+" is clicked successfully", "PASS", id);
		} catch (Exception e) {
			
			reportStep("the element with id value"+   id+" could not be clicked", "FAIL", id);
		}
		
	}

	public void clickByXpath(String xpath) {
		try {
			driver.findElementByXPath(xpath).click();
			
			reportStep("the element with id value"+   xpath+" is clicked successfully", "PASS", xpath);
		} catch (Exception e) {
			
			reportStep("the element with id value"+   xpath+" could not be clicked", "FAIL", xpath);
		}
		
	}

	public void clickByClassname(String classname) {
	
		try {
			driver.findElementByClassName(classname).click();
			
			reportStep("the element with id value"+   classname+" is clicked successfully", "PASS", classname);
		} catch (Exception e) {
			
			reportStep("the element with id value"+   classname+" could not be clicked", "FAIL", classname);
		}
		
	}

	public void clickByLink(String name) {
	
		try {
			driver.findElementByLinkText(name).click();
			
			reportStep("the element with id value"+   name+" is clicked successfully", "PASS", name);
		} catch (Exception e) {
			
			reportStep("the element with id value"+   name+" could not be clicked", "FAIL", name);
		}
		
	}

	public String getTextById(String id) {
		
		String bReturn="";
		try {
			bReturn = driver.findElementById(id).getText();
			reportStep("the element with id value"+  id+ "got some text in return", "PASS", bReturn);
			return bReturn;
			
		} catch (Exception e) {
			reportStep("the element with id value"+  id+ "could not found", "FAIL", bReturn);
		}
		return bReturn;
	}

	public String getTextByXpath(String xpath) {
		String bReturn="";
		try {
			bReturn = driver.findElementById(xpath).getText();
			reportStep("the element with id value"+  xpath+ "got some text in return", "PASS", bReturn);
			return bReturn;
			
		} catch (Exception e) {
			reportStep("the element with id value"+  xpath+ "could not found", "FAIL", bReturn);
		}
		return bReturn;
	}

	public void selectVisibileTextById(String id, String value) {
		
		try {
			new Select(driver.findElementById(id)).selectByVisibleText(value);
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS", value);
		} catch (Exception e) {
			reportStep("The element with id: "+id+" could not be selected ", "FAIL", value);
		}
		
	}

	public void selectIndexById(String id, int value) {
		try {
			new Select(driver.findElementById(id)).selectByIndex(value);
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS", id);
		} catch (Exception e) {
			reportStep("The element with id: "+id+" could not be selected ", "FAIL", id);
		}
		
	}

	public void switchToParentWindow() {
		
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void quitBrowser() {
		driver.quit();
		
	}

	public static String takeSnap(String screenshotName){
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
	public void enterById(String idVal, String data, String snam) {
		// TODO Auto-generated method stub
		driver.findElementById(idVal).clear();
		driver.findElementById(idVal).sendKeys(data);
		
		reportStep("the data"+   data+"is entered successfuly in"+  idVal+  "elemnt", "PASS", snam);
		
	}

	

}
