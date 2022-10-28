package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerTest {

	@Test(enabled = false)
	public void startServer() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 4723);
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File(
				"C:\\Users\\mdnas\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
		builder.withIPAddress("127.0.0.1");
		builder.usingAnyFreePort();
		builder.withCapabilities(capabilities);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);

		service.start();
		System.out.println(service.getUrl().toString());
		service.stop();
	}

	private static AppiumDriverLocalService appiumService;
	private static AppiumServiceBuilder builder;

	@Test(enabled = false)
	public void startAppiumServer() {
		builder = new AppiumServiceBuilder().usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		appiumService = builder.build();
		appiumService.start();
	}
	
	@Test
	public void runCmd() throws IOException, InterruptedException {
		//Runtime.getRuntime().exec("cmd.exe /C start cmd.exe /K \"appium -a 0.0.0.0 -p 4723 --relaxed-security\"");
		Runtime.getRuntime().exec("cmd.exe /C start cmd.exe /K \"java -version\"");
		Thread.sleep(5000);
		//String command1 = "taskkill /F /IM node.exe";
		//Runtime.getRuntime().exec(command1);
		String command = "taskkill /F /IM cmd.exe";
		Runtime.getRuntime().exec(command);
	}
}
