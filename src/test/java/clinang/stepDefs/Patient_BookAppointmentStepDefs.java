package clinang.stepDefs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import clinang.pageUtils.Patient_DashboardPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_BookAppointmentStepDefs {
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	Patient_DashboardPageUtils editProfile = new Patient_DashboardPageUtils();
	
	@And("^Get the patient country$")
	public void get_country() throws InterruptedException {
		editProfile.clickEditProfile();
		editProfile.patient_country();
	}
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
	
	@Then("^Check the fee details based on country$")
	public void check_patient_currentCountry(DataTable inputs) throws InterruptedException, ParseException {
		B_appointment.check_patient_fee(inputs);
	}
	
	@And("^Click on paynow$")
	public void click_on_payNow() {	
		B_appointment.clickPaynow();
	}
	
	@Then("Done a payment process via \"([^\"]*)\"$")
	public void payment_process(String paymentMethod,DataTable inputs) throws ParseException, InterruptedException {
		switch (paymentMethod) {
	       case "card":
	    	   B_appointment.paymentMethod_card(inputs);
	          break;  
	       case "upi":  
	    	   B_appointment.paymentMethod_upi(inputs);
	          break;
	       case "netbanking":
	    	   B_appointment.paymentMethod_netbanking(inputs);
	    	   break;
	       case "wallet" :
	    	   B_appointment.paymentMethod_wallet(inputs);
	    	   break;
	       case "emi":
	    	   B_appointment.paymentMethod_emi(inputs);
	    	   break;
	  }
		
	}
	
}