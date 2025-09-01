package pageObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import utilities.HelperFunctions;

public class AccountRegistrationPage extends Basepage {
	

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
//		 TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-home']") @CacheLookup private WebElement homeIcon;
    @FindBy(xpath="//h1[normalize-space()='Register Account']")WebElement RegisterAccount_Heading; 
    
	@FindBy(xpath="//input[@id='input-firstname']") WebElement InpFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement InpLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement InpEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement InpTelephone;
    @FindBy(xpath="//input[@id='input-password']") WebElement InpPassword;
    @FindBy(xpath="//input[@id='input-confirm']") WebElement InpConfirmPwd;
    
    @FindBy(xpath="//label[normalize-space()='Yes']") WebElement RadYes;
	@FindBy(xpath="//label[normalize-space()='No']")  WebElement RadNo;
    @FindBy(xpath="//input[@name='agree']") WebElement CheckBoxAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement BtnContinue;
	
	@FindBy(xpath="//div[@class='text-danger' and contains(text(),'First Name')]") WebElement RequiredFieldFirstName;
    @FindBy(xpath="//div[@class='text-danger' and contains(text(),'Last Name')]") WebElement RequiredFieldLastName;
    @FindBy(xpath="//div[contains(@class,'alert')]") WebElement WarningMsg;
    
    @FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]") WebElement EmailValidationTxt;
    
    @FindBy(xpath = "//div[@class='text-danger' and contains(text(),'First Name')]")
    private WebElement firstNameWarningMsg;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastNameWarningMsg;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    private WebElement telephoneWarningMsg;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    private WebElement passwordWarningMsg;

    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible' and text()='Warning: You must agree to the Privacy Policy!']")
    private WebElement privacyPolicyWarningMsg;

    

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement SuccessTxt;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement SuccessContinue;
	@FindBy(xpath="//div[@id='content']") WebElement AccountSuccessContent;
    @FindBy(xpath="//input[@name='confirm']/following-sibling::div") WebElement ConfirmPwdWarningMsg;	
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") @CacheLookup private WebElement warningEMailAlreadyRegister;
    @FindBy(xpath="//form[@class='form-horizontal']") WebElement AccountRegisterationForm;
    

@FindBy(xpath="//label[normalize-space()='First Name']") WebElement LabelFirstName;
@FindBy(xpath="//label[normalize-space()='Last Name']") WebElement LabelLastName;
@FindBy(xpath="//label[normalize-space()='E-Mail']")  WebElement LabelEmail;
@FindBy(xpath="//label[normalize-space()='Telephone']") WebElement LabelTelephone;
@FindBy(xpath="//label[normalize-space()='Password']") WebElement LabelPwd;
@FindBy(xpath="//label[normalize-space()='Password Confirm']") WebElement ConfirmPwd;

   //All links on the Reigster Page

@FindBy(xpath="//a[normalize-space()='login page']") @CacheLookup private WebElement loginPageLink;
@FindBy(xpath="//b[normalize-space()='Privacy Policy']") @CacheLookup private WebElement privacyPolicylink;
@FindBy(xpath="//a[normalize-space()='Forgotten Password']") @CacheLookup private WebElement forgottenPasswordlink;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='My Account']") @CacheLookup private WebElement myAccountlink;
@FindBy(xpath="//a[normalize-space()='Address Book']") @CacheLookup private WebElement addressBooklink;

