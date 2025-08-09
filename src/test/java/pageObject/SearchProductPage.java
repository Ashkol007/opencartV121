package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchProductPage extends Basepage {

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="(//i[@class='fa fa-heart'])[2]") WebElement addtoWishlistIcon;
	@FindBy(xpath="//a[@id='wishlist-total']//i[@class='fa fa-heart']") WebElement WishlistIcon;
	@FindBy(xpath="(//div[@class='row'])[5]//div[@class='product-thumb']//h4") List<WebElement> titlesofProduct;
	@FindBy(xpath="//h4//a") List<WebElement> ProductHeading;
	@FindBy(xpath="(//i[@class='fa fa-exchange'])[1]")WebElement ProductCompareIcon;
	
	@FindBy(xpath="//a[normalize-space()='product comparison']") WebElement ProductComparePageLink;
	
	
	public void addProductToWishlist(String product) {
		
		for(WebElement prodHeading : titlesofProduct) {
			
			if(prodHeading.getText().equalsIgnoreCase(product)) {
				prodHeading.click();
				await.until(ExpectedConditions.elementToBeClickable(addtoWishlistIcon)).click();
			}
			
		}
		
		
	}
	
	public void goToWishList() {

		await.until(ExpectedConditions.elementToBeClickable(WishlistIcon)).click();
		
	}
	
	public void  addProdToCompareProducts(String prod) {
		
        for(WebElement prodHeading : ProductHeading) {
			
			if(prodHeading.getText().equalsIgnoreCase(prod)) {
				prodHeading.click();
				await.until(ExpectedConditions.elementToBeClickable(ProductCompareIcon)).click();
			}
			
		}
		
		
	}
	
	public void goToProductComparePage() {
		
		await.until(ExpectedConditions.elementToBeClickable(ProductComparePageLink)).click();
		
	}

}
