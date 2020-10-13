package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import clinang.pageUtils.Patient_RegistrationPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_RegistrationStepDefs {
	Patient_RegistrationPageUtils registration = new Patient_RegistrationPageUtils();
	
	@When("^Click on registration link$")
	public void click_registrationLink() {
		registration.ClickregistrationLink();		
	}
	
	@When("^Enter firstname,lastname,email and password$")
	public void enterDetails(DataTable inputs) {
		registration.passInput(inputs);		
	}
	
	@And("^Click on register button$")
	public void clickRegister() {
		registration.clickRegButton();
	}
	
	@Then("^Check the validation message for success registration$")
	public void checkSuccessProcess() {	
		assertTrue(registration.get_alertMessage().contains("Registered successfully."));
	}
	
	@Then("^Check the validation message for existing details$")
	public void checkFailedprocess_existing() {		
		assertTrue(registration.get_alertMessage().contains("Something went wrong!, Please try again later"));
		
	}
	
	@Then("^Check validation message for invalid details$")
	public void checkFailedprocess_invalid_all() {		
		assertTrue(registration.gettext_loginform().contains("First Name should be in alphabets"));
		assertTrue(registration.gettext_loginform().contains("Last Name should be in alphabets"));
		assertTrue(registration.gettext_loginform().contains("Enter a valid Email"));
		assertTrue(registration.gettext_loginform().contains("Password must have atleast 6 characters with a mix of special character, digit, uppercase and lowercase"));
		//System.out.println(registration.gettext_loginform());
	}
	
}