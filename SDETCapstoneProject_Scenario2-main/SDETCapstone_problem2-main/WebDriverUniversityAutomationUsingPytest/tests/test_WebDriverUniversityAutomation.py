import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from pages.WebDriverUniversity_IndexPage import IndexPage
from pages.WebDriverUniversity_Dropdown_checkboxPage import DropdownPage

def test_launchURLAndClickOnDropDown_CheckBox_RadioLink(driver):
    indexPage=IndexPage(driver)
    indexPage.open_Page("http://webdriveruniversity.com/index.html")
    assert "Automation & AI Testing Courses by Gianni Bruno" in indexPage.get_PageTitle()
    indexPage.click_dropdown_checkboxes_RadioButton_Link()

    # Tab Switching as onclicking dropdown, checkbox and radio button link it will invoke new tab
    windows= driver.window_handles
    driver.switch_to.window(windows[1])
    dropdownPage=DropdownPage(driver)
    print(dropdownPage.get_PageTitle())
    assert "WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)" in dropdownPage.get_PageTitle()
    # Programming Language Dropdown
    dropdownPage.select_ProgrammingDropDownValue("C#")
    selectedValue1=dropdownPage.getSelected_ProgrammingDropDownValue()
    assert selectedValue1=="C#"
    # IDE Dropdown
    dropdownPage.select_IDEDropDownValue("Maven")
    selectedValue2=dropdownPage.getSelected_IDEDropDownValue()
    assert selectedValue2=="Maven"
    # Scripting Language Dropdown
    dropdownPage.select_ScriptingDropDownValue("JQuery")
    selectedValue3=dropdownPage.getSelected_ScriptingDropDownValue()
    assert selectedValue3=="JQuery"

    # Checkbox Selection
    dropdownPage.select_CheckBox(1)
    dropdownPage.select_CheckBox(2)
    print("Count of Checked Checkboxes: ", dropdownPage.getCount_CheckedCheckboxes())
    print("Count of Unchecked Checkboxes: ", dropdownPage.getCount_UnCheckedCheckboxes())
    assert dropdownPage.getCount_CheckedCheckboxes() == 3
    assert dropdownPage.getCount_UnCheckedCheckboxes() == 1

    # Radio Button Selection
    dropdownPage.select_RadioButton("orange")
    assert dropdownPage.getSelected_RadioButtonValue("orange") == True

    #Note: I think no need of checking count as we can able to select only one radion button at a time
    
    
