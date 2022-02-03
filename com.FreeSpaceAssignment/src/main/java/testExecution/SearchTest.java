package testExecution;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import broswerSetup.Setupbrowser;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import pageElements.PageObjects;

public class SearchTest extends Setupbrowser{
	
	
	@Test
	public void SearchApp() throws BiffException, IOException, InterruptedException, RowsExceededException, WriteException {
		PageFactory.initElements(driver, pageElements.PageObjects.class);
		
		File file=new File(System.getProperty("user.dir")+"//TestData//TestData.xls");
		Workbook wb=Workbook.getWorkbook(file);
		
		PageObjects.searchTextbox.sendKeys(wb.getSheet(0).getCell(0, 1).getContents());
		Actions PressEnterKey = new Actions(driver);
		PressEnterKey.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		Setupbrowser.pageScrollDown();
		Thread.sleep(3000);
		String ZomatoRating=PageObjects.zomatoPlaystore.getText();
		System.out.println(ZomatoRating);
		
		WritableWorkbook write = Workbook.createWorkbook(file);
		WritableSheet sht = write.getSheet(0);
		
		
		
		
		
	}

}
