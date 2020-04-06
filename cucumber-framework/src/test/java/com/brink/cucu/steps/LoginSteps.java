package com.brink.cucu.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	
	private WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "D:\\dev\\udemy\\selenium\\bruno\\cucumber-framework\\src\\test\\java\\resources\\webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After()
	public void tearDown() {
		driver.close();
	}
	
	@Given("^user navigates to website$")
	public void user_navigates_to_website() throws Throwable {
	    driver.get("https://stackoverflow.com");
	}

	@Given("^user clicks homepage login button$")
	public void user_clicks_homepage_login_button() throws Throwable {
		Thread.sleep(2000);
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
	    Thread.sleep(2000);
		
		WebElement askQuestionsButton = driver.findElement(By.xpath("//*[@id=\"mainbar\"]/div[1]/div/a"));
	
	    Assert.assertTrue(askQuestionsButton.isDisplayed());
	}
	
}
