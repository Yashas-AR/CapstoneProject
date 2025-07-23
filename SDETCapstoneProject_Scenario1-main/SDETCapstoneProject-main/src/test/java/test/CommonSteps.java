package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonSteps {

private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shiva\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
		Thread.sleep(1000);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
