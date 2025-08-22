package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC014_CheckifAstreixIsPresentForMandatoryFields extends BaseClass{
	
 
	@Test(groups= {"Master"})
	public void registerWithInvalidPhoneNumber() {
		
		try {
			
			logger.info("TC014_CheckifAstreixIsPresentForMandatoryFields TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);

           Assert.assertEquals(Arp.checkForAstreixFirstNameText(),"\"* \"" );
		    

			logger.info("TC014_CheckifAstreixIsPresentForMandatoryFields TestCase passed" );
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Astreix should be present before each mandatory fields on Register Page.");
			Assert.fail();
          			
			
		}
		
		
		
		
	}
	

	

}
