package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddToCartPage;
import pageObject.Homepage;

public class TC0004_AddToCartTest extends BaseClass {
	

	
	
	
	@Test(groups= {"Master"})
	public void AddTocartFromHomePage() {
		
	
		Homepage Hp = new Homepage(driver);
		   Hp.addtocart();
		   Hp.shoppingCart();
		
		AddToCartPage Atc = new AddToCartPage(driver);
		   Boolean isShopCart = Atc.isShopCartTable();
		   
		   Assert.assertEquals(true, isShopCart);
	}
	
	
	

}
