package Com.Flipkart.Runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import Com.Flipkart.Pages.WebActions;
import Com.Flipkart.Support.ExtentReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.Assert;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Com/Flipkart/Feature/AddCart.feature" , 
glue="Com.Flipkart.StepDef",
monochrome=true,
plugin= {"json:target/cucumber-report.json","html:target/cucumer.html"})


public class FlipkartRunner extends WebActions {

	public static ExtentReport extentReportObject = new ExtentReport();
	//Creating objects

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	
	
	public static DOMConfigurator domconfig;

	public void webAction() {
		domconfig = new DOMConfigurator();
		DOMConfigurator.configure("log4j.xml");
	}

	@BeforeClass
	public static void setUp() {
		try {
			extentReportObject.publishReports();
		} catch (Exception e) {
			e.printStackTrace();	
			Assert.fail("Could not start publishReports");
		}
	}

	
	
	@AfterClass
	public static void tearDown() {
		Date date= new Date();
	try {	
		CucumberDetailedResults dresult= new CucumberDetailedResults();
		dresult.setOutputDirectory("src\\reports\\"+sdf.format(date));
		dresult.setOutputName(sdf.format(date));
		dresult.setSourceFile("target\\cucumber-report.json");
		dresult.execute();
		CucumberResultsOverview result_Oview = new CucumberResultsOverview();
		result_Oview.setOutputDirectory("src\\reports\\"+sdf.format(date));
		result_Oview.setOutputName(sdf.format(date));
		result_Oview.setSourceFile("target\\cucumber-report.json");
		result_Oview.execute();
	} catch (Exception e) {
		e.printStackTrace();	
		Assert.fail("Could not close publishReports");
	}
	}

}
