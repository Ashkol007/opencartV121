package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.WaitHelper;

public class TC0011_MobileViewTestcase extends BaseClass {
	
	    @Test(groups={"Master"})
	    public void testMobileLayout() {
	        // Home Page
	        driver.manage().window().setSize(new Dimension(375, 812));
        
	        
	        WebElement menuToggle = driver.findElement(By.cssSelector(".fa.fa-bars"));
	        Assert.assertTrue(menuToggle.isDisplayed(), "Mobile menu toggle should be visible on homepage");
            menuToggle.click();
	        // Product Page
	        driver.findElement(By.xpath("//a[normalize-space()='Desktops']")).click();
	        driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']")).click();
	        WebElement productTitle = driver.findElement(By.xpath("//h2[normalize-space()='Mac']"));
	        Assert.assertTrue(productTitle.isDisplayed(), "Product title should be visible on mobile product page");

	        // Cart Page
	        ;
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click", driver.findElement(By.xpath("(//button[@type='button'])[11]")));
	        
	        WebElement cartDropdown = driver.findElement(By.cssSelector("#cart-total"));
	        WaitHelper await = new WaitHelper(driver);
	        await.waitForElementClickable(By.cssSelector("#cart-total"), 10);
	        Assert.assertTrue(cartDropdown.isDisplayed(), "Cart dropdown should be visible on mobile");
	    }

		
	
	
	

}
