package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends Basepage {
	

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
//		 TODO Auto-generated constructor stub
	}
	


	@FindBy(xpath="//input[@id='input-firstname']") WebElement InpFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement InpLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement InpEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement InpTelephone;
    @FindBy(xpath="//input[@id='input-password']") WebElement InpPassword;
    @FindBy(xpath="//input[@id='input-confirm']") WebElement InpConfirmPwd;
    @FindBy(xpath="//label[normalize-space()='Yes']") WebElement RadYes;
	@FindBy(xpath="//label[normalize-space()='No']")  WebElement RadNo;
    @FindBy(xpath="//input[@name='agree']") WebElement CheAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement BtnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement SuccessTxt;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement SuccessContinue;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'First Name')]") WebElement RequiredFieldFirstName;
    @FindBy(xpath="//div[@class='text-danger' and contains(text(),'Last Name')]") WebElement RequiredFieldLastName;
    @FindBy(xpath="//div[contains(@class,'alert')]") WebElement WarningMsg;
    
    @FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]") WebElement EmailValidationTxt;
	
	
	public void setFirstname(String firstname){
		
		InpFirstName.sendKeys(firstname);
		
    }
	
	public void setLastName(String lastname) {
		InpLastName.sendKeys(lastname);
		
	}
	
	public void setEmail(String email){
		InpEmail.sendKeys(email);
		
	}
	
	public void setTelephone(String telephone) {
		InpTelephone.sendKeys(telephone);
		
	}
	
	public void setPassword(String pwd) {
		InpPassword.sendKeys(pwd);
		
	}
	
	public void setConfirmPwd(String confirmpwd) {
     InpConfirmPwd.sendKeys(confirmpwd);
		
	}
	
	public void setPrivacyPolicy() {
		CheAgree.click(); 
	}
	
	public void clickContinue() { 
		BtnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return SuccessTxt.getText();
		}catch(Exception e){ 
			return (e.getMessage()); 
			}
	}
	
	public void submitSuccess() {
		SuccessContinue.click();
	}
	
	public Boolean checkValidations() {
		
		await.until(ExpectedConditions.visibilityOf(RequiredFieldFirstName));

		await.until(ExpectedConditions.visibilityOf(RequiredFieldLastName));

		await.until(ExpectedConditions.visibilityOf(WarningMsg));
		
		if(RequiredFieldFirstName.isDisplayed() && RequiredFieldLastName.isDisplayed() && WarningMsg.isDisplayed() ) {
			
			return true;
		}
		
		return false;
	}
	
	
	public Boolean emailValidation() {
		   
		if(EmailValidationTxt.isDisplayed()) {
			return true;
		}
		return false;
	}

	
	
	

}
