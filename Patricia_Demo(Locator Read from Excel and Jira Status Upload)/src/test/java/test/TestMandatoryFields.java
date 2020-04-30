package test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameWork.Log;
import pages.MandatoryFields;

public class TestMandatoryFields extends MandatoryFields {

	
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}

	@Test
	@Parameters("Mandatory_fields")
	public void testmandatoryfields(String error_type) {
		testCaseID = "Patricia_CaseCreation_Mandatory fields";
		Log.startTestCase(testCaseID, "Test_Patricia_CaseCreation");
		try {
			//initialize the element
			message = " Initialize elements";
			initializeElement();
			Log.getReport(message);
			//login to the Application:
			message = " Login to Patricia";
			loginToPatricia();
			Log.getReport(message);
			//For Switch Case
			Switch_Case(error_type);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("Test_Patricia_Mandatory fields");		
	}

	@AfterClass
	public void testAfterClass() throws InterruptedException {
		closeDriver();
	}
				
}


