package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	WebDriver driver;

    WebDriverWait await;


	public Basepage(WebDriver driver) {
		this.driver = driver;
		
		this.await = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

}
