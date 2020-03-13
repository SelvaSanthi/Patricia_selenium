package test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameWork.Log;
import pages.AddDocument;

public class TestAddDocument extends AddDocument{
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}
	
	@Test
	public void testAddDocument() {
		testCaseID = "Patricia_Add Document";
		Log.startTestCase(testCaseID, "Test_Patricia_Add Document");
		try {
			//initialize the element
			message = incrementSteps() + " Initialize elements";
			initializeElement();
			Log.getReport(message);
			//login into the  application
			message = incrementSteps() + " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			//search a case
			searchForCase("CaseNo_AddDocument");
			Log.getReport(message);
			//add a document to the case
			addDocument(System.getProperty("user.dir")+excelFileReader("Document path_AddDocument"));
			
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
