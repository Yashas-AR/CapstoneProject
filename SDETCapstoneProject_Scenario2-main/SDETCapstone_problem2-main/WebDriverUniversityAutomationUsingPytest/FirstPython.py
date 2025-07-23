from selenium import webdriver
from pages.WebDriverUniversity_IndexPage import IndexPage
driver = webdriver.Chrome()
driver.maximize_window()
driver.get("http://webdriveruniversity.com/index.html")
print(driver.current_url)

driver.quit()





     