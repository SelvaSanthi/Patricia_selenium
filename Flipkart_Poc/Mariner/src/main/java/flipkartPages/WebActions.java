package flipkartPages;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WebActions {

	public  WebDriver driver;

	//Locators
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']") public static WebElement usernameField;
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']") public static WebElement passwordField;
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']") public static WebElement btnlogin;
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']") public static WebElement homePageSearch;
	@FindBy(xpath="//span[@class='_2yAnYN']") public static WebElement resultSearch;
	@FindBy(xpath="//div[contains(text(),'Selvamuthukumar')]") public static WebElement userAccountName;
	@FindBy(xpath="//button[@class='vh79eN']//*[local-name()='svg']") public static WebElement btnSearch;
	@FindBy(xpath="//div[contains(text(),'Apple iPhone 7 (Black, 32 GB)')]") public static WebElement producttobeAdd;
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
		try {
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
			Assert.assertEquals(true, check);
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
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
			finalsetup();
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
		systemWait();
		movetoWishlist();
		waitUntil(resultWishlist);
		String result=resultWishlist.getText();
		System.out.println(result);
	}

	//This is to move to the wishlist
	public void movetoWishlist() {
		waitUntil(userAccountName);
		mouseAction(userAccountName);
		optWishlist.click();
	}

	//This is to remove from wishlist
	public void removefromWishlist() {
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
	public void finalsetup() {
		waitUntil(userAccountName);
		mouseAction(userAccountName);
		waitUntil(btnLogout);
		btnLogout.click();
		driver.quit();

	}


}	

