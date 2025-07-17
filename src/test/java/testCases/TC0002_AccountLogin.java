package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC0002_AccountLogin extends BaseClass {

	@Test(groups= {"Master","Regression"})
	public void accountLogin() {
		     
		     logger.info("*********TC0002_AccountLogin_Test_Started****************");
		     Homepage hp = new Homepage(driver);
		              hp.myAccount();
		              hp.login();
		  
	    	 LoginPage lp = new LoginPage(driver);
	    	 
	    	 lp.sendEmail(p.getProperty("email"));
	    	 lp.sendPwd(p.getProperty("password"));
	    	 lp.clickLogin();
	    	 
	    	 MyAccountPage Map = new MyAccountPage(driver);
	    	 Boolean HeadingTxt =  Map.MyAccountHeading();
             
	    	 Assert.assertEquals(true, HeadingTxt);

	    	 logger.info("Heding Text Passed SuccessFully" + HeadingTxt);
			 logger.info("*********TC0002_AccountLogin_Test_Ended****************");
	    	 
	}
	
}
