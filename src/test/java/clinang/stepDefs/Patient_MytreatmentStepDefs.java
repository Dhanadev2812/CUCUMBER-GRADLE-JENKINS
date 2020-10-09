package clinang.stepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import clinang.pageUtils.Patient_MytreatmentPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_MytreatmentStepDefs {
	Patient_MytreatmentPageUtils myTreatment = new Patient_MytreatmentPageUtils();
	
	
	@And("^Move to my treatment$")
	public void moveTo_myTreatment() {
		myTreatment.wait_pageLoadercomplate();
		myTreatment.click_myTreatmentmodule();
	}
	
	@Then("^Check the my treatment details with the help of \"([^\"]*)\"$")
	public void get_myTreatmentdetails(String myTreatmentfile) throws IOException {
		myTreatment.get_myTreatment(myTreatmentfile);
	}
	
	@When("^Validate and Download the prescription based on appointment id \"([^\"]*)\"$")
	public void find_appointment(String appointmentid,DataTable prescription) {
		myTreatment.downloadPrescription(appointmentid,prescription);
	}
}