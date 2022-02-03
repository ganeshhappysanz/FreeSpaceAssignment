package broswerSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setupbrowser {
	
	public static WebDriver driver;
	String ApppURL="https://www.google.com";
	
			
		@BeforeSuite
		public void setup() {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
			driver.get(ApppURL);
			
		}
		
		public static void pageScrollDown() {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,2000)");
		}
		
		
		@AfterSuite
		public void teardown() {
			if(driver!=null) {
	           // driver.quit();
	        }
		}
		

	}
