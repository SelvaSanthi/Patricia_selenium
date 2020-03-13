package test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameWork.Log;
import pages.DocumentPreview;

public class TestDocumentPreview extends DocumentPreview {
			
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}
		
	@Test
	public void testDocumentPreview() {
		testCaseID = "Patricia_Document_Preview";
		Log.startTestCase(testCaseID, "Test_Patricia_Document_Preview");
		try {
			//initialize the element
			message = incrementSteps() + " Initialize elements";
			initializeElement();
			Log.getReport(message);
			message = incrementSteps() + " Login to Patricia";
			//login into the application
			loginToPatricia();
			Log.getReport(message);
			//search a case
			searchForCase("CaseNo_PreviewDocument");
			Log.getReport(message);
			//preview the document from the document widget
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
