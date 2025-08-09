package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends Basepage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@name='email']") WebElement emailInput;
	@FindBy(xpath="//input[@type='submit']") WebElement continueBtn;
	
	
	public void setForgotEmail(String email) {
		await.until(ExpectedConditions.elementToBeClickable(emailInput));
		emailInput.sendKeys(email);
		
	}
	
	public void clickContinue() {

		await.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
	}
	
	
  	

}
