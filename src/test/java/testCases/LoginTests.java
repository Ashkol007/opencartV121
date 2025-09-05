package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginTests extends BaseClass {
	
	Homepage homepage;
	LoginPage loginpage;
	
	@Test(priority=1,groups= {"Master","Regression"})
	public void accountLogin() {
		     
		     logger.info("*********TC01_Login to App using valid credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.sendEmail(p.getProperty("email"));
	    	 loginpage.sendPwd(p.getProperty("password"));
	    	 loginpage.clickLogin();
	    	 
	    	 MyAccountPage Map = new MyAccountPage(driver);
	    	 Boolean HeadingTxt =  Map.MyAccountHeading();
             
	    	 Assert.assertEquals(true, HeadingTxt);
	    	 Assert.assertTrue(Map.isRightSideLogoutLinkDisplayed());

	    	 logger.info("Heding Text Passed SuccessFully" + HeadingTxt);
			 logger.info("*********TC01_Login to App using valid credentials testcase ended****************");
	    	 
	}
	
	
	@Test(priority=2,groups= {"Master","Regression"})
	public void loginAccountUsingInvalidCredentials() {
		     
		     logger.info("*********TC01_Login to App using invalid credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.sendEmail(p.getProperty("invalidemail"));
	    	 loginpage.sendPwd(p.getProperty("invalidpwd"));
	    	 loginpage.clickLogin();
	    	 
             
	    	 Assert.assertTrue(loginpage.isEmailandPwdWarningDisplayed());
	    	 Assert.assertEquals(loginpage.getEmailandPwdValidationWarningText(), "Warning: No match for E-Mail Address and/or Password.");

			 logger.info("*********TC0002_TC01_Login to App using invalid credentials testcase ended****************");
	    	 
	}
	
	@Test(priority=3,groups= {"Master","Regression"})
	public void loginAccountUsingValidEmailAndInvalidPwd() {
		     
		     logger.info("*********TC03_Login to App using valid email invalid pwd credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.sendEmail(p.getProperty("email"));
	    	 loginpage.sendPwd(p.getProperty("invalidpwd"));
	    	 loginpage.clickLogin();
	    	 
             
	    	 Assert.assertTrue(loginpage.isEmailandPwdWarningDisplayed());
	    	 Assert.assertEquals(loginpage.getEmailandPwdValidationWarningText(), "Warning: No match for E-Mail Address and/or Password.");

			 logger.info("*********TC03_TC03_Login to App using valid email invalid pwd credentials testcase ended****************");
	    	 
	}
	
	

}
