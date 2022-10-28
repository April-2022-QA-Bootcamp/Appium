package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.iOSBy;

public class CheckoutPage {

	CommonActions actions;
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Proceed To Checkout button']")
	@iOSBy(xpath = "//XCUIElementTypeButton[@Name='ProceedToCheckout']")
	public WebElement proceedToCheckout;
	
	public void clickProceedToCheckout() {
		actions.click(proceedToCheckout);
	}
}
