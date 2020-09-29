package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.Arrays;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import clinang.pageUtils.Patient_AppointmentPageUtils;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import clinang.pageUtils.Patient_DashboardPageUtils;


public class Patient_AppointmentStepDefs {
	
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	Patient_BookAppointmentPageUtils bookAppointment_PageUtils = new Patient_BookAppointmentPageUtils();
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	
	@And("^Go to appointment module$")
	public void goTo_appointment() throws InterruptedException {
		dashboard.appointmentCount();
		appointmentPageUtils.Click_appointmentModule();
	}
	
	@And("^Move to appointment list page based on date \"([^\"]*)\" and zoneid \"([^\"]*)\"$")
	public void compare__date(String dateofappointment,String Zone) throws ParseException {
		
		bookAppointment_PageUtils.get_dateOfappointment(dateofappointment);
		bookAppointment_PageUtils.currentDateandTime(Zone);
		
		String providedDate01 = (bookAppointment_PageUtils.expectedDate+"/"+bookAppointment_PageUtils.expectedMonth_F02+"/"+bookAppointment_PageUtils.expectedYear);
		String Currentdate01 = (bookAppointment_PageUtils.current_date+"/"+bookAppointment_PageUtils.current_month+"/"+bookAppointment_PageUtils.current_year);
		
		if(providedDate01.matches(Currentdate01)) {	
			appointmentPageUtils.Click_appointmentList_today();
		}
		
		else if((bookAppointment_PageUtils.expectedYear<bookAppointment_PageUtils.current_year) || (bookAppointment_PageUtils.expectedMonth_F02<bookAppointment_PageUtils.current_month) || (bookAppointment_PageUtils.expectedDate<bookAppointment_PageUtils.current_date)) {
			appointmentPageUtils.Click_appointmentList_past();
		}
		else {
			appointmentPageUtils.Click_appointmentList_upcoming();
		}	
		
	}
	
	@And("^Find the appointment using the appointment ID \"([^\"]*)\"$")
	public void find_appointmentID(String appointmentID) {
		appointmentPageUtils.findAppointment(appointmentID);
	}
	
	@Then("^Check wheather the reschedule date-\"([^\"]*)\" is a past date or not,Based on zoneid \"([^\"]*)\"$")
	public void check_reschedule_date(String dateofappointment,String Zone) throws ParseException {
		bookAppointment_PageUtils.get_dateOfappointment(dateofappointment);
		bookAppointment_PageUtils.currentDateandTime(Zone);	
		bookAppointment_PageUtils.compare_date();
	}
	
	@When("^Reschedule the appointment to \"([^\"]*)\"$")
	public void rescheduleAppointment(String rescheduleDate) throws ParseException {
		
		appointmentPageUtils.Click_reschedule();
		bookAppointment_PageUtils.get_dateOfappointment(rescheduleDate);
		bookAppointment_PageUtils.selectDatefromDatepicker();			
	}
	
	@Then("^Check the slot time is 2hrs>current time,if the reschedule date \"([^\"]*)\" is a current date also check the slot availability$")
	public void Check_slot(String rescheduleDate) throws ParseException {
		bookAppointment_PageUtils.get_dateOfappointment(rescheduleDate);
		bookAppointment_PageUtils.check_slot();
	}
	
	
	@When("^Select slot  \"([^\"]*)\" with complaint \"([^\"]*)\"$")
	public void Select_slot_complaint(String Slot,String Complaint) throws ParseException {
		appointmentPageUtils.slot(Slot).click();
		appointmentPageUtils.enter_rescheduleComment(Complaint);
		appointmentPageUtils.get_rescheduleDetails();
		appointmentPageUtils.submit_Reschedule();
		appointmentPageUtils.wait_pageLoadercomplate();	
	}
	
	@Then("^Check validation message$")
	public void check_validation_message() throws ParseException {
		
		assertTrue(appointmentPageUtils.get_message().contains("Appointment rescheduled successfully"));
		appointmentPageUtils.click_reschedule_closeAlert();
		appointmentPageUtils.get_appointmentDetails_viewPage();
	}
	
	@Then("^Validate rescheduled appointment details$")
	public void Validate_rescheduleDetails()  {
		assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[5].replace(" ", "")).contains(appointmentPageUtils.reschedule_appointmentDetails[0].replace(" ", "")));
		assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]).contains(appointmentPageUtils.reschedule_appointmentDetails[1]));						
			
		}
	@Then("^Check the appointment count based on reschedule date \"([^\"]*)\" and previous appointment date \"([^\"]*)\"$")
	public void check_appointmentCount(String rescheduleDate,String existingAppointment) throws InterruptedException, ParseException {
		
		dashboard.dashboardField().click();
		dashboard.wait_profileView();
		Thread.sleep(5000);
		
		String Currentdate = (bookAppointment_PageUtils.current_date+"/"+bookAppointment_PageUtils.current_month+"/"+bookAppointment_PageUtils.current_year);
		int compareAppointmentdates =rescheduleDate.compareTo(existingAppointment);
		
		int size = dashboard.dashboard_appointmentCount.length;
	    int [] arr = new int [size];    
	    arr[0] = Integer.parseInt(dashboard.dashboard_appointmentCount[0]);
	    arr[1] = Integer.parseInt(dashboard.dashboard_appointmentCount[1]);
	    
		if(rescheduleDate.equals(Currentdate)) {	
				if(compareAppointmentdates==0) {
					assertTrue((Arrays.asList(arr[0]).toString()).contains(dashboard.getCount_todayApp()));
				}
				else {
					assertTrue((Arrays.asList(arr[0]+1).toString()).contains(dashboard.getCount_todayApp()));
				}				
		   }
			
		else {
			
			if(compareAppointmentdates<0 || compareAppointmentdates>0 || compareAppointmentdates==0) {
				assertTrue((Arrays.asList(arr[1]).toString()).contains(dashboard.getCount_upcomingApp()));
			}
			else {
				assertTrue((Arrays.asList(arr[1]+1).toString()).contains(dashboard.getCount_upcomingApp()));
			}					
		}
		
		if(existingAppointment.equals(Currentdate)) {	
			
			if(compareAppointmentdates==0) {
				assertTrue((Arrays.asList(arr[0]).toString()).contains(dashboard.getCount_todayApp()));
			}
			else {
				assertTrue((Arrays.asList(arr[0]-1).toString()).contains(dashboard.getCount_todayApp()));
			}
		}
		
		else {
			if(compareAppointmentdates<0 || compareAppointmentdates>0 || compareAppointmentdates==0) {
				assertTrue((Arrays.asList(arr[1]).toString()).contains(dashboard.getCount_upcomingApp()));
			}
			else {
				assertTrue((Arrays.asList(arr[1]-1).toString()).contains(dashboard.getCount_upcomingApp()));
			}
		}				
	}	
}