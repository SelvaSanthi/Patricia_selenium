package test;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameWork.Log;
import pages.webAction;

public class TestSearchforNegativeCase extends webAction {	
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}	
	@Test
	public void testSearchCase() {
		testCaseID = "Patricia_Search for Case";
		Log.startTestCase(testCaseID, "Test_Patricia_Search for Case");
		try {
			//initialize the element
			message = " Initialize elements";
			initializeElement();
			Log.getReport(message);
			//login into the application
			message = " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			//search a case
			SearchCheck("P2002480IN00");
			Log.getReport(message);	
			//Navigate to the document
			message = " Navigate to the Parties widget";
			PartiesWidget();
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

	
	
	


