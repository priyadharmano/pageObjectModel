package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilitypom.SupportClass;

public class OrangeHrmLoginTest extends SupportClass {
	@BeforeClass
	public void setUp(){
		
		testCaseName="Login";
		category="smoke";
		workbookName="pomworkbook";
		//sheetname="logindata";
		
	}
	@Test(dataProvider="fetchdata")
	public void login(String username,String password){
		
		
		new LoginPage(driver, test)
		
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton();
	}
}
