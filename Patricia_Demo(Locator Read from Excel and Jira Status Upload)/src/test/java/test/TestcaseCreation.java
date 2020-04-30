package test;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameWork.Log;
import pages.CaseCreation;

public class TestcaseCreation extends CaseCreation{
		
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}
	
	@Test
	@Parameters({"Case_Type","Add_Document","Add_Device"})
	public void testCaseCreation(String type,String documentAdd,String deviceAdd) {
		testCaseID = "Patricia_CaseCreation";
		Log.startTestCase(testCaseID, "Test_Patricia_CaseCreation");
		try {
			//initialize the element
			message = " Initialize elements";
			initializeElement();
			Log.getReport(message);
			//login to application
			message = " Login to Patricia";
			loginToPatricia();	
			Log.getReport(message);
			//case creation
			caseCreation(type,documentAdd,deviceAdd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("Test_Patricia_CaseCreation");		
	}

	@AfterClass
	public void testAfterClass() throws InterruptedException {
		closeDriver();
	}
				
}
