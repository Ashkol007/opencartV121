package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsLetterPage extends Basepage {

	public NewsLetterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@type='radio'][@value='1']") WebElement Subscribe_Yes_Radio;

	@FindBy(xpath="//input[@type='radio'][@value='0']") WebElement Subscribe_No_Radio;
	@FindBy(xpath="//input[@value='Continue']") WebElement Continue;
	
	
	public void selectYesForSubscribe() {
        
    	await.until(ExpectedConditions.elementToBeClickable(Subscribe_Yes_Radio));
    	Subscribe_Yes_Radio.click();
    	
    }
	
	public void continueBtnNewsLetter() {

    	await.until(ExpectedConditions.elementToBeClickable(Continue)).click();
	
	}
	
	public Boolean isSubscribeYesSelected() {
		

    	await.until(ExpectedConditions.elementToBeClickable(Subscribe_Yes_Radio));
    	
    	if(Subscribe_Yes_Radio.isSelected()) return true;
    	return false;
	}
	
	public Boolean isSubscribeNoSelected() {
		

    	await.until(ExpectedConditions.elementToBeClickable(Subscribe_No_Radio));
    	
    	if(Subscribe_No_Radio.isSelected()) return true;
    	return false;
	}
	
	
    

}
