package clinang.stepDefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

import clinang.pageUtils.ClinicAdmin_DashboardPageUtils;
import clinang.pageUtils.ClinicAdmin_LoginPageUtils;
import clinang.pageUtils.ClinicAdmin_PatientPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_PatientStepDefs {
	ClinicAdmin_PatientPageUtils C_Admin_patientpageUtils = new ClinicAdmin_PatientPageUtils();
	ClinicAdmin_DashboardPageUtils C_Admin_DashboardPageUtils = new ClinicAdmin_DashboardPageUtils();
	
	@And("^Click on patient module$")
	public void moveTo_patientModule() {
		C_Admin_patientpageUtils.click_patientModule();
	}
	
	@And("^Click on create patient button$")
	public void create_patient() {
		C_Admin_patientpageUtils.wait_pageLoad_complate();
		C_Admin_patientpageUtils.click_createPatient();
	}
	
	@When("^Enter the new patient details$")
	public void enter_patientDetails(DataTable inputs) {
		C_Admin_patientpageUtils.passPatientdetails(inputs);
	}
	
	@Then("^Check the register button is in enable state$")
	public void check_register_button_enable() {
		assertTrue(C_Admin_patientpageUtils.register().isEnabled());
	}
	@And("^Click on register option$")
	public void click_register() {
		C_Admin_patientpageUtils.click_register();
	}
	@Then("^Check the validation message for new patient creation$")
	public void check_validation_patient_create() {
		assertTrue(C_Admin_patientpageUtils.messageBox().getText().replace(" ", "").equalsIgnoreCase(("Patient mapped to clinic successfully.").replace(" ", "")));
		System.out.println("Patient mapped to clinic successfully.");
		C_Admin_patientpageUtils.click_close_messageBox();
	}
	@When("^Skip the mandatory inputs$")
	public void skip_mandatory_inputs() {
		C_Admin_patientpageUtils.skipMandatoryinputs();
	}
	@Then("^Check the register button is in disable state$")
	public void check_register_button_disable() {
		assertFalse(C_Admin_patientpageUtils.register().isEnabled());
		System.out.println("Register button is in disable state");
	}
	@Then("^Check the validation message for patient mandatory fields$")
	public void check_validation_patient_mandatory() {
		assertTrue(C_Admin_patientpageUtils.firstName_alert().getText().replace(" ", "").equalsIgnoreCase(("First Name is Required").replace(" ", "")));
		System.out.println("First Name is Required");
		assertTrue(C_Admin_patientpageUtils.lastName_alert().getText().replace(" ", "").equalsIgnoreCase(("Last Name is Required").replace(" ", "")));
		System.out.println("Last Name is Required");
		assertTrue(C_Admin_patientpageUtils.email_alert().getText().replace(" ", "").equalsIgnoreCase(("Email is Required").replace(" ", "")));
		System.out.println("Email is Required");
		assertTrue(C_Admin_patientpageUtils.password_alert().getText().replace(" ", "").equalsIgnoreCase(("Password is Required").replace(" ", "")));
		System.out.println("Password is Required");
		C_Admin_patientpageUtils.close_popUp().click();
	}
	@When("^Enter invalid inputs$")
	public void enter_invalid_inputs(DataTable inputs) {
		C_Admin_patientpageUtils.passInvalidpatientDetails(inputs);
	}
	
	@Then("^Check the validation message for invalid patient details$")
	public void check_validation_invalidInput() {
		assertTrue(C_Admin_patientpageUtils.firstName_alert().getText().replace(" ", "").equalsIgnoreCase(("First Name should be in alphabets & not allowed space").replace(" ", "")));
		System.out.println("First Name should be in alphabets & not allowed space");
		assertTrue(C_Admin_patientpageUtils.lastName_alert().getText().replace(" ", "").equalsIgnoreCase(("Last Name should be in alphabets & not allowed space").replace(" ", "")));
		System.out.println("Last Name should be in alphabets & not allowed space");
		assertTrue(C_Admin_patientpageUtils.email_alert().getText().replace(" ", "").equalsIgnoreCase(("Enter a valid Email").replace(" ", "")));
		System.out.println("Enter a valid Email");
		assertTrue(C_Admin_patientpageUtils.password_alert().getText().replace(" ", "").equalsIgnoreCase(("Password must have atleast 6 characters with a mix of special character, digit, uppercase and lowercase").replace(" ", "")));
		System.out.println("Password must have atleast 6 characters with a mix of special character, digit, uppercase and lowercase");
		C_Admin_patientpageUtils.close_popUp().click();
	}
	
	@When("^get the patient details from \"([^\"]*)\"$")
	public void get_patient_details(String patient_details_file) throws IOException {
		C_Admin_patientpageUtils.get_patientFile(patient_details_file);	
	}
	@Then("^Verify patient personal details$")
	public void validate_patient_personalDetails() throws IOException {
		C_Admin_patientpageUtils.verify_tableIsempty();
		C_Admin_patientpageUtils.validate_patient_personalDetails();
	}
	@Then("^Verify medical history details$")
	public void verify_medicalHistory_details() throws IOException  {
		C_Admin_patientpageUtils.verify_tableIsempty();
		C_Admin_patientpageUtils.validateMedicalhistory();
	}
	@Then("^Verify the appointment details on patient module$")
	public void verify_appointment_patientModule() throws IOException, ParseException, InterruptedException {
		C_Admin_patientpageUtils.validate_appointmentDetails();
	}
	@Then("^Verify the medical report details$")
	public void verify_medicalReport_details() throws IOException, ParseException, InterruptedException {
		C_Admin_patientpageUtils.verify_tableIsempty();
		C_Admin_patientpageUtils.validate_medicalReport();
	}
	@Then("^Verify the medical treatment details$")
	public void verify_medicalTreatment_details() throws IOException, ParseException, InterruptedException {
		C_Admin_patientpageUtils.verify_tableIsempty();
		C_Admin_patientpageUtils.validate_Medicaltreatment();
	}
	@Then("^Check the total patient count with dashboard$")
	public void Check_patientCount_dashboard() throws InterruptedException {
		if(C_Admin_patientpageUtils.patient_tbody().getText().isEmpty()==true) {
			System.out.println("No record found");
			String[] patientCount =new String[] {"0"};
			C_Admin_DashboardPageUtils.dashboardModule().click();
			C_Admin_DashboardPageUtils.wait_dashboard_calender();
			C_Admin_patientpageUtils.wait_pageLoad_complate();
			C_Admin_DashboardPageUtils.get_dashboardCount();
			assertTrue(Arrays.asList(C_Admin_DashboardPageUtils.dashboard_counts[1]).equals(Arrays.asList(patientCount[0])));
		}
		else {
			C_Admin_patientpageUtils.wait_pageLoad_complate();
			C_Admin_patientpageUtils.wait_patientTable();
			C_Admin_patientpageUtils.get_totalPatientcount();
			C_Admin_DashboardPageUtils.dashboardModule().click();
			C_Admin_DashboardPageUtils.wait_dashboard_calender();
			C_Admin_patientpageUtils.wait_pageLoad_complate();
			C_Admin_DashboardPageUtils.get_dashboardCount();
			assertTrue(Arrays.asList(C_Admin_DashboardPageUtils.dashboard_counts[1]).equals(Arrays.asList(C_Admin_patientpageUtils.patient_totalCount)));
			}
		}
	@Then("^Verify if the table is empty$")
	public void verify_table_empty() {
		C_Admin_patientpageUtils.wait_pageLoad_complate();
		C_Admin_patientpageUtils.verify_tableIsempty();
	}
}