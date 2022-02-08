package testExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import broswerSetup.Setupbrowser;
import pageElements.PageObjects;

public class SearchTest extends Setupbrowser{
	
	
	@Test
	public static void SearchApp() throws InterruptedException, IOException{
		PageFactory.initElements(driver, pageElements.PageObjects.class);
		
		FileInputStream fis = new FileInputStream((System.getProperty("user.dir")+"\\TestData\\TestData.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator(); // sh.rowIterator(); -- also works well
		if (rowIterator.hasNext())
			rowIterator.next();
		
		while(rowIterator.hasNext()){               
		    Row row = rowIterator.next();               
		    Iterator<Cell> cellIterator = row.iterator();
		    String inputData=cellIterator.next().toString();
		    
		    for (String exceldata:inputData.split("\\r\\n")) {
		    
		    PageObjects.searchTextbox.sendKeys(exceldata.split("\n"));
		    Actions PressEnterKey = new Actions(driver);
			PressEnterKey.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(3000);
			Setupbrowser.pageScrollDown();
			Thread.sleep(4000);
			
		    }
		   PageObjects.searchTextbox.clear();
		    

	
		
		
		
		
		/*
		 * System.out.println(sheet.getRow(1).getCell(0));
		 * System.out.println(sheet.getRow(2).getCell(0));
		 */
		
		    
		    
		}
		
		
		}
		
		

}
