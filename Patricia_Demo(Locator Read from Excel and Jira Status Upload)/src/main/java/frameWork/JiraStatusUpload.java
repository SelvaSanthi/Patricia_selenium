package frameWork;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JiraStatusUpload {


	WebDriver driver;
	public static WebElement outValue = null;
	String cell_ValueJ;
	String cell_ValueJ1;
	String cell_ValueJ2;
	String cell_ValueJ3;
	int rowCount;
	Sheet WorkSheet;
	

		HashMap<String, String> excelHashMapJira= new HashMap<String, String>();
		HashMap<String, String> locatorsHashMap = new HashMap<String, String>();
		HashMap<String, String> elementHashMap = new HashMap<String, String>();
	
		//newly created for read locators from excel
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
			e.printStackTrace();
			System.out.println("Unable to locate the element");
		}
		return outValue;
	}

	public void driverWait(WebElement elementJ) {
		WebDriverWait driverwait= new WebDriverWait(driver,5);
		driverwait.until(ExpectedConditions.elementToBeClickable(elementJ));
		
	}

	public void systemJWait() throws InterruptedException {
		Thread.sleep(1500);
	}

	protected Robot keyboardAction() throws AWTException {
		Robot keyboard=new Robot();
		return keyboard;
	}

	
	public void launchJira() { 
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(PropertyReader.readProperty("Jirapage"));
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("Unable to launch the Jira page");
		}
	}
	public void loginToJira() throws InterruptedException {
		try {
			element("loginUsernameJ").sendKeys(PropertyReader.readProperty("Jira_Username"));
			element("btnLoginJ").click();
			driverWait(element("loginPasswordJ"));
			element("loginPasswordJ").sendKeys(PropertyReader.readProperty("Jira_Password"));
			element("btnLoginJ").click();
			systemJWait();
			element("jiraSoftwarepage").click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to login into the Jira home page");
		}	
	}
	public void searchFieldJira(String TestCaseId) throws AWTException, InterruptedException {
		try {
			systemJWait();
			driverWait(element("jiraSearchField"));
			element("jiraSearchField").click();
			element("jiraSearchField").sendKeys(TestCaseId);
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to searh a Testcase");
		}
	}

	public void addDefect(String imgPath) throws InterruptedException, AWTException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			systemJWait();
			element("addDefect").click();
			element("createDefect").click();
			driver.switchTo().defaultContent();
			driverWait(element("summaryField"));
			element("summaryField").sendKeys("Expected conditios not match");
			keyboardAction().keyPress(KeyEvent.VK_END);
			keyboardAction().keyRelease(KeyEvent.VK_END);
			keyboardAction().keyPress(KeyEvent.VK_PAGE_UP);
			keyboardAction().keyRelease(KeyEvent.VK_PAGE_UP);
			driverWait(element("btnBrowse"));
			systemJWait();
			element("btnBrowse").sendKeys(imgPath);
			//System.out.println(driver.findElements(By.tagName("iframe")).size());
			driver.switchTo().frame(element("iframeDoc"));
			//System.out.println("frame entered");
			systemJWait();systemJWait();
			driverWait(element("btnupload"));
			element("btnupload").click();
			Clipboard copy= Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection copy_value= new StringSelection(imgPath); 
			copy.setContents(copy_value, null); 
			systemJWait();
			keyboardAction().keyPress(KeyEvent.VK_CONTROL);
			keyboardAction().keyPress(KeyEvent.VK_V);
			keyboardAction().keyRelease(KeyEvent.VK_V);
			keyboardAction().keyRelease(KeyEvent.VK_CONTROL);
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(6000);
			element("btnInsert").click();
			driver.switchTo().defaultContent();
			driverWait(element("issueSubmit"));
			Thread.sleep(6000);
			driver.switchTo().defaultContent();
			keyboardAction().keyPress(KeyEvent.VK_ALT);
			keyboardAction().keyPress(KeyEvent.VK_S);
			keyboardAction().keyRelease(KeyEvent.VK_S);
			keyboardAction().keyRelease(KeyEvent.VK_ALT);
			systemJWait();
			driver.switchTo().defaultContent();
		} catch (HeadlessException e) {
			e.printStackTrace();
			System.out.println("Add defect not completed successfully");
		}
	}

	public void statusUpdateJira(String Status, String imagepath) throws InterruptedException, AWTException {
		try {
			driverWait(element("jiraExecutionFlag"));
			element("jiraExecutionFlag").click();
			keyboardAction().keyPress(KeyEvent.VK_HOME);
			keyboardAction().keyRelease(KeyEvent.VK_HOME);
			systemJWait();
			driver.switchTo().frame(0);
			driverWait(element("jiraExeIcon"));
			systemJWait();
			element("jiraExeIcon").click();
			driver.switchTo().defaultContent();
			//System.out.println(driver.findElements(By.tagName("iframe")).size());
			systemJWait();
			driverWait(element("frameToPopup"));
			driver.switchTo().frame(element("frameToPopup"));
			//System.out.println("frame entered");
			systemJWait();
			element("radiobtnExecute").click();
			driverWait(element("versionField"));
			element("versionField").sendKeys("Unscheduled");
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			systemJWait();
			driverWait(element("cycleSummaryField"));
			element("cycleSummaryField").sendKeys("Cycle-One");
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			systemJWait();
			driverWait(element("testField"));
			element("testField").sendKeys("Page-One");
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			systemJWait();
			driverWait(element("btnExecute"));
			element("btnExecute").click();
			driver.switchTo().defaultContent();
			//System.out.println(driver.findElements(By.tagName("iframe")).size());
			systemJWait();
			driverWait(element("frameExePage"));
			driver.switchTo().frame(element("frameExePage"));
			//System.out.println("frame2");
			systemJWait();systemJWait();
			driverWait(element("jiraStatusExeDropdown"));
			element("jiraStatusExeDropdown").click();
			if (Status.equalsIgnoreCase("Pass")) {
				driverWait(element("jiraStatusExePASS"));
				element("jiraStatusExePASS").click();
			}else if (Status.equalsIgnoreCase("Fail")) {
				driverWait(element("jiraStatusExeFAIL"));
				element("jiraStatusExeFAIL").click();
			} 
			systemJWait();systemJWait();
			systemJWait();systemJWait();
			driver.switchTo().defaultContent();
			keyboardAction().keyPress(KeyEvent.VK_END);
			keyboardAction().keyRelease(KeyEvent.VK_END);
			driver.switchTo().frame(0);
			driverWait(element("jiraStatusTestDropdown"));
			systemJWait();
			element("jiraStatusTestDropdown").click();
			if (Status.equalsIgnoreCase("Pass")) {
				driverWait(element("jiraStatusTestPASS"));
				element("jiraStatusTestPASS").click();
				driver.switchTo().defaultContent();
			}else if (Status.equalsIgnoreCase("Fail")) {
				driverWait(element("jiraStatusTestFAIL"));
				element("jiraStatusTestFAIL").click();
				addDefect(imagepath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to update the Test status");
		}

	}
	public void logout() throws InterruptedException, AWTException {
		systemJWait();systemJWait();systemJWait();
		driverWait(element("btnMyProfile"));
		/*systemJWait();systemJWait();
		systemJWait();systemJWait();
		element("btnMyProfile").click();
		driverWait(element("btnLogoutJ"));
		element("btnLogoutJ").click();*/
		driver.close();
	}


	public void zephyrStatusUpload(String suitename) throws AWTException, IOException, InterruptedException {
		launchJira();
		excelFileReaderOfLocators("JiraPage");
		//initializeElementJ();
		loginToJira();

		String filePath =  System.getProperty("user.dir")+"\\src\\data\\TestNGXML.xlsx";
		String fileName =  PropertyReader.readProperty("fileName");
		String sheetName =  PropertyReader.readProperty("sheetName");
		String column_Value= "7";
		int c_Value = Integer.parseInt(column_Value);
		FileInputStream inputStream = new FileInputStream(filePath);
		Workbook Workbook = null;    
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}
		WorkSheet = Workbook.getSheet(sheetName);
		rowCount = WorkSheet.getLastRowNum()-WorkSheet.getFirstRowNum();

		for (int i = 0; i < rowCount+1; i++) {
			Row row = WorkSheet.getRow(i);
			Cell cell= row.getCell(0);
			cell_ValueJ = cell.toString();
			//System.out.println(cell_Value);
			if (cell_ValueJ.equalsIgnoreCase(suitename)&&row.getCell(3).toString().equalsIgnoreCase("Yes"))
			{
				//for (int j = 0; j < rowCount+1; j++) {
				Row row1 = WorkSheet.getRow(i);//next column  
				Cell cell1= row1.getCell(1);
				cell_ValueJ1 = cell1.toString();
				//System.out.println(c_Value);
				Cell cell_Out_Value= row1.getCell(c_Value);
				cell_ValueJ2=cell_Out_Value.toString();

				Cell cell_Out_path= row1.getCell(c_Value+1);
				cell_ValueJ3 = cell_Out_path.toString();
				
				searchFieldJira(cell_ValueJ1);
				statusUpdateJira(cell_ValueJ2, cell_ValueJ3);
				if (cell_ValueJ2.equalsIgnoreCase("Fail")) {
					driverWait(element("createdIssueNo"));
					row.createCell(9).setCellValue(element("createdIssueNo").getText());
					inputStream.close();
					FileOutputStream issueno= new FileOutputStream(filePath);
					Workbook.write(issueno);
					issueno.close();
				}else {
					inputStream.close();
				}

			}
		}	
		logout();
	}

}

