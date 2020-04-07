package flipkartSupport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCapture {
	// ScreenShot Switch
	public String SCREENSHOT_SWITCH = PropertyReader.readProperty("screenshot_switch");
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	/**
	 * This method is used to Capturing screenshot.
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String capture(WebDriver driver, String screenShotName) throws IOException {
		Date date= new Date();
		if (SCREENSHOT_SWITCH.trim().toLowerCase().equals("on")) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			if (System.getenv("ReportName") != null) {
				String dest = System.getProperty("user.dir") + File.separator + "src" + File.separator + "reports"
						+ File.separator + screenShotName + ".png";
				File destination = new File(dest);
				FileUtils.copyFile(source, destination);
			} else {
				String dest = System.getProperty("user.dir") + File.separator + "src" + File.separator + "reports"
						+ File.separator + screenShotName + ".png";
				File destination = new File(dest);
				FileUtils.copyFile(source, destination);
				
			}
		}
		return screenShotName;
	}
}
