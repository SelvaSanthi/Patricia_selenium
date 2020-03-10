package TestPatrixmaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestPatrixmavenSupport.ScreenShotCapture;
import TestPatrixmavenSupport.ExtentReport;
import TestPatrixmavenSupport.Log;
import TestPatrixmavenSupport.PropertyReader;



public class webAction {
	
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
	
	
	//@AfterSuite
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
	
	/**
	 * 
	 */
	public void getUrl() {
		try {
//			driver.get(url_to);
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
			TittleCheck();
			loginUsername.sendKeys(user);
			loginPassword.sendKeys(password);
			btnLogin.click();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the application");
		}
		return val;
	}
	
	public boolean TittleCheck() throws InterruptedException {
		boolean val=false;
		try {
			title= driver.getTitle();
			if (title.equalsIgnoreCase("Patricia")) {
				System.out.println("System successfully navigate to "+driver.getTitle()+" Home page");
			} else {
				System.out.println("System not successfully navigate to "+driver.getTitle()+" Home page");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("System not Navigate to the Patricia Home page");
		}
		return val;
	}
	
/*	public void SearchCheck() throws IOException, InterruptedException {
		excelFileReader(4, 1);
		String title=driver.getTitle();
		if (title.equalsIgnoreCase(excelCellValue)) {System.out.println("System successfully Opened Searched Case No : "+driver.getTitle());
		} else {
		System.out.println("System not successfully Opened Searched Case No. ");
		}	
	}*/
	
	public boolean searchForCase() throws IOException, InterruptedException {
		boolean val= false;
		try {
			driverWait();
			excelFileReader(4, 1);
			searchField.sendKeys(excelCellValue);
			driverWait();
			btnHomepageSearch.click();
			//SearchCheck();
			driverWait();
			 message = incrementSteps() + " Search for Case No: " +excelCellValue;
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Invalid CaseNo");
			
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
		
	public void excelFileReader(int a, int b) throws IOException {
		FileInputStream File = new FileInputStream("C:\\Users\\selvamuthukumar.g.ZUCISYSTEMS\\OneDrive - zucisystems.com\\SG\\Patricia\\Automation\\Testmaven\\CaseCreation.xlsx");
		XSSFWorkbook Wbook;
		Wbook = new XSSFWorkbook(File);
		XSSFSheet Sheet = Wbook.getSheet("Sheet1");
		XSSFRow Row = Sheet.getRow(a);
		XSSFCell Cell = Row.getCell(b);
		excelCellValue = Cell.getStringCellValue();

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
		
	//@AfterMethod
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
