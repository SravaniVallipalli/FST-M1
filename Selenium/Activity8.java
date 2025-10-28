package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		Actions action=new Actions(driver);
		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("page title is : " +driver.getTitle());
		List<WebElement> buttons=driver.findElements(By.cssSelector("div.svelte-hs12g9"));
		action.click(buttons.get(0)).pause(Duration.ofSeconds(4)).click(buttons.get(1)).pause(Duration.ofSeconds(3)).build().perform();
		//print the message
		String message=driver.findElement(By.id("result")).getText();
		System.out.println(message);
		
		//double click
		action.doubleClick(buttons.get(2)).pause(Duration.ofSeconds(2)).contextClick(buttons.get(3)).pause(Duration.ofSeconds(3)).perform();
		action.click(driver.findElement(By.xpath("//span[text()='Open']"))).pause(Duration.ofSeconds(2));
		 message=driver.findElement(By.id("result")).getText();
		System.out.println(message);
		//driver.quit();
	}	

}
