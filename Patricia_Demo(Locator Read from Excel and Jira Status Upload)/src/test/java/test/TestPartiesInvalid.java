package test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.beust.jcommander.Parameter;

import frameWork.Log;
import pages.PartiesInvalid;

public class TestPartiesInvalid extends PartiesInvalid{
	
	@BeforeClass
	public void testBeforeClass() throws IOException {
		before_Class(); 
	}

	@Test
	@Parameters("Party_value")
	
	public void testpartiesinvalid(String Parties_value) {
		testCaseID = "Patricia_CaseCreation_Parties_value";
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
			//Case with invalid parties
			Partiesvalid(Parties_value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("Test_Patricia_Party value");		
	}

	@AfterClass
	public void testAfterClass() throws InterruptedException {
		closeDriver();
	}
				
}
	


