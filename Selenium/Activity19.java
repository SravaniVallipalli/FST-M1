package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity19 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/alerts");
		driver.manage().window().maximize();

		System.out.println("page title is " + driver.getTitle());
//		Find the button to open a SIMPLE alert and click it.
		driver.findElement(By.id("confirmation")).click();
//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println(confirmationAlert.getText());
//		Close the alert once with OK.
		confirmationAlert.dismiss();
		// print the confirmation message after clicking
		System.out.println(driver.findElement(By.id("result")).getText());
		// Close the browser.
		
		//repeating the above to click on accept
		driver.findElement(By.id("confirmation")).click();
//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		//Alert simpleAlert = driver.switchTo().alert();
		System.out.println(confirmationAlert.getText());
//		Close the alert once with OK.
		confirmationAlert.accept();
		// print the confirmation message after clicking
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.close();
	}

}
