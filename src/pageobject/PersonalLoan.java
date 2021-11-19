package pageobject;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import TestScript.BaseClass;

public class PersonalLoan extends BaseClass {
	
WebDriver driver;
	
	public PersonalLoan(WebDriver _driver) {
		driver = _driver;
		
		PageFactory.initElements(_driver, this);
	}

	
	@FindBy(xpath = "/html/body/div/div[1]/om-wc-config/div/om-page/div/div/header/om-segment-landing-header/div/om-main-navigation/div[1]/nav/div[1]/div[2]/om-main-navigation-menu/ul/li[1]/ul/li[3]/a")
	@CacheLookup
	WebElement linkPersonalLoans;

	//Navigate to PERSONAL LOANS page and verify that you are on the correct page.
	public void VerifyPersonalLoansPageObject() throws InterruptedException, IOException {
		
		driver.navigate().to("https://www.oldmutual.co.za/personal/solutions/bank-and-borrow/personal-loans/");
    	Thread.sleep(5000);

		String expectedTitle = driver.getTitle();
		String actuialTitle = "Personal Loans | Apply Online | Old Mutual";
		
		if(expectedTitle.equals(actuialTitle)) {
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Successfully Verified Personal Loan Page");

		}else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Unable To Verify Personal Loan Page");
			boolean checked = true;
			assertFalse(checked );
		}
		
		//System.out.print(driver.getTitle());
	}

}


