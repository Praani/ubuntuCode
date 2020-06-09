package com.jtest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	WebDriver driver;
	
	public void takescreebshoot(String filename) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile, 
				new File("/home/pranesh/Documents/Eclipse_Home/JuitTesting/ScreenShots/" + filename + ".jpg"));
		}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/pranesh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}

	@Test
	public void test() throws InterruptedException, IOException {
		WebElement menu = driver.findElement(By.xpath("//div[@id='p-navigation']/div/ul"));
		List<WebElement> links = menu.findElements(By.tagName("a"));
		int count = links.size();
		
		for (int i = 0; i < count; i++) {
			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(clickonLink);
			Thread.sleep(1000);
		}
		Set<String> webs = driver.getWindowHandles();
		Iterator<String> it = webs.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String title = driver.getTitle();
			System.out.println(title);
			takescreebshoot(title);
		}
	}

	@After
	public void close() {
		driver.quit();
	}

}