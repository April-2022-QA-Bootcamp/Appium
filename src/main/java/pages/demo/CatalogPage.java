package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.iOSBy;

public class CatalogPage {
	
	CommonActions actions;
	public CatalogPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Bike Light']")
	@iOSBy(xpath = "//XCUIElementTypeStaticText[@Value='Sauce Lab Bike Light']")
	public WebElement bikeLight;
	
	public void clickBikeLight() {
		actions.click(bikeLight);
	}
}
