package clinang.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import clinang.pageUtils.Patient_MedicalhistoryPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_MedicalhistoryStepDefs {
	
	Patient_MedicalhistoryPageUtils Medicalhistory = new Patient_MedicalhistoryPageUtils();
	
	
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
		Medicalhistory.select_option(get_option);
		
	}
	@Then("^Check validation message for successful medical history add$")
	public void checkValidation_add() {
		assertTrue(Medicalhistory.get_alertMessage().contains("Medical history saved successfully"));
	}
	
	@Then("^Check validation message for successful medical history update$")
	public void checkValidation_update() {
		assertTrue(Medicalhistory.get_alertMessage().contains("Medical history updated successfully"));
	}
	
	@And("^Clear the mandatory fields$") 
	public void check_add_mandatory() throws InterruptedException {
		Medicalhistory.nullField();
	}
	
	@Then("^Check the validation message for medical history mandatory fields$")
	public void checkValidation_mandatory_add() {
		
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Select Blood Group"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Select Date of Birth"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter Age"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Weight"));
		assertTrue(Medicalhistory.get_medicalHistoryform().contains("Please Enter the Height"));



	}
}