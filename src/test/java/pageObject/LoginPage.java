package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Basepage {



	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(name = "email") WebElement Inpemail;
    @FindBy(xpath="//input[@id='input-password']") WebElement Inppassword;
    @FindBy(xpath="//input[@value='Login']") WebElement Btnlogin;
    @FindBy(xpath="//div[contains(@class,'alert') and text()='Warning: No match for E-Mail Address and/or Password.']")
    WebElement PasswordValidationTxt;
    
    public void sendEmail(String email) {
    	Inpemail.sendKeys(email);
    }
    
    public void sendPwd(String pwd) {
    	Inppassword.sendKeys(pwd);
    }
    
    public void clickLogin() {
         Btnlogin.click();	
    }
    
    public Boolean isPasswordValidationTxt() {
    	await.until(ExpectedConditions.visibilityOf(PasswordValidationTxt));
    	if(PasswordValidationTxt.isDisplayed()) {
    		return true;
    	}
    	return false; 
    }



	
	
	
	

}
