package Com.Flipkart.Pages;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import junit.framework.Assert;

public class WebActions {
	
	public static ExtentTest test;
	public int stepNum = 1;
	public WebDriver driver;
	public String message = "";
	public String testCaseStatus;
	public String CaseID;
	
	
	
	public String incrementSteps() {
		return "Step No: " + stepNum++ ;
	}
	
	//Locators
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']") public static WebElement username;
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']") public static WebElement password;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']") public static WebElement btnlogin;
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']") public static WebElement homePageSearch;
	@FindBy(xpath="//div[text()='Selvamuthukumar']") public static WebElement userAccountName;
	@FindBy(xpath="//button[@class='vh79eN']//*[local-name()='svg']") public static WebElement btnSearch;
	@FindBy(xpath="//div[contains(text(),'Apple iPhone 7 (Black, 32 GB)')]") public static WebElement producttobeAdd;
	@FindBy(xpath="//*[text()='GO TO CART']") public static WebElement btnAddCart;
	
	
	//Initial setup
	public void setup() throws InterruptedException {
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not navigate to URL");
		}
	}
	//This is for driver wait until the expected condition
	public void waitUntil(WebElement waitElement) {
		WebDriverWait driverWait = new WebDriverWait(driver, 5);
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
		mAction.click(mElement).build().perform();
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
	public void login() {
		try {
			username.sendKeys("8144855487");
			password.sendKeys("Selva@2000");
			btnlogin.click();	
			systemWait();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the flipkart application");
		}
	}
	
	
	public void logininvalid(String username_val ,String password_val ) {
		try {
			waitUntil(username);
			waitUntil(password);
			username.sendKeys(username_val);
			password.sendKeys(password_val);
			btnlogin.click();	
			systemWait();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Could not login to the flipkart application");
		}
	}
	
	//This is to validate the login page
	public void loginvalidate() {
			waitUntil(userAccountName);
			boolean check=userAccountName.isDisplayed();
			Assert.assertEquals(true, check);
	}
	
	//This is to search for a product
	public void search(String search_product) throws InterruptedException {
		waitUntil(homePageSearch);
		homePageSearch.sendKeys(search_product);
		systemWait();
		btnSearch.click();
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
		
		System.out.println(driver.getTitle());
		systemWait();
		btnAddCart.click();
		
	}
	
	}	

