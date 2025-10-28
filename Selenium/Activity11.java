package activities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("page title is " + driver.getTitle());
//		Find the checkbox on the page.
		
//		Click the "Toggle Checkbox" button to remove the checkbox.
//		Wait for the checkbox to disappear.
//		Toggle the checkbox again.
//		Wait for it appear and then select it.
		
		
		
	}

}
