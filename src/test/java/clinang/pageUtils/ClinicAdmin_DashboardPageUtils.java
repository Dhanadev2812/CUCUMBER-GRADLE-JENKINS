package clinang.pageUtils;

import clinang.Locators.ClinicAdmin_DashboardLocators;
import clinang.webDriverUtils.CustomDriver;

public class ClinicAdmin_DashboardPageUtils extends CustomDriver {
	
	ClinicAdmin_DashboardLocators C_Admin_dashboard_Locators = new ClinicAdmin_DashboardLocators();
	
	public void wait_dashboard_calender() {
		
		waitForElementPresent(C_Admin_dashboard_Locators.dashboard_calender);
	}
}