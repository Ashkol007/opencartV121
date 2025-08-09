package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.AccountRegistrationPage;
import pageObject.ForgotPasswordPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC0009_ForgotPassword extends BaseClass {
	
	@Test(groups="Master")
	public void emailValidation() {
		
		try {
			
			logger.info(" ************** TC0008_ForgotPassword TestCase started ***********");
			Homepage Hp = new Homepage(driver);
			
			Hp.myAccount();
			Hp.register();
			
			
			AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    Arp.setFirstname(nameGenerator(5));
		    Arp.setLastName(nameGenerator(5));
		    String emailName = nameGenerator(5);
		    Arp.setEmail(emailName+"@gmail.com");
		    Arp.setTelephone(numGenerator(10));
		    Arp.setPassword("12345");
		    Arp.setConfirmPwd("12345");
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
			
		    MyAccountPage acp = new MyAccountPage(driver);
		    acp.MyAccountLogout(); 
		    acp.ContinueLogout();
			
			Hp.myAccount();
		    Hp.login();
			
			LoginPage lp = new LoginPage(driver);
			          lp.clickForgotPassword();
			          
			ForgotPasswordPage fpp = new ForgotPasswordPage(driver);      
			          fpp.setForgotEmail(emailName+"@gmail.com");
			          fpp.clickContinue();
		
			          
		      
		   
		    Assert.assertEquals(lp.isForgotPwdConfirmMessage(),true, "Forgot password email link was not sent successfully");
		    
		    
		    logger.info(" ************** TC0009_ForgotPassword TestCase ended *********** ");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
	}

}
