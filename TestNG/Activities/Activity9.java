package Activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Reporter.log("Starting test!");

		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Opened browser!");
		Reporter.log("page title is " + driver.getTitle() + " |");
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("testcase is started!");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 1)
	public void simpleAlertTestcase() {
		Reporter.log("simple alert testcase started");
		//click the button to open a simple alert
		driver.findElement(By.id("simple")).click();
		Reporter.log("simple alert opened");
		//switch to alert window
		Alert simpleAlert=driver.switchTo().alert();
		Reporter.log("driver switched to alert");
		//get text in simple alert and print it
		String alertText=simpleAlert.getText();
		Reporter.log("Alert text is " + alertText + " |");
		//Assertion
		Assert.assertEquals("You've just triggered a simple alert!", alertText);
		simpleAlert.accept();
		Reporter.log("alert closed");
		Reporter.log("testcase ended |");
	}
	@Test(priority=2)
	public void confirmAlertTestcase() {
		Reporter.log("confirm alert testcase started:");
		//click button to open a confirm alert
		driver.findElement(By.id("confirmation")).click();
		Reporter.log("confirmation alert opened");
		Alert confirmAlert=driver.switchTo().alert();
		Reporter.log("driver switched to confirm alert");
		String confirmAlertText=confirmAlert.getText();
		Reporter.log("confirm alert text is " + confirmAlertText + " |");
		Assert.assertEquals("You've just triggered a confirmation alert!", confirmAlertText);
		confirmAlert.accept();
		Reporter.log("alert closed");
		Reporter.log("testcase ended |");
	}
	@Test(priority=3)
	public void promptAlertTestcase() {
		Reporter.log("prompt alert testcase started:");
		driver.findElement(By.id("prompt")).click();
		Reporter.log("prompt alert opened");
		Alert promptAlert=driver.switchTo().alert();
		Reporter.log("driver switched to prompt alert");
		String promptAlertText=promptAlert.getText();
		Reporter.log("confirm alert text is " + promptAlertText + " |");
		Assert.assertEquals("I'm a Prompt! Type something into me!", promptAlertText);
		promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |");
        // Close the prompt
        promptAlert.accept();
        Reporter.log("Alert closed |");
 
        Reporter.log("Test case ended |");
	}
	@AfterClass
	public void TearDown() {
		Reporter.log("Ending test |");
		driver.close();
	}

}