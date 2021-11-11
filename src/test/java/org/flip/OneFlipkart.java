package org.flip;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneFlipkart {
	static WebDriver driver;
	static long starttime ;
	@BeforeClass
	public static void launchBrowser() {
		System.out.println("beforeclass");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Mobile() throws InterruptedException {
		WebElement email=driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]"));
		email.sendKeys("8870148903");
		WebElement pass=driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]"));
		pass.sendKeys("@arunkumar8903");
		WebElement login=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		login.click();
		Thread.sleep(10000);
		WebElement search=driver.findElement(By.xpath("//input[@autocomplete='off']"));
		search.sendKeys("mobiles");
		Thread.sleep(3000);
		WebElement enter=driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		enter.click();
		Thread.sleep(10000);

	}
	
	@Test(priority=2)
	public void MobilePhone() throws InterruptedException {
		WebElement realme=driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		   String r= realme.getText();
		   System.out.println(r);
		   
		  String parwin= driver.getWindowHandle();
		  System.out.println(parwin);
		  realme.click();
		  Thread.sleep(5000);
		 Set<String> allwin= driver.getWindowHandles();
		 for (String x : allwin) {
			 if(!parwin.equals(x)) {
				 driver.switchTo().window(x);
				 

	}
		 }
	
		      }
	
	
	@Test(priority=3,enabled=false)
	public void MobileSpecification() {
		WebElement spec=driver.findElement(By.xpath("//div[text()='Specifications']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",spec );
		

	}
	
	@AfterClass
	public static void close() throws IOException {
		
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
