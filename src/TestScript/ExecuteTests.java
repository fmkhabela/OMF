package TestScript;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageobject.CalculateLoan;
import pageobject.MonthlyInstalment;
import pageobject.OldMutualMainPageTitle;
import pageobject.PersonalLoan;
import pageobject.ValidateRepaymentAmount;

public class ExecuteTests extends BaseClass {
	
	@Test
	public void VerifyMainPage() throws IOException {
		
		try {
			BrowserSetup("chrome");
			test = extent.startTest("VerifyPageTitle");

			OldMutualMainPageTitle mainpage = new OldMutualMainPageTitle(driver);
			mainpage.VerifyTitlePageObject();

		} catch (Exception e) {
			System.out.print("inside catch");

			// Close the browser
			System.out.print(e);

		}
	}


	@Test
		public void VerifyPersonalLoanPage() throws IOException {
			 
			try {
				
				BrowserSetup("chrome");
			
				test = extent.startTest("VerifyPersonalLoanPage");
				

				//Navigate to Personal Loans check if you on the correct page by getting the page title
				PersonalLoan personal = new PersonalLoan(driver);
				personal.VerifyPersonalLoansPageObject();
			
		
			} catch (Exception e) {
				
				// Close the browser
				System.out.print(e);
				test.log(LogStatus.ERROR, test.addScreenCapture(capture(driver))+ "Unable To Verify Personal Loan Page");

			}}
			
			@Test
			public void CalculatePersonalLoans(){
					
				try {
					
					BrowserSetup("chrome");
					test = extent.startTest("CalculateLoan");

					CalculateLoan calculateLoan = new CalculateLoan(driver);
					calculateLoan.CalulateLoanPageObject();

					
				} catch (Exception e) {
					
					// Close the browser
					System.out.print(e);

				}

			}


			@Test
			public void CalculateMonthlyInstalment(){
				
				
				try {
					
					BrowserSetup("chrome");
					test = extent.startTest("MonthlyLoanRepayments");

					//Navigate to Personal Loans check if you on the correct page by getting the page title
					MonthlyInstalment monthlypayment = new MonthlyInstalment(driver);
					monthlypayment.MonthlyInstalmentPageObject();

								
				} catch (Exception e) {
					
					// Close the browser
					System.out.print(e);

				}
			}
			

			@Test
			public void ValidateLoanRepayment() {
				
			
				try {
					
					BrowserSetup("chrome");
					test = extent.startTest("ValidatesLoanAmount");

					//Navigate to Personal Loans check if you on the correct page by getting the page title
					ValidateRepaymentAmount validateamount = new ValidateRepaymentAmount(driver);
					validateamount.ValidateRepaymentAmountPageObject();
					
					
				} catch (Exception e) {
					
					// Close the browser
					System.out.print(e);
			
				}
			
			}
			
		
	@AfterMethod
	public void close() {
		BrowserClose();
		
		
	}
	
	
}
