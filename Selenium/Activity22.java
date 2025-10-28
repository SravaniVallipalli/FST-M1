package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/popups");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("page title is " + driver.getTitle());
//		Find the button on the page and click it to launch the popup.
		driver.findElement(By.id("launcher")).click();
//		Wait for the popup to appear and then enter the credentials:
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement username=driver.findElement(By.id("username"));
		
		WebElement password=driver.findElement(By.id("password"));
		
//		username: admin
//		password: password
		username.sendKeys("admin");
		Thread.sleep(4000);
		
		password.sendKeys("password");
		Thread.sleep(4000);

//		Click submit and print the message on the page after logging in.
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.cssSelector("h2.text-center")).getText());
		
//		Finally, close the browser.
		driver.close();
	
		
	}

}
