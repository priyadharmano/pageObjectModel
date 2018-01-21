package utilitypom;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrappers.BaseClass;

public abstract class ReportExtentPom {
	public static ExtentReports report;
	public static ExtentTest test;
	static RemoteWebDriver driver;
	
	public static void reportStep(String description,String status, String screenshotName){
		
		
		String imagepath = BaseClass.takeSnap(screenshotName);
		
		if (status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.PASS,  description+test.addScreenCapture("./../reports/screenshots/"+screenshotName+".png"));
		}
		if (status.toUpperCase().equals("FAIL")) {
			test.log(LogStatus.FAIL,  description+test.addScreenCapture("./../reports/screenshots/"+screenshotName+".png"));
		}
		if (status.toUpperCase().equals("INFO")) {
			test.log(LogStatus.INFO,  description+test.addScreenCapture("./../reports/screenshots/"+screenshotName+".png"));
		}
		
	}
	
	public ExtentReports startResult(){
		 report=new ExtentReports("./reports/extentreport.html");
		
		 return report;
	}
	
	public void endResult(){
		
		report.flush();
	}
	
	public ExtentTest startTest(String testCaseName){
		 test = report.startTest(testCaseName);
		 return test;
		 
	}
	
	public void endTest(){
		report.endTest(test);
		
	}
}
