package com.brinkmcd.webdu.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebDUClearContactUsFormSteps {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Initialitzing webdriver");
		System.setProperty("webdriver.gecko.driver", "D:\\dev\\udemy\\selenium\\bruno\\cucumber-framework\\src\\test\\java\\resources\\webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		System.out.println("Deleting all cookies");
		System.out.println("Closing the webdriver");
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	@Given("^I access webdriver university contact form$")
	public void i_access_webdriver_university_contact_form() throws Throwable {
	    driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@When("^I fill out the contact us form$")
	public void i_fill_out_the_contact_us_form() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, 3);
		
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"contact_form\"]/input[1]")));
	    
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("Joe");
	    driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("Guage");
	    driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("joe.guage@hateful8.com");
	    driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("I'm goin home to see my momma");
		
	}

	@When("^I click the reset button$")
	public void i_click_the_reset_button() throws Throwable {
		Thread.sleep(1500);
	    driver.findElement(By.xpath("//*[@id='form_buttons']/input[1]")).click();
	}

	@Then("^the form should be cleared of all my input$")
	public void the_form_should_be_cleared_of_all_my_input() throws Throwable {
	    System.out.println("Form cleared.");
	}
}
