package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends Basepage {
	

	 public AddToCartPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 
	 @FindBy(xpath="//h1[contains(text(),'Shopping Cart')]") WebElement ShopCart_heading;
	 
	 @FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']")WebElement ShopCart_table;
	 
	 @FindBy(xpath="//table//tbody") WebElement CartTableTbody;
	 
	 
	 public Boolean isShopCartTable() {
		 if(ShopCart_table.isDisplayed()) {
			 return true;
		 }
		 return false;
	 }
	 
	
	 
	 
	 
}
