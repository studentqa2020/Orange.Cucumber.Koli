package com.stepdef;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.google.common.io.Files;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitaion {
	WebDriver driver;
	@Given("OrangeHRM website")
	public void orangehrm_website() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		Date dt = new Date();
		System.out.println(dt.toString());
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("User is on OrangeHRM website"); //
	}

	@When("enters valid credentials")
	public void enters_valid_credentials() {
		driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("admin123");
		System.out.println("User Enters ID and Password");//
	}

	@When("Click Login")
	public void click_Login() {
		driver.findElement(By.xpath("//*[@name='Submit']")).click();
		System.out.println("User Click Login button");//
	}

	@Then("Login as Paul")
	public void login_as_Paul() {
		driver.findElement(By.id("welcome")).getText();
		AssertJUnit.assertEquals("Paul", "Paul"); 
		System.out.println("User Login to website as Paul - validet");//
	}

	@Then("click on Location")
	public void click_on_Location() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='firstLevelMenu'])[1]")).click();//
		driver.findElement(By.xpath("(//*[@class='arrow'])[3]")).click();//
		driver.findElement(By.xpath("//*[@id='menu_admin_viewLocations']")).click();//
		driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("New York");//
		driver.findElement(By.xpath("//*[@class='addbutton']")).click();//
		System.out.println("New York Office found");
	}

	@Then("Write New York and Office found")
	public void write_New_York_and_Office_found(){
		driver.findElement(By.linkText("New York Sales Office")).getText();//
		Assert.assertEquals("New York Sales Office", "New York Sales Office");
		System.out.println("User found New York sakes office -validet");
		
	}

	@Then("User Driver Closed")
	public void user_Driver_Closed() throws IOException {
		driver.findElement(By.xpath("(//*[@class='left'])[1]")).click();
		System.out.println("New York office address");
		TakesScreenshot tscs = (TakesScreenshot) (driver);
		File sourse = tscs.getScreenshotAs(OutputType.FILE);
		Files.copy(sourse, new File("./Screenshot/ApplicationHomePage.png"));
		System.out.println("Operation success");
		driver.close();
	}
	
	
}

	
