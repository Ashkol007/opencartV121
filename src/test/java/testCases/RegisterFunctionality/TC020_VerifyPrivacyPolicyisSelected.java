package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import pageObject.MyAccountPage;
import pageObject.NewsLetterPage;
import testCases.BaseClass;

public class TC020_VerifyPrivacyPolicyisSelected extends BaseClass{
	
	
	
	@Test(priority=1,groups= {"Sanity"})
	public void verifyPrivacyPolicyisSelected() {
		
	 logger.info(" ************** TC020_VerifyPrivacyPolicyisSelected TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
	    
	                            Assert.assertFalse(Arp.isPrivacyCheckBox_Selected()); 
	   
	    
	    
	    logger.info(" ************** TC020_VerifyPrivacyPolicyisSelected TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for  Privacy Policy isSelected!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}

    }
	
	
}
