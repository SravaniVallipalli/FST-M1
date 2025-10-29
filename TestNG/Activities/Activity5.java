package Activities;

//import java.awt.Color;
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
import org.openqa.selenium.support.Color;

public class Activity5 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/target-practice/");

	}

	@Test(groups= {"HeaderTest", "ButtonTest"})
	public void getPageTitle() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}

	@Test(dependsOnMethods= {"getPageTitle"}, groups= {"HeaderTest"})
	public void headerTest1() {
		WebElement thirdHeader = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
		Assert.assertTrue(thirdHeader.isDisplayed());
		Assert.assertEquals(thirdHeader.getText(), "Heading #3");
	}
	@Test(dependsOnMethods= {"getPageTitle"}, groups= {"HeaderTest"})
	public void headerTest2() {
		Color header5Color=Color.fromString(driver.findElement(By.cssSelector("h3.text-orange-600"))
				.getCssValue("color"));
		
		Assert.assertEquals(header5Color.asHex(), "#ea580c");
	}

	@Test(dependsOnMethods= {"getPageTitle"}, groups= {"ButtonTest"})
	public void buttonTest1() {
		WebElement button1 = driver.findElement(By.xpath("//button[text()='Emerald']"));
		Assert.assertTrue(button1.isDisplayed());
		Assert.assertEquals(button1.getText(), "Emerald");
	}
	
	@Test(dependsOnMethods= {"getPageTitle"}, groups= {"ButtonTest"})
	public void buttonTest2() {
		Color button2Color=Color.fromString(driver.findElement(By.cssSelector("button.bg-purple-200"))
				.getCssValue("color"));
		Assert.assertEquals(button2Color.asHex(), "#581c87");
	}
	@AfterClass(alwaysRun = true)
	public void TearDown() {
		driver.close();
	}
}
