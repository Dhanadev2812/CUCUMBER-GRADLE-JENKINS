package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import clinang.pageUtils.ClinicAdmin_ProfileupdatePageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_ProfileupdateStepDefs {
	
	ClinicAdmin_ProfileupdatePageUtils C_Admin_Profileupdate_PageUtils = new ClinicAdmin_ProfileupdatePageUtils();
	
	@And("^Go to clinic admin module$")
	public void goto_clinicAdmin() {
		C_Admin_Profileupdate_PageUtils.wait_pageLoad_complate();
		C_Admin_Profileupdate_PageUtils.Click_ClinicAdmin();
	}
	
	@And("^Click on edit option$")
	public void click_edit() {
		C_Admin_Profileupdate_PageUtils.click_edit();
	}
	
	@And("^Upload the clinic logo from \"([^\"]*)\"$")
	public void upload_clinicLogo(String imgPath)  {
		C_Admin_Profileupdate_PageUtils.upload_Img(imgPath);
	}
	
	@When("^Enter clinic details$")
	public void enter_clinic_details(DataTable inputs) {
		C_Admin_Profileupdate_PageUtils.passClinicdetails(inputs);
	}
	@And("^Submit the clinic updates$")
	public void submit_clinicUpdate() {
		C_Admin_Profileupdate_PageUtils.Click_submit_clinicUpdate();
		C_Admin_Profileupdate_PageUtils.wait_pageLoad_complate();
	}
	@Then("^Validation clinic update message$")
	public void validate_update_clinic() {
		assertTrue(C_Admin_Profileupdate_PageUtils.messageBox().getText().equalsIgnoreCase("Clinic details updated successfully"));
		C_Admin_Profileupdate_PageUtils.click_closeMesagebox();
	}
	
	@Then("^Validate the updated clinic name on grid$")
	public void validate_clinicName() {
		System.out.println(C_Admin_Profileupdate_PageUtils.grid_clinicName().getText());
		System.out.println(Arrays.asList(C_Admin_Profileupdate_PageUtils.given_clinicName[0]));
		assertTrue((Arrays.asList(C_Admin_Profileupdate_PageUtils.given_clinicName[0].replace(" ", ""))).contains(C_Admin_Profileupdate_PageUtils.grid_clinicName().getText().replace(" ", "")));
	}
	
	@When("^Remove the inputs from mandatory fields$")
	public void remove_mandatoryFieds() {
		C_Admin_Profileupdate_PageUtils.clear_mandatoryInputs();
	}
	
	@But("^t display the alerts for mandatory fields$")
	public void clinic_alert() {
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicName_alert().getText().equalsIgnoreCase("Please Enter Clinic Name"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicAddress_alert().getText().equalsIgnoreCase("Please Enter Address"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicStreet_alert().getText().equalsIgnoreCase("Please enter Street"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicCity_alert().getText().equalsIgnoreCase("Please Enter City"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicState_alert().getText().equalsIgnoreCase("Please Enter State"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicPincode_alert().getText().equalsIgnoreCase("Please Enter Pincode"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicEmail_alert().getText().equalsIgnoreCase("Clinic Email is Required"));
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicPhone_alert().getText().equalsIgnoreCase("Clinic Phone Number is Required"));
	}
	
	@When("^enter invalid email \"([^\"]*)\"$")
	public void enter_invalid_email(String invalidEmail) {
		C_Admin_Profileupdate_PageUtils.wait_pageLoad_complate();
		C_Admin_Profileupdate_PageUtils.invalidEmail(invalidEmail);
	}
	
	@But("^It display invalid email alert$")
	public void invalid_email_alert() {
		assertTrue(C_Admin_Profileupdate_PageUtils.clinicEmail_alert().getText().equalsIgnoreCase("Enter a valid Clinic Email"));
	}
}