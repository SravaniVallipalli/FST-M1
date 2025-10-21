package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println(driver.getTitle());
		//Find the username field using any locator and enter "admin" into it.
		driver.findElement(By.id("username")).sendKeys("admin");
		//Find the password field using any locator and enter "password" into it.
		driver.findElement(By.id("password")).sendKeys("password");

		//Find the "Log in" button using any locator and click it.
		driver.findElement((By.xpath("//button[text()='Submit']"))).click();
		//Close the browser.
		driver.close();
	}

}
