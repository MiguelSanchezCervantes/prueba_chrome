package com.miguelsanchez.prueba_chrome;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleSearchTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void GoogleSearchTest() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Oracle");
		searchbox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("rc"),1));
		List<WebElement> results = driver.findElements(By.className("rc"));
		WebElement webpage = results.get(0).findElement(By.xpath("./div/a"));
		webpage.click();
		wait.until(ExpectedConditions.urlToBe("https://www.oracle.com/mx/index.html"));
		System.out.println(driver.getTitle());
	}
	
	@After
	public void CloseWindow() {
		driver.quit();
	}
	

}
