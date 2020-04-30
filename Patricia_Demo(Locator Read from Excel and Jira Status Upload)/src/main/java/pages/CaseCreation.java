package pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import frameWork.Log;
import frameWork.PropertyReader;

public class CaseCreation extends webAction {

	String newCase;
	public	String CaseType_Report;
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
	@FindBy(xpath="//div[9]//div[1]//div[2]//input[1]") 
	public static WebElement desgCountries;
	@FindBy(xpath="//div[text()='Classes']/following::input") 
	public static WebElement classes;
	@FindBy(xpath="//span[text()='ADD CLASS']") 
	public static WebElement addclassbutton;
	@FindBy(xpath="//form[@class='v-upload v-widget v-upload-immediate']//div//div[@class='v-button']")
    public static WebElement Createadd_device;
    @FindBy(xpath="//form[@class='v-upload v-widget doc-upload v-upload-doc-upload browse v-upload-browse v-upload-immediate']//div//div[@class='v-button']")
    public static WebElement Createadd_Document;
    @FindBy(xpath="//span[contains(text(),'OK')]") 
	public static WebElement buttonOk;    
    @FindBy(xpath="//div[text()='Case information']/following::span[text()='CANCEL']")
    public static WebElement caseinfo_okbtn;
    @FindBy(xpath="//div[contains(text(),'Diary')]/following::span[contains(text(),'CANCEL')]")
	public static WebElement dairybtn;
    @FindBy(xpath="//span[@class='v-checkbox v-widget blurCC1368265809 v-checkbox-blurCC1368265809']//label")
    public static WebElement deselectcheckbox;
    @FindBy(xpath="//div[@class='v-csslayout v-layout v-widget cancel-save-btns-layout v-csslayout-cancel-save-btns-layout v-has-width']//span[@class='v-button-caption'][contains(text(),'OK')]")
	public static WebElement confirmationok;
	@FindBy(xpath="//div[@class='v-label v-widget v-label-undef-w']")
	public static WebElement Docpath;
	@FindBy(xpath="//div[@class='v-label v-widget v-label-undef-w']")
	public static WebElement devpath;
	@FindBy(xpath="//div[@class='trish-web-link v-widget v-has-width v-has-height']//a//span//img")
    public static WebElement pButton;
	
	
	public void driverUntilWait() {
		
		WebDriverWait driverwait=new WebDriverWait(driver, 15);
		driverwait.until(ExpectedConditions.titleContains("2"));
	}
	
	//This method is to get the newly created case No.
	public void caseNO() {
		driverUntilWait();
		 newCase=driver.getTitle();
		
	}
		
	
	//This method is to perform the case creation process with different case types
	public void caseCreation(String Case_Type, String docAdd ,String devAdd) throws IOException, InterruptedException, AWTException  {
		
    CaseType_Report=Case_Type;
		if (Case_Type.equalsIgnoreCase("Patent")) {
			patentcase(docAdd,devAdd);
			
		} else if (Case_Type.equalsIgnoreCase("Trademark")) {
			trademarkcase(docAdd,devAdd);
		} 

		}
		
