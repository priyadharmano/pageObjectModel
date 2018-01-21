package wrappers;


public interface PomInterface {
	
	
	public void invokeApp(String browser);

	public void enterById(String idVal,String data,String snam);
	
	public void enterByXpath(String xpathVal,String data);
	
	public void enterByName(String nameVal,String data);
	
	public void enterByClassName(String classVal,String data);
	
	public boolean verifyTitle(String title);
	
	public void verifyTextById(String id,String text);
	
	public void verifyTextByXpath(String xpath,String text);
	
	
	public void verifyTextContainsByXpath(String xpath, String text);
	
	public void verifyTextContainsById(String id, String text);
	
	public void clickById(String id);
	
	public void clickByXpath(String xpath);
	
	public void clickByClassname(String classname);
	
	public void clickByLink(String name);
	
	public String getTextById(String id);
	
	public String getTextByXpath(String xpath);
	
	public void selectVisibileTextById(String id, String value);
	
	public void selectIndexById(String id, int value);
	
	public void switchToParentWindow();
	
	public void switchToLastWindow();

	public void acceptAlert();
	
	public void quitBrowser();
}
