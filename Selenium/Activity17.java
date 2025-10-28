package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/selects");
		driver.manage().window().maximize();

		System.out.println("page title is " + driver.getTitle());
		WebElement listBox = driver.findElement(By.cssSelector("select.h-80"));
		Select multiList = new Select(listBox);

		// Select the "HTML" option using the visible text.
		multiList.selectByVisibleText("HTML");

		// Select the 4th, 5th and 6th options using the index.
		for (int i = 3; i <= 5; i++) {
			multiList.selectByIndex(i);
		}
		// Select the "Node" option using the value.
		multiList.selectByValue("nodejs");
		// Deselect the 5th option using index.
		multiList.selectByIndex(4);
		// print all values
		for (WebElement option : multiList.getOptions()) {
			System.out.println(option.getText());
		}

		driver.close();
	}

}
