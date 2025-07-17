package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AddToCartPage;
import pageObject.Homepage;
import pageObject.LaptopsAndNoteBookPage;

public class TC0005_AddMultipleProductsToCartTest extends BaseClass {
	
	@Test(groups={"Master"})
	public void addMultipleToCartFromLaptopsAndNoteBook() throws InterruptedException {
		
		Homepage Hp = new Homepage(driver);
		Hp.showAllLaptopAndNoteBooks();
		
		Thread.sleep(1000);
		LaptopsAndNoteBookPage Lab = new LaptopsAndNoteBookPage(driver);
		Lab.selEachProductImg();
		
		Thread.sleep(1000);
		AddToCartPage Acp = new AddToCartPage(driver);
		 Hp.shoppingCart();
		 Acp.isShopCartTable();
		Assert.assertTrue(true);
		
		
		
	}
	

}
