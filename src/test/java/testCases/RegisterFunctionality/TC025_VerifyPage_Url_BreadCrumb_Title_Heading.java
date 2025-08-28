package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;

public class TC025_VerifyPage_Url_BreadCrumb_Title_Heading extends BaseClass {
	
	
	@Test(groups= {"Master"})
	public void verifyPageUrlBreadCrumbTitleHeading() {
		
		try {
			 
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			
		    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
		    
		    Assert.assertEquals(Arp.registerBreadCrumb(), "Register");
		    Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/register");
		    Assert.assertEquals(driver.getTitle(), "Register Account");
		    Assert.assertEquals(Arp.getRegisterAccountHeading(), "Register Account");
		    
		    
			
			
			
			
		}catch(Exception e){
			
			
			logger.error("TC025_VerifyPage_Url_BreadCrumb_Title_Heading is failed");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
		
		
	}

}
