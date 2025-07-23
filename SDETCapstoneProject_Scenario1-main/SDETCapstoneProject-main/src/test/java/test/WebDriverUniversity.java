package test;

import static org.junit.Assert.fail;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import actions.Common_Actions;
import actions.WebUniversity_actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebDriverUniversity {

	Common_Actions commomActions;
	WebUniversity_actions webDriverUniversityActions;
	
	public WebDriverUniversity(Common_Actions commomActions, WebUniversity_actions webDriverUniversityActions) {
		this.commomActions=commomActions;
		this.webDriverUniversityActions=webDriverUniversityActions;
	}
	String firstImgSrc;
	
	@Given("I am on {string} page")
	public void i_am_on_page(String webDriverUniversityURL) {
		commomActions.goToURL(webDriverUniversityURL);
	}

	
	@Then("verify the title of page {string}")
	public void verify_the_title_of_page(String expPageTitle) {
		String actPageTitle=commomActions.getTitle();
		if(!actPageTitle.equals(expPageTitle)) {
			   fail("The Home Page Title is not matching");
		   }
		Assert.assertEquals(actPageTitle, expPageTitle);
	}
	

	@When("I Click on IFRAME link")
	public void i_click_on_iframe_link() {
		webDriverUniversityActions.clickIFRAMELink();
	}
	
	@Then("New tab is open and verify the title of page {string}")
	public void new_tab_is_open_and_verify_the_title_of_page(String expectedIFrameTitle) throws InterruptedException {
		webDriverUniversityActions.switchTab();
		 String actIFrameTitle=commomActions.getTitle();
			if(!actIFrameTitle.equals(expectedIFrameTitle)) {
				   fail("The IFrame Title is not matching");
			}
			Assert.assertEquals(actIFrameTitle, expectedIFrameTitle);
			Thread.sleep(3000);
	}


	@Then("Image is present")
	public void image_is_present() {
		webDriverUniversityActions.switchToFrame();
		WebElement activeImg=webDriverUniversityActions.getActiveImage();
		if(!activeImg.isDisplayed()){
			  //fail("The image is not showing");
			Assert.fail("The image is not showing");
		  }
		  firstImgSrc=activeImg.getCssValue("src");
	}
	

	@When("I Click right arrow button")
	public void i_click_right_arrow_button() throws InterruptedException {
		webDriverUniversityActions.clickRightArrow();
		  Thread.sleep(5000);
	}
	

	@Then("Images are changing accordingly")
	public void images_are_changing_accordingly() {
		WebElement activeImg= webDriverUniversityActions.getActiveImage();
		String imgSrc=activeImg.getAttribute("src");
		if(firstImgSrc.equals(imgSrc)) {
			//fail("The images are not changing");
			Assert.fail("The image is not showing");
		}
		
	}
}
