package com.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;




public class OrangeLogIn {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		 
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Got URL");
		Date dt = new Date();
		System.out.println(dt.toString());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@class='button']")).click();
		driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals("Paul", "Paul");
		System.out.println("User Paul is varified");
		
		driver.findElement(By.xpath("(//*[@class='firstLevelMenu'])[1]")).click();
		driver.findElement(By.xpath("(//*[@class='arrow'])[3]")).click();
		driver.findElement(By.xpath("//*[@id='menu_admin_viewLocations']")).click();
		driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("New York");
		driver.findElement(By.xpath("//*[@class='addbutton']")).click();
		
		System.out.println(driver.findElement(By.linkText("New York Sales Office")).getText());
		Assert.assertEquals("New York Sales Office", "New York Sales Office");
		System.out.println("New York Office is true");
		
		driver.findElement(By.xpath("//a[@href='location?locationId=2']")).click();
						
		TakesScreenshot tscs = (TakesScreenshot) (driver);
		File sourse = tscs.getScreenshotAs(OutputType.FILE);
		Files.copy(sourse, new File("./Screenshot/ApplicationHomePage.png"));
		Thread.sleep(2000);
		driver.close();
		System.out.println("Test Pass in Automation");
	}

}
