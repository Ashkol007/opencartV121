package testCases.RegisterFunctionality;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.ForgotPasswordPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import testCases.BaseClass;

public class TC023_CheckAllLinksAvailableOnRegisterPage extends BaseClass {
	
	WebDriverWait await;

	@Test(groups= {"Master"})
	public void validateAllLinksOnRegisterPage() {
		
            try {
            	
        		logger.info(" TC023_CheckAllLinksAvailableOnRegisterPage Tescase started ");
        		
        		Homepage Hp = new Homepage(driver);
                         Hp.myAccount();
                         Hp.register();
                         
                AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
                LoginPage Lp = new LoginPage(driver);   
                ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
                
                         Arp.loginPageLink();
                         Assert.assertEquals(Lp.newCustomerHeading(), "New Customer");
                         
                         driver.navigate().back();
                         
                         Arp.forgottenPasswordLink();
                         Assert.assertEquals(fpp.getForgottenPwdHeading(), "Forgot Your Password?");
                         
                         driver.navigate().back();
                         
                         
        		         
                         Arp.privacyPolicyLink();
                         
        		         Assert.assertTrue(Arp.isprivacyPolicyPopCloseBtn());
                         
        		         Arp.privacyPopUpClose();
                         

                         
                         
                         
                         
                         
        		         

        		 		logger.info(" TC023_CheckAllLinksAvailableOnRegisterPage Tescase ended ");
            	
            } catch (Exception e){
            	
            	logger.error("link on register page is not working properly");
            	logger.debug(e.getMessage());
            	Assert.fail("Navigate to register Account page");
            	
            	
            }        
		
		
	}

	
  
}
