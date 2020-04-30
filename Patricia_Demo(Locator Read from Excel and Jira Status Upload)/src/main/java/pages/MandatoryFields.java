package pages;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameWork.Log;
import junit.framework.Assert;

public class MandatoryFields extends webAction {

	@FindBy(xpath="//div[@class='v-csslayout v-layout v-widget nav-menu-open-button v-csslayout-nav-menu-open-button']")
	public static WebElement btnHomepageMenu;
	@FindBy(xpath="//span[text()='Create Case']") 
	public static WebElement creatCaseOption;
	@FindBy(xpath="//div[text()='Case type']/following::input") 
	public static WebElement caseTypeSelection;
	@FindBy(xpath="//div[text()='Country']/following::input") 
	public static WebElement countrySelection;
	@FindBy(xpath="//div[text()='Application type']/following::input")
	public static WebElement applicationTypeSelection;
	@FindBy(xpath="//div[text()='Catchword']/following::input")
	public static WebElement catchwordField;
	@FindBy(xpath="//div[text()='Service level']/following::input")
	public static WebElement serviceLevelSelection;
	@FindBy(xpath="//div[text()='Team']/following::input") 
	public static WebElement teamSelection;
	@FindBy(xpath="//div[text()='Case type']/following::div[text()='Field is mandatory']") 
	public static WebElement Casetype_error_msg;
	@FindBy(xpath="//div[text()='Country']/following::div[text()='Field is mandatory']") 
	public static WebElement Country_error_msg;
	@FindBy(xpath="//div[text()='Team']/following::div[text()='Field is mandatory']") 
	public static WebElement team_error_msg;
	@FindBy(xpath="//div[text()='Application type']/following::div[text()='Field is mandatory']") 
	public static WebElement application_error_msg;
	@FindBy(xpath="//div[text()='Service level']/following::div[text()='Field is mandatory']")
	public static WebElement service_level_errormsg;



	//This method is for switch actions
	public void Switch_Case(String type) throws InterruptedException, IOException {

		switch (type) {

		case "All_fields"       :      All_Fields();
		break;

		case "App_fields"       :	   Application_Type();
		break; 

		case "Ser_fields"       :	   Service_Level();
		break;	                           

		default:					   System.out.println("Accepts default value");                               

		}
	}



	//This method is for empty fields:
	public void All_Fields() {
		try{
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			String Casetype_errmsg=Casetype_error_msg.getText();
			driverWait();
			String Country_errmsg=Country_error_msg.getText();
			driverWait();
			String team_errmsg=team_error_msg.getText();
			driverWait();
			if (Casetype_errmsg.contains("Field is mandatory")&&Country_errmsg.contains("Field is mandatory")&&team_errmsg.contains("Field is mandatory"))
			{
				message= " 'Field is mandatory error message' - displayed under the fields: Case Type, Country, Team";
				Log.getReport(message);
			}
			else if (Country_errmsg.contains("Field is mandatory")&&team_errmsg.contains("Field is mandatory")) {
				Assert.fail(" 'Field is mandatory error message' not displayed under the field: Case Type");
			}
			else if (Casetype_errmsg.contains("Field is mandatory")&&team_errmsg.contains("Field is mandatory")) {
				Assert.fail(" 'Field is mandatory error message' not displayed under the field: Country Type");
			}
			else {
				Assert.fail(" 'Field is mandatory error message' not displayed under the field: Team" );
			}
		}catch (Exception e) {

			e.printStackTrace();
			Assert.fail(" Mandatory error message is not generated");
		}
	}

	//This method is for Application Type
	public void Application_Type() throws IOException {
		excelFileReaderOfNumeric("Case_Creation");
		try {
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			driverWait();
			caseTypeSelection.sendKeys(excelHashMap.get("Case type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			countrySelection.sendKeys(excelHashMap.get("Country"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			teamSelection.sendKeys(excelHashMap.get("Team"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			String errormsg=	application_error_msg.getText();
			System.out.println(errormsg);
			if(errormsg.contains("Field is not mandatory")) {
				message= "  'Field is mandatory error message'- displayed under the field: Application Type ";
				Log.getReport(message);
			}else {
				Assert.fail(" 'Field is mandatory error message' not displayed under the field: Application Type");
			}

		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail(" Mandatory error message for Application Type is not generated");
		}

	}

	//This method is for Servicce_Level
	public void Service_Level() throws IOException {
		excelFileReaderOfNumeric("Case_Creation");
		try {
			driverWait();
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			driverWait();
			caseTypeSelection.sendKeys(excelHashMap.get("Case type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			countrySelection.sendKeys(excelHashMap.get("Country"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			applicationTypeSelection.sendKeys(excelHashMap.get("Application_Type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			teamSelection.sendKeys(excelHashMap.get("Team"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			String Service_errormsg=service_level_errormsg.getText();
			if (Service_errormsg.contains("Field is mandatory")) {
				message= " 'Field is mandatory error message' - displayed under the field: Service Level";
				Log.getReport(message);
			}else {
				Assert.fail("'Field is mandatory error message' not displayed under the field: Service Level");
			}

		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Mandatory error message for Service Level is not generated");
		}
	}
}

