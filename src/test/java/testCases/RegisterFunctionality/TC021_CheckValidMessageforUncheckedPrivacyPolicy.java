package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC021_CheckValidMessageforUncheckedPrivacyPolicy extends BaseClass{

	
	@Test(priority=1,groups= {"Sanity"})
	public void checkValidMessageforUncheckedPrivacyPolicy() {
		
	 logger.info(" ************** TC021_CheckValidMessageforUncheckedPrivacyPolicy TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);

	    Arp.setFirstname(nameGenerator(5));
	    Arp.setLastName(nameGenerator(5));
	    Arp.setEmail(nameGenerator(5)+"@gmail.com");
	    Arp.setTelephone(numGenerator(10));
	    Arp.setPassword(p.getProperty("password"));
	    Arp.setConfirmPwd(p.getProperty("confirmpwd"));
	    Arp.selectYesForNewsletterSubscribe();
	    Arp.clickContinue();
	    
	   Assert.assertEquals(Arp.uncheckedPrivacyPolicyWarningMsg(), "Warning: You must agree to the Privacy Policy!");
	    
	   
	    
	    
	    logger.info(" ************** TC021_CheckValidMessageforUncheckedPrivacyPolicy TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for  Privacy Policy warning message!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}

    }

}
