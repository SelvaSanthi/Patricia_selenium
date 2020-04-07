package flipkartPages;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.mkolisnyk.cucumber.reporting.CucumberCustomReport;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import flipkartSupport.CustomExtentReport;
import flipkartSupport.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import junit.framework.Assert;

public class FlipkartProduct {

	public  WebDriver driver;


	String excelCellValue;

	//Locators
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']") public static WebElement usernameField;
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']") public static WebElement passwordField;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']") public static WebElement btnlogin;
	@FindBy(xpath="//img[@alt='Flipkart']") public static WebElement btnhomepage;
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']") public static WebElement homePageSearch;
	@FindBy(xpath="//span[@class='_2yAnYN']") public static WebElement resultSearch;
	@FindBy(xpath="//div[contains(text(),'Selvamuthukumar')]") public static WebElement userAccountName;
	@FindBy(xpath="//button[@class='vh79eN']//*[local-name()='svg']") public static WebElement btnSearch;
	@FindBy(xpath="//div[text()='Relevance']/following::div[10]") public static WebElement producttobeAdd;
	@FindBy(xpath="//*[text()='GO TO CART']|//*[text()='ADD TO CART']") public static WebElement btnAddCart;
	@FindBy(xpath="//div[@class='_3gDSOa _13EqDR']/child::div") public static WebElement btnWishlist;
	@FindBy(xpath="//a[@href='/wishlist?link=home_wishlist']") public static WebElement optWishlist;
	@FindBy(xpath="//div[@class='_3oWply']/child::span") public static WebElement resultWishlist;
	@FindBy(xpath="//div[@class='col col-2-12 _1uJCYU']/child::div/child::span") public static WebElement btnDeleteWishlist;
	@FindBy(xpath="//button[text()='YES, REMOVE']") public static WebElement btnYesRemove;
	@FindBy(xpath="//span[text()='Cart']") public static WebElement icnCart;
	@FindBy(xpath="//div[text()='Save for later']") public static WebElement addSaveforLater;
	@FindBy(xpath="//div[text()='Move to cart']") public static WebElement btnMovetoCart;
	@FindBy(xpath="//div[text()='Orders']") public static WebElement optOrder;
	@FindBy(xpath="//div[text()='Logout']") public static WebElement btnLogout;


	//Initial setup
	public void URLsetup() throws InterruptedException {

		String Browser=PropertyReader.readProperty("Browser");

		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				driver= new ChromeDriver();

			} else if (Browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");


		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not navigate to URL");
		}

	}	


	//This method is to read the data form the excel file
	public String excelFileReader(String varName) throws IOException{
		String filePath =  System.getProperty("user.dir")+"\\src\\data\\inputData.xlsx";
		String fileName =  PropertyReader.readProperty("fileName");
		String sheetName =  PropertyReader.readProperty("sheetName");
		String column_Value=PropertyReader.readProperty("setofData_ColumnNumber");
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
			String cell_Value = cell.toString();
			if (cell_Value.equalsIgnoreCase(varName))
			{
				Cell cell_Out_Value= row.getCell(c_Value);
				excelCellValue=cell_Out_Value.toString();
				inputStream.close();
				break;
			}		
		}
		return excelCellValue;

	}

	//This is to perform login process
	public void loginfromexcel(String username ,String password ) {
		try {
			waitUntil(usernameField);
			waitUntil(passwordField);
			excelFileReader(username);
			usernameField.sendKeys(excelCellValue);
			excelFileReader(password);
			passwordField.sendKeys(excelCellValue);
			btnlogin.click();	
			systemWait();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the flipkart application");
		}
	}

	//This is to search for a product
	public void searchfromexcel(String product) throws InterruptedException, IOException {
		waitUntil(homePageSearch);
		excelFileReader(product);
		homePageSearch.sendKeys(excelCellValue);
		systemWait();
		btnSearch.click();
	}

	//This is for driver wait until the expected condition
	public void waitUntil(WebElement waitElement) {
		WebDriverWait driverWait = new WebDriverWait(driver, 8);
		driverWait.until(ExpectedConditions.elementToBeClickable(waitElement));
	}

	//This is to wait
	public void systemWait() throws InterruptedException {
		Thread.sleep(2000);
	}

	//This is to for mouse actions
	public void mouseAction(WebElement mElement) {
		Actions mAction = new Actions(driver);
		mAction.moveToElement(mElement).build().perform();
	}

	//This method is to Initialize the elements
	public boolean initializeElement() {
		boolean returnValue = false;
		try {
			PageFactory.initElements(driver, this);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	//This is to perform login process
	public void login(String username ,String password ) {
		try {
			waitUntil(usernameField);
			waitUntil(passwordField);
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			btnlogin.click();	
			systemWait();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the flipkart application");
		}
	}

	//This is to validate the login page
	public void loginvalidate() {
		try {
			waitUntil(userAccountName);
			boolean check=userAccountName.isDisplayed();
			//			Assert.assertEquals(true, check);
		} catch (Exception e) {
			e.printStackTrace();
			//driver.quit();
		}
	}

	//This is to search for a product
	public void search(String product) throws InterruptedException {
		waitUntil(homePageSearch);
		homePageSearch.sendKeys(product);
		systemWait();
		btnSearch.click();
	}

	//This is to validate the search
	public void validateSearch() {
		try {
			waitUntil(resultSearch);
			String result=resultSearch.getText();
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("No search result found");

		}

	}

	//This is to add a product to cart
	public void selectaProduct() throws InterruptedException, AWTException {
		waitUntil(producttobeAdd);
		producttobeAdd.click();
		systemWait();

	}
	//This is to add the product to cart
	public void addToCart() throws InterruptedException {
		Set<String> windows=driver.getWindowHandles();

		for (String string : windows) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if (title.contains("Buy Products")) {
				driver.close();
			}
		}
		systemWait();
		btnAddCart.click();
	}
	//This is to add a product from wishlist
	public void addtoWishlist() throws InterruptedException {
		Set<String> windows=driver.getWindowHandles();

		for (String string : windows) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if (title.contains("Buy Products")) {
				driver.close();
			}
		}
		waitUntil(btnWishlist);
		btnWishlist.click();
	}

	//This is to validate wishlist
	public void validateWishlist() throws InterruptedException {
		driver.navigate().refresh();
		waitUntil(userAccountName);
		movetoWishlist();
		waitUntil(resultWishlist);
		String result=resultWishlist.getText();
		System.out.println(result);
	}

	//This is to move to the wishlist
	public void movetoWishlist() throws InterruptedException {
		systemWait();
		waitUntil(userAccountName);
		mouseAction(userAccountName);
		optWishlist.click();
	}

	//This is to remove from wishlist
	public void removefromWishlist() throws InterruptedException {
		waitUntil(btnDeleteWishlist);
		btnDeleteWishlist.click();
		waitUntil(btnYesRemove);
		btnYesRemove.click();

	}

	//This is to add a product to save for later
	public void addSaveforLater() {
		waitUntil(icnCart);
		icnCart.click();
		waitUntil(addSaveforLater);
		addSaveforLater.click();
	}

	//This is to remove a product from save for later
	public void removeProduct() {
		waitUntil(icnCart);
		icnCart.click();
		waitUntil(btnMovetoCart);
		btnMovetoCart.click();
	}

	//This is to check the previous order
	public void checkPreviousOrder() throws InterruptedException {
		waitUntil(userAccountName);
		mouseAction(userAccountName);
		waitUntil(optOrder);
		optOrder.click();
		systemWait();
		java.util.List<WebElement> countOrder =driver.findElements(By.className("_7BRRQk"));
		int count=countOrder.size();
		System.out.println("There are "+count+" orders are available");
	}


	
	//This is to logout and close the browser
	public void finalsetup() throws InterruptedException {		
		systemWait();
		waitUntil(userAccountName);
		mouseAction(userAccountName);
		waitUntil(btnLogout);
		btnLogout.click();
		driver.quit();

	}


	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");



	public static String generateFileName(io.cucumber.java.Scenario scenario) {
		Date date = new Date();
		String fileName = scenario.getName() + "_" + sdf.format(date);
		return fileName;
	}









}	

