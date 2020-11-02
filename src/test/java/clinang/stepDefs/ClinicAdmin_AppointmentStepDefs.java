package clinang.stepDefs;

import java.io.IOException;
import java.text.ParseException;

import clinang.pageUtils.ClinicAdmin_AppointmentPageUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_AppointmentStepDefs {
	
	ClinicAdmin_AppointmentPageUtils C_admin_appointmentPageUtils = new ClinicAdmin_AppointmentPageUtils();
	
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
	}
	@Then("^Validate and download the medical report details on appointment module$")
	public void validate_medicalReport_details() throws IOException, ParseException, InterruptedException {
		C_admin_appointmentPageUtils.validate_medicalReport();
	}
}