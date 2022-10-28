package app.installing.nyp;

import org.testng.annotations.Test;

import base.BaseClass;

public class NYPAppTest extends BaseClass{

	@Test
	public void NYPAppLaunch() {
		//startPage.startPageSteps();
		//chooseAlerts.chooseAlertsSteps();
		startPage.chooseAlertsSteps();
	}
}