		public void Add_document(String Document_Path) throws AWTException, InterruptedException, IOException {
			
			//	excelFileReaderOfNumeric("CaseCreation_Trademark");
				Clipboard copy= Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection copy_value= new StringSelection(Document_Path); 
				copy.setContents(copy_value, null); 
				driverWait();
				keyboardAction().keyPress(KeyEvent.VK_CONTROL);
				keyboardAction().keyPress(KeyEvent.VK_V);
				keyboardAction().keyRelease(KeyEvent.VK_V);
				keyboardAction().keyRelease(KeyEvent.VK_CONTROL);
				driverWait();
				keyboardAction().keyPress(KeyEvent.VK_ENTER); 
				keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			}
		public void Add_device(String Device_Path) throws AWTException, InterruptedException {
				
				Clipboard copy= Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection copy_value= new StringSelection(Device_Path); 
				copy.setContents(copy_value, null); 
				driverWait();
				keyboardAction().keyPress(KeyEvent.VK_CONTROL);
				keyboardAction().keyPress(KeyEvent.VK_V);
				keyboardAction().keyRelease(KeyEvent.VK_V);
				keyboardAction().keyRelease(KeyEvent.VK_CONTROL);
				driverWait();
				keyboardAction().keyPress(KeyEvent.VK_ENTER); 
				keyboardAction().keyRelease(KeyEvent.VK_ENTER);
		
		}	
	//this method is used to create the trademarkcase//newly created
	public void trademarkcase(String docAdd,String devAdd) throws IOException, InterruptedException, AWTException {
		try {
		excelFileReaderOfNumeric("CaseCreation_Trademark");
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
		driverWait();
		driverUntilWait(applicationTypeSelection);
		applicationTypeSelection.sendKeys(excelHashMap.get("Application type"));
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_ENTER);
		keyboardAction().keyRelease(KeyEvent.VK_ENTER);
		driverWait();
		//Enter the catchword
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
		//Enter the Designation Countries
		driverWait();
		desgCountries.sendKeys(excelHashMap.get("Designation"));
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_ENTER);
		keyboardAction().keyRelease(KeyEvent.VK_ENTER);
		driverWait();
		//Enter the Classes
		driverWait();
		System.out.println(excelCellValue);
		classes.sendKeys(excelHashMap.get("Classes"));
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_ENTER);
		keyboardAction().keyRelease(KeyEvent.VK_ENTER);
		driverWait();
		//Click Add Button
		driverWait();
		addclassbutton.click();
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_PAGE_DOWN);
		keyboardAction().keyRelease(KeyEvent.VK_PAGE_DOWN);
		driverWait();
		if (docAdd.equalsIgnoreCase("Yes")) {
			Createadd_Document.click();
			Add_document(System.getProperty("user.dir")+excelHashMap.get("Document_Path"));
			driverWait();	
			String document_ele=Docpath.getText();
			System.out.println(document_ele);
			driverWait();
			if((excelHashMap.get("Document_Path")).contains (document_ele)) {
				message="Test Document is added to the Case";
				Log.getReport(message);
			}else {
				Assert.fail("Document is not added to the case");
			}
		}
		if (devAdd.equalsIgnoreCase("Yes")) {
			Createadd_device.click();
			Add_device(System.getProperty("user.dir")+excelHashMap.get("Device_Path"));
			driverWait();
			String device_ele=Docpath.getText();
			System.out.println(device_ele);
			driverWait();
			if((excelHashMap.get("Document_Path")).contains (device_ele)) {
				message="Device is added to the Case";
				Log.getReport(message);
			}else {
				Assert.fail("Device is not added to the case");
			}
		}
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_PAGE_DOWN);
		keyboardAction().keyRelease(KeyEvent.VK_PAGE_DOWN);
		driverWait();
		buttonOk.click();
		driverWait();
		driverWait();
		driverUntilWait(caseinfo_okbtn);
		caseinfo_okbtn.click();
		driverWait();
		driverWait();
		driverWait();
		keyboardAction().keyPress(KeyEvent.VK_PAGE_DOWN);
		keyboardAction().keyRelease(KeyEvent.VK_PAGE_DOWN);
		driverWait();
		driverWait();
		Actions act= new Actions(driver);
		act.moveToElement(dairybtn).build().perform();
		act.click().build().perform();
		driverWait();
		driverUntilWait();
		caseNO();
		//Generate the report with created CaseNo.
		message = " Case Created with the casetype as: " +CaseType_Report  +" Created Case No : " +newCase; 
		Log.getReport(message);
		excelFileWriter("CaseCreation_Trademark_Create_CaseNo",newCase);
		driverWait();
        pButton.click();
        driverWait();
		excelFileReaderOfNumeric("CaseCreation_Trademark");
		System.out.println(excelHashMap.get("CaseCreation_Trademark_Create_CaseNo"));
		SearchCheck(excelHashMap.get("CaseCreation_Trademark_Create_CaseNo"));
		
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("trademark casetype is not selected");
		}
	}
	//This method is used to create the patent case
	
	public void patentcase(String docAdd,String devAdd) throws IOException {
		
		try {
			String document_switch = PropertyReader.readProperty("add_document_switch");
			String device_switch = PropertyReader.readProperty("add_device_switch");
			excelFileReaderOfNumeric("CaseCreation_Patent");
			driverWait();
			driverUntilWait(btnHomepageMenu);
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
			//Enter the catchword
			catchwordField.sendKeys(excelHashMap.get("Catchword"));
			driverWait();
			//Enter the service level
			serviceLevelSelection.sendKeys(excelHashMap.get("Service level"));
			driverWait();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			//Distinguish code
			/*distinguishcode.clear();
			driverWait();*/
			//Enter the team
			teamSelection.sendKeys(excelHashMap.get("Team"));
			driverWait();

			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			driverWait();
			
			if (docAdd.equalsIgnoreCase("Yes")) {
				driverUntilWait(Createadd_Document);
				Createadd_Document.click();
				Add_document(System.getProperty("user.dir")+excelHashMap.get("Document_Path"));
				driverWait();	
				driverWait();
				String document_ele=Docpath.getText();
				System.out.println(document_ele);
				driverWait();
				if((excelHashMap.get("Document_Path")).contains(document_ele)) {
					message="Document is added to the Case";
					Log.getReport(message);
				}else {
					Assert.fail("Document is not added to the case");
				}
				keyboardAction().keyPress(KeyEvent.VK_PAGE_DOWN);
				keyboardAction().keyRelease(KeyEvent.VK_PAGE_DOWN);
				driverWait();
			}
			if (devAdd.equalsIgnoreCase("Yes")) {
				driverUntilWait(Createadd_device);
				Createadd_device.click();
				Add_device(System.getProperty("user.dir")+excelHashMap.get("Device_Path"));
				driverWait();	
				driverWait();
				String device_ele=devpath.getText();
				System.out.println(device_ele);
				driverWait();
				if((excelHashMap.get("Document_Path")).contains(device_ele)) {
					message="Device is added to the Case";
					Log.getReport(message);
				}else {
					Assert.fail("Device is not added to the case");
				}
				keyboardAction().keyPress(KeyEvent.VK_PAGE_DOWN);
				keyboardAction().keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
			driverWait();
			buttonOk.click();
			driverWait();
			driverWait();
			driverWait();
			driverUntilWait(caseinfo_okbtn);
			caseinfo_okbtn.click();
			keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);
			driverWait();
			/*keyboardAction().keyPress(KeyEvent.VK_ENTER);
			keyboardAction().keyRelease(KeyEvent.VK_ENTER);	*/
			
			
			driverUntilWait();
			caseNO();
			//Generate the report with created CaseNo.
			message = " Case Created with the casetype as: " +CaseType_Report  + " and the Created Case No : " +newCase; 
			Log.getReport(message);
			excelFileWriter("CaseCreation_Patent_Create_CaseNo",newCase);
			driverWait();
            pButton.click();
            driverWait();
			excelFileReaderOfNumeric("CaseCreation_Patent");
			System.out.println(excelHashMap.get("CaseCreation_Patent_Create_CaseNo"));
			SearchCheck(excelHashMap.get("CaseCreation_Patent_Create_CaseNo"));
				
			 			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(" Case Creation Process not completed");
		}
	}
}

							