@FindBy(xpath="//button[normalize-space()='×']") private WebElement PrivacyPolicyCloseBtn;
@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Register']") @CacheLookup private WebElement registerBreadCrumb;

	
	
	public Boolean isRegisterAccountPage() {
		
		if(RegisterAccount_Heading.isDisplayed()) return true;
		return false;
	}
	
	public String getRegisterAccountHeading() {
		
		return RegisterAccount_Heading.getText();
	}
	
	public void setFirstname(String firstname){
		
		InpFirstName.sendKeys(firstname);
		
    }
	
	public void clearFirstName() {
		InpFirstName.clear();
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
	
	public String getPwdTypeAttribute() {
		return  InpPassword.getAttribute("type");
	}
	
	public void setConfirmPwd(String confirmpwd) {
      InpConfirmPwd.sendKeys(confirmpwd);
		
	}
	
	public String getConfirmPwdTypeAttribute() {
		return  InpConfirmPwd.getAttribute("type");
	}
	
	public void setPrivacyPolicy() {
		CheckBoxAgree.click(); 
	}
	
	public Boolean isPrivacyCheckBox_Selected() {
		
		if(CheckBoxAgree.isSelected()) return true;
		return false;
		
	}
	
	public String uncheckedPrivacyPolicyWarningMsg() {
		return privacyPolicyWarningMsg.getText();
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
	
	
	public String emailValidation() {
		   
		return EmailValidationTxt.getText();
		
	}
	
	public String getEmailToolTipWarningMsg() {
		
		return InpEmail.getAttribute("validationMessage");
	}
	
	public Boolean accountSuccessContent(String expectedText) {
		
		String actualText =  AccountSuccessContent.getText();
		
		if(actualText.contains(expectedText)) return true;
	
		return false;
	}
	
	
	public String firstNameValidation() {
		 return firstNameWarningMsg.getText();
	}
	
	public Boolean firstNameWarningDisplayed() {
		return firstNameWarningMsg.isDisplayed();
	}
	
	public String larstNameValidation() {
		return lastNameWarningMsg.getText();
		
	}
	
	public String telephoneValidation() {
	  
		return telephoneWarningMsg.getText();
		
	}
	
	public String paswordValidation() {
		return passwordWarningMsg.getText();
		
	}

	public void selectYesForNewsletterSubscribe() {
		await.until(ExpectedConditions.elementToBeClickable(RadYes));
		RadYes.click();
	}
	
	public void selectNoForNewsletterSubscribe() {
		await.until(ExpectedConditions.elementToBeClickable(RadNo));
		RadNo.click();
	}
	
	 public void homeIcon() {

     	await.until(ExpectedConditions.elementToBeClickable(homeIcon));
     	
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	 js.executeScript("arguments[0].click()", homeIcon);
     	               
     }
	 
	 public String confirmPwdWarningMsg() {
		 

	     	await.until(ExpectedConditions.elementToBeClickable(ConfirmPwdWarningMsg));
	     	
	     	if(ConfirmPwdWarningMsg.isDisplayed()) {
	     	   return ConfirmPwdWarningMsg.getText(); 	
	     	}
	     	
	     	return "Confirm Password Warning message is not displayed! ";
		 
	 }
	 
	 
	 public String warningForPreviouslyRegisterdAccount() {
		 

	     	await.until(ExpectedConditions.elementToBeClickable(AccountRegisterationForm));
	     	return warningEMailAlreadyRegister.getText();
		 
	 }
	
	 public Boolean getScreenShotOfRegistrationForm() throws IOException {

	     	await.until(ExpectedConditions.elementToBeClickable(AccountRegisterationForm));
		 
		       File screenShot1 = AccountRegisterationForm.getScreenshotAs(OutputType.FILE);
		       

		       String fileName = "sc1Actual_" + System.currentTimeMillis() + ".png";
		       File destination = new File(System.getProperty("user.dir") + "\\screenShots\\" + fileName);

		       FileHandler.copy(screenShot1, destination); 
		       
			    BufferedImage actualBimg = ImageIO.read(new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName));

			    BufferedImage expectedBimg = ImageIO.read(new File(System.getProperty("user.dir")+"\\screenshots\\sc1Expected.png"));
				
			    ImageComparison imageComparison = new ImageComparison(expectedBimg, actualBimg);
		        ImageComparisonResult result = imageComparison.compareImages();
		        

		        BufferedImage resultImage = result.getResult();

			       String dfileName = "sc1Difference" + System.currentTimeMillis() + ".png";
		        ImageIO.write(resultImage, "png",
		                new File(System.getProperty("user.dir") + "\\screenshots\\" + dfileName));
		        
		        if(result.getDifferencePercent() > 0) {
		        	return true;
		        }
		        
		        return false;
		        
		       
	 }
	 
	 
	 public void registerUsingtheKeyboardKeys() {
		 
		 Actions act = new Actions(driver);
		 
		 HelperFunctions hf = new HelperFunctions();
		 
		 for(int i=0;i<23;i++) {

			  act.sendKeys(Keys.TAB).perform();
		 }
		 
		 act.sendKeys("Ashitosh").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys("Kole").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys(hf.nameGenerator(5)+"@gmail.com").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys("9309803610").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys("pwd9309803610").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys("pwd9309803610").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 .sendKeys(Keys.SPACE)
		 .pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
		 .build().perform();
		 
		 
		  
		 
	 }
	 
	// First Name
	 public String getFirstNamePlaceholder() {
	     return InpFirstName.getAttribute("placeholder");
	 }

	 // Last Name
	 public String getLastNamePlaceholder() {
	     return InpLastName.getAttribute("placeholder");
	 }

	 // Email
	 public String getEmailPlaceholder() {
	     return InpEmail.getAttribute("placeholder");
	 }

	 // Telephone
	 public String getTelephonePlaceholder() {
	     return InpTelephone.getAttribute("placeholder");
	 }

	 // Password
	 public String getPasswordPlaceholder() {
	     return InpPassword.getAttribute("placeholder");
	 }

	 // Confirm Password
	 public String getConfirmPasswordPlaceholder() {
	     return InpConfirmPwd.getAttribute("placeholder");
	 }
	 
	 
	 public String getLabelBeforeContent(WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    return (String) js.executeScript(
		        "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", 
		        element
		    );
		}
	 
	 
	 public String checkForAstreixFirstNameText() {
		 
		 await.until(ExpectedConditions.visibilityOf(LabelFirstName));
		 
		 String beforeAstreix = getLabelBeforeContent(LabelFirstName);
		        
		 
		 return beforeAstreix;
	 }
	 
	 
	 public String[] getHeightOfElement(WebElement element) {
		 
		 String height = element.getCssValue("height");
		 
		 JavascriptExecutor Js = (JavascriptExecutor) driver;
		 
		 
		 String width = (String) Js.executeScript("return window.getComputedStyle(arguments[0], null).getPropertyValue('width');", element);
		 
		return new String[] {height,width};
		 
	}
	 
	
	 
	 public String[] getHAndWforFirstName() {
		 
		   return getHeightOfElement(InpFirstName);
		 
	 }
	 
	 
	 public void loginPageLink() {
	        await.until(ExpectedConditions.elementToBeClickable(loginPageLink)).click();
	    }

	    public void privacyPolicyLink() {
	        await.until(ExpectedConditions.elementToBeClickable(privacyPolicylink)).click();
	    }

	    public void forgottenPasswordLink() {
	        await.until(ExpectedConditions.elementToBeClickable(forgottenPasswordlink)).click();
	    }

	    public void myAccountLink() {
	        await.until(ExpectedConditions.elementToBeClickable(myAccountlink)).click();
	    }

	    public void addressBookLink() {
	        await.until(ExpectedConditions.elementToBeClickable(addressBooklink)).click();
	    }
	    
	    public Boolean isprivacyPolicyPopCloseBtn() {

	    	await.until(ExpectedConditions.elementToBeClickable(PrivacyPolicyCloseBtn));
	    	
	    	if(PrivacyPolicyCloseBtn.isDisplayed()) return true;
	    	return false;
	    }
	    
	    public void privacyPopUpClose() {
	    	
	    	await.until(ExpectedConditions.elementToBeClickable(PrivacyPolicyCloseBtn)).click();
		    
	    }
	    
	    public String registerBreadCrumb() {
	    	

	    	return await.until(ExpectedConditions.elementToBeClickable(registerBreadCrumb)).getText();
	    	
	    }
	 
	 


	

}
