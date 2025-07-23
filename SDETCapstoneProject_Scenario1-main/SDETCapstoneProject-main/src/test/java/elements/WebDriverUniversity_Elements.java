package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebDriverUniversity_Elements {

WebDriver driver;
	
	@FindBy(xpath="//h1[normalize-space()='IFRAME']") public WebElement iFramelink;
	@FindBy(xpath="//div[@class='item active']//img[@class='slide-image']") public WebElement activeImage;
	@FindBy(id="frame") public WebElement iframeIFrame;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-chevron-right']") public WebElement rightArrow;

	public WebDriverUniversity_Elements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
