package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commons.CommonActions;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.iOSBy;

public class LoginPage {

	CommonActions actions;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Username input field']")
	@iOSBy(xpath = "(//XCUIElementTypeTextField)[1]")
	public WebElement userName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Password input field']")
	@iOSBy(xpath = "(//XCUIElementTypeTextField)[2]")
	public WebElement password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Login button']")
	@iOSBy(xpath = "//XCUIElementTypeButton[@Name='Login']")
	public WebElement login;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView")
	public WebElement errorMsg;
	
	public void inputUserName(String user) {
		actions.input(userName, user);
	}
	
	public void inputPassword(String pass) {
		actions.input(password, pass);
	}
	
	public void clickLogin() {
		actions.click(login);
	}
	
	public void assertEqualErrorMsg(String expectedErrorMsg) {
		Assert.assertEquals(actions.getText(errorMsg), expectedErrorMsg);
	}
}
