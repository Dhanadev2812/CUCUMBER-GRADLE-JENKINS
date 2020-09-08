package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.Arrays;

import clinang.pageUtils.Patient_DashboardPageUtils;
import clinang.pageUtils.Patient_MedicalhistoryPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Patient_MedicalhistoryStepDefs {
	
	Patient_MedicalhistoryPageUtils Medicalhistory = new Patient_MedicalhistoryPageUtils();
	Patient_DashboardPageUtils Dashboard = new Patient_DashboardPageUtils();	
	
	@Then("^Go to medical history$")
	public void goto_medicalhistory() throws InterruptedException {
		Medicalhistory.scrollTomedicalHistory();
		Medicalhistory.click_medicalHistory();
	}
	
	@And("^Enter the medical history details$")
	public void enter_medicalHistorydetails(DataTable inputs) throws InterruptedException, ParseException {
		Medicalhistory.passMedicalhistoryDetails(inputs);	
	}
	
	@Then("^Click \"([^\"]*)\"$") 
	public void click_option(String get_option) {	
		Medicalhistory.get_medicalHistorydata();
		Medicalhistory.select_option(get_option);		
	}
	
	@Then("^Check validation message for successful medical history add$")
	public void checkValidation_add() {
		assertTrue(Medicalhistory.get_alertMessage().contains("Medical history saved successfully"));
		
	}
	
	@Then("^Check validation message for successful medical history update$")
	public void checkValidation_update()  {
		assertTrue(Medicalhistory.get_alertMessage().contains("Medical history updated successfully"));		
	}
	
	@Then("^Check the added details updated on patient dashboard$")
	public void comparewith_dashboard() throws InterruptedException, ParseException  {
		
		Medicalhistory.closeAlert();
		Dashboard.fluentWait_profileMail();
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_age().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_gender().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_bloodGroup().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.dob_changedformat()));

	}
	
	@And("^Clear the mandatory fields$") 
	public void check_add_mandatory() throws InterruptedException {
		Medicalhistory.nullField_add();
	}
	
	@Then("^Check the validation message for medical history mandatory fields$")
	public void checkValidation_mandatory_add() {
		
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Select Blood Group"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Select Date of Birth"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter Age"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Weight"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Height"));

	}
	
	@And("^Enter the details except allergy and medical history$")
	public void check_allergy_medicalhistory_mandatory(DataTable inputs) throws ParseException {
		Medicalhistory.nullField_allergy_medicalHistory(inputs);
	}
	
	@Then("^Check the validation message on allergy and medical history field$")
	public void checkValidation_allergy_medicalHistory() {
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please enter any allergies that needs to be known"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please enter your medical history that needs to be known"));
	}
	
	@And("^Clear the mandatory fields on edit screen$")
	public void check_editMandatory() throws InterruptedException {
		Medicalhistory.nullField_edit();
	}
	
	@Then("^Check the validation message for medical history mandatory fields on edit$")
	public void checkValidation_mandatory_edit() {
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter Age"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Weight"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Height"));
		
	}
	
	@And("^Clear only allergy and medicalhistory details$")
	public void Check_edit_allergy_medicalhistory_mandatory() throws InterruptedException {
		Medicalhistory.nullField_edit_allergy_medicalHistory();
	}
	
	@And("^Enter invalid details$")
	public void enter_invalid_details(DataTable inputs) {
		Medicalhistory.invalid_medicalHistory(inputs);
	}
	
	@Then("^Check the validation message for invalid details$")
	public void checkValidation_add_invalid() {
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Weight must be number"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Height must be number"));
	}
}