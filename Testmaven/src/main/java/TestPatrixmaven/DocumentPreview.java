package TestPatrixmaven;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DocumentPreview  extends webAction{
	
	@FindBy(xpath="//table//tbody//tr//td[3]") public static WebElement previewDocument;

	public void previewDocument() throws InterruptedException, IOException {
		try {
			documentWidget();
			driverWait();
			Actions actions = new Actions(driver);
			WebElement preview = previewDocument;
			driverUntilWait(previewDocument);
			actions.doubleClick(preview).perform();
			driverWait();
			driverWait();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Document Cannot be preview");
		}		
	}
		
}
