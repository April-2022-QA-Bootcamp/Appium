package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AppiumTest {

	@Test(enabled = false)
	public void simpleAppiumTestWithBrowser() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platrformVersion", "12");
		//----------------------Alternative-----------------
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setVersion("12");
		capabilities.setBrowserName("Chrome");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, capabilities);
		driver.get("https://www.amazon.com/");
	}
	
	@Test
	public void appiumTestWithInstalledApp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setVersion("12");
		//App Activity, App package
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, capabilities);
		WebElement element = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		element.click();
		element = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		element.click();
		element = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		element.click();
		element = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		element.click();
		element = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		System.out.println(element.getText());
	}
}
