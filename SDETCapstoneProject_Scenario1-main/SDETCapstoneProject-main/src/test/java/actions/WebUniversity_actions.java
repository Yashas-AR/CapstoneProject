package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.WebDriverUniversity_Elements;
import test.CommonSteps;

public class WebUniversity_actions {
	private WebDriver driver;
	WebDriverUniversity_Elements webDriverUniversityElements;

	public WebUniversity_actions(CommonSteps commonSteps){
		this.driver=commonSteps.getDriver();
		webDriverUniversityElements=new WebDriverUniversity_Elements(this.driver);
	}
	
	public void clickIFRAMELink() {
		webDriverUniversityElements.iFramelink.click();
	}
	
	public void switchToFrame() {
		 WebElement iframe = webDriverUniversityElements.iframeIFrame;
         driver.switchTo().frame(iframe);
	}
	
	public void switchTab() {
		 Object[] windowHandles=driver.getWindowHandles().toArray();
	     driver.switchTo().window((String) windowHandles[1]);
	}
	
	public WebElement getActiveImage() {
		return webDriverUniversityElements.activeImage;
	}
	
	public void clickRightArrow() {
		webDriverUniversityElements.rightArrow.click();
	}
}
