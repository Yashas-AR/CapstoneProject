
Feature: WebDriverUniversity WebPage Testing

  Scenario: Title of the page
    Given I am on 'http://webdriveruniversity.com/index.html' page
    Then verify the title of page 'Automation & AI Testing Courses by Gianni Bruno | WebDriver University'

  Scenario: verify new tab is opened and image is shown 
    Given I am on 'http://webdriveruniversity.com/index.html' page
    When I Click on IFRAME link
    Then New tab is open and verify the title of page 'WebDriver | IFrame'
    And Image is present
    When I Click right arrow button
    Then Images are changing accordingly
	
 