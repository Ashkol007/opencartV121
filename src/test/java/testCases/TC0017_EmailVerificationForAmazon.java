package testCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.EmailVerification;

public class TC0017_EmailVerificationForAmazon {
	
	@Test()
	public void emailVerfication() {
		
		WebDriver driver;
		WebDriverWait await;
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		
//		WebElement expandBtn = driver.findElement(By.xpath("//button[@aria-label='Expand Account and Lists']"));
		WebElement signInBtn =await.until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.a-button-text span"))
				);
		WebElement emailInput = driver.findElement(By.xpath("(//input[@id='ap_email_login'])[1]"));
		WebElement signInContinueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement forgotPwdLink = driver.findElement(By.xpath("//a[normalize-space()='Forgot password?']"));
		WebElement pwdAssistEmailInp = driver.findElement(By.xpath("//input[@id='ap_email']"));
		WebElement pwdAssistContinueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		
		String email = "ashitoshkole007@gmail.com";
		String pwd = "dokc yhnr bbnd lbbb";
		
		
//		expandBtn.click();
		

		await.until(ExpectedConditions.elementToBeClickable(signInBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		  js.executeScript("arguments[0].click()", signInBtn);
		
		
		await.until(ExpectedConditions.elementToBeClickable(emailInput));
		emailInput.sendKeys("ashitoshkole007@gmail.com");

		await.until(ExpectedConditions.elementToBeClickable(signInContinueBtn));
		signInContinueBtn.click();
		

		await.until(ExpectedConditions.elementToBeClickable(forgotPwdLink));
		forgotPwdLink.click();
		

		await.until(ExpectedConditions.elementToBeClickable(pwdAssistEmailInp));
		pwdAssistEmailInp.sendKeys("ashitoshkole007@gmail.com");
		

		await.until(ExpectedConditions.elementToBeClickable(pwdAssistContinueBtn));
		pwdAssistContinueBtn.click();
		
		String host = "imap.gmail.com";
        String username = "your_email@gmail.com"; // Your Gmail address
        String appPassword = "your_app_password"; // Generated App password

//        Properties props = new Properties();
//        props.put("mail.store.protocol", "imaps");
//        props.put("mail.imaps.host", host);
//        props.put("mail.imaps.port", "993");
//        props.put("mail.imaps.ssl.enable", "true");

        EmailVerification.gmailInboxVerification();
		
	}
	

}
