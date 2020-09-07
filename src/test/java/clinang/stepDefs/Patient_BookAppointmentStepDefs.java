package clinang.stepDefs;

import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import io.cucumber.java.en.When;

public class Patient_BookAppointmentStepDefs {
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	
	@When("^Go to book appointment screen$") 
	public void Goto_bookAppointment() {
		B_appointment.click_bookAppointment();
		
	}
	
}