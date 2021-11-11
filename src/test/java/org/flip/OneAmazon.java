package org.flip;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneAmazon {
	
	static WebDriver driver;
	static long starttime ;
	@DataProvider(name="search box")
	public Object[][] getSearchBoxName(){
		return new Object [][ ] {{"laptop"}};
	}
	
	@BeforeClass
	public static void launchBrowser() {
		System.out.println("beforeclass");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		 
	@Test(invocationCount=5, dataProvider="search box")
	
	public void mobile(String value) throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(value,Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public static void close() throws IOException {
		System.out.println("hi");
		TakesScreenshot ss=(TakesScreenshot) driver;
		File sourse=ss.getScreenshotAs(OutputType.FILE);
		File Target=new File("C:\\Users\\Desktop\\screenShot.png");
		FileUtils.copyFile(sourse, Target);
		
		driver.close();
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
		 starttime = System.currentTimeMillis();

	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod");
		long endtime = System.currentTimeMillis();
		long time=endtime-starttime;
		System.out.println(time);

	}

}
