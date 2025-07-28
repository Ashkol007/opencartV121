package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import pageObject.LoginPage;

public class TC0007_PasswordValidation extends BaseClass {
	
	  
		
		@Test(groups= {"Master"})
		public void checkPasswordValidation() {
			
			try {
				logger.info(" ************** TC0007_Password Validation TestCase started ***********");
				Homepage Hp = new Homepage(driver);
				Hp.myAccount();
				Hp.login();
				
				
			    LoginPage Alp = new LoginPage(driver);
			              Alp.sendEmail("ashitosh3@gmail.com");
			              Alp.sendPwd("wrongpwd");
			              Alp.clickLogin();
			      
			   
			    Assert.assertEquals(Alp.isPasswordValidationTxt(),true, "Validation txt for wrong paswword does not appeared");
			    
			    
			    logger.info(" ************** TC0007_Password Validation TestCase ended *********** ");
			    
				}catch(Exception e){
					
					logger.error("Error message for Account has created!!!");
			    	logger.debug(e.getMessage());
					Assert.fail();
					
				}
			
			
			
		}

}




