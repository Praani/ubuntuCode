package com.jtest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelRead {

WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
	}
	
	@Test
	public void test() throws IOException {

		String filePath = "/home/pranesh/Documents/Selenium/DDT/book.xls";
		FileInputStream file = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(1);
		
		
		HSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("Column Count : " + colCount);
		
		int rowCount = sheet.getLastRowNum()+1;
		System.out.println("Row Count : " + rowCount);
		System.out.println("=======================");
		
		for (int i=1; i<rowCount; i++) {
				
				double cello = sheet.getRow(i).getCell(0).getNumericCellValue();
				String str1 = String.format("%.0f", cello);
				System.out.println(str1);
				
				String str2 = sheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println(str2);
				
				double cell2 = sheet.getRow(i).getCell(2).getNumericCellValue();
				String str3 = String.format("%.0f", cell2);
				System.out.println(str3);
			}
		}		
}
