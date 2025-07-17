package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;

public class TC0001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(priority=1,groups= {"Sanity"})
	public void accountRegistraion() {
		
	 logger.info(" ************** TC0001_AccountRegistrationTest TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
	    
	    Arp.setFirstname(nameGenerator(5));
	    Arp.setLastName(nameGenerator(5));
	    Arp.setEmail(nameGenerator(5)+"@gmaiil.com");
	    Arp.setTelephone(numGenerator(10));
	    Arp.setPassword("12345");
	    Arp.setConfirmPwd("12345");
	    Arp.setPrivacyPolicy();
	    Arp.clickContinue();
	    String confirmMsg = Arp.getConfirmationMsg();
	    
	   
	    Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	    Arp.submitSuccess();
	    
	    logger.info(" ************** TC0001_AccountRegistrationTest TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}
	    	
	}
	
	
	
	
      
}
