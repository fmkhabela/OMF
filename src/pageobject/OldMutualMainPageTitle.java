package pageobject;

import static org.testng.Assert.assertFalse;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import TestScript.BaseClass;


public class OldMutualMainPageTitle extends BaseClass{
	
	WebDriver driver;
	
	public OldMutualMainPageTitle(WebDriver _driver) {
		driver = _driver;
		
		PageFactory.initElements(_driver, this);
	}


	
	public void VerifyTitlePageObject() throws IOException {
		

		String expectedTitle = driver.getTitle();
		String actuialTitle = "Bank and Borrow Solutions | Old Mutual";
		
		if(expectedTitle.equals(actuialTitle)) {
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Successfully Verified Old Mutual Finance Web Page Title");

		}else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Unable To Verify Verified Old Mutual Finance Web Page Title");
			boolean checked = true;
			assertFalse(checked );
		}
		

	}
}
