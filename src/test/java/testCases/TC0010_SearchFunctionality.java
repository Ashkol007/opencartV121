package testCases;

//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.ForgotPasswordPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC0010_SearchFunctionality extends BaseClass {
	
	@Test(groups="Master")
	public void isProductAvailableBySearch() {
		
		try {
			
			logger.info(" ************** TC0010_Search Product and Validate TestCase started ***********");
			Homepage Hp = new Homepage(driver);
			
			Hp.searchItem("Apple Cinema");
			
			Boolean flag =  driver.getTitle().contains("Apple Cinema");
		
		      
		   
		    Assert.assertEquals(flag,true, "Product was not Appeared on Search page successfully");
		    
		    
		    logger.info(" ************** TC0010_Search Product and Validate TestCase ended ***********");
		    
			}catch(Exception e){
				
				logger.error("Error message for Account has created!!!");
		    	logger.debug(e.getMessage());
				Assert.fail();
				
			}
		
	}

}
