package flipkartSupport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.itextpdf.text.List;

import cucumber.api.Scenario;

public class CustomExtentReport {

	private  ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extendReports;

	public CustomExtentReport(String reportlocation) {
		extentHtmlReporter = new ExtentHtmlReporter(new File(reportlocation));
		extendReports = new ExtentReports();
		extendReports.attachReporter(extentHtmlReporter);
	}
	
	public void createTest(io.cucumber.java.Scenario scenario, String screenShotPath) throws IOException, InterruptedException {
		String title=scenario.getName();
			
		if (scenario.getStatus() != null) {
			
			switch (scenario.getStatus()) {

			case PASSED:
				extendReports.createTest(scenario.getName()).pass(scenario.getName()+" Executed successfully");
				break;
			case FAILED:
				Thread.sleep(3000);
				extendReports.createTest(scenario.getName()).fail(scenario.getName()+" Execution failed").addScreenCaptureFromPath(screenShotPath+".png");
				break;
			default:
				extendReports.createTest(scenario.getName()).skip(scenario.getName()+"Execution skipped");
				break;
			}
		}

	}
	
	/*private String geterrormessage(Scenario scenario) throws IllegalArgumentException, IllegalAccessException {
		List testresult =null;
		List filedstepresult=null;
		
		try {
			Field StepResults=scenario.getClass().getDeclaredField("StepResults");
			StepResults.setAccessible(true);
			StepResults.get(scenario);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	*/

	public void writeReport() {
		if (extendReports != null ) {
			extendReports.flush();
		}
	}





}





