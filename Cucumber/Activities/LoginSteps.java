package StepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass{
	@Given("the user is on the login page")	
	public void openLoginpage() {
		driver.get("https://training-support.net/webelements/login-form");
		Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
		
	}
	@When("the user enters username and password")
	public void enterCredentials() {
		WebElement usernameField=driver.findElement(By.id("username"));
		usernameField.sendKeys("admin");
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.sendKeys("password");
		//Assertion
		Assertions.assertEquals("admin",usernameField.getDomProperty("value"));
		Assertions.assertEquals("password",passwordField.getDomProperty("value"));

	}
	@When("the user enters {string} and {string}")
	public void entervalidCredentials(String username, String password) {
		
		WebElement usernameField=driver.findElement(By.id("username"));
		usernameField.sendKeys("admin");
		WebElement passwordField=driver.findElement(By.id("password"));
		passwordField.sendKeys("password");
		//Assertion
		Assertions.assertEquals("admin",usernameField.getDomProperty("value"));
		Assertions.assertEquals("password",passwordField.getDomProperty("value"));

	}
	@And("clicks the submit button")
	public void clickSubmit() {
		//locate the element and click on submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	@Then("get the confirmation message and verify it")
	public void verifyMessage() {
		String message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800"))).getText();
		Assertions.assertEquals("Welcome Back, Admin!", message);
	}
	@Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage) {
		 // Find the message
        String message = "NOT FOUND";
        if (expectedMessage.contains("Invalid")) {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
        } else {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
        }
        // Assert message
        Assertions.assertEquals(expectedMessage, message);
    
    }
//	@Then("verify error message as {string}")
//    public void verifyErrorMessage(String expectedMessage) {
//    	// Find the confirmation message
//		String message =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
//        driver.findElement(By.cssSelector("h2.mt-5")).getText();
//        // Assert message
//        Assertions.assertEquals(expectedMessage, message);
//    }
	
	
	}

