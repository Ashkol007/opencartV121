package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import pageObject.NewsLetterPage;
import pageObject.SearchProductPage;

public class TC0016_SubscribeToNewsletter extends BaseClass {

	@Test(groups={"Master"})
	public void subscribeToNewsletter() {
		
         try {
			
			logger.info(" ************** TC0016_Subscribe for newsletter Successfully ***********");
			   Homepage hp = new Homepage(driver);
	              hp.myAccount();
	              hp.login();
	  
 	           LoginPage lp = new LoginPage(driver);
 	            lp.sendEmail(p.getProperty("email"));
 	    	    lp.sendPwd(p.getProperty("password"));
 	    	    lp.clickLogin();
			     
 	    	    MyAccountPage Map = new MyAccountPage(driver);
 	    	                  Map.newsletterSubscribeOrUnsubscribe();
 	    	                  
 	    	    NewsLetterPage Nlp = new NewsLetterPage(driver);
 	    	                   Nlp.selectYesForSubscribe();
 	    	                   Nlp.continueBtnNewsLetter();
 	    	                   
 	    	            Boolean actual =  Map.isNewsSubscribeSuccessMsg();
 	    	            
		         Assert.assertEquals(actual, true);
		    
		    logger.info(" ************** TC0016_Subscribe for newsletter Successfully ***********");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
		
	}
	
	
}
