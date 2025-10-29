package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass

	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net");

	}

	@Test(priority=1)
	public void pageTitleTest() {
		//String pageTitle=driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Training Support");
	}
	@Test(priority=2)
	public void aboutLinkTest() {
		driver.findElement(By.linkText("About Us")).click();
		//Assertions
		wait.until(ExpectedConditions.titleContains("About Training Support"));
		
	}
	

	@AfterClass
	public void TearDown() {
		driver.close();
	}
}
