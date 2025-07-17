package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends Basepage {
	
	
	
	public Homepage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement MyAcc_txt;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement Register_txt;
    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement Login_txt;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']") WebElement ShoppingCart_Btn;
	@FindBy(xpath="(//span[contains(text(),'Add to Cart')])[2]") WebElement Iphone_atc;
	@FindBy(xpath="(//span[contains(text(),'Add to Cart')])[1]") WebElement Macbook_atc;
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']") WebElement LaptopAndNoteBooks_tab;
	@FindBy(xpath="//a[normalize-space()='Show AllLaptops & Notebooks']") WebElement ShowAllLaptopAndNoteBook_opt;
	
	
	public void myAccount(){
		
		MyAcc_txt.click();
	}
	
	public void register() {
		
		Register_txt.click();
	}
	
	public void login() {
		
		Login_txt.click();
	}
	
	public void addtocart() {
		Iphone_atc.click();
		Macbook_atc.click();
	}
	
	public void shoppingCart() {
		ShoppingCart_Btn.click();
	}
	
	public void showAllLaptopAndNoteBooks() {
		LaptopAndNoteBooks_tab.click();
//		await.until(ExpectedConditions.elementToBeClickable(ShowAllLaptopAnd))
		ShowAllLaptopAndNoteBook_opt.click();
	}
	
	

}
