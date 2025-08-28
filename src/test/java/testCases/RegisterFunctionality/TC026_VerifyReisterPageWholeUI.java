package testCases.RegisterFunctionality;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.Homepage;
import testCases.BaseClass;
import utilities.HelperFunctions;

public class TC026_VerifyReisterPageWholeUI extends BaseClass {
	

	@Test(groups= {"Master"})
	public void verifyPageUrlBreadCrumbTitleHeading() {
		
		try {
			 
			Homepage Hp = new Homepage(driver);
			Hp.myAccount();
			Hp.register();
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File Actualfile =  ts.getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(Actualfile,new File(System.getProperty("user.dir")+"\\screenshots\\RegisterPageActual.png"));
		    
		    HelperFunctions hf = new HelperFunctions();
		    
		    Assert.assertFalse(hf.compareScreenshots(System.getProperty("user.dir")+"\\screenshots\\sc1Actual.png",
		    		System.getProperty("user.dir")+"\\screenshots\\RegisterPageActual.png"));
			
			
			
			
		}catch(Exception e){
			
			
			logger.error("TC025_VerifyPage_Url_BreadCrumb_Title_Heading is failed");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}
		
		
	}


}

