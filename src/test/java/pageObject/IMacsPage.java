package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IMacsPage extends Basepage{
	
	IMacsPage(WebDriver driver){
		super(driver);
		
	}
	
	
	By MacAddtoCartBtn = By.xpath("//div[@class='product-layout product-list col-xs-12']//button[1]");
	By CartDropdown = By.xpath("//span[@id='cart-total']");
	By ViewCartBtn = By.xpath("//strong[normalize-space()='View Cart']");
	
	
	public void MacAddToCart() {
		await.until(ExpectedConditions.elementToBeClickable(MacAddtoCartBtn));
		driver.findElement(MacAddtoCartBtn).click();
	}
	
	public void addiMacToCart() {

		await.until(ExpectedConditions.elementToBeClickable(CartDropdown));

		driver.findElement(CartDropdown).click();
		
		await.until(ExpectedConditions.elementToBeClickable(ViewCartBtn));
		driver.findElement(ViewCartBtn);
		
	}
	

}
