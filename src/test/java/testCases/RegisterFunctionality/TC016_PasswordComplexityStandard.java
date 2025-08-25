package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC016_PasswordComplexityStandard extends BaseClass {
	
	
	@Test(groups= {"Master"},dataProvider = "passwordData")
	public void passwordComplexityStandard(String pwdTxt) {
		
try {
			
			logger.info("TC016_PasswordComplexityStandard TestCase started" );
			
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    
		    Arp.setFirstname("ashtiosh");
		    Arp.setLastName("kole");
		    Arp.setEmail("ashitosh@gmail.com");
		    Arp.setTelephone("abcdef");
		    Arp.setPassword(pwdTxt);
		    Arp.setConfirmPwd(pwdTxt);
		    Arp.setPrivacyPolicy();
		    Arp.clickContinue();
		    
		    logger.info("TC016_PasswordComplexityStandard TestCase passed"+pwdTxt);
			
			
			
		}catch(Exception e){
			
			logger.debug(e.getMessage());
			logger.error("Password Complexity Standard is not set!");
			Assert.fail();
          			
			
		}

    
		
   }
	
	@DataProvider(name="passwordData")
	public Object[][] pwdStrings() {
		
		Object [][] data = {{"1234"},{"abcde"},{"123abcd"},{"!@#$%%"}};
		return data;
	}
	

}
