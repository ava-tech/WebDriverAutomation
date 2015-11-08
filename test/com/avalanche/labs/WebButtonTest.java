package com.avalanche.labs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class WebButtonTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void f() {
		driver.findElement(By.cssSelector("#menu_documentation>a")).click();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("codeLanguagePreference")).getText()
						.startsWith("Programming");
			}
		});

		List<WebElement> elements = new ArrayList<WebElement>();

		elements = driver.findElements(By.cssSelector("#codeLanguagePreference>ul>li"));
		
		Assert.assertEquals("Verify: ", 7, elements.size());;
	
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("http://www.seleniumhq.org/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
