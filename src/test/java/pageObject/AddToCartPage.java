package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartPage extends Basepage {
	

	 public AddToCartPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 
	 @FindBy(xpath="//h1[contains(text(),'Shopping Cart')]") WebElement ShopCart_heading;
	 
	 @FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']")WebElement ShopCart_table;
	 
	 @FindBy(xpath="//table//tbody") WebElement CartTableTbody;
	 
	 @FindBy(xpath="//table[@class='table table-bordered']//tbody//tr//td[@class='text-center']") List<WebElement> ShopCartProducts;
	 
	 
	 public Boolean isShopCartTable() {
		 if(ShopCart_table.isDisplayed()) {
			 return true;
		 }
		 return false;
	 }
	 
	public int cartProductCount() {
		
		int Count = 0;
		
		for(WebElement product:ShopCartProducts) {
			
			Count++;
			
		}
		
		return Count;
		
	}
	 
	 
	 
}
