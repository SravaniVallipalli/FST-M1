package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://training-support.net/webelements/selects");
        driver.manage().window().maximize();

        System.out.println("page title is " + driver.getTitle());

        WebElement combobox = driver.findElement(By.cssSelector("select.h-10"));
        Select dropdown = new Select(combobox);

        dropdown.selectByVisibleText("One");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("three");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        for(WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}