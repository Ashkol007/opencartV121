package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;

public class TC0006_RequiredFieldValidation extends BaseClass {
	
	
	@Test(priority=1,groups= {"Sanity"})
	public void accountRegistraion() {
		
	 logger.info(" ************** TC0006_Registration Validation Field TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
	    
	    
	    Arp.clickContinue();
	    
	    
	    
	   
	    Assert.assertEquals(Arp.checkValidations(),true,"Validations messages not appeared.");;
	    
	    
	    logger.info(" ************** TC0006_Registration Validation Field TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}
	    	
	}

}
