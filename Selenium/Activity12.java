package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {
//	Using Selenium:
//
//Open a new browser to https://training-support.net/webelements/dynamic-content
//Get the title of the page and print it to the console.
//On the page, perform:

//Wait till the word "release" appears.
//Get the text and print it to console.
//Close the browser.

		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/dynamic-content");
		System.out.println(driver.getTitle());
		//Find and click the "Click me!" button.
		driver.findElement(By.id("genButton")).click();
		//Wait till the word "release" appears.
		WebElement wordElement=driver.findElement(By.id("word"));
		wait.until(ExpectedConditions.textToBePresentInElement(wordElement,"release"));//gettext is not possible bec it is returning boolean value and not webelement
		System.out.println(wordElement.getText());
		driver.quit();
		
	}

}
