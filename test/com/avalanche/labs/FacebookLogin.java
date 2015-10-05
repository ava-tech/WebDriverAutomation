package com.avalanche.labs;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FacebookLogin {
	public static WebDriver driver;

	@BeforeClass
	public static void startDriver() {
		
		File pathBinary = new File("C:\\Users\\KaiserDell\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary Binary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxPro = new FirefoxProfile(); 
		
		driver = new FirefoxDriver(Binary,firefoxPro);
	}
	
	@AfterClass
	public static void stopDriver() {
		driver.quit();
	}
	

	@Test
	public void driverLevelPageInterrogationMethod() {

		final String theTestPageURL = "file:///C:/AutomationWorkspace/WebDriverAutomation/Apps/AvaTech.html";
	
		driver.navigate().to(theTestPageURL);

		Assert.assertEquals(driver.getTitle(), "Avalanche Information Technology, Inc.");
		Assert.assertEquals(driver.getCurrentUrl(), theTestPageURL);

		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Home of Technology Solutions"));

	}
	
	@Test
	public void faceBookErrorPageValidation() {
		
		String faceBook = "http://www.facebook.com";

		driver.get(faceBook);
		
		//String tagName = null;		
		
		System.out.println("Tag name for Email id: " + driver.findElement(By.id("email")).getTagName()); 
		System.out.println("Attribute Value for Type: " + driver.findElement(By.id("email")).getAttribute("type"));
		System.out.println("Attribute Value for Class: " + driver.findElement(By.id("email")).getAttribute("class"));
		System.out.println("Attribute Value for Name: " + driver.findElement(By.id("email")).getAttribute("name"));
		System.out.println("Attribute Value for TabIndex: " + driver.findElement(By.id("email")).getAttribute("tabindex"));
		
		driver.findElement(By.id("email")).sendKeys("alamkawser@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("dummy");
		driver.findElement(By.id("u_0_x")).click();
		
		//System.out.println("Error Message: " + driver.findElement(By.xpath(".//*[@id='login_form']/div[1]/div[1]") ).getText());
		
		String expectedResult = "Please re-enter your password";
		String actualResult = driver.findElement(By.xpath(".//*[@id='login_form']/div[1]/div[1]") ).getText();
		
		Assert.assertEquals("Test Result:", expectedResult, actualResult);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
