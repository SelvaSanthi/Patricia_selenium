package pages;

import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CaseCreation extends webAction {

	String newCase;
	
	//locators for case creation
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
	/*@FindBy(xpath="//div[@class='v-button v-widget blue-button v-button-blue-button primary-button v-button-primary-button']") 
	public static WebElement btncaseCreationOk;*/
	
	//This method is to wait the driver upto expected conditions
	public void driverUntilWait() {
		
		WebDriverWait driverwait=new WebDriverWait(driver, 10);
		driverwait.until(ExpectedConditions.titleContains("1"));
	}
	
	//This method is to get the newly created case No.
	public void caseNO() {
		driverUntilWait();
		 newCase=driver.getTitle();
		
	}
		
	//This method is to perform the case creation process
	public void caseCreation()  {
		try {
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			driverWait();
			//Enter the case type
			caseTypeSelection.sendKeys(excelFileReader("Case type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the country
			countrySelection.sendKeys(excelFileReader("Country"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the application type
			applicationTypeSelection.sendKeys(excelFileReader("Application type"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the catchword
			catchwordField.sendKeys(excelFileReader("Catchword"));
			driverWait();
			//Enter the service level
			serviceLevelSelection.sendKeys(excelFileReader("Service level"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Enter the team
			teamSelection.sendKeys(excelFileReader("Team"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverUntilWait();
			caseNO();
			//Generate the report with created CaseNo.
			message = incrementSteps() + " Case Creation - Created Case No : "+newCase; 
			
			excelFileWriter("Create_CaseNo",newCase);
			
			 			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Case Creation Process not completed");
		}
	}
	
							
}
