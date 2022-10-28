package pages.calculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class CalculatorObject {

	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	WebDriver driver;
	CommonActions commonActions;

	public CalculatorObject(WebDriver driver) {
		this.driver = driver;
		commonActions = new CommonActions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.google.android.calculator:id/op_add")
	WebElement addition;
	@FindBy(id = "com.google.android.calculator:id/eq")
	WebElement equal;
	@FindBy(id = "com.google.android.calculator:id/result_final")
	WebElement result;

	public void addition(int a, int b) {
		if (a > 9 || b > 9 || a < 0 || b < 0) {

		} else {
			WebElement firstDigit = driver.findElement(By.id("com.google.android.calculator:id/digit_" + a));
			commonActions.click(firstDigit);
			commonActions.click(addition);
			WebElement secondDigit = driver.findElement(By.id("com.google.android.calculator:id/digit_" + b));
			commonActions.click(secondDigit);
			commonActions.click(equal);
			logger.log(Level.INFO, result.getText());
		}
	}

	public void multiAddition(int... a) {
		for (int i : a) {
			WebElement firstDigit = driver.findElement(By.id("com.google.android.calculator:id/digit_" + i));
			commonActions.click(firstDigit);
			commonActions.click(addition);
			commonActions.click(equal);
			logger.log(Level.INFO, result.getText());
		}
	}

}
