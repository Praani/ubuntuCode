package com.jtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.Argument;

public class WindowHandles2 {

	WebDriver driver;

	public void takescreebshoot(String filename) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile, new File(
				"/home/pranesh/Documents/Eclipse_Home/JuitTesting/ScreenShots/WindowHandles2/" + filename + ".jpg"));
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
	}

	@Test
	public void test() throws InterruptedException, IOException {
		String mainWindow = driver.getWindowHandle();
		
		List<WebElement> twoWheel = driver.findElements(By.xpath("//div[@id='twoWheelVehicles']/input"));
		int twowheelCount = twoWheel.size();
		for (int x = 1; x <= twowheelCount; x++) {
			driver.findElement(By.xpath("//div[@id='twoWheelVehicles']/input[" + x + "]")).click();
		}
		System.out.println("Selected all 2 wheel Vehicles");
		System.out.println("---------------------");

		List<WebElement> fourWheel = driver.findElements(By.xpath("//div[@id='fourWheelVehicles']/input"));
		int fourwheelCount = fourWheel.size();
		for (int y = 1; y <= fourwheelCount; y++) {
			driver.findElement(By.xpath("//div[@id='fourWheelVehicles']/input[" + y + "]")).click();
		}
		System.out.println("Selected all 4 wheel Vehicles");
		System.out.println("---------------------");

		WebElement test = driver.findElement(By.xpath("//div[@id='booksCheckboxes']/input[1]"));
		if (!test.isSelected()) {
			test.click();
			System.out.println("Selected radio button");
		}
		System.out.println("---------------------");

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='programming-languages']"));
		Select oSelect = new Select(dropdown);
		List<WebElement> elementCount = oSelect.getOptions();
		System.out.println("Dropdown values are : ");
		int i = 1;
		for (WebElement element : elementCount) {
			System.out.println(i + ". " + element.getText());
			i++;
		}
		//		int iSize = elementCount.size();
		//		  for(int i=0; i<iSize; i++) { String sValue = elementCount.get(i).getText();
		//		  System.out.println(i+1 + ". " + sValue); 
		//		  }

		Thread.sleep(1000);
		oSelect.selectByValue("JavaScript");
		System.out.println("JavaScript is selected");
		System.out.println("---------------------");

		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='selenium_suite']"));
		Select oSelect2 = new Select(dropdown2);
		List<WebElement> elementCount2 = oSelect2.getOptions();
		System.out.println("Dropdown values are : ");
		int i2 = 1;
		for (WebElement element : elementCount2) {
			System.out.println(i2 + ". " + element.getText());
			i2++;
		}
		oSelect2.selectByValue("WebDriver");
		System.out.println("Selenium WebDriver is selected");
		System.out.println("---------------------");

		List<WebElement> t1_rows = driver
				.findElements(By.xpath("(//div[@class='table-responsive'])[1]/table/tbody/tr"));
		int t1_rowCount = t1_rows.size();

		List<WebElement> t1_cols = driver
				.findElements(By.xpath("(//div[@class='table-responsive'])[1]/table/tbody/tr/td"));
		int t1_colsCount = t1_cols.size();
		for (int k = 1; i < t1_rowCount + 1; k++) {
			System.out.println(t1_rows.get(k).getText());
		}

		//		for (int k=1; i <t1_colsCount+1; i++) {
		//			System.out.println(t1_cols.get(k).getText());
		//		}
		//		
		//		for(WebElement t1row : t1_rows ) {
		//			System.out.println(t1row.getText());
		//		}		
		for (WebElement t1col : t1_cols) {
			System.out.println(t1col.getText());
		}
		System.out.println("---------------------");
		System.out.println("---------------------");

		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement alert1 = driver.findElement(By.id("alertBox"));
		//je.executeScript("arguments[0].scrollIntoView();",alert1);
		je.executeScript("window.scrollBy(0,500)");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(alert1).perform();
		
		Thread.sleep(2000);
		System.out.println("---------------------");
		alert1.click();
		String Alertmsg1 = driver.switchTo().alert().getText();
		System.out.println("Alert 1 message is \n" +  Alertmsg1);
		driver.switchTo().alert().dismiss();
		System.out.println("Alert 1 dismissed");
		driver.findElement(By.id("alertBox")).click();
		driver.switchTo().alert().accept();
		System.out.println("Alert 1 selected");
		System.out.println("---------------------");
		
		driver.findElement(By.id("confirmBox")).click();
		String Alertmsg2 = driver.switchTo().alert().getText();
		System.out.println("Alert 2 message is \n" +  Alertmsg2);
		driver.switchTo().alert().dismiss();
		System.out.println("Alert 2 dismissed");
		driver.findElement(By.id("confirmBox")).click();
		driver.switchTo().alert().accept();
		System.out.println("Alert 2 selected");
		System.out.println("---------------------");
		
		driver.findElement(By.id("promptBox")).click();
		String Alertmsg3 = driver.switchTo().alert().getText();
		System.out.println("Alert 3 message is \n" +  Alertmsg3);
		driver.switchTo().alert().dismiss();
		System.out.println("Alert 3 dismissed");
		driver.findElement(By.id("promptBox")).click();
		driver.switchTo().alert().sendKeys("Selenium WebDriver");
		driver.switchTo().alert().accept();
		System.out.println("Alert 3 selected");
		System.out.println("---------------------");
		
		
		
		//
		//		driver.findElement(By.xpath("//a[contains(text(),'Lakshmi Chandana')]")).click();
		//		Thread.sleep(3000); //
		//		driver.findElement(By.xpath("//li[contains(text(),'What is //Selenium?')]")).click();
		//
		//		Set<String> set = driver.getWindowHandles();
		//		Iterator<String> itr = set.iterator();
		//		while (itr.hasNext()) {
		//			String childWindow = itr.next();
		//			driver.switchTo().window(childWindow);
		//			System.out.println(driver.switchTo().window(childWindow).getTitle());
		//			System.out.println(driver.switchTo().window(childWindow).getCurrentUrl());
		//			System.out.println("---------------------");
		//			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		//			driver.findElement(By.xpath("//a[contains(text(),'What is Selenium?')]")).sendKeys(clickonLink);
		//			driver.findElement(By.xpath("//a[contains(text(),'Why automated testing?')]")).sendKeys(clickonLink);
		//			driver.findElement(By.xpath("//a[contains(text(),'History of Selenium')]")).sendKeys(clickonLink);
		//			driver.findElement(By.xpath("//a[contains(text(),'Selenium Tool Suite')]")).sendKeys(clickonLink);
		//		}
		//
		//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//
		//		driver.switchTo().window(mainWindow);
		//		String page = driver.getTitle();
		//		takescreebshoot(page);
		//		System.out.println("Main window title is " + driver.getTitle() + " and URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//
		//		driver.switchTo().window(tabs.get(1));
		//		String page1 = driver.getTitle();
		//		takescreebshoot(page1);
		//		System.out.println("Title is " + driver.getTitle() + "\n" + "URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//		driver.close();
		//
		//		driver.switchTo().window(tabs.get(2));
		//		String page2 = driver.getTitle();
		//		takescreebshoot(page2);
		//		System.out.println("Title is " + driver.getTitle() + "\n" + "URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//		driver.close();
		//
		//		driver.switchTo().window(tabs.get(3));
		//		String page3 = driver.getTitle();
		//		takescreebshoot(page3);
		//		System.out.println("Title is " + driver.getTitle() + "\n" + "URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//		driver.close();
		//
		//		driver.switchTo().window(tabs.get(4));
		//		String page4 = driver.getTitle();
		//		takescreebshoot(page4);
		//		System.out.println("Title is " + driver.getTitle() + "\n" + "URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//		driver.close();
		//
		//		driver.switchTo().window(tabs.get(5));
		//		String page5 = driver.getTitle();
		//		takescreebshoot(page5);
		//		System.out.println("Title is " + driver.getTitle() + "\n" + "URL is " + driver.getCurrentUrl());
		//		System.out.println("---------------------");
		//		driver.close();
		//		driver.switchTo().window(mainWindow);

		//		driver.findElement(By.id("win2")).click();
		//		Thread.sleep(2000);
		//		System.out.println("Title is " + driver.getTitle() +" \nURL is " + driver.getCurrentUrl());
		//		driver.manage().window().maximize();
		//		System.out.println("The window is maximized");
		//		driver.close();

	}

	@After
	public void teardown() {
		driver.quit();
	}

}