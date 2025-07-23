
from selenium.webdriver.support.select import Select
from selenium.webdriver.common.by import By
from pages.WebDriverUniversity_IndexPage import IndexPage

class DropdownPage(IndexPage):
    programmingLanguage=(By.ID,"dropdowm-menu-1")
    ide=(By.ID,"dropdowm-menu-2")
    scriptingLang=(By.ID,"dropdowm-menu-3")

    checkbox1=(By.XPATH,"//div[@id='checkboxes']//label[1]//input")
    checkbox2=(By.XPATH,"//div[@id='checkboxes']//label[2]//input")
    checkbox3=(By.XPATH,"//div[@id='checkboxes']//label[3]//input")
    checkbox4=(By.XPATH,"//div[@id='checkboxes']//label[4]//input")

    allCheckboxes=(By.XPATH,"//div[@id='checkboxes']//input[@type='checkbox']")

    radioButtonGreen=(By.XPATH,"//input[@value='green']")
    radioButtonBlue=(By.XPATH,"//input[@value='blue']")
    radioButtonYellow=(By.XPATH,"//input[@value='yellow']")
    radioButtonOrange=(By.XPATH,"//input[@value='orange']")
    radioButtonPurple=(By.XPATH,"//input[@value='purple']")

    def select_ProgrammingDropDownValue(self,value):
       selectValue=Select(self.driver.find_element(*self.programmingLanguage))
       selectValue.select_by_visible_text(value)

    def getSelected_ProgrammingDropDownValue(self):
        selectValue=Select(self.driver.find_element(*self.programmingLanguage))
        return selectValue.first_selected_option.text
    
    def select_IDEDropDownValue(self,value):
       selectValue=Select(self.driver.find_element(*self.ide))
       selectValue.select_by_visible_text(value)

    def getSelected_IDEDropDownValue(self):
        selectValue=Select(self.driver.find_element(*self.ide))
        return selectValue.first_selected_option.text
    
    def select_ScriptingDropDownValue(self,value):
       selectValue=Select(self.driver.find_element(*self.scriptingLang))
       selectValue.select_by_visible_text(value)

    def getSelected_ScriptingDropDownValue(self):
        selectValue=Select(self.driver.find_element(*self.scriptingLang))
        return selectValue.first_selected_option.text
    
    def select_CheckBox(self,value):
        match value:
            case 1: self.driver.find_element(*self.checkbox1).click()
            case 2: self.driver.find_element(*self.checkbox2).click()
            case 3: self.driver.find_element(*self.checkbox3).click()
            case 4: self.driver.find_element(*self.checkbox4).click()

    def getCount_CheckedCheckboxes(self):
        count=0
        for checkbox in self.driver.find_elements(*self.allCheckboxes):
            if checkbox.is_selected():
                count += 1
        return count
    
    def getCount_UnCheckedCheckboxes(self):
        return (len(self.driver.find_elements(*self.allCheckboxes)) - self.getCount_CheckedCheckboxes())
    
    def select_RadioButton(self,value):
        match value.lower():
            case "green":
                self.driver.find_element(*self.radioButtonGreen).click()
            case "blue":
                self.driver.find_element(*self.radioButtonBlue).click()
            case "yellow":
                self.driver.find_element(*self.radioButtonYellow).click()
            case "orange":
                self.driver.find_element(*self.radioButtonOrange).click()
            case "purple":
                self.driver.find_element(*self.radioButtonPurple).click()

    def getSelected_RadioButtonValue(self,value):
        return self.driver.find_element(By.XPATH, "//input[@value='"+value+"']").is_selected() 
    
                
            
            
        

