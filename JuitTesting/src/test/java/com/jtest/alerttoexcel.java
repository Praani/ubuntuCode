package com.jtest;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerttoexcel {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
	}

	@Test
	public void test() throws IOException, InterruptedException {
		String file = "/home/pranesh/Documents/Selenium/DDT/Write1.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Alerts");
		
		List<WebElement> alertbuttons = driver.findElements(By.xpath("(//div[@class='row'])[4]/div"));
		int alertbuttons_count = alertbuttons.size();
		
		sheet.createRow(0).createCell(0).setCellValue("Alerts");
		sheet.getRow(0).createCell(1).setCellValue("Description");
		
		String xpath1 = "(//div[@class='row'])[4]/div[";
		String xpath2 = "]/button";
		int k=1;
		for(int i=1; i<=alertbuttons_count; i++) {
			String actualXpath = xpath1 + i + xpath2;
			WebElement alertbutton_value = driver.findElement(By.xpath(actualXpath));
			String alertboxvalue = alertbutton_value.getText();
			System.out.println(alertboxvalue);
			alertbutton_value.click();
			String alertmessage = driver.switchTo().alert().getText();
			System.out.println(alertmessage);
			driver.switchTo().alert().accept();
			sheet.createRow(k).createCell(0).setCellValue(alertboxvalue);
			sheet.getRow(k).createCell(1).setCellValue(alertmessage);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			System.out.println("-------------");
			k++;
		}	
		workbook.close();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
