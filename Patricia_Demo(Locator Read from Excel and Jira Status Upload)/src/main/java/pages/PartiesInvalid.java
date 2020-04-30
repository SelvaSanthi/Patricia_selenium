package pages;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import frameWork.Log;

//import frameWork.Log;

public class PartiesInvalid extends webAction{
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
	@FindBy(xpath="//textarea[@class='expanding-text-area v-textarea block-prop']")
	public static WebElement partiesselection;
	@FindBy (xpath="//span[contains(text(),'OK')]")
	public static WebElement okbutton;
	@FindBy(xpath="//div[text()='Case information']/following::span[text()='CANCEL']")
    public static WebElement caseinfo_okbtn;
	@FindBy(xpath="//div[@class='field-validation-msg']")
	public static WebElement Invaliderror;
	@FindBy(xpath="//span[contains(text(),'50211')]")
	public static WebElement Partyno;

	//This method is for Valid Party value
	public void Partiesvalid(String value) { 
		try {
			excelFileReaderOfNumeric("CaseCreation_Patent");
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			driverWait();
			//Enter the case type
			caseTypeSelection.sendKeys(excelHashMap.get("Case type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the country
			countrySelection.sendKeys(excelHashMap.get("Country"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the application type
			applicationTypeSelection.sendKeys(excelHashMap.get("Application type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the catch word
			catchwordField.sendKeys(excelHashMap.get("Catchword"));
			driverWait();
			//Enter the service level
			serviceLevelSelection.sendKeys(excelHashMap.get("Service level"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the team
			teamSelection.sendKeys(excelHashMap.get("Team"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter valid Parties
			if(value.equalsIgnoreCase("valid_value"))
			{
				partiesselection.sendKeys(excelHashMap.get("Parties_valid"));
				driverWait();
				keyboardAction().keyPress(KeyEvent.VK_ENTER);
				keyboardAction().keyRelease(KeyEvent.VK_ENTER);
				driverWait();
				//Click on OK button
				okbutton.click();
				driverWait();
				driverWait();
				driverWait();
				driverWait();
				driverUntilWait(caseinfo_okbtn);
				//click on Case information
				caseinfo_okbtn.click();
				//extendokbutton.click();
				driverWait();
				driverWait();
				message = " Case created with valid Party value";	
				Log.getReport(message);
				PartiesWidget();
				/*keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);*/
			}
			else {
				partiesselection.sendKeys(excelHashMap.get("Parties_Invalid"));
				driverWait();
				okbutton.click();
				driverWait();
				String Invalid_errormsg=Invaliderror.getText();
				System.out.println(Invalid_errormsg);
				if(Invalid_errormsg.contains("Incorrect party spelling. Should be ''Name No with User Name as Role")) {
					message= "Party with invalid error message: 'Incorrect party spelling. Should be Name No with User Name as Role error message' - displayed";
					Log.getReport(message);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("FAIL- parties are not created");

		}
	}
}
