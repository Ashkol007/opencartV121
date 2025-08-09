package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.SearchProductPage;

public class TC0012_AddProducttoWishlist extends BaseClass {

	@Test(groups={"Master"})
	
	public void addProducttoWishList() {
		
            try {
			
			logger.info(" ************** TC0012_Search Product and Check if present in wishlist started ***********");
			   Homepage hp = new Homepage(driver);
	              hp.myAccount();
	              hp.login();
	  
 	           LoginPage lp = new LoginPage(driver);
 	            lp.sendEmail(p.getProperty("email"));
 	    	    lp.sendPwd(p.getProperty("password"));
 	    	    lp.clickLogin();
			
			   lp.searchItem("ipod shuffle");
			
			Boolean flag =  driver.getTitle().contains("ipod shuffle");
		
		      
		   
		    Assert.assertEquals(flag,true, "Product was not Appeared on Search page successfully");
		    
		    SearchProductPage Spp = new SearchProductPage(driver);
		                      Spp.addProductToWishlist("iPod Shuffle");  
		                      Spp.goToWishList();
		                      
		    Boolean isProductAvailable = driver.getPageSource().toLowerCase().contains("ipod shuffle");
		    Assert.assertEquals(isProductAvailable, true,"Product was not Appeared on WishList page successfully");                  
		    
		    logger.info(" ************** TC0012_Search Product and Check if present in wishlist ended ***********");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
		
	}
	
	
}
