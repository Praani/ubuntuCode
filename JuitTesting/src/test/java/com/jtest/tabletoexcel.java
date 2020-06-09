package com.jtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tabletoexcel {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
	}

	@Test
	public void test() throws IOException {
		String file = "/home/pranesh/Documents/Selenium/DDT/Write1.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Data");
		List<WebElement> tableheadings = driver
				.findElements(By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr[1]/th"));
		int tablecolCount = tableheadings.size();
		System.out.println(tablecolCount);
		
		sheet.createRow(0);
		for (int i = 1; i <= tablecolCount; i++) {
			String table_Cell_Value = driver
					.findElement(By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr[1]/th[" + i + "]")).getText();
			System.out.println(table_Cell_Value);
//			HSSFCell cell = row0.createCell(i-1);
//			cell.setCellValue(table_Cell_Value);
			sheet.getRow(0).createCell(i-1).setCellValue(table_Cell_Value);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);	
		}

		List<WebElement> tablevalues = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr"));
		int table_row_Count = tablevalues.size();
		for (int i = 2; i <= table_row_Count; i++) {
			System.out.println("-----------------------");
			sheet.createRow(i-1);
			for (int j = 0; j < tablecolCount; j++) {
				String table_Cell_Value = driver
						.findElement(
								By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr[" + i + "]/td[" + (j + 1) + "]"))
						.getText();
				System.out.println(table_Cell_Value);				
				HSSFRow row11 = sheet.getRow(i-1);
				HSSFCell cell = row11.createCell(j);
				cell.setCellValue(table_Cell_Value);
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
			}
		}
		System.out.println("-----------------------");
		
		HSSFRow row_1 = sheet.getRow(0);
		int row_count = sheet.getLastRowNum();
		int col_count = row_1.getLastCellNum();
		for(int k=0; k<row_count+1; k++) {
			System.out.println("-----------------------");
			for (int l=0; l<col_count; l++) {
				System.out.println(sheet.getRow(k).getCell(l).getStringCellValue());
			}
		}
		
		System.out.println("---------------------");
		
		WebElement alert1 = driver.findElement(By.id("alertBox"));
		String alert1value=alert1.getText();
		System.out.println();
		alert1.click();
		String Alertmsg1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert 1 message is \n" +  Alertmsg1);
		HSSFSheet sheet1 = workbook.createSheet("Alert");
		sheet1.createRow(0);
		sheet1.getRow(0).createCell(0).setCellValue(alert1value);
		sheet1.getRow(0).createCell(1).setCellValue(Alertmsg1);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
		System.out.println("-----------------------");
		workbook.close();
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
