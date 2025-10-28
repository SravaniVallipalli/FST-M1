from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://training-support.net")
    print(f"Page title is: {driver.title}")
    driver.find_element(By.LINK_TEXT,"About Us").click()
    print(f"new page title is: {driver.title}")
#driver.quit()
