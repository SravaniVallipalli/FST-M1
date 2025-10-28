package activities;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		Actions action=new Actions(driver);
		driver.get("https://training-support.net/webelements/keyboard-events");
		System.out.println("page title is : " +driver.getTitle());
		action.sendKeys("this is coming from the text we enter").sendKeys(Keys.ENTER).pause(5000).build().perform();
		String pageText=driver.findElement(By.cssSelector("h1.mt-3")).getText();
		System.out.println(pageText);
		driver.close();
		
		
	}

}
