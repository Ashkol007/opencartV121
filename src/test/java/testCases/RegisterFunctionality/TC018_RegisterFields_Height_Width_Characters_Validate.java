package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC018_RegisterFields_Height_Width_Characters_Validate extends BaseClass {
	
	@Test(groups= {"Master"})
	public void registerFieldsHeightAndWidth() {
		
try {
			
			logger.info("TC018_RegisterFields_Height_Width_Characters_Validate TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    AccountSuccessPage Asp = new AccountSuccessPage(driver);
		    
		             String pwd20char = nameGenerator(20);
		    
		           String[] heightWidthsize =  Arp.getHAndWforFirstName();
		           
		           String FirstNameWarningMsg = "First Name must be between 1 and 32 characters!";
		           
		           
		           Assert.assertEquals(heightWidthsize[0].toString(), "34px");
                   Assert.assertEquals(heightWidthsize[1], "701.25px");
                   Arp.setFirstname(" ");
                   Arp.clickContinue();
                   Assert.assertEquals(Arp.firstNameValidation(), FirstNameWarningMsg);
		           
		           Arp.clearFirstName();
		           Arp.setFirstname(nameGenerator(32));
		           Arp.clickContinue();
		           try {

			           Assert.assertFalse(Arp.firstNameWarningDisplayed());
		           }catch(Exception e){
		        	   Assert.assertTrue(true);
		           }
		           
		          
		           Arp.setLastName(nameGenerator(32));
		           Arp.setEmail(nameGenerator(50)+"@gmail.com");
		           Arp.setTelephone(numGenerator(32));
		           Arp.setPassword(pwd20char);
		           Arp.setConfirmPwd(pwd20char);
		           Arp.selectYesForNewsletterSubscribe();
		           Arp.setPrivacyPolicy();
		           
		           

		           
		    
		    logger.info("TC018_RegisterFields_Height_Width_Characters_Validate TestCase passed"+heightWidthsize);
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Password Complexity Standard is not set!");
			Assert.fail();
          			
			
		}


   }
	
	
}
