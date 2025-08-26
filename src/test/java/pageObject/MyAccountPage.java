package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends Basepage {
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}    
	     
	
        @FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Heading_MyAcc;
      
        @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement MyAcc_Logout;
        @FindBy(xpath="//a[normalize-space()='Continue']") WebElement Continue_Logout;
        @FindBy(xpath="//span[@class='caret']") WebElement MyProfile;
        @FindBy(xpath="//a[normalize-space()='Subscribe / unsubscribe to newsletter']") WebElement NewsLetter_SubscribeOrUnsubscribe_Link;
        @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement NewsLetter_SubscribeSuccess_Message;
        
        @FindBy(xpath="//ul[@class='list-unstyled']//li//a[normalize-space()='Edit your account information']") WebElement Edit_Your_Account_Info;
        
        
        public boolean MyAccountHeading() {
        	
        	if(Heading_MyAcc.getText().equals("My Account")) {
        		
        		return true;
        	}
        	
			return false;
        	
        }
        
        
        public void MyAccountProfile() {
        	await.until(ExpectedConditions.elementToBeSelected(MyProfile));
        	MyProfile.click();
        	
        }
        
        
        public void MyAccountLogout() {
        	await.until(ExpectedConditions.elementToBeClickable(MyAcc_Logout));
        	MyAcc_Logout.click();
        }
        
        public void ContinueLogout() {

        	await.until(ExpectedConditions.elementToBeClickable(Continue_Logout));
        	Continue_Logout.click();
        }
        
        public void newsletterSubscribeOrUnsubscribe() {

        	await.until(ExpectedConditions.elementToBeClickable(NewsLetter_SubscribeOrUnsubscribe_Link));
        	NewsLetter_SubscribeOrUnsubscribe_Link.click();
        }
        
        public Boolean isNewsSubscribeSuccessMsg() {

        	await.until(ExpectedConditions.elementToBeClickable(NewsLetter_SubscribeSuccess_Message));
        	if(NewsLetter_SubscribeSuccess_Message.isDisplayed()) return true;
        			return false;
        }
        
        public void editYourAccountInfoTab() {
        	

        	await.until(ExpectedConditions.elementToBeClickable(Edit_Your_Account_Info)).click();
        	
        	
        }
        

        
       
        
        
        
	

}
