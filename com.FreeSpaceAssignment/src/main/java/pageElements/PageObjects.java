package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {
	
	@FindBy(xpath="//input[@name='q'] | //input[@title=('Search')]")
	public static WebElement searchTextbox;
	
	@FindBy(xpath="//*[contains(text(),'Rating')  and  //*[contains(text(),'Zomato: Food Delivery & Dining ? Apps on Google Play')]]")
	public static WebElement zomatoPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'Swiggy : Food Delivery & More – Apps on Google Play')]]")
	public static WebElement swiggyPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'Netflix – Apps on Google Play')]]")
	public static WebElement netflixPlaystore;
	
	@FindBy(xpath="//*[contains(text(),'Rating') and //*[contains(text(),'ZEE5: Movies, TV Shows, Web Series, News - Google Play')]]")
	public static WebElement zee5Playstore;
	
	

}
