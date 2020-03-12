package TestPatrixmaven;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestPatrixmavenSupport.Log;

public class TestSearchforCase extends webAction {	
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Suite(); 
	}		
	@Test
	public void testSearchCase() {
		testCaseID = "Patricia_Search for Case";
		Log.startTestCase(testCaseID, "Test_Patricia_Search for Case");
		try {
			
			message = incrementSteps() + " Initialize elements";
			initializeElement();
			Log.getReport(message);
			message = incrementSteps() + " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			SearchCheck("Negative case search");
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

	
	
	


