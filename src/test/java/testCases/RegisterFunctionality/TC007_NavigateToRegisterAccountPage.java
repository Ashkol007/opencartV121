package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import testCases.BaseClass;

public class TC007_NavigateToRegisterAccountPage extends BaseClass {
	
	
	@Test(groups= {"Master"})
	public void differentWaysToRegisterPage() {
		
            try {
            	
        		logger.info(" TC007_NavigateToRegisterAccountPage Tescase started ");
        		
        		Homepage Hp = new Homepage(driver);
                         Hp.myAccount();
                         Hp.register();
                         
                AccountRegistrationPage Arp = new AccountRegistrationPage(driver);         
                         Assert.assertEquals(Arp.isRegisterAccountPage(), true);
                         
                         Arp.homeIcon();
                         
                         Hp.myAccount();
                         Hp.login();
                         
                LoginPage Lp = new LoginPage(driver);         
        		          Lp.newCustomerContinueBtn();
        		          
        		         Assert.assertEquals(Arp.isRegisterAccountPage(), true);
        		

        		 		logger.info(" TC007_NavigateToRegisterAccountPage Tescase ended ");
            	
            } catch (Exception e){
            	
            	logger.error("Navigate to register Account page failed");
            	logger.debug(e.getMessage());
            	Assert.fail("Navigate to register Account page");
            	
            	
            }        
		
		
	}

}
