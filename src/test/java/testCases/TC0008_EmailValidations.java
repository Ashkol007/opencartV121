package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import pageObject.LoginPage;

public class TC0008_EmailValidations extends BaseClass {
	
	@Test(groups="Master")
	public void emailValidation() {
		
		try {
			
			logger.info(" ************** TC0008_Email Validation TestCase started ***********");
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
		
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		                            Arp.setEmail("ashi@123");
		                            Arp.clickContinue();
		      
		   
		    Assert.assertEquals(Arp.emailValidation(),true, "Validation txt for email does not appeared");
		    
		    
		    logger.info(" ************** TC0008_Email Validation TestCase ended *********** ");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
	}

}
