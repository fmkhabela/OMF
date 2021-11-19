package TestScript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public void BrowserSetup(String browserType) {
		
			
			
			if(browserType.equalsIgnoreCase("chrome")) {

				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
				driver =  new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.oldmutualfinance.co.za/");
				

				
			}else {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
				driver =  new FirefoxDriver();
				driver.get("https://www.oldmutualfinance.co.za/");

			}
			
			
		}
	@BeforeClass
	public void ReportInitialazation() {
		
		/*
		 * Specify the path, add current system time to the report and store in the folder "Screenshot"
		 * Start the instance of test class and pass the report name as argument
		*/
		String reportPath = "./Reports\\FirtReportExample "+ System.currentTimeMillis() +".html";	
		extent = new ExtentReports(reportPath);
		//test = extent.startTest("Testing");
	}
	
	//Take a screenshot, create a folder and store the image
	public static String capture(WebDriver driver) throws IOException {
		
		/*Capture the screenshot of the current WebDriver instance
		* Create a new Folder and store the image with the current system date
		* Copy the the images to the creates folder 
		*/
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Screenshots\\" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
	

	public void BrowserClose() {
		extent.endTest(test);
		extent.flush();
		driver.close();
	}
			

}
