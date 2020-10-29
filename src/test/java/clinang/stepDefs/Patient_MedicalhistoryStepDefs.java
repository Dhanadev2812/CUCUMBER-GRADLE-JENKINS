package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.Arrays;

import clinang.pageUtils.Patient_DashboardPageUtils;
import clinang.pageUtils.Patient_MedicalhistoryPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_MedicalhistoryStepDefs {
	
	Patient_MedicalhistoryPageUtils Medicalhistory = new Patient_MedicalhistoryPageUtils();
	Patient_DashboardPageUtils Dashboard = new Patient_DashboardPageUtils();	
	
	@Then("^Go to medical history$")
	public void goto_medicalhistory() throws InterruptedException {
		Medicalhistory.scrollTomedicalHistory();
		Medicalhistory.click_medicalHistory();
	}
	
	@When("^Enter the medical history details$")
	public void enter_medicalHistorydetails(DataTable inputs) throws InterruptedException, ParseException {
		Medicalhistory.passMedicalhistoryDetails(inputs);	
	}
	
	@And("^Click \"([^\"]*)\"$") 
	public void click_option(String get_option) {	
		Medicalhistory.get_medicalHistorydata();
		Medicalhistory.select_option(get_option);		
	}
	
	@Then("^Check validation message for successful medical history add$")
	public void checkValidation_add() {
		assertTrue(Medicalhistory.get_alertMessage().equalsIgnoreCase("Medical history saved successfully"));
		System.out.println("Medical history saved successfully");
	}
	
	@Then("^Check validation message for successful medical history update$")
	public void checkValidation_update()  {
		assertTrue(Medicalhistory.get_alertMessage().equalsIgnoreCase("Medical history updated successfully"));	
		System.out.println("Medical history updated successfully");
	}
	
	@Then("^Check the added details updated on patient dashboard$")
	public void comparewith_dashboard() throws InterruptedException, ParseException  {
		
		Medicalhistory.closeAlert();
		Dashboard.fluentWait_profileMail();
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_age().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_gender().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.profile_bloodGroup().getText()));
		assertTrue(Arrays.asList(Medicalhistory.charArr).contains(Dashboard.dob_changedformat()));
		System.out.println("Added details updated on patient dashboard");
	}
	
	@And("^Clear the mandatory fields$") 
	public void check_add_mandatory() throws InterruptedException {
		Medicalhistory.nullField_add();
	}
	
	@Then("^Check the validation message for medical history mandatory fields$")
	public void checkValidation_mandatory_add() {
		
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Select Blood Group"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Select Date of Birth"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter Age"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter the Weight"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter the Height"));
		System.out.println("Validation message exhibits for invalid inouts");
	}
	
	@When("^Enter the details except allergy and medical history$")
	public void check_allergy_medicalhistory_mandatory(DataTable inputs) throws ParseException {
		Medicalhistory.nullField_allergy_medicalHistory(inputs);
	}
	
	@Then("^Check the validation message on allergy and medical history field$")
	public void checkValidation_allergy_medicalHistory() {
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please enter any allergies that needs to be known"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please enter your medical history that needs to be known"));
		System.out.println("Validation message exhibits for invalid inouts");
	}
	
	@And("^Clear the mandatory fields on edit screen$")
	public void check_editMandatory() throws InterruptedException {
		Medicalhistory.nullField_edit();
	}
	
	@Then("^Check the validation message for medical history mandatory fields on edit$")
	public void checkValidation_mandatory_edit() {
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter Age"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter the Weight"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Please Enter the Height"));
		System.out.println("Validation message exhibits for invalid inouts");
		
	}
	
	@And("^Clear only allergy and medicalhistory details$")
	public void Check_edit_allergy_medicalhistory_mandatory() throws InterruptedException {
		Medicalhistory.nullField_edit_allergy_medicalHistory();
	}
	
	@When("^Enter invalid details$")
	public void enter_invalid_details(DataTable inputs) {
		Medicalhistory.invalid_medicalHistory(inputs);
	}
	
	@But("^It display alert message - Weight and height must be number$")
	public void checkValidation_add_invalid() {
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Weight must be number"));
		assertTrue(Medicalhistory.get_medicalHistoryform().equalsIgnoreCase("Height must be number"));
		System.out.println("Validation message exhibits for invalid inouts");
	}
}