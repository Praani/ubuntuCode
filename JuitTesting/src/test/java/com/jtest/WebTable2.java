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

public class WebTable2 {

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

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		int col_count = cols.size();
		System.out.println("Total number of columns are " + col_count);
		for (WebElement col : cols) {
			System.out.println(col.getText());
		}

		System.out.println("***************************");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		int row_count = rows.size();
		System.out.println("Total number of rows are " + row_count);
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

		System.out.println("***************************");
		System.out.println("***************************");

		// Column-1 values //table[@id='task-table']/tbody/tr[1]/td[1]
		// WebElement col1 =
		// driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[1]"));
		String col1_bxpath = "//table[@id='task-table']/tbody/tr[";
		String col1_axpath = "]/td[1]";
		for (int i = 1; i < row_count + 1; i++) {
			String col1_actualpath = col1_bxpath + i + col1_axpath;
			WebElement value1 = driver.findElement(By.xpath(col1_actualpath));
			System.out.println(value1.getText());
		}

		System.out.println("***************************");

		// Column-2 values //table[@id='task-table']/tbody/tr[1]/td[2]
		// WebElement col2 =
		// driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[2]"));
		String col2_bxpath = "//table[@id='task-table']/tbody/tr[";
		String col2_axpath = "]/td[2]";
		for (int i = 1; i < row_count + 1; i++) {
			String col1_actualpath = col2_bxpath + i + col2_axpath;
			WebElement value2 = driver.findElement(By.xpath(col1_actualpath));
			System.out.println(value2.getText());
		}

		System.out.println("***************************");
		// Column-3 values //table[@id='task-table']/tbody/tr[1]/td[3]
		// WebElement col3 =
		// driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[3]"));
		String col3_bxpath = "//table[@id='task-table']/tbody/tr[";
		String col3_axpath = "]/td[3]";
		for (int i = 1; i < row_count + 1; i++) {
			String col1_actualpath = col3_bxpath + i + col3_axpath;
			WebElement value3 = driver.findElement(By.xpath(col1_actualpath));
			System.out.println(value3.getText());
		}

		System.out.println("***************************");
		// Column-3 values //table[@id='task-table']/tbody/tr[1]/td[3]
		// WebElement col4 =
		// driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[3]"));
		String col4_bxpath = "//table[@id='task-table']/tbody/tr[";
		String col4_axpath = "]/td[4]";
		for (int i = 1; i < row_count + 1; i++) {
			String col1_actualpath = col4_bxpath + i + col4_axpath;
			WebElement value4 = driver.findElement(By.xpath(col1_actualpath));
			if (value4.getText().equalsIgnoreCase("in progress")) {
				System.out.println(value4.getText());
			}

		}

		System.out.println("***************************");
		// Row-1 values //table[@id='task-table']/tbody/tr
		// WebElement row1 =
		// driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[3]"));
		String row1_bxpath = "//table[@id='task-table']/tbody/tr[";
		String row11 = "]/td[";
		String row1_axpath = "]";
		for (int j = 1; j < row_count; j++) {
			for (int i = 1; i < col_count + 1; i++) {
				String row1_actualpath = row1_bxpath + j + row11 + i + row1_axpath;
				WebElement value5 = driver.findElement(By.xpath(row1_actualpath));
				System.out.print(value5.getText() + " ");
			}
		}

	}

	@After
	public void teardown() {
		driver.quit();
	}
}