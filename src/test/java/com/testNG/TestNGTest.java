package com.testNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class TestNGTest {
	WebDriver driver;
	@BeforeTest
	public void MyTest1() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		Date dt = new Date();
		System.out.println(dt.toString());
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("User is on OrangeHRM website");//
		
		
	}
	
	@Test
	public void MyTest2() {
		driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys("Admin");
		System.out.println("User Enters UserName");//
		
	}
	@Test
	public void MyTest3() {
		driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("admin123");
		System.out.println("User Enters Password");//
		
	}
	@Test
	public void MyTest4() {
		driver.findElement(By.xpath("//*[@name='Submit']")).click();
		System.out.println("User Click Login button");//
		
	}
	
	@Test
	public void MyTest5() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).getText();
		AssertJUnit.assertEquals("Paul", "Paul");
		System.out.println("User Login to website as Paul");//
		
	}
	@Test
	public void MyTest6() throws InterruptedException {
		
		driver.findElement(By.xpath("(//*[@class='firstLevelMenu'])[1]")).click();//
		driver.findElement(By.xpath("(//*[@class='arrow'])[3]")).click();//
		System.out.println("User click on Location which is inside Admin and then Organization");
		
	}
	@Test
	public void MyTest7() {
		driver.findElement(By.xpath("//*[@id='menu_admin_viewLocations']")).click();//
		driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("New York");//
		System.out.println("User enters Location Name");
	}
	
	@Test
	public void MyTest8() {
		driver.findElement(By.xpath("//*[@class='addbutton']")).click();//
		System.out.println("New York Office found");
	}
	@Test
	public void MyTest9() throws IOException {
		System.out.println(driver.findElement(By.linkText("New York Sales Office")).getText());//
		Assert.assertEquals("New York Sales Office", "New York Sales Office");
		System.out.println("User click on Search Button");
		TakesScreenshot tscs = (TakesScreenshot) (driver);
		File sourse = tscs.getScreenshotAs(OutputType.FILE);
		Files.copy(sourse, new File("./Screenshot/ApplicationHomePage.png"));
		
	}
	@Test
	public void MyTest91() {
		driver.findElement(By.xpath("(//*[@class='left'])[1]")).click();
		System.out.println("New York office address");
	}
	@AfterTest
	public void MyTest92() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Driver Closed");
	}
}
	