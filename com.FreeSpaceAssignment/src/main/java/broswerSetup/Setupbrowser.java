package broswerSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setupbrowser {

	public static WebDriver driver = null;
	public static Properties properties = null;

	public static Properties loadpropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	public static void ElementWait() throws Exception {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//*[contains(text(),'Rating')]"), "Rating"));
	}

	@BeforeSuite
	public static void setup() throws IOException {
		loadpropertyFile();
		String Appurl = properties.getProperty("APPURL");
		String Browsers = properties.getProperty("browser");
		// WebDriverManager.firefoxdriver().setup();

		if (Browsers.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browsers.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(Appurl);

	}

	public static void pageScrollDown() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1800)");
		jse.executeScript("window.scrollBy(0,-550)");

	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
//B1 branch updated via sourceTree