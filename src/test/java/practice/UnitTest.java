package practice;

import static utils.IConstant.*;

import java.io.File;

import org.testng.annotations.Test;

import utils.ReadProperties;

public class UnitTest {

	@Test
	public void testAppCapabilities() {
		ReadProperties app_caps = new ReadProperties(APP_CAPS);
		File file = new File(app_caps.getKey(APP));
		
		System.out.println(file.exists());
	}
}
