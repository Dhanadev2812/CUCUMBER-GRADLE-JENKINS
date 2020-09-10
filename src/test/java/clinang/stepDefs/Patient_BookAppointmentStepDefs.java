package clinang.stepDefs;



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
	
	@Then("^Check the slot time is 2hrs>current time,if the current date is equal to the given date$")
	public void compare_slot() {
		B_appointment.check_slot();
	}
	
}