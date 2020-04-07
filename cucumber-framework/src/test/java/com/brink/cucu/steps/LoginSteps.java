package com.brink.cucu.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.DriverFactory;


public class LoginSteps extends DriverFactory {
	private WebDriverWait wait = new WebDriverWait(driver, 5);
	
	@Given("^user navigates to website2$")
	public void user_navigates_to_website2() throws Throwable {
	    System.out.println("SECOND TEST!!!");
	}
	
	@Given("^user navigates to website$")
	public void user_navigates_to_website() throws Throwable {
	    driver.get("https://stackoverflow.com");
	}

	@Given("^user clicks homepage login button$")
	public void user_clicks_homepage_login_button() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Log in')]"))));
		
		// dynamic xpath // - search whole doc, a[contains(<type>, '<text>')] - for a link conatining <text>...
	    driver.findElement(By.xpath("//a[contains(text(), 'Log in')]")).click();
	}

	@When("^user enters valid credentials and clicks login button$")
	public void user_enters_valid_credentials_and_clicks_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("betatesteru1@gmail.com");
	   	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ssw0rd!12345");
	   	driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
	}

	@Then("^user should be taken to successful login page$")
	public void user_should_be_taken_to_successful_login_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div/a"))));
		
		WebElement askQuestionsButton = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div/a"));
	
	    Assert.assertTrue(askQuestionsButton.isDisplayed());
	}
	
}
