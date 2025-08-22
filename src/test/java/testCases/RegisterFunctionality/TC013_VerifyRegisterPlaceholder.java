package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC013_VerifyRegisterPlaceholder extends BaseClass {
	
	

	@Test(groups= {"Master"})
	public void verifyRegisterPlaceholder() {
		
		try {
			
			logger.info("TC013_VerifyRegisterPlaceholder TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);

			Assert.assertEquals(Arp.getFirstNamePlaceholder(), "First Name");

			Assert.assertEquals(Arp.getLastNamePlaceholder(), "Last Name");

			Assert.assertEquals(Arp.getEmailPlaceholder(), "E-Mail");

			Assert.assertEquals(Arp.getPasswordPlaceholder(), "Password");

			Assert.assertEquals(Arp.getConfirmPasswordPlaceholder(), "Password Confirm");

			Assert.assertEquals(Arp.getTelephonePlaceholder(), "Telephone");
		    

		    
		    
			
		    

			logger.info("TC013_VerifyRegisterPlaceholder TestCase passed" );
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Register_Invalid_PoneNumber is being accepted");
			Assert.fail();
          			
			
		}
	

	}

}
