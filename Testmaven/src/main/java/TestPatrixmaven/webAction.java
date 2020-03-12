package TestPatrixmaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPatrixmavenSupport.ScreenShotCapture;
import TestPatrixmavenSupport.ExtentReport;
import TestPatrixmavenSupport.Log;
import TestPatrixmavenSupport.PropertyReader;

public class webAction  {

	//Driver declaration
	WebDriver driver;
	
	//Variable declaration
	public int stepNum = 1;
	public static ExtentTest test;
	public String message = "";
	public String testCaseStatus;
	String excelCellValue;
	public String testCaseID;
	String title;
	String cellValue;
	String cell_Value;
	String cell_Value_in;
	

	//Creating objects
	ExtentReport extentReportObject = new ExtentReport();
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	public static DOMConfigurator domconfig;

	//Config properties
	public String url_to = PropertyReader.readProperty("url");
	public String user = PropertyReader.readProperty("Username");
	public String password = PropertyReader.readProperty("Password");

	public webAction() {
		domconfig = new DOMConfigurator();
		DOMConfigurator.configure("log4j.xml");
	}

	//Locators
	@FindBy(xpath="//input[contains(@class,'v-textfield')][@type='text']") 
	public static WebElement loginUsername;
	@FindBy(xpath="//input[contains(@class,'v-textfield')][@type='password'] ") 
	public static WebElement loginPassword;
	@FindBy(xpath="//div[contains(@class,'v-button-trish-login-button')]") 
	public static WebElement btnLogin;
	@FindBy(xpath="//div[@class='v-slot v-slot-logout v-align-middle']/child::div/child::span") 
	public static WebElement btnLogout;
	@FindBy(xpath="//input[contains(@class,'v-textfield')]") 
	public static WebElement searchField;
	@FindBy(xpath="//div[@class='v-button v-widget v-has-height start-search-button v-button-start-search-button no-shadow v-button-no-shadow focused v-button-focused']") 
	public static WebElement btnHomepageSearch;
	@FindBy(id="documents_tab") 
	public static WebElement documentTabWidget;

	public void before_Suite() throws IOException{
		try {
			launchDriver();
			getUrl();
			extentReportObject.publishReports();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("System could not navigate to application URL");
		}
	}

	public void closeDriver() throws InterruptedException {

		driverWait();
		driverUntilWait(btnLogout);
		btnLogout.click();
		driverWait();
		if (driver != null) {
			driver.close();
		}
		ExtentReport.extent.flush();
	}
	/**
	 * This method is used to launch the driver
	 */
	public void launchDriver() {	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\selvamuthukumar.g.ZUCISYSTEMS\\OneDrive - zucisystems.com\\SG\\Patricia\\Automation\\Testmaven\\chromedriver.exe");
	}

	public void getUrl() {
		try {
			driver.navigate().to(url_to);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Could not navigate to the Application Login page");
		}
	}

	public String incrementSteps() {
		return "Step No: " + stepNum++ ;
	}

