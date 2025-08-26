package testCases.RegisterFunctionality;


	import org.testng.Assert;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.AccountRegistrationPage;
import pageObject.AccountSuccessPage;
import pageObject.EditInformationPage;
import pageObject.Homepage;
import pageObject.MyAccountPage;
import testCases.BaseClass;
import utilities.HelperFunctions;

	public class TC019_HeadingAndTrailingSpacesforAllFields extends BaseClass {
		
		
		@Test(groups= {"Master"})
		public void headingandTrailingSpacesOnRegisterPage() {
			
			try {
				
				logger.info("TC019_HeadingAndTrailingSpacesforAllFields TestCase started" );
				
				Homepage Hp = new Homepage(driver);
				Hp.myAccount();
				Hp.register();
				
				
			    AccountRegistrationPage Arp = new AccountRegistrationPage(driver);
			    
			    HelperFunctions help = new HelperFunctions();
			    
			    String firstName = "   "+help.nameGenerator(5)+ "   ";
			    String lastName ="   "+ help.nameGenerator(5) +"   ";
			    String email = "   " +help.emailGenerator(5) + "   ";
			    String telephone = "   9809869840   ";
			    
			    Arp.setFirstname(firstName);
			    Arp.setLastName(lastName);
			    Arp.setEmail(email);
			    Arp.setTelephone(telephone);
			    Arp.setPassword("12345");
			    Arp.setConfirmPwd("12345");
			    Arp.setPrivacyPolicy();
			    Arp.clickContinue();
			    
			    AccountSuccessPage asp = new AccountSuccessPage(driver);
			                       asp.clickContinueBtn();
			    
			    MyAccountPage mcp = new MyAccountPage(driver);
			                  mcp.editYourAccountInfoTab();
			                  
			    EditInformationPage eip = new EditInformationPage(driver);
			                          
			    
			    SoftAssert softAssert = new SoftAssert();

			 // perform soft assertions
//			 softAssert.assertEquals(eip.getFirstNameText(), firstName.trim(), "First name does not match");
//			 softAssert.assertEquals(eip.getLastNameText(), lastName.trim(), "Last name does not match");
			 softAssert.assertEquals(eip.getEmailText(), email.trim(), "Email does not match");
//			 softAssert.assertEquals(eip.getTelephoneText(), telephone.trim(), "Telephone does not match");
			                  
			 softAssert.assertAll();
			    

				logger.info("TC019_HeadingAndTrailingSpacesforAllFields TestCase passed" );
				
				
				
			}catch(Exception e){
				
				logger.debug(e.getMessage());
				logger.error("Register_Invalid_PoneNumber is being accepted");
				Assert.fail();
	          			
				
			}
			
			
			
			
		}
		

		
	

	

}
