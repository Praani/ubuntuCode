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

public class WebTable_3 {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
	}

	@Test
	public void test() {
		// table[@id='task-table']/tbody/tr[1]/td[2]
		List<WebElement> value = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td"));
		//int vcount = value.size();
		for (WebElement val : value) {
			System.out.println(val.getText());
		}

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		int row_count = rows.size();

		System.out.println("***************************");

		String bxpath = "//table[@id='task-table']/tbody/tr[";
		String axpath = "]/td[2]";
		for (int i = 1; i < row_count + 1; i++) {
			String actualxpath = bxpath + i + axpath;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
		}

		System.out.println("***************************");

		String bxpath1 = "//table[@id='task-table']/tbody/tr[";
		String axpath1 = "]/td[4]";
		for (int i = 1; i < row_count + 1; i++) {
			String actualxpath1 = bxpath1 + i + axpath1;
			WebElement element = driver.findElement(By.xpath(actualxpath1));
			System.out.println(element.getText());
		}

		String nbxpat = "//table[@id='task-table']/tbody/tr[";
		String naxpath = "]/td[4]";
		for (int i = 1; i < row_count + 1; i++) {
			String actualxpath1 = nbxpat + i + naxpath;
			WebElement element = driver.findElement(By.xpath(actualxpath1));
			if (element.getText().equalsIgnoreCase("in progress")) {
				WebElement realv = driver.findElement(By.xpath(nbxpat + i + "]/td[2]"));
				System.out.println(realv.getText());
			}
		}

		System.out.println("***************************");
		
		String nbxpat1 = "//table[@id='task-table']/tbody/tr[";
		String naxpath1 = "]/td[2]";
		for (int i = 1; i < row_count + 1; i++) {
			String actualxpath1 = nbxpat1 + i + naxpath1;
			WebElement element = driver.findElement(By.xpath(actualxpath1));
			System.out.println(element.getText());

			String naxpath2 = "]/td[4]";
			String actualxpath2 = nbxpat1 + i + naxpath2;
			WebElement element1 = driver.findElement(By.xpath(actualxpath2));
			System.out.println(element1.getText());
		}

	}

	@After
	public void teardown() {
		driver.quit();
	}
}