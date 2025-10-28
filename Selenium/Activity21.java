package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/tabs");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("page title is " + driver.getTitle());
		

        // Find button to open new tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Print the handle of the current window
        System.out.println("Current tab: " + driver.getWindowHandle());
        //print the handles of all tabs opened
        System.out.println("Current tab: " + driver.getWindowHandles());
       //switch to the newest tab
        for(String handle:driver.getWindowHandles()) {
        	driver.switchTo().window(handle);
        }
        // Print the handle of the parent window
        System.out.println("Current tab: " + driver.getWindowHandle());
        //print the title and message on the new tab
        System.out.println("title of new tab is " +driver.getTitle());
        List<WebElement> spantext=driver.findElements(By.xpath("//h1[contains(@class,'inline-flex')]//span"));
        System.out.println(spantext.get(0).getText() + " " + spantext.get(1).getText());
        
	}

}
