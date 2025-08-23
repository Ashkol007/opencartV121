package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC015_EnterSpaceInMandatoryFields extends BaseClass {
	
	@Test(groups= {"Master"})
	public void enterSpaceMandatoryValidationMeassage() {
		
		try {
			
			logger.info("TC015_EnterSpaceInMandatoryFields testcase started");
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    
		    Arp.setFirstname(" ");
		    Arp.setLastName(" ");
		    Arp.setEmail(" ");
		    Arp.setTelephone(" ");
		    Arp.setPassword(" ");
		    Arp.setConfirmPwd(" ");
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
		    
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
	        
			logger.info("TC015_EnterSpaceInMandatoryFields testcase passed");
			
			
		}catch(Exception e){
			
			logger.error("Verify Register Account By Existing Account Validation Failed");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
	

    }
	
}
