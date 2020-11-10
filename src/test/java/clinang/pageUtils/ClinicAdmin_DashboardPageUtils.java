package clinang.pageUtils;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import clinang.Locators.ClinicAdmin_DashboardLocators;
import clinang.webDriverUtils.CustomDriver;

public class ClinicAdmin_DashboardPageUtils extends CustomDriver {
	
	ClinicAdmin_DashboardLocators C_Admin_dashboard_Locators = new ClinicAdmin_DashboardLocators();
	public String[] dashboard_counts;
	
	public WebElement dashboardModule() {
		return findElement(C_Admin_dashboard_Locators.dashboardModule);
	}
	public void wait_dashboard_calender() {	
		fluentWait(C_Admin_dashboard_Locators.dashboard_calender);
	}
	private WebElement todayAppointmentcount() {
		return findElement(C_Admin_dashboard_Locators.todayAppointmentcount);
	}
	public String get_todayAppointmentcount() {
		return todayAppointmentcount().getText();
	}
	private WebElement upcomingAppointmentcount() {
		return findElement(C_Admin_dashboard_Locators.upcomingAppointmentcount);
	}
	public String get_upcomingAppointmentcount() {
		return upcomingAppointmentcount().getText();
	}
	private WebElement totalPatient() {
		return findElement(C_Admin_dashboard_Locators.totalPatient);
	}
	public String get_totalPatient() {
		return totalPatient().getText();
	}
	public List<String> get_dashboardCount() {
		String todayAppointment_count = get_todayAppointmentcount();
		String upcomingAppointment_count = get_upcomingAppointmentcount();
		String totalPatient = get_totalPatient();
		this.dashboard_counts = new String[] {todayAppointment_count,totalPatient,upcomingAppointment_count};
		return Arrays.asList(dashboard_counts);
	}
}