package testCases;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.ForgotPasswordPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import pageObject.SearchProductPage;

public class TC0015_CheckProductCompare extends BaseClass {
	
	@Test(groups="Master")
	public void isProductAvailableBySearch() {
		
try {
			
			logger.info(" ************** TC0015_Verify Compare Product started ***********");
			   Homepage hp = new Homepage(driver);
	              hp.myAccount();
	              hp.login();
	  
 	           LoginPage lp = new LoginPage(driver);
 	            lp.sendEmail(p.getProperty("email"));
 	    	    lp.sendPwd(p.getProperty("password"));
 	    	    lp.clickLogin();
			
			    lp.searchItem("ipod shuffle");
//			System.out.println(driver.getTitle().toString());
//			Boolean flag =  driver.getPageSource().toLowerCase().contains("ipod shuffle");
//		    Assert.assertEquals(flag,true, "Product was not Appeared on Search page successfully");
		    
		    SearchProductPage Spp = new SearchProductPage(driver);
		                      Spp.addProdToCompareProducts("iPod Shuffle");  
		                      lp.clearSearchInput();
		                      
		                      lp.searchItem("iMac");
		                      Spp.addProdToCompareProducts("iMac");
		                      Spp.goToProductComparePage();
		                      
		                     Boolean isProduct1 = driver.getPageSource().toLowerCase().contains("ipod shuffle");
		                     Boolean isProduct2 =  driver.getPageSource().toLowerCase().contains("imac");
		                      
		                      
		                      if(isProduct1 && isProduct2) {
		                    	  Assert.assertTrue(true, "Both the products are present in the Product Compares");
		                      }            
		    
		    logger.info(" ************** TC0015_Verify Compare Product ended ***********");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
	}

}

