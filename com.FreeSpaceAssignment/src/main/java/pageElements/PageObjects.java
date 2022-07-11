package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {
	
	@FindBy(xpath="//input[@name='q'] | //input[@title=('Search')]")
	public static WebElement searchTextbox;
	
	@FindBy(xpath="//*[contains(text(),'Rating:') and //h3[contains(text(),'Google Play')]]")
	public static WebElement zomatoPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating:') and //h3[contains(text(),'App Store')]]")
	public static WebElement zomatoAppstore;
	
	@FindBy(xpath="//*[contains(text(),'Rating:') and //h3[contains(text(),'Google Play')]]")
	public static WebElement swiggyPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating:') and //h3[contains(text(),'App Store')]]")
	public static WebElement swiggyAppstore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'Netflix – Apps on Google Play')]]")
	public static WebElement netflixPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'App Store')]]")
	public static WebElement netflixAppstore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'ZEE5: Movies, TV Shows, Web Series, News - Google Play')]]")
	public static WebElement zee5Playstore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'App Store')]]")
	public static WebElement zee5Appstore;
	
	
	public static String zomatoPlaystore() {
		
		return zomatoPlaystore.getText();
	}
	
	public static String swiggyPlaystore() {
		
		return swiggyPlaystore.getText();
	}
	
	public static String netflixPlaystore() {
		return netflixPlaystore.getText();
		
	}
	
	public static String zee5Playstore() {
		return zee5Playstore.getText();
		
	}
	

}

//b1 branch updated
