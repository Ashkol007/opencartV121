package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import pageObject.MyAccountPage;
import testCases.BaseClass;

public class TC012_ReigsterUsingKeyboardKeys extends BaseClass {
	
	

	@Test(groups= {"Master"})
	public void registerUsingKeyboardKeys() {
		
		try {
			
			logger.info("TC012_ReigsterUsingKeyboardKeys TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    Arp.registerUsingtheKeyboardKeys();
		    
//		    MyAccountPage Map = new MyAccountPage(driver);
		    AccountSuccessPage Asp = new AccountSuccessPage(driver);
		                  
		    Assert.assertEquals(Asp.isAccountSuccessPage(), true);
		    
		    
			
		    

			logger.info("TC012_ReigsterUsingKeyboardKeys TestCase passed" );
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Register_Invalid_PoneNumber is being accepted");
			Assert.fail();
          			
			
		}
	

	}
	
}
