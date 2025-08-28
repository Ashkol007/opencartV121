package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC022_CheckIfPasswordInputIsHidden extends BaseClass {

	
	@Test(groups= {"Master"})
	public void passwordInputIsHidden() {
		
		try {
			
			logger.info("TC022_CheckIfPasswordInputIsHidden testcase started");
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    

		    Assert.assertEquals(Arp.getPwdTypeAttribute(), "password");
		    
		    Assert.assertEquals(Arp.getConfirmPwdTypeAttribute(), "password");

			logger.info("TC022_CheckIfPasswordInputIsHidden testcase passed");
			
			
		}catch(Exception e){
			
			logger.error("Password Input Is not Hidden");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}

	}	
	
}
