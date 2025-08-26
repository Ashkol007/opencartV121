package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EditInformationPage extends Basepage {
	
	
	public EditInformationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") @CacheLookup private WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']") @CacheLookup private WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']") @CacheLookup private WebElement eMail;
	@FindBy(xpath="//input[@id='input-telephone']") @CacheLookup private WebElement telephone;

	// Method to get text from First Name field
	public String getFirstNameText() {
	    return firstName.getAttribute("value");
	}

	// Method to get text from Last Name field
	public String getLastNameText() {
	    return lastName.getAttribute("value");
	}

	// Method to get text from Email field
	public String getEmailText() {
	    return eMail.getAttribute("value");
	}

	// Method to get text from Telephone field
	public String getTelephoneText() {
	    return telephone.getAttribute("value");
	}

	
	

	
	

}
