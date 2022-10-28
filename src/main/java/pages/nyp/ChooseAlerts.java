package pages.nyp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class ChooseAlerts {

	CommonActions commonActions;
	
	public ChooseAlerts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.Switch")
	WebElement sportsTogglElement;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.Switch")
	WebElement newYorkMetroTogglElement;
	
	@FindBy(id = "br.com.golmobile.nypost:id/continue_customize")
	WebElement continuElement;
	
	public void chooseAlertsSteps() {
		commonActions.click(sportsTogglElement);
		commonActions.click(newYorkMetroTogglElement);
		commonActions.click(continuElement);
	}
}
