package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaptopsAndNoteBookPage extends Basepage {
	
	public LaptopsAndNoteBookPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='product-thumb']//img") List<WebElement> productsList_images;
	@FindBy(xpath="//button[@id='button-cart']") WebElement addToCart_Btn;
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Laptops & Notebooks')]") WebElement  laptopAndNotebook_tab;
	
	
	public void selEachProductImg() {
	
		System.out.println("*****ProduImages*****"+productsList_images);
		for(WebElement product : productsList_images) {
			await.until(ExpectedConditions.elementToBeClickable(product)).click();
//			product.click();
			addToCart_Btn.click();
			driver.navigate().back();
//			laptopAndNotebook_tab.click();
//            await.until(ExpectedConditions.elementToBeClickable(laptopAndNotebook_tab)).click();
		}
	}

}
