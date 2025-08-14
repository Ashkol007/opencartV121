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
	    
	    
        
        Assert.assertEquals(Arp.firstNameValidation(), true);

        Assert.assertEquals(Arp.larstNameValidation(), true);

        Assert.assertEquals(Arp.emailValidation(), true);

        Assert.assertEquals(Arp.paswordValidation(), true);
        

        Assert.assertEquals(Arp.telephoneValidation(), true);
        
	    
	    logger.info(" ************** MandatoryFieldsNotifications TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}
	    	
	}
	
	
	
}
