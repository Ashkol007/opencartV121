package testCases.RegisterFunctionality;

//import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC011_Register_Invalid_PoneNumber extends BaseClass {
	
	
	@Test(groups= {"Master"})
	public void registerWithInvalidPhoneNumber() {
		
		try {
			
			logger.info("TC011_Register_Invalid_PoneNumber TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    
		    Arp.setFirstname("ashtiosh");
		    Arp.setLastName("kole");
		    Arp.setEmail("ashitosh@gmail.com");
		    Arp.setTelephone("abcdef");
		    Arp.setPassword("12345");
		    Arp.setConfirmPwd("12345");
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
			
		    

			logger.info("TC011_Register_Invalid_PoneNumber TestCase passed" );
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Register_Invalid_PoneNumber is being accepted");
			Assert.fail();
          			
			
		}
		
		
		
		
	}
	

}
