package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.iOSBy;

public class ItemPage {

	CommonActions actions;
	public ItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Add To Cart button']")
	@iOSBy(xpath = "//XCUIElementTypeButton[@Name='AddToCart']")
	public WebElement addToCart;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']")
	@iOSBy(xpath = "//XCUIElementTypeButton[@Name='Cart-tab-item']")
	public WebElement cart;
	
	public void clickAddToCart() {
		actions.click(addToCart);
	}
	
	public void clickCart() {
		actions.click(cart);
	}
}
