package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println(driver.getTitle());
		//Find the username field using any locator and enter "admin" into it.
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		//Find the password field using any locator and enter "password" into it.
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");

		//Find the "Log in" button using any locator and click it.
		driver.findElement((By.xpath("//button[text()='Submit']"))).click();
		//Close the browser.
		
		WebElement loginTextElement=driver.findElement(By.xpath("//h2[text()='Welcome Back, Admin!']"));
		String logintext=loginTextElement.getText();
		System.out.println(logintext);
		driver.close();

	}

}
