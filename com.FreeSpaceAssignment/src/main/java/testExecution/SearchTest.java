package testExecution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import broswerSetup.Setupbrowser;
import pageElements.PageObjects;

public class SearchTest extends Setupbrowser {

	
	public static void enterData(WebElement appElement, int row, int cellNo, XSSFSheet sheet) {
		try {
			sheet.getRow(row).createCell(cellNo).setCellValue(appElement.getText().toString());

		} catch (NoSuchElementException e) {
			sheet.getRow(row).createCell(cellNo).setCellValue("-");
		}

	}

	@Test
	public static void SearchApp() throws Exception {
		PageFactory.initElements(driver, pageElements.PageObjects.class);

		FileInputStream fis = new FileInputStream((System.getProperty("user.dir") + "\\TestData\\TestData.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator(); // sh.rowIterator(); -- also works well
		if (rowIterator.hasNext())
			rowIterator.next();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.iterator();
			String inputData = cellIterator.next().toString();

			for (String exceldata : inputData.split("\\r\\n")) {

				PageObjects.searchTextbox.sendKeys(exceldata.split("\n"));
				Actions PressEnterKey = new Actions(driver);
				PressEnterKey.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(4000);
				Setupbrowser.pageScrollDown();
				Setupbrowser.ElementWait();

				if (exceldata.equalsIgnoreCase("Zomato")) {
					enterData(PageObjects.zomatoPlaystore, 1, 1, sheet);
					enterData(PageObjects.zomatoAppstore, 1, 2, sheet);

				}
				if (exceldata.equalsIgnoreCase("Swiggy")) {
					enterData(PageObjects.swiggyPlaystore, 2, 1, sheet);
					enterData(PageObjects.swiggyAppstore, 2, 2, sheet);
					
					
				}
				if (exceldata.equalsIgnoreCase("Netflix")) {
					enterData(PageObjects.netflixPlaystore, 3, 1, sheet);
					enterData(PageObjects.netflixAppstore, 3, 2, sheet);
					
				}
				if (exceldata.equalsIgnoreCase("Zee5")) {
					enterData(PageObjects.zee5Playstore, 4, 1, sheet);
					enterData(PageObjects.zee5Appstore, 4, 2, sheet);
					
				}

			}

			PageObjects.searchTextbox.clear();

		}
		FileOutputStream fos = new FileOutputStream((System.getProperty("user.dir") + "\\TestData\\TestData.xlsx"));
		workbook.write(fos);

	}

}

/*
 * sheet.getRow(1).createCell(1).setCellValue(PageObjects.zomatoPlaystore.
 * getText());
 * sheet.getRow(2).createCell(1).setCellValue(PageObjects.swiggyPlaystore.
 * getText());
 * sheet.getRow(3).createCell(1).setCellValue(PageObjects.netflixPlaystore.
 * getText());
 * sheet.getRow(4).createCell(1).setCellValue(PageObjects.zee5Playstore.getText(
 * )); FileOutputStream fos = new
 * FileOutputStream((System.getProperty("user.dir")+"\\TestData\\TestData.xlsx")
 * ); workbook.write(fos);
 */