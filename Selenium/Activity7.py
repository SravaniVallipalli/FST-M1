# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://training-support.net/webelements/dynamic-controls")
    print("page title is ",driver.title)
    #find the textbox
    textbox=driver.find_element(By.ID,"textInput")