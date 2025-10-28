"""
Using Selenium:

Open a new browser to https://training-support.net/webelements/login-form/
Get the title of the page and print it to the console.
Find the username field using any locator and enter "admin" into it.
Find the password field using any locator and enter "password" into it.
Find the "Log in" button using any locator and click it.
Close the browser.
"""
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    print(f"Page title is: {driver.title}")
    username=driver.find_element(By.ID,"username")
    password=driver.find_element(By.ID,"password")
    
    username.send_keys("admin")
    password.send_keys("password")
    login=driver.find_element(By.xpath,"//button[text()='Submit']")
    login.click
    loginmessage=driver.find_element(By.CSS_SELECTOR,"h1.text-center")
    print("login message is :", loginmessage.text)