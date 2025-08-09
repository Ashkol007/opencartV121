package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddToCartPage;
import pageObject.Homepage;

public class TC0013_CheckCartCount extends BaseClass {
    
	@Test(groups= {"Master"})
	public void AddTocartFromHomePage() {
		logger.info("CheckCartCount Testcase  Started ");
	
		Homepage Hp = new Homepage(driver);
		   Hp.addtocart();
		   Hp.shoppingCart();
		
		AddToCartPage Atc = new AddToCartPage(driver);
		   System.out.println(Atc.cartProductCount());
		   
		   
		   Boolean isShopCart = Atc.isShopCartTable();
		   
		   Assert.assertEquals( isShopCart,true);
		   
		   Assert.assertEquals(Atc.cartProductCount(), 2);
		
		logger.info("CheckCartCount Testcase Ended");
	}	
	
}
