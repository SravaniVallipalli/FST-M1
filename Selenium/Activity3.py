from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Chrome() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    print(f"Page title is: {driver.title}")
    username=driver.find_element(By.XPATH,"//input[@name='username']")
    password=driver.find_element(By.XPATH,"//input[@name='password']")
    
    username.send_keys("admin")
    password.send_keys("password")
    login=driver.find_element(By.XPATH,"//button[text()='Submit']")
    login.click
    loginmessage=driver.find_element(By.CSS_SELECTOR,"h1.text-center")
    print("login message is :", loginmessage.text)