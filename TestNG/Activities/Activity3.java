package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass

	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form/");

	}
	@Test
	public void loginTest() throws InterruptedException {
		WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
 
        // Enter credentials
        username.sendKeys("admin");
        password.sendKeys("password");
        Thread.sleep(2000);
        // Click login
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(2000);

        // Read login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.close();
	}
}
