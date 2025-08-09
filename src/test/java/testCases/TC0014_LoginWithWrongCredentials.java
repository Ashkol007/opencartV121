
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC0014_LoginWithWrongCredentials extends BaseClass{
	



		@Test(groups= {"Master","Regression"})
		public void accountLogin() {
			     
			     logger.info("*********TC0014_Account Login With Wrong Credentials Started****************");
			     Homepage hp = new Homepage(driver);
			              hp.myAccount();
			              hp.login();
			  
		    	 LoginPage lp = new LoginPage(driver);
		    	 
		    	 lp.sendEmail("wrongeemailis@gmail.com");
		    	 lp.sendPwd("wrongpassword");
		    	 lp.clickLogin();
		    	 
		    	 
	             
		    	 Assert.assertEquals(lp.isToastForInvalidEmail(), true, "Toast message for wrong credentials not displayed");

				 logger.info("*********TC0014_Account Login With Wrong Credentials Ended****************");
		    	 
		
		
	}


}
