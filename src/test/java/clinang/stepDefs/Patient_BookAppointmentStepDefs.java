package clinang.stepDefs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_BookAppointmentStepDefs {
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	
	@And("^Go to book appointment screen$") 
	public void Goto_bookAppointment() {
		B_appointment.click_bookAppointment();	
	}
	
	@When("^Enter the appointment details$")
	public void Enter_appointment_details(DataTable inputs) throws InterruptedException, ParseException {
		B_appointment.passAppointmentdetails(inputs);
	}
	
	@Then("^Check wheather the appointment date-\"([^\"]*)\" is a past date or not,Based on zoneid \"([^\"]*)\"$") 
	public void validation_appointmentDate(String dateofappointment,String Zone) throws ParseException {
		B_appointment.get_dateOfappointment(dateofappointment);
		B_appointment.currentDateandTime(Zone);	
		B_appointment.compare_date();
	}
	
	@And("^Select the appointment date \"([^\"]*)\"$")
	public void select_appointment_Date(String dateofappointment ) throws ParseException {
		B_appointment.get_dateOfappointment(dateofappointment);
		B_appointment.selectDatefromDatepicker();	
	}
	
	@Then("^Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability$")
	public void compare_slot() throws ParseException {
		B_appointment.check_slot();
	}
	
	@And("^Select the slot \"([^\"]*)\"$")
	public void select_slot(String slot) {
		B_appointment.clickSlot(slot);
	}
	
	@Then("^Check the paynow option is enabled or not$")
	public void check_payNow_enable() {
		assertEquals(true, B_appointment.payNow_button().isEnabled());		
	}
	
	@And("^Check the consultation fee \"([^\"]*)\" and then Click on paynow$")
	public void click_on_payNow(String ConsultationFee) {
		B_appointment.get_consultationFee();
		assertTrue(B_appointment.get_consultationFee().equals(ConsultationFee));
		B_appointment.clickPaynow();
		
	}
	
}