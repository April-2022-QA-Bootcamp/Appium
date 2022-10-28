package app.installing.demo;

import org.testng.annotations.Test;

import base.BaseClass;

public class TestDemoApp extends BaseClass{

	@Test
	public void demoAppLaunch() {
		catalogPage.clickBikeLight();
		itemPage.clickAddToCart();
		itemPage.clickCart();
		checkoutPage.clickProceedToCheckout();
		loginPage.inputUserName("Agent009");
		loginPage.inputPassword("superMan");
		loginPage.clickLogin();
		loginPage.assertEqualErrorMsg("Provided credentials do not match any user in this service.");
	
	}
}
