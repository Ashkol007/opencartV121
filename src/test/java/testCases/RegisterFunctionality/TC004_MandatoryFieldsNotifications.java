package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC004_MandatoryFieldsNotifications extends BaseClass {


	@Test(priority=1,groups= {"Sanity"})
	public void accountRegistraion() {
		
	 logger.info(" ************** TC_RF004_MandatoryFieldsNotifications TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
	    
	    logger.info("Before click continue");
	    Arp.clickContinue();
	    logger.info("After click continue");
	    
	    String FirstNameWarning = "First Name must be between 1 and 32 characters!";
	    String LastNameWarning = "Last Name must be between 1 and 32 characters!";
	    String EmailWarning = "E-Mail Address does not appear to be valid!";
	    String TelephoneWarning = "Telephone must be between 3 and 32 characters!";
	    String PasswordWarning = "Password must be between 4 and 20 characters!";
	    		
	    		
	    
	    		
	   
	    
        
        Assert.assertEquals(Arp.firstNameValidation(), FirstNameWarning);

        Assert.assertEquals(Arp.larstNameValidation(), LastNameWarning);

        Assert.assertEquals(Arp.emailValidation(), EmailWarning);

        Assert.assertEquals(Arp.paswordValidation(), PasswordWarning);
        

        Assert.assertEquals(Arp.telephoneValidation(), TelephoneWarning);
        
	    
	    logger.info(" ************** MandatoryFieldsNotifications TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}
	    	
	}
	
	
	
}
