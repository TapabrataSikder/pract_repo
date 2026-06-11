package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PhpPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public PhpPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By popup = By.xpath("//button[text()='I Understand & Continue']");
	By signUpDd = By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/button/span[2]");
	By custSignup = By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/div[2]/div/a[1]/span[2]");

	
	
	public void clickSignup() {
		wait.until(ExpectedConditions.elementToBeClickable(popup)).click();
		WebElement sign = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpDd));
		Actions actions = new Actions(driver);
		actions.moveToElement(sign).perform();
		wait.until(ExpectedConditions.elementToBeClickable(custSignup)).click();
	}
	
	By fname= By.id("first_name");
	By lname = By.id("last_name");
	By email = By.id("email");
	By pwd = By.id("password");
	By cnfpwd = By.id("confirm_password");
	By captcha = By.id("captcha_answer");
	
//	By chkbox = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[6]/div/div/div/span");
	By chkbox = By.className("checkbox-custom");
	By continueBtn = By.cssSelector(".btn.emerald.w-full");

	public void register(String f, String l, String e, String p)
	{
		wait.until(ExpectedConditions.elementToBeClickable(fname)).sendKeys(f);
		driver.findElement(lname).sendKeys(l);
		driver.findElement(email).sendKeys(e);
		driver.findElement(pwd).sendKeys(p);	
		driver.findElement(cnfpwd).sendKeys(p);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(captcha));
//		
//		wait.until(ExpectedConditions.elementToBeClickable(chkbox)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	}
	
	public void submitRegistration() {
		WebElement checkboxElement = wait.until(ExpectedConditions.presenceOfElementLocated(chkbox));
	    
	    // Use Javascript to click the checkbox, bypassing UI overlays
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", checkboxElement);
	    
	    // Click the continue button
	    wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	}

	
	
	
}
