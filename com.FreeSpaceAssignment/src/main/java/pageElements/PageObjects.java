package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {
	
	@FindBy(xpath="//input[@name='q'] | //input[@title=('Search')]")
	public static WebElement searchTextbox;
	
	@FindBy(xpath="//*[contains(text(),'Rating')  and  //*[contains(text(),'Zomato: Food Delivery & Dining – Apps on Google Play')]]")
	public static WebElement zomatoPlaystore;

}
