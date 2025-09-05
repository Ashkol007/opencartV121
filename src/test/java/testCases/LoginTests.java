package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginTests extends BaseClass {
	
	Homepage homepage;
	LoginPage loginpage;
	ForgotPasswordPage forgottenPasswordPage;
	MyAccountPage myaccountpage;
	
	
	
	@Test(priority=1,groups= {"Master","Regression"})
	public void accountLogin() {
		     
		     logger.info("*********TC01_Login to App using valid credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.sendEmail(p.getProperty("email"));
	    	 loginpage.sendPwd(p.getProperty("password"));
	    	 loginpage.clickLogin();
	    	 
	    	 myaccountpage = new MyAccountPage(driver);
	    	 Boolean HeadingTxt =  myaccountpage.MyAccountHeading();
             
	    	 Assert.assertEquals(true, HeadingTxt);
	    	 Assert.assertTrue(myaccountpage.isRightSideLogoutLinkDisplayed());

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

			 logger.info("*********TC02_Login to App using invalid credentials testcase ended****************");
	    	 
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

			 logger.info("*********TC03_Login to App using valid email invalid pwd credentials testcase ended****************");
	    	 
	}
	
	@Test(priority=4,groups= {"Master","Regression"})
	public void loginAccountUsingValidEmailandInvalidPwd() {
		     
		     logger.info("*********TC04_Login to App using Invalid email and valid pwd credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.sendEmail(p.getProperty("invalidemail"));
	    	 loginpage.sendPwd(p.getProperty("password"));
	    	 loginpage.clickLogin();
	    	 
             
	    	 Assert.assertTrue(loginpage.isEmailandPwdWarningDisplayed());
	    	 Assert.assertEquals(loginpage.getEmailandPwdValidationWarningText(), "Warning: No match for E-Mail Address and/or Password.");

			 logger.info("*********TC04_Login to App using Invalid email and valid pwd credentials testcase ended****************");
	    	 
	}
	
	@Test(priority=5,groups= {"Master","Regression"})
	public void loginAccountWithEmptyEmailandPwdField() {
		     
		     logger.info("*********TC05_Login to App with empty email and pwd field credentials testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  
	    	 
	    	 loginpage.clickLogin();
	    	 
             
	    	 Assert.assertTrue(loginpage.isEmailandPwdWarningDisplayed());
	    	 Assert.assertEquals(loginpage.getEmailandPwdValidationWarningText(), "Warning: No match for E-Mail Address and/or Password.");

			 logger.info("*********TC05_Login to App with empty email and pwd field credentials testcase passed****************");
	    	 
	}
	
	
	@Test(priority=6,groups= {"Master","Regression"})
	public void verifyForgotPwdLinkIsPresentandWorkingFine() {
		     
		     logger.info("*********TC06_Check if Forgot password link is working fine testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		  

		     Assert.assertTrue(loginpage.isForgottenPwdLinkpresent());
	    	        
	    	         forgottenPasswordPage =  loginpage.clickForgotPasswordv2();
	    	 
	    	 Assert.assertEquals(forgottenPasswordPage.getForgottenPwdHeading(),"Forgot Your Password?");
	    	 Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordParagraphText(), "Enter the e-mail address associated with your account. Click submit to have a password reset link e-mailed to you.");

			 logger.info("*********TC06_Check if Forgot password link is working fine testcase passed****************");
	    	 
	}
	
	@Test(priority=7,groups= {"Master","Regression"})
	public void verifyLoginUsingKeyboardKeys() {
		     
		     logger.info("*********TC07_Verify login Functionalty using keyboard keys testcase started****************");
		              homepage = new Homepage(driver);
		              homepage.myAccount();
		              loginpage =  homepage.loginV2();
		              
		              loginpage.usingTabKeyToReachLoginFieldandPassValues();
		              
		              myaccountpage = new MyAccountPage(driver);
		              try {
						Thread.sleep(Duration.ofSeconds(1));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	    	  Boolean HeadingTxt =  myaccountpage.MyAccountHeading();
		              
		 	    	 Assert.assertEquals(true, HeadingTxt);
		 	    	 Assert.assertTrue(myaccountpage.isRightSideLogoutLinkDisplayed());

		     
			 logger.info("*********TC06_Check if Forgot password link is working fine testcase passed****************");
	    	 
	}
	
	

}
