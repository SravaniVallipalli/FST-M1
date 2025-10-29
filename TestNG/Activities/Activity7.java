package Activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	//Alert alert=
	
	@BeforeClass

	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form/");
	}

	@DataProvider(name = "Credentials")
	public Object[][] creds() {
		return new Object[][] { { "admin", "wrongPassword" }, { "wrongAdmin", "password" },
				{ "$_$", "DELETE USERS TABLE;" } };
	}

	@Test(priority = 1)
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
	}

	@Test(priority = 2, dataProvider = "Credentials")
	public void invalidLoginTest(String username, String password) throws InterruptedException {
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		// clear the input fields
		usernameField.clear();
		passwordField.clear();
		// Enter credentials
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		Thread.sleep(2000);
		// Click login
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);

		// Read login message
		String invalidMessage = driver.findElement(By.id("subheading")).getText();
		Assert.assertEquals("Invalid credentials", invalidMessage);

	}

	@AfterClass
	public void TearDown() {
		driver.close();
	}

}
