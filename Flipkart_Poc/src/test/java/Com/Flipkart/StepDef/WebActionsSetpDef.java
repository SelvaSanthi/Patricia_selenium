package Com.Flipkart.StepDef;

import java.awt.AWTException;

import Com.Flipkart.Pages.WebActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebActionsSetpDef extends WebActions {
	
	@Given("user start the report process")
	public void user_start_the_report_process() {
		CaseID = "Validate the login function";
		//LogReport.startTestCase(CaseID);  
	}

	@When("^user navigate to the flipkart application$")
	public void user_navigate_to_the_flipkart_application() throws Throwable {
		message = incrementSteps() + " Navigate to the flipkart application";
		setup();
		//LogReport.getReport(message);	
	}

	@And("^enter the valid username and password$")
	public void enter_the_valid_username_and_password() throws Throwable {
		message = incrementSteps() + " Initialze element";
		initializeElement();
		//LogReport.getReport(message);
		message = incrementSteps() + " Enter the username and password";
		login();
		//LogReport.getReport(message);
	}

	@Then("^the user should navigate to the homepage as user$")
	public void the_user_should_navigate_to_the_homepage_as_user() throws Throwable {
			message = incrementSteps() + " Validate that user logged into the application";
			loginvalidate();
			//LogReport.getReport(message);
			//LogReport.endTestCase();
	}

	@When("enter the invalid {string} and {string}")
	public void enter_the_invalid_and(String username_value,  String password_value) {
		initializeElement();
		logininvalid(username_value,password_value);
	}

	@Then("the user should not navigate to the homepage as user")
	public void the_user_should_not_navigate_to_the_homepage_as_user() {
		loginvalidate();
	}
	
	@When("enter the {string}")
	public void enter_the(String search_product) throws InterruptedException {
		search(search_product);
	}

	@When("click on the product to view its details")
	public void click_on_the_product_to_view_its_details() throws  AWTException, InterruptedException {
		selectaProduct();
	}

	@When("add the the product to the cart")
	public void add_the_the_product_to_the_cart() throws InterruptedException {
		addToCart();
	}
	
}