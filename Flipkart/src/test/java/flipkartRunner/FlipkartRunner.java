package flipkartRunner;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.reporting.CucumberConsolidatedReport;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import flipkartSupport.PropertyReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/flipkartFeatureFile/" , 
glue="flipkartStepDef",
monochrome=true,
//dryRun=true,
tags= {"@RegressionTest"},
//strict = true,
//plugin= {"pretty:target/cucumber/report1.html"})
plugin= {"json:target/cucumber-report.json","html:target/cucumer.html",
		//"com.cucumber.listener.ExtentCucumberFormatter:"
		})

public class FlipkartRunner extends flipkartPages.FlipkartProduct {
	
	static flipkartSupport.ExtentReport extentReportObject = new flipkartSupport.ExtentReport();
	
	@BeforeClass
	public static void setUp() throws IOException {
		String Browser=PropertyReader.readProperty("Browser");
		ExtentProperties properties= ExtentProperties.INSTANCE;
		properties.setReportPath("output/myreport.html");
		extentReportObject.publishReports();

		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		} 
	}

	public  static String getReportConfigPath(){
		String reportConfigPath = PropertyReader.readProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		flipkartSupport.ExtentReport.extent.flush();
		Reporter.loadXMLConfig(new File(getReportConfigPath()));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("OS"));
        Reporter.setTestRunnerOutput("Test Runner Output Logs");
        
		Date date= new Date();

		CucumberConsolidatedReport creport = new CucumberConsolidatedReport();
		creport.setOutputDirectory("src\\reports\\"+sdf.format(date));
		creport.setOutputName(sdf.format(date));
		creport.setSourceFile("target\\cucumber-report.json");
		creport.execute();
		
		
		CucumberDetailedResults dresult= new CucumberDetailedResults();
		dresult.setOutputDirectory("src\\reports\\"+sdf.format(date));
		dresult.setOutputName(sdf.format(date));
		dresult.setSourceFile("target\\cucumber-report.json");
		dresult.setScreenShotLocation("src\\reports\\"+sdf.format(date));
		dresult.execute();

		CucumberResultsOverview result_Oview = new CucumberResultsOverview();
		result_Oview.setOutputDirectory("src\\reports\\"+sdf.format(date));
		result_Oview.setOutputName(sdf.format(date));
		result_Oview.setSourceFile("target\\cucumber-report.json");
		result_Oview.execute();

	}



}
