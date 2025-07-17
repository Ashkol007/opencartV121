package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Basepage {



	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(name = "email") WebElement Inpemail;
    @FindBy(xpath="//input[@id='input-password']") WebElement Inppassword;
    @FindBy(xpath="//input[@value='Login']") WebElement Btnlogin;
    
    
    public void sendEmail(String email) {
    	Inpemail.sendKeys(email);
    }
    
    public void sendPwd(String pwd) {
    	Inppassword.sendKeys(pwd);
    }
    
    public void clickLogin() {
         Btnlogin.click();	
    }



	
	
	
	

}
