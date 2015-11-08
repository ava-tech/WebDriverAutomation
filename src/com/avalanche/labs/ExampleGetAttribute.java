package com.avalanche.labs;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleGetAttribute {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.seleniumhq.org/");
		
		driver.findElement(By.cssSelector("#menu_documentation>a")).click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("codeLanguagePreference")).getText().startsWith("Programming");
			}
		});
		
		System.out.println(driver.findElement(By.id("codeLanguagePreference")).getText());
		
		List<WebElement> elements = new ArrayList<WebElement>();
		
		elements = driver.findElements(By.cssSelector("#codeLanguagePreference>ul>li"));
		
		System.out.println(elements.size());
		
		for(WebElement e: elements){
			System.out.println(e.findElement(By.tagName("input")).getAttribute("value"));
		}
		
		
		driver.close();

	}

}

