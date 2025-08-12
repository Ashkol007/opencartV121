package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.Homepage;

public class TC0001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(priority=1,groups= {"Sanity"})
	public void accountRegistraion() {
		
	 logger.info(" ************** TC0001_AccountRegistrationTest TestCase started ***********");
		
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
	    Arp.setPrivacyPolicy();
	    Arp.clickContinue();
	    String confirmMsg = Arp.getConfirmationMsg();
	    
	   
	    Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	    
	    Assert.assertEquals(Asp.isAccountSuccessPage(), true);
	    
	    String expectedTxt1 = "Congratulations! Your new account has been successfully created!";

        String expectedTxt2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";

        String expectedTxt3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";

        String expectedTxt4 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
        
        Assert.assertEquals(Asp.accountSuccessContent(expectedTxt1), true);

        Assert.assertEquals(Asp.accountSuccessContent(expectedTxt2), true);

        Assert.assertEquals(Asp.accountSuccessContent(expectedTxt3), true);

        Assert.assertEquals(Asp.accountSuccessContent(expectedTxt4), true);
        
        Arp.submitSuccess(); 
	    
	    logger.info(" ************** TC0001_AccountRegistrationTest TestCase ended *********** ");
	    
		}catch(Exception e){
			
			logger.error("Error message for Account has created!!!");
	    	logger.debug(e.getMessage());
			Assert.fail();
			
		}
	    	
	}
	
	
	
	
      
}
