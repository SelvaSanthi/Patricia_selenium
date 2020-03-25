package flipkartStepDef;

import java.awt.AWTException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import flipkartPages.WebActions;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginAndsearchStepDef extends WebActions {

	@When("Launch flipkart application")
	public void launch_flipkart_application() throws InterruptedException {
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
	public void logout_from_the_application() {
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
	public void navigate_to_userprofile_and_click_on_wishlist() {
		movetoWishlist();
	}

	@When("Click on the product from the wishlist to remove")
	public void click_on_the_product_from_the_wishlist_to_remove() {
		removefromWishlist();
	}

	@Then("Product should be successfuly removed from the wishlist")
	public void product_should_be_successfuly_removed_from_the_wishlist() throws InterruptedException {
		validateWishlist();
	}

	//This is to take screenshot
	@AfterStep
	public void screenShot(io.cucumber.java.Scenario scenario) {
	    if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	   // embed it in the report.
	      scenario.embed(screenshot, "image/png"); 
	      driver.close();
	    }
	}
}
