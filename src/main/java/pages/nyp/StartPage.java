package pages.nyp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class StartPage {

	CommonActions commonActions;
	
	public StartPage(WebDriver driver) {
		commonActions = new CommonActions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "br.com.golmobile.nypost:id/welcome_continue")
	WebElement continuElement;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.Switch")
	WebElement sportsTogglElement;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.Switch")
	WebElement newYorkMetroTogglElement;
	
	@FindBy(id = "br.com.golmobile.nypost:id/continue_customize")
	WebElement continuElement2;
	
	public void chooseAlertsSteps() {
		commonActions.click(continuElement);
		commonActions.click(sportsTogglElement);
		commonActions.click(newYorkMetroTogglElement);
		commonActions.click(continuElement2);
	}
	
	public void startPageSteps() {
		commonActions.click(continuElement);
	}
}
