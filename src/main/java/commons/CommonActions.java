package commons;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonActions {

	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	WebDriver driver;
	//WebDriverWait wait;
	
	public CommonActions(WebDriver driver) {
		this.driver = driver;
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void click(WebElement element) {
		try {
			//wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			logger.log(Level.INFO,"Element has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			logger.log(Level.INFO,"Element Not Found");
			Assert.fail();
		}
	}
	
	public void input(WebElement element, String value) {
		try {
			element.sendKeys(value);
			logger.log(Level.INFO,value +" : " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			logger.log(Level.INFO,"Element Not Found : " + element);
			Assert.fail();
		}
	}
	
	public String getText(WebElement element) {
		try {
			String text = element.getText();
			logger.log(Level.INFO,element + " : has text, " + text);
			return text;
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			logger.log(Level.INFO,"Element Not Found : " + element);
			return null;
		}
	}
}
