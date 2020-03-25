package flipkartRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/flipkartFeatureFile" , 
glue="flipkartStepDef",
monochrome=true,
//dryRun=true,
plugin= {"json:target/cucumber-report.json","html:target/cucumer.html"})


public class FlipkartRunner extends flipkartPages.WebActions {


	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");


	@BeforeClass
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}


	@AfterClass
	public static void tearDown() throws Exception {
		Date date= new Date();

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

		
	}

}
