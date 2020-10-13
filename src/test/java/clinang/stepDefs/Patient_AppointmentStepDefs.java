package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clinang.pageUtils.Patient_AppointmentPageUtils;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import clinang.pageUtils.Patient_DashboardPageUtils;
import clinang.pageUtils.Patient_MytreatmentPageUtils;

import java.awt.AWTException;
import java.io.File;
import java.net.URL;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Patient_AppointmentStepDefs {
	
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	Patient_BookAppointmentPageUtils bookAppointment_PageUtils = new Patient_BookAppointmentPageUtils();
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	Patient_MytreatmentPageUtils myTreatment = new Patient_MytreatmentPageUtils();
	
	@And("^Go to appointment module$")
	public void goTo_appointment() throws InterruptedException {
		dashboard.fluentWait_profileMail();
		dashboard.appointmentCount();
		appointmentPageUtils.Click_appointmentModule();
		appointmentPageUtils.wait_pageLoadercomplate();	
	}
	
	@When("^Move to appointment list page based on date \"([^\"]*)\" and zoneid \"([^\"]*)\"$")
	public void compare__date(String dateofappointment,String Zone) throws ParseException {
		
		bookAppointment_PageUtils.get_dateOfappointment(dateofappointment);
		bookAppointment_PageUtils.currentDateandTime(Zone);
		
		String providedDate01 = (bookAppointment_PageUtils.expectedDate+"/"+bookAppointment_PageUtils.expectedMonth_F02+"/"+bookAppointment_PageUtils.expectedYear);
		String Currentdate01 = (bookAppointment_PageUtils.current_date+"/"+bookAppointment_PageUtils.current_month+"/"+bookAppointment_PageUtils.current_year);
		
		if(providedDate01.matches(Currentdate01)) {	
			appointmentPageUtils.Click_appointmentList_today();
			appointmentPageUtils.wait_pageLoadercomplate();	
		}
		
		else {
			if(bookAppointment_PageUtils.expectedYear<bookAppointment_PageUtils.current_year) {
				appointmentPageUtils.Click_appointmentList_past();
			}
			else if(bookAppointment_PageUtils.expectedYear>bookAppointment_PageUtils.current_year) {
				appointmentPageUtils.Click_appointmentList_upcoming();
			}
			else if(bookAppointment_PageUtils.expectedYear.equals(bookAppointment_PageUtils.current_year)) {
				if(bookAppointment_PageUtils.expectedMonth_F02<bookAppointment_PageUtils.current_month) {
					appointmentPageUtils.Click_appointmentList_past();
				}
				else if(bookAppointment_PageUtils.expectedMonth_F02>bookAppointment_PageUtils.current_month) {
					appointmentPageUtils.Click_appointmentList_upcoming();
				}
				else if(bookAppointment_PageUtils.expectedMonth_F02.equals(bookAppointment_PageUtils.current_month)) {
					if(bookAppointment_PageUtils.expectedDate<bookAppointment_PageUtils.current_date) {
						appointmentPageUtils.Click_appointmentList_past();
					}
					else if(bookAppointment_PageUtils.expectedDate>bookAppointment_PageUtils.current_date) {
						appointmentPageUtils.Click_appointmentList_upcoming();
					}
				}
			}
		}
		appointmentPageUtils.wait_pageLoadercomplate();
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
		appointmentPageUtils.click_closeOption();
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
					//System.out.println("today to today");
					assertTrue((Arrays.asList(arr[0]).toString()).contains(dashboard.getCount_todayApp()));
				}
				else {
					//System.out.println("upcoming-today");
					assertTrue((Arrays.asList(arr[0]+1).toString()).contains(dashboard.getCount_todayApp()));
					assertTrue((Arrays.asList(arr[1]-1).toString()).contains(dashboard.getCount_upcomingApp()));
				}				
		   }		
		else {
			
			if(existingAppointment.equals(Currentdate)) {
				//System.out.println("today-upcoming");
				assertTrue((Arrays.asList(arr[1]+1).toString()).contains(dashboard.getCount_upcomingApp()));
				assertTrue((Arrays.asList(arr[0]-1).toString()).contains(dashboard.getCount_todayApp()));					
			}
			else {
				//System.out.println("upcoming - upcoming");
				assertTrue((Arrays.asList(arr[1]).toString()).contains(dashboard.getCount_upcomingApp()));
			}					
		}				
	}
	
	@And("^Cancel the appointment$")
	public void cancel_appointment() {
		appointmentPageUtils.wait_pageLoadercomplate();
		appointmentPageUtils.click_cancelButton();
		appointmentPageUtils.wait_cancelConfirm_alertBox();
		appointmentPageUtils.click_confirmCancel();
	}
	
	@Then("^Check the validation message for cancellation process$")
	public void Check_validationMessage_cancel() {
		assertTrue(appointmentPageUtils.get_message().contains("Appoinment cancelled successfully."));
		appointmentPageUtils.click_closeOption();
	}
	
	@Then("^Check the appointment count based on cancelled appointment date \"([^\"]*)\"$") 
	public void Check_appointmentCount_dashborad(String cancelledAppointment) throws InterruptedException {
		dashboard.dashboardField().click();
		dashboard.wait_profileView();
		Thread.sleep(5000);
		
		String Currentdate = (bookAppointment_PageUtils.current_date+"/"+bookAppointment_PageUtils.current_month+"/"+bookAppointment_PageUtils.current_year);
		int size = dashboard.dashboard_appointmentCount.length;
	    int [] arr = new int [size];    
	    arr[0] = Integer.parseInt(dashboard.dashboard_appointmentCount[0]);
	    arr[1] = Integer.parseInt(dashboard.dashboard_appointmentCount[1]);
	    arr[2] = Integer.parseInt(dashboard.dashboard_appointmentCount[2]);
	    
	    assertTrue((Arrays.asList(arr[2]+1).toString()).contains(dashboard.getCount_cancelledApp()));
	    
		if(cancelledAppointment.equals(Currentdate)) {
			assertTrue((Arrays.asList(arr[0]-1).toString()).contains(dashboard.getCount_todayApp()));				
		}
		else {
			assertTrue((Arrays.asList(arr[1]-1).toString()).contains(dashboard.getCount_upcomingApp()));
		}
	}
	
	@And("^Add medical report with description$")
	public void add_medicalReport(DataTable medicalReport) {
		appointmentPageUtils.addFile_medicalRecord(medicalReport);
	}
	
	@Then("^Validate the uploaded medical reports$")
	public void Validate_uploadedReport(DataTable uploaded_medicalReport) {
		appointmentPageUtils.validate_uploadedReport(uploaded_medicalReport);
	}
	
	@When("^download all the uploaded report$")
	public void download_all_report() throws InterruptedException {
		appointmentPageUtils.wait_pageLoadercomplate();	
		appointmentPageUtils.downloadAllreport();
	}
	
	@When("^Download specific uploaded report based on report name and description$") 
	public void download_specific_report(DataTable reportName) {
		appointmentPageUtils.wait_pageLoadercomplate();
		appointmentPageUtils.downloadSpecificreport(reportName);
	}
	@When("^delete all the uploaded report$") 
	public void delete_all_medicalReport() throws InterruptedException {
		appointmentPageUtils.wait_pageLoadercomplate();
		appointmentPageUtils.deleteAllreport();
	}
	
	@When("^Delete specific uploaded report based on report name and description$")
	public void delete_specific_report(DataTable uploaded_medicalReport) {
		appointmentPageUtils.deleteSpecificreport(uploaded_medicalReport);
	}
	
	@Then("^Check wheather the appointment date-\"([^\"]*)\" is a upcoming date or not,Based on zoneid \"([^\"]*)\"$")
	public void check_appointmentDate_upcoming(String dateofappointment,String Zone) throws ParseException {
		appointmentPageUtils.wait_pageLoadercomplate();
		bookAppointment_PageUtils.get_dateOfappointment(dateofappointment);
		bookAppointment_PageUtils.currentDateandTime(Zone);
		bookAppointment_PageUtils.compareDate_upcoming();
	}
	@Then("^Check the appointment have an option to book a followup$")
	public void Check_bookFollowupOption() {
		appointmentPageUtils.wait_pageLoadercomplate();
		if(appointmentPageUtils.bookFollowup().isDisplayed()==true) {
			assert true;
		}
		else {
			assert false;
		}		
	}
	@Then("^Validate the followup fees$")
	public void Validate_followupFee(DataTable inputs) throws InterruptedException, ParseException {
		appointmentPageUtils.bookFollowup_Appointment();
		appointmentPageUtils.check_patient_followupFee(inputs);
	}
	@And("^Accept the book followup$")
	public void Accept_bookFollowup() {
		appointmentPageUtils.accept_bookFollowup();
	}
	@When("^Enter the followup appointment details$")
	public void followup_appointmentDetails(DataTable inputs) throws InterruptedException, ParseException {
		appointmentPageUtils.wait_pageLoadercomplate();
		appointmentPageUtils.passFollowupappointmentDetails(inputs);
	}
	@Then("^Validate the payment amount with followup fee details$")
	public void Validate_followUp_fee() {
		assertTrue((Arrays.asList(appointmentPageUtils.appointmentView_followupDetails[0]).contains(bookAppointment_PageUtils.get_consultationFee())));
	}
	@Then("^Check the appointment id \"([^\"]*)\" should removed from my treatment list$") 
	public void check_appointmentID_mytreatment(String appointmentId) throws InterruptedException {
		myTreatment.wait_pageLoadercomplate();
		myTreatment.click_myTreatmentmodule();
		myTreatment.wait_pageLoadercomplate();
		List<String> List_appointmentID = new ArrayList<String>();
		List_appointmentID = Arrays.asList(appointmentId);
		myTreatment.check_cancelled_appointmentID(List_appointmentID);
	}
}