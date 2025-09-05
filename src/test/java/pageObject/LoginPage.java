package pageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
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
    @FindBy(xpath="//div[contains(@class,'alert') and text()='Warning: No match for E-Mail Address and/or Password.']")WebElement PasswordValidationTxt;

    @FindBy(xpath="//div[contains(@class,'alert') and text()='Warning: No match for E-Mail Address and/or Password.']")WebElement PasswordandEmailValidationWarning;
    @FindBy(xpath="(//a[normalize-space()='Forgotten Password'])[1]") WebElement ForgotPassword;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement ForgotPwdConfirmMsg;

	@FindBy(xpath="//input[@placeholder='Search']") WebElement SearchInput;
    @FindBy(xpath="//i[@class='fa fa-search']") WebElement SearchBtn;
    @FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible'])[1]")WebElement toastForInvalidEmail;
    @FindBy(xpath="//div[@class='well']//a[normalize-space()='Continue']") WebElement NewCustomerContinueBtn;
    @FindBy(xpath="//h2[normalize-space()='New Customer']") @CacheLookup private WebElement newCustomerHeading;
    
    @FindBy(linkText="Forgotten Password")
    WebElement forgottenPasswordLink;
    
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
    
    public String getEmailandPwdValidationWarningText() {

    	return await.until(ExpectedConditions.visibilityOf(PasswordandEmailValidationWarning)).getText();
    	
    }
    
    public Boolean isEmailandPwdWarningDisplayed() {
    	

    	return await.until(ExpectedConditions.visibilityOf(PasswordandEmailValidationWarning)).isDisplayed();
    }
    
    public void clickForgotPassword() {
        await.until(ExpectedConditions.elementToBeClickable(ForgotPassword));
        ForgotPassword.click();
    }
    
    public ForgotPasswordPage clickForgotPasswordv2() {
        await.until(ExpectedConditions.elementToBeClickable(ForgotPassword));
        ForgotPassword.click();
        return new ForgotPasswordPage(driver);
    }
    
    public Boolean isForgottenPwdLinkpresent() {
    	return await.until(ExpectedConditions.elementToBeClickable(forgottenPasswordLink)).isDisplayed();
    }

    public Boolean isForgotPwdConfirmMessage() {
      
      if(ForgotPwdConfirmMsg.isDisplayed())	return true;
      
      return false;
    }
    
    public void searchItem(String item) {

	    await.until(ExpectedConditions.elementToBeClickable(SearchInput));
		SearchInput.sendKeys(item);
		SearchBtn.click();
	}
    
    public Boolean isToastForInvalidEmail() {
    	if(toastForInvalidEmail.isDisplayed()) return true;
    	return false;
    }
    
    public void clearSearchInput() {
    	SearchInput.clear();
    }
    
    public void newCustomerContinueBtn() {

    	await.until(ExpectedConditions.elementToBeClickable(NewCustomerContinueBtn)).click();
    }

    public String newCustomerHeading() {
    	
     return await.until(ExpectedConditions.elementToBeClickable(newCustomerHeading)).getText();
    }
    
    public void usingTabKeyToReachLoginFieldandPassValues(){

		Actions act = new Actions(driver);
    	
         //		Reach to login field
           for(int i=1;i<=23;i++) {
       		        act.sendKeys(Keys.TAB).build().perform();
       		  }
       
           act.sendKeys("ashitosh1@gmail.com").pause(Duration.ofSeconds(1))
           .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
           .sendKeys("12345").pause(Duration.ofSeconds(1))
           .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
           .sendKeys(Keys.ENTER).build().perform();
	
	
	
    }

}
