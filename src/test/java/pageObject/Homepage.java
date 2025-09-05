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
	@FindBy(xpath="(//span[contains(text(),'Add to Cart')])[1]") WebElement CanonEos_atc;
    @FindBy(xpath="(//span[contains(text(),'Add to Cart')])[3]") WebElement AppleCinema_atc;
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']") WebElement LaptopAndNoteBooks_tab;
	@FindBy(xpath="//a[normalize-space()='Show AllLaptops & Notebooks']") WebElement ShowAllLaptopAndNoteBook_opt;
	
	@FindBy(xpath="//input[@placeholder='Search']") WebElement SearchInput;
	@FindBy(xpath="//i[@class='fa fa-search']") WebElement SearchBtn;
	
	@FindBy(xpath="(//button[@data-original-title='Compare this Product'])[1]") WebElement AddMacToCompareProds;
    @FindBy(xpath="(//button[@data-original-title='Compare this Product'])[2]") WebElement AddiPhoneToCompareProds;
    @FindBy(xpath="(//button[@data-original-title='Compare this Product'])[3]") WebElement AddAppleCinemaToCompareProds;
	
	public void myAccount(){
		
		MyAcc_txt.click();
	}
	
	public void register() {
		
		Register_txt.click();
	}
	
    public void login() {
		
		Login_txt.click();
	}
	
	public LoginPage loginV2() {
		
		Login_txt.click();
		return new LoginPage(driver);
	}
	
	public void addtocart() {

       await.until(ExpectedConditions.elementToBeClickable(Iphone_atc));
		Iphone_atc.click();
		Macbook_atc.click();
//		CanonEos_atc.click();
//		AppleCinema_atc.click();
	}
	
	public void shoppingCart() {
		ShoppingCart_Btn.click();
	}
	
	public void showAllLaptopAndNoteBooks() {
		LaptopAndNoteBooks_tab.click();
//		await.until(ExpectedConditions.elementToBeClickable(ShowAllLaptopAnd))
		ShowAllLaptopAndNoteBook_opt.click();
	}
	
	public void searchItem(String item) {

	    await.until(ExpectedConditions.elementToBeClickable(SearchInput));
		SearchInput.sendKeys(item);
		SearchBtn.click();
	}
	
	

}
