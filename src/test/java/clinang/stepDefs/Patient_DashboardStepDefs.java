package clinang.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import clinang.pageUtils.Patient_DashboardPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_DashboardStepDefs {
	
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	
	@Then("^click on logout button$")
	public void clickon_Logout()  {
		dashboard.clickLogout();
	}
	
	@And("^Click on edit profile option$")
	public void click_editProfile() {
		dashboard.clickEditProfile();		
	}
	
	@Then("^Upload the image from \"([^\"]*)\"$")
	public void uploadimage(String img_path) throws InterruptedException {
		dashboard.upload_profileImg(img_path);
	}
	
	@And("^Enter mobile_number,address,street,city,state,country and pincode$")
	public void enter_profiledetails(DataTable inputs) throws InterruptedException {
		dashboard.passProfiledetails(inputs);
		dashboard.get_editFormdata();
	}
	
	@Then("^Click on \"([^\"]*)\"$") 
	public void click_option(String get_option) {
		dashboard.select_option(get_option);
		
	}
	@Then("^Move to dashboard$")
	public void moveto_dashboard() throws InterruptedException {
		dashboard.scrollTodashboard();
		dashboard.clickDashboard();
	}
	
	@Then("^Check validation message for successful update$")
	public void check_updatealert_success() {
		assertTrue(dashboard.get_alertMessage().contains("Patient profile updated succesfully"));
	}
	
	@And("^Check the profile details updated on dashboard$")
	public void check_with_dashboard() throws InterruptedException {
		assertTrue(Arrays.asList(dashboard.editpageArr).contains(dashboard.profile_mob().getText()));
		assertTrue(Arrays.asList(dashboard.editpageArr).contains(dashboard.profile_address().getText()));

	}	
	
	@Then("^Clear all existing details$")
	public void update_with_nullDetails() throws InterruptedException  {
		dashboard.updateProfile_nullValue();
	}
	
	@Then("^Check the validation message for mandatory fields$")
	public void validation_message_mandatory()  {
		assertTrue(dashboard.gettext_profileEditform().contains("Mobile Number is Required"));
		assertTrue(dashboard.gettext_profileEditform().contains("Please Enter Address"));
		assertTrue(dashboard.gettext_profileEditform().contains("Please enter Street"));
		assertTrue(dashboard.gettext_profileEditform().contains("Please Enter City"));
		assertTrue(dashboard.gettext_profileEditform().contains("Please Enter State"));
		assertTrue(dashboard.gettext_profileEditform().contains("Please Enter Pincode"));
	}
	
	@Then("^Check the save button is disabled or not$")
	public void check_saveDisable()  {
		assertEquals(false, dashboard.clickSave().isEnabled());
	}
	
	@Then("^Enter invalid mobile number$")
	public void invalid_mobileNum(DataTable inputs ) throws InterruptedException {
		dashboard.passProfiledetails(inputs);
	}
	
	@Then("^Check the validation message for invalid data$") 
		public void alert_invalidMobnum() {
		assertTrue(dashboard.gettext_profileEditform().contains("Mobile Number should be 10 digits"));
		}
	}


