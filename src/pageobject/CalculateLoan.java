package pageobject;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.LogStatus;

import TestScript.BaseClass;


public class CalculateLoan extends BaseClass{

	WebDriver driver;
	
	public CalculateLoan(WebDriver _driver) {
		driver = _driver;
		
		PageFactory.initElements(_driver, this);
	}


	@FindBy(xpath = "//div[@class='theme-default om-personal-loans-calculator']/..//*[@id=\'loanAmount\']/div/div/div/om-form-dropdown-field/div/div[1]")
	@CacheLookup
	WebElement ddlHowMuchYouNeed;

	@FindBy(id = "R50000")
	@CacheLookup
	WebElement selectAmount;
	
	@FindBy(xpath = "//div[@class='theme-default om-personal-loans-calculator']/..//*[@id=\"loanAmount\"]/div/div/div/om-form-dropdown-field/div/div[1]/span[1]")
	@CacheLookup
	WebElement selectedAmountIs;
	
	public void CalulateLoanPageObject() throws InterruptedException, IOException {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	Thread.sleep(10000);
	    	
			driver.navigate().to("https://www.oldmutual.co.za/personal/tools-and-calculators/personal-loan-calculator/");	
	    	Thread.sleep(15000);
	    	
	    	js.executeScript("window.scrollBy(0,750)", "");
	    	Thread.sleep(5000);
	    	
	        js.executeScript("arguments[0].click();", ddlHowMuchYouNeed);
	    	Thread.sleep(2000);
	        js.executeScript("arguments[0].click();", selectAmount);
	    	Thread.sleep(5000);

			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Successfully Selected Amount Of R50 000");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Unable To Selected Amount Of R50 000");			
			boolean checked = true;
			assertFalse(checked );

		}
		

	}
}