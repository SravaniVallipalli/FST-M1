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

public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass

	public void setUp() {
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/target-practice/");

	}
	@Test(priority=1)
	public void testcase1() {
		 
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	@Test(priority=2)
	public void testcase2() {
		
		WebElement blackbutton=driver.findElement(By.xpath("//button[text()='Black']"));
		Assert.assertTrue(blackbutton.isDisplayed());
		Assert.assertEquals(blackbutton.getText(), "black");
	}
	@Test(enabled=false)
	public void testcase3() {
		String subheading=driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subheading.contains("Practice"));	
	}
	@Test
	public void testcase4() throws Exception {
		throw new Exception("Skipping the testcase");
	}
	@AfterClass
	public void TearDown() {
		driver.close();
	}

}
