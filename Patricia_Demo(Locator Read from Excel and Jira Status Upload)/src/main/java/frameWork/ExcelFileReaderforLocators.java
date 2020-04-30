package frameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.webAction;

public class ExcelFileReaderforLocators {
	
	WebDriver driver;
	
	public static WebElement outValue = null;
	
	 HashMap<String, String> locatorsHashMap = new HashMap<String, String>();
	 HashMap<String, String> elementHashMap = new HashMap<String, String>();
	//newly created
	
	public void excelFileReaderOfLocators(String pageName) throws IOException{

		String filePath =  System.getProperty("user.dir")+"\\src\\data\\Locators.xlsx";
		String fileName =  PropertyReader.readProperty("fileName");//to take file type
		String sheetName =  pageName;
		FileInputStream inputStream = new FileInputStream(filePath);
		Workbook Workbook = null;    
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}
		Sheet WorkSheet = Workbook.getSheet(sheetName);
		int rowCount = WorkSheet.getLastRowNum()-WorkSheet.getFirstRowNum();

		try {
			for (int i = 0; i < rowCount+1; i++) {
				Row row = WorkSheet.getRow(i);
				Cell cell= row.getCell(0);
				String cell_Value_locators = cell.toString();
				//System.out.println(cell_Value);
				Cell cell1= row.getCell(1);
				String cell_Value_By = cell1.toString();
				Cell cell_Out_Value= row.getCell(2);
				String CoutValue = cell_Out_Value.toString();
				locatorsHashMap.put(cell_Value_locators, cell_Value_By);
				elementHashMap.put(cell_Value_locators,CoutValue);				
				inputStream.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to read the Excel File");
		}

	}	

	//This is to read the locators
	public WebElement element(String element_Name) {	
		
		String byLocator=locatorsHashMap.get(element_Name).toLowerCase().replace(" ", "");
		String valueLocator= elementHashMap.get(element_Name);
		
		WebDriverWait switchWait = new WebDriverWait(driver, 10);
		try {
			switch (byLocator) {
			case "classname":
				//@FindBy(className=valueLocator) ;
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.className(valueLocator)));
				outValue=driver.findElement(By.className(valueLocator));
				break;
			case "cssselector":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(valueLocator)));
				outValue=driver.findElement(By.cssSelector(valueLocator));		
				break;
			case "id":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.id(valueLocator)));
				outValue=driver.findElement(By.id(valueLocator));		
				break;
			case "linktext":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(valueLocator)));
				outValue=driver.findElement(By.linkText(valueLocator));		
				break;
			case "name":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.name(valueLocator)));
				outValue=driver.findElement(By.name(valueLocator));		
				break;
			case "partiallinktext":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(valueLocator)));
				outValue=driver.findElement(By.partialLinkText(valueLocator));		
				break;
			case "tagname":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(valueLocator)));
				outValue=driver.findElement(By.tagName(valueLocator));		
				break;
			case "xpath":
				switchWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(valueLocator)));
				outValue=driver.findElement(By.xpath(valueLocator));
				break;
			default:
				break;
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to locate the element");
		}
		return outValue;
	}

}
