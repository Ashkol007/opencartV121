package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import utilities.EmailVerification;

public class TC0018_ToolTipValidationMessageForEmail extends BaseClass {
	

	@Test(groups={"Master"})
	public void emailVerfication() {
		

	    String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
		
		
try {
			
			logger.info(" ************** TC0018_Email Validation TestCase started ***********");
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
		
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		                            Arp.setEmail("ashi123");
		                       Arp.clickContinue();

		    if(browserName.equalsIgnoreCase("firefox")) {
		    	

				   logger.info("$$FirfoxEmailToolTipWarningMsg$$ :"+Arp.getEmailToolTipWarningMsg());
				    Assert.assertTrue(Arp.getEmailToolTipWarningMsg().trim().contains("Please enter an email address."));
				    
		    }else {
		    	

				   logger.info("$$EmailToolTipWarningMsg$$ :"+Arp.getEmailToolTipWarningMsg());
				    Assert.assertTrue(Arp.getEmailToolTipWarningMsg().contains("Please include an '@' in the email address."));
		    }                   
		  
		                            
		    
		    
		    logger.info(" ************** TC0018_Email Validation TestCase ended *********** ");
		    
			}catch(Exception e){
				
				logger.error("Error message for Email has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
	}

		
}


