package TestPatrixmaven;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestPatrixmavenSupport.Log;

public class TestDocumentPreview extends DocumentPreview {
			
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Suite(); 
	}
		
	@Test
	public void testDocumentPreview() {
		testCaseID = "Patricia_Document_Preview";
		Log.startTestCase(testCaseID, "Test_Patricia_Document_Preview");
		try {
			
			message = incrementSteps() + " Initialize elements";
			initializeElement();
			Log.getReport(message);
			message = incrementSteps() + " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			searchForCase("Case_No");
			Log.getReport(message);
			message = incrementSteps() + " Preview the Document";
			previewDocument();
			Log.getReport(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("Test_Patricia_Document_Preview");
	}

	@AfterClass
	public void testAfterClass() throws InterruptedException {
		closeDriver();
	}
		
}
