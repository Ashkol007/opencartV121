package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends Basepage {
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}    
	     
	
        @FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Heading_MyAcc;
        @FindBy(xpath="//a[@class='list-group-item'][contains(text(),'Logout')]") WebElement MyAcc_Logout;
        @FindBy(xpath="//a[normalize-space()='Continue']") WebElement Continue_Logout;
        
        
        public boolean MyAccountHeading() {
        	
        	if(Heading_MyAcc.getText().equals("My Account")) {
        		
        		return true;
        	}
        	
			return false;
        	
        }
        
        
        
        public void MyAccountLogout() {
        	await.until(ExpectedConditions.elementToBeClickable(MyAcc_Logout)).click();
//        	MyAcc_Logout.click();
        }
        
        public void ContinueLogout() {
        	Continue_Logout.click();
        }
        
        
	

}
