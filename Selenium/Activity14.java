package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity14 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		//	Actions action=new Actions(driver);
			driver.get("https://training-support.net/webelements/tables");
			driver.manage().window().maximize();
			System.out.println("page title is " +driver.getTitle());
			List<WebElement> cols=driver.findElements(By.xpath("//table/thead/tr/th"));
			System.out.println("number of cols is " +cols.size());
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
			System.out.println("number of rows is " +rows.size());
			//Find and print the Book Name in the 5th row.

			String fifthRowBookName=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
			Thread.sleep(5000);
			System.out.println(fifthRowBookName);
			
			//Click the header of the Price column to sort it in ascending order.
			 driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
			//Find and print the Book Name in the 5th row again.
			  fifthRowBookName=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
				System.out.println(fifthRowBookName);
				driver.close();
	}

}
