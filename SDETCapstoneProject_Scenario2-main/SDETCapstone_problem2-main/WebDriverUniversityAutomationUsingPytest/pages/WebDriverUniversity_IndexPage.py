from selenium.webdriver.common.by import By

class IndexPage:
    def __init__(self, driver):
        self.driver=driver
        self.dropdown_Checkboxes_RadioButtons_link=(By.XPATH,"//h1[normalize-space()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")

    def open_Page(self, url):
        self.driver.get(url)

    def get_PageTitle(self):
        return self.driver.title
    
    def click_dropdown_checkboxes_RadioButton_Link(self):
        self.driver.find_element(*self.dropdown_Checkboxes_RadioButtons_link).click()



