package utilitypom;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import wrappers.BaseClass;

/**
 * @author PRIYA
 *
 */
public class SupportClass extends BaseClass {
	
	public String testCaseName,category,sheetname,workbookName;
	
	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}
	@AfterSuite
	public void afterSuite(){
		
		endResult();
	}
	@BeforeMethod
	public void beforeMethod(){
		test=startTest(testCaseName);
		//test.assignCategory(category);
		invokeApp("chrome");
		
	}
	
	@AfterMethod
	public void afterMethod(){
		
		endTest();
		quitBrowser();
	}
	
	@DataProvider(name="fetchdata")
	public String[][] getData() throws IOException{
		
		return DataProvide2.getData(workbookName);
	}
	
}
