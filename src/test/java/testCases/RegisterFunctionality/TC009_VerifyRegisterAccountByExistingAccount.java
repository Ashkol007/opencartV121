package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC009_VerifyRegisterAccountByExistingAccount extends BaseClass{

	
	@Test(groups= {"Master"})
	public void verifyRegisterAccount() {
		
		try {
			
			logger.info("TC009_VerifyRegisterAccountByExistingAccount testcase started");
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    
		    Arp.setFirstname("ashtiosh");
		    Arp.setLastName("kole");
		    Arp.setEmail("ashitosh3"+"@gmail.com");
		    Arp.setTelephone(numGenerator(10));
		    Arp.setPassword("12345");
		    Arp.setConfirmPwd("12345");
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
		    
		    logger.info("Warning message: " + Arp.warningForPreviouslyRegisterdAccount());

		    
		    
		    Assert.assertEquals(Arp.warningForPreviouslyRegisterdAccount(), "Warning: E-Mail Address is already registered!");

			logger.info("TC009_VerifyRegisterAccountByExistingAccount testcase passed");
			
			
		}catch(Exception e){
			
			logger.error("Verify Register Account By Existing Account Validation Failed");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
		
		
	}
	
	
	
}
