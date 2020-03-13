package pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddDocument extends webAction {
	
	
	
	@FindBy(xpath="//input[@class='gwt-FileUpload']/following::div[@class='v-button']") public static WebElement btnAddDocument;
	@FindBy(xpath="//span[text()='OK'][@class='v-button-caption']") public static WebElement btnAddDocumentOk;
	
	
	//This method is to add the document to the case
	public void addDocument(String Document_Path) throws InterruptedException, AWTException, IOException {
		
		try {
			documentWidget();
			driver.navigate().refresh();
			driverUntilWait(btnAddDocument);
			btnAddDocument.click();
			//Copy the file path in SystemClipboard
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
			driverUntilWait(btnAddDocumentOk);
			btnAddDocumentOk.click();
			driverWait();
			driverWait();
			//To generate report with document type
			message = incrementSteps() + " Add "+excelFileReader("Document type_AddDocument")+ " document to the Case";
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Document not added to the Case");			
		}
				
	}
	
}