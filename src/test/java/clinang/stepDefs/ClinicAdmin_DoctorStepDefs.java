package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.Arrays;
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
		assertTrue(C_Admin_doctorPageUtils.alertBox().getText().replaceAll("/s+", "").contentEquals(("Doctor created successfully.").replaceAll("/s+", "")));
		C_Admin_doctorPageUtils.close_alertBox().click();
	}
	@Then("^Validate the new doctor details on doctor without profile screen$")
	public void validate_newDoctor_details() {
		C_Admin_doctorPageUtils.doctorWithoutprofile_tab().click();
		C_Admin_doctorPageUtils.wait_pageLoad_complate();
		int size = C_Admin_doctorPageUtils.latestDoctor_withoutProfile.length;
	    int [] arr = new int [size];    
	    arr[0] = Integer.parseInt( C_Admin_doctorPageUtils.latestDoctor_withoutProfile[0]);
		assertTrue((Arrays.asList(arr[0]+1).toString()).contains(C_Admin_doctorPageUtils.newDoctor_latest().getText()));
		
	}
}
	
