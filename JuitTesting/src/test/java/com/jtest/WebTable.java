package com.jtest;

import java.io.File;
import java.io.IOException;
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

public class WebTable {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}

	@Test
	public void test() {
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rcount = rows.size();
		System.out.println("Total number of rows are " + rcount);
		/*for (int i = 0; i < rcount; i++) {
			System.out.println(rows.get(i).getText());
		}*/

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		int colcount = cols.size();
		System.out.println("Total number of columns are " + colcount);
		/*for (int i = 0; i < colcount; i++) {
			System.out.println(cols.get(i).getText());
		}*/

		// table[@id='customers']/tbody/tr[2]/td[1]
		String rbforeXpath = "//table[@id='customers']/tbody/tr[";
		String rafterXpath = "]/td[1]";

		System.out.println("***************************");
		WebElement companycol = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[1]/th[1]"));
		System.out.println(companycol.getText() + " column values are below:");
		for (int i = 2; i < rcount; i++) {
			String actualXpath = rbforeXpath + i + rafterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}

		System.out.println("***************************");
		WebElement Contactcol = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[1]/th[2]"));
		System.out.println(Contactcol.getText() + " column values are below:");
		// table[@id='customers']/tbody/tr[2]/td[1]
		String contactXpath = "]/td[2]";
		for (int i = 2; i < rcount; i++) {
			String actualXpath = rbforeXpath + i + contactXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}

		System.out.println("***************************");
		WebElement Countrycol = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[1]/th[3]"));
		System.out.println(Countrycol.getText() + " column values are below:");
		String countryXpath = "]/td[3]";
		for (int i = 2; i < rcount; i++) {
			String actualXpath = rbforeXpath + i + countryXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		
	}

	@After
	public void teardown() {
		driver.quit();
	}
}