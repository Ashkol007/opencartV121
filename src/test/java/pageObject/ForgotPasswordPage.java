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
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']") WebElement forgottenPasswordHeading;
	@FindBy(xpath="//p[contains(text(),'Enter the e-mail address associated with your acco')]")
	WebElement forgottenPasswordParagraphText;
	
	
	public void setForgotEmail(String email) {
		await.until(ExpectedConditions.elementToBeClickable(emailInput));
		emailInput.sendKeys(email);
		
	}
	
	public void clickContinue() {

		await.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
	}
	
	public String getForgottenPwdHeading() {
		
		await.until(ExpectedConditions.elementToBeClickable(forgottenPasswordHeading));
		
		return forgottenPasswordHeading.getText();
	}
	
	public String getForgottenPasswordParagraphText() {
		
		return await.until(ExpectedConditions.elementToBeClickable(forgottenPasswordParagraphText)).getText();
	}
	
  	

}
