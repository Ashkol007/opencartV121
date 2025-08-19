package testCases.RegisterFunctionality;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC010_VerifyingRegisteringAccountByInvalidEmail extends BaseClass {
	
	
	@Test(groups= {"Master"})
	public void verifyRegisterAccountByInvalidEmail() {
		 
		try {
			
			logger.info("VerifyingRegisteringAccountByInvalidEmail testcase started");
			
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    
		    Arp.setFirstname("ashtiosh");
		    Arp.setLastName("kole");
		    Arp.setEmail("ashitosh");
		    Arp.setTelephone("9309803610");
		    Arp.setPassword("12345");
		    Arp.setConfirmPwd("12345");
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
		    
		    
		    
		    Assert.assertTrue(Arp.getScreenShotOfRegistrationForm());
		    

		        

			logger.info("VerifyingRegisteringAccountByInvalidEmail testcase ended");
			 
		 }catch(Exception e){
			 
			    logger.error("Verify Register Account By Invalid Email Validation Failed");
				logger.debug(e.getMessage());
				Assert.fail();
			 
		 }
		
		
	}

}
