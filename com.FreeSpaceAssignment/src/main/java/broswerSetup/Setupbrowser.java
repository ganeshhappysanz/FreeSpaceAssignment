package broswerSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setupbrowser {
	
	public static WebDriver driver=null;
	public static Properties properties=null;
	
	
	public static Properties loadpropertyFile() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("config.properties");
        properties =new Properties();
        properties.load(fileInputStream);
        return properties;
    }

	
			
		@BeforeSuite
		public static void setup() throws IOException {
			 loadpropertyFile();
		     String Appurl=properties.getProperty("APPURL");
			
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
			driver.get(Appurl);
			
		}
		
		public static void pageScrollDown() {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,2000)");
		}
		
		
		@AfterSuite
		public void teardown() {
			if(driver!=null) {
	            driver.quit();
	        }
		}
		

	}
