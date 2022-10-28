package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.calculator.CalculatorObject;
import pages.demo.CatalogPage;
import pages.demo.CheckoutPage;
import pages.demo.ItemPage;
import pages.demo.LoginPage;
import pages.nyp.ChooseAlerts;
import pages.nyp.StartPage;

import static utils.IConstant.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.ReadProperties;

public class BaseClass {

	protected Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	WebDriver driver;
	ReadProperties device_caps;
	ReadProperties app_caps;
	ReadProperties browserstack;
	Runtime runtime = Runtime.getRuntime();
	
	protected CalculatorObject calculatorObject;
	protected StartPage startPage;
	protected ChooseAlerts chooseAlerts;
	
	protected CatalogPage catalogPage;
	protected CheckoutPage checkoutPage;
	protected ItemPage itemPage;
	protected LoginPage loginPage;
	
	//@BeforeSuite
	public void startServer() {
		try {
			runtime.exec("cmd.exe /C start cmd.exe /K \"appium -a 0.0.0.0 -p 4723 --relaxed-security\"");
			logger.log(Level.INFO, "Appium Server started...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp() {
		device_caps = new ReadProperties(DEVICE_CAPS);
		app_caps = new ReadProperties(APP_CAPS);
		browserstack = new ReadProperties(BROWSERSTACK);
		try {
			URL url = new URL(browserstack.getKey(URL));
			driver = new RemoteWebDriver(url, setBrowserStackCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		initClasses();
	}
	
	private DesiredCapabilities setCapabilitiesForInstalledApp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(DEVICE_NAME, device_caps.getKey(DEVICE_NAME));
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion(PLATFORM_VERSION);
		dc.setCapability(APP_PACKAGE, app_caps.getKey(APP_PACKAGE));
		dc.setCapability(APP_ACTIVITY, app_caps.getKey(APP_ACTIVITY));
		return dc;
	}
	
	private DesiredCapabilities setCapabilitiesForNotInstalledApp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(DEVICE_NAME, device_caps.getKey(DEVICE_NAME));
		dc.setPlatform(Platform.ANDROID);
		dc.setCapability(PLATFORM_VERSION, device_caps.getKey(PLATFORM_VERSION));
		dc.setCapability(APP, app_caps.getKey(APP));
		return dc;
	}
	
	private DesiredCapabilities setCapabilitiesForMobileBrowser() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(DEVICE_NAME, device_caps.getKey(DEVICE_NAME));
		dc.setPlatform(Platform.ANDROID);
		dc.setCapability(PLATFORM_VERSION, device_caps.getKey(PLATFORM_VERSION));
		dc.setBrowserName(app_caps.getKey(BROWSER));
		return dc;
	}
	
	public DesiredCapabilities setBrowserStackCapabilities() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(BS_USER, browserstack.getKey(USER));
    	caps.setCapability(BS_KEY, browserstack.getKey(PASS));
    	
    	// Set URL of the application under test
    	caps.setCapability(APP, browserstack.getKey(APP_URL));
    	
    	// Specify device and os_version for testing
    	caps.setCapability(DEVICE, device_caps.getKey(BS_DEVICE));
    	caps.setCapability(OS_VERSION, device_caps.getKey(BS_VERSION));
        
    	// Set other BrowserStack capabilities (NOT MEDATORY)
    	caps.setCapability("project", "First Java Project");
    	caps.setCapability("build", "browserstack-build-1");
    	caps.setCapability("name", "first_test");
    	return caps;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	private void initClasses() {
		calculatorObject = new CalculatorObject(driver);
		startPage = new StartPage(driver);
		chooseAlerts = new ChooseAlerts(driver);
		catalogPage = new CatalogPage(driver);
		checkoutPage = new CheckoutPage(driver);
		itemPage = new ItemPage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void closeSession() {
		driver.quit();
	}
	
	//@AfterSuite
	public void stopServer() {
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
