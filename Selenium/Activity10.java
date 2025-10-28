package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		Actions action=new Actions(driver);
		driver.get("https://training-support.net/webelements/drag-drop");
		System.out.println("page title is : " +driver.getTitle());
		WebElement football=driver.findElement(By.id("ball"));
		WebElement dropZone1=driver.findElement(By.id("dropzone1"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		action.clickAndHold(football).moveToElement(dropZone1).pause(5000).build().perform();
		if(dropZone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("ball is dropped in dropzone1");
		}
		action.clickAndHold(football).moveToElement(dropZone2).pause(5000).build().perform();
		if(dropZone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("ball is dropped in dropzone1");
		}
		
		driver.close();
		
	}

}
