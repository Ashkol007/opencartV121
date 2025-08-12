package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountSuccessPage extends Basepage {

	
	public AccountSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@id='content']") WebElement pageContent;
	@FindBy(xpath="//a[normalize-space()='Continue']") @CacheLookup private WebElement continueBtn;
	@FindBy(xpath="//a[normalize-space()='Success']") @CacheLookup private WebElement successTabLink;
	
	
    public Boolean accountSuccessContent(String expectedText) {
		
		String actualText =  pageContent.getText();
		
		if(actualText.contains(expectedText)) return true;
	
		return false;
	}
    
    public Boolean isAccountSuccessPage() {
    	 
    	await.until(ExpectedConditions.elementToBeClickable(successTabLink));
    	
    	if(successTabLink.isDisplayed()) return true;
    	return false;
    	
    	
    }
    
    public void clickContinueBtn() {

    	await.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    	
    }
	
}
