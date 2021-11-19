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

public class MonthlyInstalment extends BaseClass{

	WebDriver driver;
	
	public MonthlyInstalment(WebDriver _driver) {
		driver = _driver;
		
		PageFactory.initElements(_driver, this);
	}


	@FindBy(xpath = "//div[@class='theme-default om-personal-loans-calculator']/..//*[@id=\'loanAmount\']/div/div/div/om-form-dropdown-field/div/div[1]")
	@CacheLookup
	WebElement ddlHowMuchYouNeed;

	@FindBy(id = "R50000")
	@CacheLookup
	WebElement selectAmount;
	
	@FindBy(xpath = "/html/body/div/div[1]/om-wc-config/div/om-page/div/div/main/om-application-container/div/om-1-col-layout/div/om-section/div/div/div[2]/div/om-personal-loans-calculator/div/div[2]/div[1]/div[1]/om-button/button")
	@CacheLookup
	WebElement btnNext;
	
	@FindBy(id = "60 Months")
	@CacheLookup
	WebElement selectHowLongToRepay;
	
	@FindBy(xpath = "/html/body/div/div[1]/om-wc-config/div/om-page/div/div/main/om-application-container/div/om-1-col-layout/div/om-section/div/div/div[2]/div/om-personal-loans-calculator/div/div[2]/div[1]/div[1]/div/om-button/button")
	@CacheLookup
	WebElement btnCalculate;
	
	@FindBy(xpath = "//*[@id=\'blt9c764616951e6d18\']/div/div[2]/div[2]/om-calculator-result/div[2]/h5/strong")
	@CacheLookup
	WebElement validateAmount;
	
	public void MonthlyInstalmentPageObject() throws InterruptedException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	Thread.sleep(10000);
		driver.navigate().to("https://www.oldmutual.co.za/personal/tools-and-calculators/personal-loan-calculator/");
    	Thread.sleep(15000);
    	
    	js.executeScript("window.scrollBy(0,750)", "");
    	Thread.sleep(5000);

        js.executeScript("arguments[0].click();", ddlHowMuchYouNeed);
    	Thread.sleep(5000);
        js.executeScript("arguments[0].click();", selectAmount);
    	Thread.sleep(5000);
        js.executeScript("arguments[0].click();", btnNext);

        js.executeScript("arguments[0].click();", ddlHowMuchYouNeed);
    	Thread.sleep(5000);
    	js.executeScript("arguments[0].click();", selectHowLongToRepay);
    	Thread.sleep(5000);

    	js.executeScript("arguments[0].click();", btnCalculate);
    	Thread.sleep(15000);
		String expectAmount = validateAmount.getText();
		String actualAmount = "R1 656.43 - R1 810.05";
		
		if(expectAmount.equals(actualAmount)) {
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "Successfully Validated Personal Loan Amount");
	    	Thread.sleep(2000);

		}else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "Unable To Validated Personal Loan Amount");
			boolean checked = true;
			assertFalse(checked );	    	

		}
	}
} 
