package flipkartStepDef;

import java.awt.AWTException;

import java.io.IOException;
import java.util.Date;

import flipkartPages.FlipkartProduct;
import flipkartSupport.CustomExtentReport;
import flipkartSupport.ExtentReport;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAndSearchStepDef extends FlipkartProduct {

	private static CustomExtentReport customExtentReport;
	private static boolean isReporterRunning;

	@When("Launch flipkart application")
	public void launch_flipkart_application() throws InterruptedException {
		//ExtentReport.extent.startReporter(reporterType, filePath)
		URLsetup();
	}

	@When("Enter {string} and {string}")
	public void enter_and(String username, String password) {
		initializeElement();
		login(username, password);
	}

	@Then("User should be successfully navigated to Homepage")
	public void user_should_be_successfully_navigated_to_Homepage() {
		loginvalidate();
	}

	@Then("Logout from the application")
	public void logout_from_the_application() throws InterruptedException {
		finalsetup();
	}

	@When("Enter {string} to search")
	public void enter_to_search(String product) throws InterruptedException {
		search(product);
	}

	@Then("Product should be successfully searched")
	public void product_should_be_successfully_searched() {
		validateSearch();
	}

	@When("Click on the product in the search result to view details")
	public void click_on_the_product_in_the_search_result_to_view_details() throws InterruptedException, AWTException {
		selectaProduct();
	}

	@When("Add the the product to the wishlist")
	public void add_the_the_product_to_the_wishlist() throws InterruptedException {
		addtoWishlist();
	}

	@Then("Product should be successfully added to wishlist")
	public void product_should_be_successfully_added_to_wishlist() throws InterruptedException {
		validateWishlist();
	}

	@When("Navigate to userprofile and click on wishlist")
	public void navigate_to_userprofile_and_click_on_wishlist() throws InterruptedException {
		movetoWishlist();
	}

	@When("Click on the product from the wishlist to remove")
	public void click_on_the_product_from_the_wishlist_to_remove() throws InterruptedException {
		removefromWishlist();
	}

	@Then("Product should be successfuly removed from the wishlist")
	public void product_should_be_successfuly_removed_from_the_wishlist() throws InterruptedException {
		validateWishlist();
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		initializeElement();
		loginfromexcel(username, password);
	}

	@When("User enter {string} to search")
	public void user_enter_to_search(String product) throws InterruptedException, IOException {
		searchfromexcel(product);
	}

	@Before
	public void beforeScenario(io.cucumber.java.Scenario scenario) {
		Date date= new Date();
		if (!isReporterRunning) {
			System.out.println(System.getProperty("user.dir"));
			customExtentReport = new CustomExtentReport(System.getProperty("user.dir")+"\\src\\reports\\"+sdf.format(date)+".html");
			isReporterRunning=true;
		}
	}

	@After
	public void afterScenario(io.cucumber.java.Scenario scenario) throws IOException, InterruptedException {

		/*		String ScreenshotFileName=System.getProperty("user.dir")+"\\target\\cucumer.html\\embedded0.png";*/
		String screenShotPath = "";
		// creating object for ScreenShotCapture
		flipkartSupport.ScreenShotCapture screenshotObject = new flipkartSupport.ScreenShotCapture();
		if (scenario.isFailed()) {

			if (driver != null) {
				screenShotPath = screenshotObject.capture(driver,generateFileName(scenario));
			}
			customExtentReport.createTest(scenario, screenShotPath);
			customExtentReport.writeReport();
		}else {
			customExtentReport.createTest(scenario, screenShotPath);
			customExtentReport.writeReport();
		}
	}
	
/*	@After
	public void final_setup() throws InterruptedException {
		
		finalsetup();
	}*/

}