	public boolean initializeElement() {
		boolean returnValue = false;
		try {
			PageFactory.initElements(driver, this);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public boolean loginToPatricia() throws IOException, InterruptedException {
		boolean val=false;
		try {
			loginUsername.sendKeys(user);
			loginPassword.sendKeys(password);
			btnLogin.click();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the application");
		}
		return val;
	}

	public void SearchCheck(String SearchCheckValue) throws IOException, InterruptedException {
		boolean val= false;
		try {
			driverWait();
			searchField.sendKeys(excelFileReader(SearchCheckValue));
			driverWait();
			btnHomepageSearch.click();
			driverWait();
			message = incrementSteps() + " Search for Case No: " +excelFileReader(SearchCheckValue);
			driverWait();
			driverWait();
			String title=driver.getTitle();
			if (title.equals(excelFileReader(SearchCheckValue))) {message = incrementSteps() + " Search for Case No: " +excelFileReader(SearchCheckValue);
			} else { if (title.equals("Patricia")) {

			}
			message = incrementSteps() + " No Results found for Case No: " +excelFileReader(SearchCheckValue);}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("No Results found");
		}	
	}

	public boolean searchForCase(String searchForCaseValue) throws IOException, InterruptedException {
		boolean val= false;
		try {
			driverWait();
			searchField.sendKeys(excelFileReader(searchForCaseValue));
			driverWait();
			btnHomepageSearch.click();
			driverWait();
			message = incrementSteps() + " Search for Case No: " +excelFileReader(searchForCaseValue);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("No Results found");
		}
		return val;
	}
	
	public boolean documentWidget() throws IOException, InterruptedException {
		boolean val = false;
		try {

			driverUntilWait(documentTabWidget);
			documentTabWidget.click();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("There are No documents available");
		}
		return val;
	}
	
	public void driverUntilWait(WebElement element) {
		WebDriverWait driverwait=new WebDriverWait(driver, 10);
		driverwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String excelFileReader(String varName) throws IOException{
		String filePath =  PropertyReader.readProperty("filePath");;
		String fileName =  PropertyReader.readProperty("fileName");
		String sheetName =  PropertyReader.readProperty("sheetName");
		String column_Value= PropertyReader.readProperty("setofData_ColumnNumber");
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
		Sheet WorkSheet = Workbook.getSheet(sheetName);
		int rowCount = WorkSheet.getLastRowNum()-WorkSheet.getFirstRowNum();

		for (int i = 0; i < rowCount+1; i++) {
			Row row = WorkSheet.getRow(i);
			Cell cell= row.getCell(0);
			cell_Value = cell.toString();
			if (cell_Value.equalsIgnoreCase(varName))
			{
				Cell cell_Out_Value= row.getCell(c_Value);
				excelCellValue=cell_Out_Value.getStringCellValue();
				inputStream.close();
				break;
			}		
		}
		return excelCellValue;
		
	}
	
	public void excelFileWriter(String inputVariable, String inputValue) throws IOException{
		String filePath_in =  PropertyReader.readProperty("filePath_writer");;
		String fileName_in =  PropertyReader.readProperty("fileName_writer");
		String sheetName_in =  PropertyReader.readProperty("sheetName_writer");
		
		FileInputStream inputStream = new FileInputStream(filePath_in);
		Workbook Workbook = null;    
		String fileExtensionName = fileName_in.substring(fileName_in.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
			Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			Workbook = new HSSFWorkbook(inputStream);
		}
		Sheet WorkSheet = Workbook.getSheet(sheetName_in);
		int rowCount = WorkSheet.getLastRowNum()-WorkSheet.getFirstRowNum();
		Row newRow = WorkSheet.createRow(rowCount+1);
		newRow.createCell(0).setCellValue(inputVariable);
		newRow.createCell(1).setCellValue(inputValue);

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(filePath_in);
		Workbook.write(outputStream);
		outputStream.close();


	}	
		
	
	
	
	
	
	
	
	
	
	
	

	protected Robot keyboardAction() throws AWTException {
		Robot keyboard=new Robot();
		return keyboard;
	}

	public void driverWait() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static String generateFileName(ITestResult result) {
		Date date = new Date();
		String fileName = result.getName() + "_" + sdf.format(date);
		return fileName;
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		try {
			String screenShotPath = "";
			// creating object for ScreenShotCapture
			ScreenShotCapture screenshotObject = new ScreenShotCapture();
			if (result.getStatus() == ITestResult.FAILURE) {
				Log.error(message);
				test.log(LogStatus.FAIL, message + "- FAIL");
				// Logging into JIRA for Failure
				test.log(LogStatus.FAIL, result.getThrowable());
				if (driver != null) {
					screenShotPath = screenshotObject.capture(driver, generateFileName(result));
					test.log(LogStatus.FAIL,
							"Snapshot below: " + result.getMethod() + test.addScreenCapture(screenShotPath + ".png"));
				}
				testCaseStatus = "FAIL";
			} else {
				testCaseStatus = "PASS";
				test.log(LogStatus.PASS, "Test case Executed Successfully - PASS");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

