package clinang.stepDefs;

import java.text.ParseException;

import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Patient_BookAppointmentStepDefs {
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	
	@When("^Go to book appointment screen$") 
	public void Goto_bookAppointment() {
		B_appointment.click_bookAppointment();	
	}
	
	@And("^Enter the appointment details$")
	public void Enter_appointment_details(DataTable inputs) throws InterruptedException, ParseException {
		B_appointment.passAppointmentdetails(inputs);
	}
	
}