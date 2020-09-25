package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import clinang.pageUtils.Patient_AppointmentPageUtils;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;


public class Patient_AppointmentStepDefs {
	
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	Patient_BookAppointmentPageUtils bookAppointment_PageUtils = new Patient_BookAppointmentPageUtils();
	
	@And("^Go to appointment module$")
	public void goTo_appointment() {
		appointmentPageUtils.Click_appointmentModule();
	}
	
	@And("^Move to appointment list page based on appointment date \"([^\"]*)\" and zoneid \"([^\"]*)\"$")
	public void compare__date(String dateofappointment,String Zone) throws ParseException {
		
		bookAppointment_PageUtils.get_dateOfappointment(dateofappointment);
		bookAppointment_PageUtils.currentDateandTime(Zone);
		
		String providedDate01 = (bookAppointment_PageUtils.expectedDate+"/"+bookAppointment_PageUtils.expectedMonth_F02+"/"+bookAppointment_PageUtils.expectedYear);
		String Currentdate01 = (bookAppointment_PageUtils.current_date+"/"+bookAppointment_PageUtils.current_month+"/"+bookAppointment_PageUtils.current_year);
		
		if(providedDate01.matches(Currentdate01)) {	
			System.out.println("today");
			appointmentPageUtils.Click_appointmentList_today();
		}
		
		else if((bookAppointment_PageUtils.expectedYear<bookAppointment_PageUtils.current_year) || (bookAppointment_PageUtils.expectedMonth_F02<bookAppointment_PageUtils.current_month) || (bookAppointment_PageUtils.expectedDate<bookAppointment_PageUtils.current_date)) {
			System.out.println("past");
			appointmentPageUtils.Click_appointmentList_past();
		}
		else {
			System.out.println("upcoming");
			appointmentPageUtils.Click_appointmentList_upcoming();
		}	
		
	}
	
	@And("^Find the appointment using the appointment ID \"([^\"]*)\"$")
	public void find_appointmentID(String appointmentID) {
		appointmentPageUtils.findAppointment(appointmentID);
	}
	
	@When("^Reschedule the appointment to \"([^\"]*)\" \"([^\"]*)\" with complaint \"([^\"]*)\"$")
	public void rescheduleAppointment(String rescheduleDate,String Slot,String Complaint) throws ParseException {
		
		appointmentPageUtils.Click_reschedule();
		bookAppointment_PageUtils.get_dateOfappointment(rescheduleDate);
		bookAppointment_PageUtils.selectDatefromDatepicker();
		appointmentPageUtils.slot(Slot).click();
		appointmentPageUtils.enter_rescheduleComment(Complaint);
		appointmentPageUtils.submit_Reschedule();
		appointmentPageUtils.wait_pageLoadercomplate();
		
	}
	
	@Then("^Check validation message$")
	public void check_validation_message() {
		
		assertTrue(appointmentPageUtils.get_message().contains("Appointment rescheduled successfully"));
	}
}