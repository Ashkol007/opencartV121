package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;
import utilities.HelperFunctions;

public class TC024_CheckConfirmPwdWarningMessage extends BaseClass {
	
	
	@Test(groups= {"Master"})
	public void emptyPwdFieldCheckConfirmPasswordMsgValidation() {
		
		try {
			
			logger.info(" TC024_CheckConfirmPwdWarningMessage testcase stated");
		
			
			Homepage Hp = new Homepage(driver);
			         Hp.myAccount();
			         Hp.register();
			
			HelperFunctions helpFunc = new HelperFunctions();         
			         
			AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
			                        Arp.setFirstname("Ashitosh");
			                        Arp.setLastName("kole");
			                        Arp.setEmail("ashitoshkole007@gmail.com");
			                        Arp.setTelephone("9890038026");
			                        Arp.setPassword(helpFunc.nameGenerator(5)+helpFunc.numGenerator(5));
			                        Arp.setConfirmPwd("");
			                        Arp.clickContinue();
			                        
			                   Assert.assertEquals(Arp.confirmPwdWarningMsg(), "Password confirmation does not match password!");     
		       
			
		logger.info("TC024_CheckConfirmPwdWarningMessage testcase passed");
               			
			
			
		}catch(Exception e){
			
			logger.error("Confirm Password Warning Msg Validation Failed");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
		
	}

}
