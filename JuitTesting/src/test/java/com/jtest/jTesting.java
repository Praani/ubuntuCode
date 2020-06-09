package com.jtest;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jTesting {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int rows_count = rows.size();
		System.out.println("No of rows are : " + rows_count);
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		int cols_count = cols.size();
		System.out.println("No of cols are : " + cols_count);
		System.out.println("---------------------");
		
		for (WebElement col:cols) {
			System.out.print(col.getText()+" ");
		}
		
		System.out.println("\n" + "______________________________________________________");
		
		for (WebElement row:rows) {
			System.out.println(row.getText()+" ");
		}	
		
	}
		
	@After
	public void close() {
		driver.quit();
	}
}