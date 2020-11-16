package clinang.stepDefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

import clinang.Locators.ClinicAdmin_DoctorLocator;
import clinang.pageUtils.ClinicAdmin_DoctorPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_DoctorStepDefs {
	ClinicAdmin_DoctorPageUtils C_Admin_doctorPageUtils = new ClinicAdmin_DoctorPageUtils();
	
	@And("^Go to doctor module$")
	public void goTo_doctor_module() {
		C_Admin_doctorPageUtils.click_doctorModule();
	}
	@And("^Click on create doctor$")
	public void click_createDoctor() {
		C_Admin_doctorPageUtils.wait_pageLoad_complate();
		C_Admin_doctorPageUtils.getLatestdoctorID();
		C_Admin_doctorPageUtils.click_createDoctor();
	}
	@When("^Enter doctor details$") 
	public void passDoctorDetails(DataTable inputs) throws InterruptedException, ParseException {
		C_Admin_doctorPageUtils.wait_pageLoad_complate();
		C_Admin_doctorPageUtils.passDoctordetails(inputs);
	}
	@And("^Submit the form$")
	public void submit_form() {
		C_Admin_doctorPageUtils.register().click();
	}
	@Then("^Verify the success message for doctor registration$")
	public void Verify_successMessage() {
		C_Admin_doctorPageUtils.wait_pageLoad_complate();
		assertTrue(C_Admin_doctorPageUtils.alertBox().getText().replaceAll("\\s+","").contentEquals(("Doctor created successfully.").replaceAll("\\s+","")));
		C_Admin_doctorPageUtils.close_alertBox().click();
		System.out.println("Doctor created successfully.");
	}
	@Then("^Validate the new doctor details on doctor without profile screen$")
	public void validate_newDoctor_details() {
		C_Admin_doctorPageUtils.doctorWithoutprofile_tab().click();
		C_Admin_doctorPageUtils.wait_pageLoad_complate();
		int size = C_Admin_doctorPageUtils.latestDoctor_withoutProfile.length;
	    int [] arr = new int [size];    
	    arr[0] = Integer.parseInt( C_Admin_doctorPageUtils.latestDoctor_withoutProfile[0]);
		assertTrue((Arrays.asList(arr[0]+1).toString()).contains(C_Admin_doctorPageUtils.newDoctor_latest().getText()));		
		assertTrue((C_Admin_doctorPageUtils.doctorName_input[0]).contains(C_Admin_doctorPageUtils.newDoctorname_latest().getText().replaceAll("\\s+","")));
		assertTrue(C_Admin_doctorPageUtils.newDoctorstatus_latest().getAttribute("class").contains("mat-checked"));
		System.out.println("Validated registered doctor details on doctor without profile's list");
	}
	@Then("^Validate the validation message for invalid details$")
	public void validate_validationMessage_invalidData() {
		C_Admin_doctorPageUtils.alert_overseasConsultingfees().click();
		assertTrue(C_Admin_doctorPageUtils.alert_firstName().getText().replaceAll("\\s+", "").contentEquals(("First Name should be in alphabets & not allowed space").replaceAll("\\s+", "")));
		System.out.println("First Name should be in alphabets & not allowed space");
		assertTrue(C_Admin_doctorPageUtils.alert_lastName().getText().replaceAll("\\s+", "").contentEquals(("Last Name should be in alphabets & not allowed space").replaceAll("\\s+", "")));
		System.out.println("Last Name should be in alphabets & not allowed space");
		assertTrue(C_Admin_doctorPageUtils.alert_email().getText().replaceAll("\\s+", "").contentEquals(("Enter a valid Email").replaceAll("\\s+", "")));
		System.out.println("Enter a valid Email");
		if((C_Admin_doctorPageUtils.alert_doemsticConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Consulting Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Consulting Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_doemsticConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Consulting Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Consulting Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_overseasConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Consulting Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Consulting Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_overseasConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Consulting Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Consulting Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_domesticFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Follow up Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Follow up Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_domesticFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Follow up Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Follow up Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_overseasFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Follow up Fee should be in number").replaceAll("\\s+", "")))) {
			assert true;
			System.out.println("Overseas Follow up Fee should be in number");
		}
		else if((C_Admin_doctorPageUtils.alert_overseasFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Follow up Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Follow up Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			System.out.println("Validation message is not matched");
			assert false;
		}
		assertTrue(C_Admin_doctorPageUtils.alert_password().getText().replaceAll("\\s+", "").contentEquals(("Password must have atleast 6 characters with a mix of special character, digit, uppercase and lowercase").replaceAll("\\s+", "")));
		System.out.println("Password must have atleast 6 characters with a mix of special character, digit, uppercase and lowercase");
		assertFalse(C_Admin_doctorPageUtils.register().isEnabled()==true);
		System.out.println("Register option is in disable state");
		C_Admin_doctorPageUtils.close_popUp().click();
	}
	@When("^Skip to enter the mandatory details$")
	public void skip_mandatory() {
		C_Admin_doctorPageUtils.skip_mndatory_createDoctor();
	}
	@Then("^Validate the mandatory alert message on doctor registration form$")
	public void validate_mandatory_createDoctor() {
		assertTrue(C_Admin_doctorPageUtils.alert_firstName().getText().replaceAll("\\s+", "").contentEquals(("First Name is Required").replaceAll("\\s+", ""))); 
		System.out.println("First Name is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_lastName().getText().replaceAll("\\s+", "").contentEquals(("Last Name is Required").replaceAll("\\s+", "")));
		System.out.println("Last Name is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_email().getText().replaceAll("\\s+", "").contentEquals(("Email is Required").replaceAll("\\s+", "")));
		System.out.println("Email is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_doemsticConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Consulting Fee is Required").replaceAll("\\s+", "")));
		System.out.println("Domestic Consulting Fee is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_overseasConsultingfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Consulting Fee is Required").replaceAll("\\s+", "")));
		System.out.println("Overseas Consulting Fee is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_domesticFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Domestic Follow up Fee is Required").replaceAll("\\s+", "")));
		System.out.println("Domestic Follow up Fee is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_overseasFollowupfees().getText().replaceAll("\\s+", "").contentEquals(("Overseas Follow up Fee is Required").replaceAll("\\s+", "")));
		System.out.println("Overseas Follow up Fee is Required");
		assertTrue(C_Admin_doctorPageUtils.alert_password().getText().replaceAll("\\s+", "").contentEquals(("Password is Required").replaceAll("\\s+", "")));	
		System.out.println("Password is Required");
		C_Admin_doctorPageUtils.close_popUp().click();
	}
	@When("^Get the doctor details from \"([^\"]*)\"$")
	public void get_doctor_details(String doctor_details_file) throws IOException {
		C_Admin_doctorPageUtils.get_doctorFile(doctor_details_file);	
	}
	@Then("^Verify doctor details on list page$")
	public void verify_doctor_details_listPage() throws IOException {
		C_Admin_doctorPageUtils.validate_doctor_details_listPage();
		System.out.println("Validated doctor details on doctor list page");
	}
	@Then("^Verify the appointment details on doctor module$")
	public void verify_appointmentDetails() throws IOException, ParseException, InterruptedException {
		C_Admin_doctorPageUtils.validate_appointmentDetails();
	}
	@Then("^Verify doctor personal details on view profile$")
	public void verify_doctor_personalDetails() throws IOException {
		C_Admin_doctorPageUtils.validateDoctorpersonalDetails();
		System.out.println("Validated doctor personal details");
	}
	@Then("^Verify medical report details on doctor module$")
	public void verify_medicalReport_doctorModule() throws IOException, ParseException, InterruptedException {
		C_Admin_doctorPageUtils.validate_medicalReport();
	}
	@Then("^Verify my treatment details on doctor module$")
	public void verify_myTreatment_doctorModule() throws IOException, ParseException, InterruptedException {
		C_Admin_doctorPageUtils.validate_Medicaltreatment();
	}
	@When("^Update the doctor fee details$")
	public void update_doctorFee() throws IOException {
		C_Admin_doctorPageUtils.doctor_editPayment();
	}
	@Then("^Check the success message for fee update process$")
	public void check_successMessage_editFee() {
		assertTrue(C_Admin_doctorPageUtils.alertBox().getText().replaceAll("\\s+", "").contentEquals(("Consultation fee updated successfully.").replaceAll("\\s+", "")));
		System.out.println("Consultation fee updated successfully.");
		C_Admin_doctorPageUtils.close_alertBox();
	}
	@Then("^Validate the updated details on payment edit screen$")
	public void validate_updatedDetails_editPayment() throws IOException {
		C_Admin_doctorPageUtils.validate_doctorFees_editPayment_valid();
	}
	@When("^Update the payment details with invalid inputs$")
	public void update_payment_invalid() throws IOException {
		C_Admin_doctorPageUtils.doctor_editPayment();
		C_Admin_doctorPageUtils.submit_doctorFeeupdate().click();
	}
	@Then("^Validate the validation message for invalid inputs$")
	public void validate_validationMessage_invalidInputs( ) {
		if((C_Admin_doctorPageUtils.alert_edit_domesticConsultingfee().getText().replaceAll("\\s+", "").contentEquals(("Domestic Consulting Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Consulting Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_edit_domesticConsultingfee().getText().replaceAll("\\s+", "").contentEquals(("Domestic Consulting Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Consulting Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_edit_overseasConsultingfee().getText().replaceAll("\\s+", "").contentEquals(("Overseas Consulting Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Consulting Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_edit_overseasConsultingfee().getText().replaceAll("\\s+", "").contentEquals(("Overseas Consulting Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Consulting Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_edit_domesticFollowupfee().getText().replaceAll("\\s+", "").contentEquals(("Domestic Follow up Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Follow up Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_edit_domesticFollowupfee().getText().replaceAll("\\s+", "").contentEquals(("Domestic Follow up Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Domestic Follow up Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		if((C_Admin_doctorPageUtils.alert_edit_overseasFollowupfee().getText().replaceAll("\\s+", "").contentEquals(("Overseas Follow up Fee should be in number").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Follow up Fee should be in number");
			assert true;
		}
		else if((C_Admin_doctorPageUtils.alert_edit_overseasFollowupfee().getText().replaceAll("\\s+", "").contentEquals(("Overseas Follow up Fee Minimum required is ₹ 1").replaceAll("\\s+", "")))) {
			System.out.println("Overseas Follow up Fee Minimum required is ₹ 1");
			assert true;
		}
		else {
			assert false;
		}
		assertFalse(C_Admin_doctorPageUtils.submit_doctorFeeupdate().isEnabled()==true);
		C_Admin_doctorPageUtils.close_doctorFeeupdate().click();
	}
}