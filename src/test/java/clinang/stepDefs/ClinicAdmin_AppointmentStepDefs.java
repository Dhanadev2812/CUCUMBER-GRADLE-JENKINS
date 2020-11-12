package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import clinang.pageUtils.ClinicAdmin_AppointmentPageUtils;
import clinang.pageUtils.ClinicAdmin_DashboardPageUtils;
import clinang.pageUtils.Patient_AppointmentPageUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_AppointmentStepDefs {
	
	ClinicAdmin_AppointmentPageUtils C_admin_appointmentPageUtils = new ClinicAdmin_AppointmentPageUtils();
	Patient_AppointmentPageUtils Patient_Appointment = new Patient_AppointmentPageUtils();
	ClinicAdmin_DashboardPageUtils C_Admin_DashboardPageUtils = new ClinicAdmin_DashboardPageUtils();
	private String todayCount;
	private String upcomingCount;
	private String[] totalTodayappointment;
	private String[] totalUpcomingappointment;
	
	@And("^Click on appointment module$")
	public void click_appointmentModule() {
		C_admin_appointmentPageUtils.click_appointmentModule();
	}
	@When("^Get the details from \"([^\"]*)\"$")
	public void get_appointment_details(String patient_details_file) throws IOException {
		C_admin_appointmentPageUtils.get_patientFile(patient_details_file);	
	}
	@Then("^Validate the appointment details$")
	public void validate_appointmentDetails() throws IOException, ParseException, InterruptedException {
		C_admin_appointmentPageUtils.validate_appointmentDetails();
		System.out.println("Appointment details validated");
	}
	@Then("^Validate and download the medical report details on appointment module$")
	public void validate_medicalReport_details() throws IOException, ParseException, InterruptedException {
		C_admin_appointmentPageUtils.validate_medicalReport();
		System.out.println("Validated medical report details on appointment module");
		System.out.println("Downloaded medical report details on appointment module");
	}
	@Then("^Check the total appointment count with dashboard$")
	public void check_total_appointment_count() {
		Patient_Appointment.Click_appointmentList_today();
		C_admin_appointmentPageUtils.wait_pageLoad_complate();
		
		if(Patient_Appointment.appointment_tbody().getText().isEmpty()==true) {
			System.out.println("No record found on today appointment list");
			todayCount = "0";
			this.totalTodayappointment = new String[] {todayCount};
		}
		else {
			todayCount = C_admin_appointmentPageUtils.get_totalAppointmentcount();
			this.totalTodayappointment = new String[] {todayCount};
		}
		
		Patient_Appointment.Click_appointmentList_upcoming();
		C_admin_appointmentPageUtils.wait_pageLoad_complate();
		
		if(Patient_Appointment.appointment_tbody().getText().isEmpty()==true) {
			System.out.println("No record found on upcoming appointment list");
			upcomingCount = "0";	
			this.totalUpcomingappointment = new String[] {upcomingCount};
		}
		else {
			upcomingCount = C_admin_appointmentPageUtils.get_totalAppointmentcount();
			this.totalUpcomingappointment = new String[] {upcomingCount};
		}
		C_Admin_DashboardPageUtils.dashboardModule().click();
		C_Admin_DashboardPageUtils.wait_dashboard_calender();
		C_admin_appointmentPageUtils.wait_pageLoad_complate();
		C_Admin_DashboardPageUtils.get_dashboardCount();
		assertTrue(Arrays.asList(C_Admin_DashboardPageUtils.dashboard_counts[0]).equals(Arrays.asList(totalTodayappointment)));
		System.out.println("Validated today appointment count");
		assertTrue(Arrays.asList(C_Admin_DashboardPageUtils.dashboard_counts[2]).equals(Arrays.asList(totalUpcomingappointment)));
		System.out.println("Validated upcominig appointment count");	
	}
}