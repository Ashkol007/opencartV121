package testCases.RegisterFunctionality;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;
import pageObject.MyAccountPage;
import pageObject.NewsLetterPage;
import testCases.BaseClass;

public class TC006_NoOptionForNewsLetterField extends BaseClass {
	
	@Test(priority=1,groups= {"Sanity"})
	public void accountRegistraion() {
		
	 logger.info(" ************** TC06_ No option selected For NewsLetter Field TestCase started ***********");
		
		try {
		Homepage Hp = new Homepage(driver);
		Hp.myAccount();
		Hp.register();
		
		
	    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
	    AccountSuccessPage Asp = new AccountSuccessPage(driver);
	    
	    Arp.setFirstname(nameGenerator(5));
	    Arp.setLastName(nameGenerator(5));
	    Arp.setEmail(nameGenerator(5)+"@gmail.com");
	    Arp.setTelephone(numGenerator(10));
	    Arp.setPassword("12345");
	    Arp.setConfirmPwd("12345");
	    Arp.selectYesForNewsletterSubscribe();
	    Arp.setPrivacyPolicy();
	    Arp.clickContinue();
	    String confirmMsg = Arp.getConfirmationMsg();
	    
	   
	    Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	    
	    Assert.assertEquals(Asp.isAccountSuccessPage(), true);
	    
        Arp.submitSuccess(); 
        
        MyAccountPage Map = new MyAccountPage(driver);
                      Map.newsletterSubscribeOrUnsubscribe();
                      
        NewsLetterPage Nlp = new NewsLetterPage(driver);
                       Assert.assertEquals(Nlp.isSubscribeNoSelected(), true);
	    
	    logger.info(" ************** TC06_ No option selected For NewsLetter Field TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}

}
	
}

