package TestPatrixmaven;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CaseCreation extends webAction {

	String newCase;
	
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
	
	
	public void driverUntilWait() {
		
		WebDriverWait driverwait=new WebDriverWait(driver, 10);
		driverwait.until(ExpectedConditions.titleContains("P1"));
	}
	
	public void caseNO() {
		driverUntilWait();
		 newCase=driver.getTitle();
	}
	
	
	public void caseCreation()  {
		try {
			driverWait();
			btnHomepageMenu.click();
			driverWait();
			creatCaseOption.click();
			excelFileReader(5, 1);
			driverWait();
			caseTypeSelection.sendKeys(excelCellValue);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			excelFileReader(6, 1);
			countrySelection.sendKeys(excelCellValue);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			excelFileReader(7, 1);
			applicationTypeSelection.sendKeys(excelCellValue);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			excelFileReader(8, 1);
			catchwordField.sendKeys(excelCellValue);
			driverWait();
			excelFileReader(9, 1);
			serviceLevelSelection.sendKeys(excelCellValue);
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			excelFileReader(10, 1);
			teamSelection.sendKeys(excelCellValue);
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
			message = incrementSteps() + " Case Creation - Created Case No : "+newCase; 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Case not created");
		}
	}
	
	
	
	
	
	
	
	
}
