package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC0003_LoginWithExcelDataTest extends BaseClass {

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"Master","Regression"})
	public void LoginTestData(String email,String pwd,String Res) {
		
		Homepage Hp = new Homepage(driver);
		         Hp.myAccount();
		         Hp.login();
		
		LoginPage Lp = new LoginPage(driver);
		          Lp.sendEmail(email);
		          Lp.sendPwd(pwd);
		          Lp.clickLogin();
		   logger.info("********Email*******"+email); 
		   logger.info("*********PWD******"+pwd);
		         
		MyAccountPage Macc = new MyAccountPage(driver);
		
		Boolean isMyaccount = Macc.MyAccountHeading();
		
		if(Res.equalsIgnoreCase("Valid")) {
			logger.info("******* Res :"+Res.toString());
			if(isMyaccount==true) {
				Macc.MyAccountLogout();
				Macc.ContinueLogout();
				logger.info("TestCase Passed");
				Assert.assertEquals(true, isMyaccount.booleanValue());
			}
			
		}else {
			Assert.assertTrue(false);
		}
		
//		if(Res.equalsIgnoreCase("Invalid")) {
//			
//			
//				logger.info("********Invalid testcase Passed");
//				Assert.assertTrue(true);
//			
//			
//		}else {
//		    
//			if(isMyaccount == true) {
//				Macc.MyAccountLogout();
//				Macc.ContinueLogout();
//				logger.info("********testcase failed*****");
//				Assert.assertTrue(false);
//			}
//			
//		}
		         
		
	}
	
	
	
}
