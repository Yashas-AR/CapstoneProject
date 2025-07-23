package actions;

import org.openqa.selenium.WebDriver;

import test.CommonSteps;


public class Common_Actions {
private WebDriver driver;
	
	public Common_Actions(CommonSteps commonsteps){
		this.driver=commonsteps.getDriver();
	}

	public void goToURL(String url) {
		driver.get(url);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();	
	}
	
	public void quitWebDriver() {
		driver.quit();
	}

}
