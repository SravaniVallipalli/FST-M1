# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("page title is ",driver.title)
    #find the checkbox
    checkbox= driver.find_element(By.ID,"checkbox")
    #click the checkbox
    checkbox.click()
    #verify if checkbox is selected or not
    print("checkbox is visible: ", checkbox.is_selected())
    checkbox.click()
    #verify if checkbox is selected or not
    print("checkbox is visible: ", checkbox.is_selected())
