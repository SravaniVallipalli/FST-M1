package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity13 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	//	Actions action=new Actions(driver);
		driver.get("https://training-support.net/webelements/tables");
		driver.manage().window().maximize();
		System.out.println("page title is " +driver.getTitle());
		List<WebElement> cols=driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println("number of cols is " +cols.size());
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("number of rows is " +rows.size());
		//Find and print all the cell values in the third row of the table.
		List<WebElement> thirdrow=driver.findElements(By.xpath("//table/tbody/tr[3]"));
		for(WebElement row:thirdrow) {
			System.out.println(row.getText());
		}
		//Find and print the cell value at the second row second column.
		String secondRowSecondColumn=driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		System.out.println(secondRowSecondColumn);
	}

}
