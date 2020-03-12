package TestPatrixmaven;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestPatrixmavenSupport.Log;

public class TestAddDocument extends AddDocument{
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Suite(); 
	}
	
	@Test
	public void testAddDocument() {
		testCaseID = "Patricia_Add Document";
		Log.startTestCase(testCaseID, "Test_Patricia_Add Document");
		try {
			
			message = incrementSteps() + " Initialize elements";
			initializeElement();
			Log.getReport(message);
			message = incrementSteps() + " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			searchForCase("Case_No");
			Log.getReport(message);
			addDocument(excelFileReader("Document path"));
			Log.getReport(message);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("Test_Patricia_Add Document");
	}
		
	@AfterClass
	public void testAfterClass() throws InterruptedException {
		closeDriver();
	}
			
}
