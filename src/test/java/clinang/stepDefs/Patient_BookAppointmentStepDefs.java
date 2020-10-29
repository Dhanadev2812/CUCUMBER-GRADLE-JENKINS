package clinang.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import clinang.pageUtils.Patient_AppointmentPageUtils;
import clinang.pageUtils.Patient_BookAppointmentPageUtils;
import clinang.pageUtils.Patient_DashboardPageUtils;
import clinang.pageUtils.Patient_MytreatmentPageUtils;
import clinang.pageUtils.Patient_PaymentPageUtils;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_BookAppointmentStepDefs extends CustomDriver {
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	Patient_PaymentPageUtils payment = new Patient_PaymentPageUtils();
	Patient_AppointmentPageUtils appointmentView = new Patient_AppointmentPageUtils();
	Patient_MytreatmentPageUtils myTreatment = new Patient_MytreatmentPageUtils();
	
	
	@And("^Get the patient country$")
	public void get_country() throws InterruptedException {
		dashboard.appointmentCount();
		dashboard.clickEditProfile();
		dashboard.patient_country();
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
	public void check_payNow_enable() throws ParseException {
		B_appointment.get_appointmentDetails();
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
		
		switchTochildWindow();
		B_appointment.wait_razorPayForm();
		B_appointment.razorPay_clickSuccess();
		switchTomainWindow();
		
	}
	
	@Then("^validate the appointment details on payment success screen$")
	public void validate_appointment_details()  {
		B_appointment.get_successForm_appointmentID();
		System.out.println("Appointment Booked Successfully");
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details).contains(B_appointment.appointmentSuccessform_clinic().getText()));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details).contains(B_appointment.appointmentSuccessform_speciality().getText()));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details).contains(B_appointment.appointmentSuccessform_doctor().getText()));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details).contains(B_appointment.appointmentSuccessform_date().getText()));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[10].replace(" ", "")).contains(B_appointment.get_appointmentSuccessform_time().replace(" ", "")));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details).contains(B_appointment.appointmentSuccessform_type().getText()));
		B_appointment.pageLoader();	
	}
	
	@Then("^Check payment details from payment module$")
	public void check_payment_details() throws InterruptedException {
		payment.click_paymentModule();
		payment.pageLoad();
		List<String> appointmentId = Arrays.asList(B_appointment.appointmentID_bookingScreen);
		payment.detailsFromlistPage(appointmentId);
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[6]).equals(Arrays.asList(payment.listPage_doctor)));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[7]).equals(Arrays.asList(payment.listPage_clinic)));
		assertTrue(Arrays.asList(B_appointment.consultationFee_appointmentBooking).equals(Arrays.asList(payment.listPage_amount)));
		System.out.println("Payment details stored on payment module");
	}
	
	@Then("^Check the appointment count from dashboard module$")
	public void check_dashboard_appointmentCount() throws InterruptedException {
		
		dashboard.dashboardField().click();
		dashboard.wait_profileView();
		Thread.sleep(5000);
		String providedDate = (B_appointment.expectedDate+"/"+B_appointment.expectedMonth_F02+"/"+B_appointment.expectedYear);
		String Currentdate = (B_appointment.current_date+"/"+B_appointment.current_month+"/"+B_appointment.current_year);
		int size = dashboard.dashboard_appointmentCount.length;
	    int [] arr = new int [size];    
	    arr[0] = Integer.parseInt(dashboard.dashboard_appointmentCount[0]);
	    arr[1] = Integer.parseInt(dashboard.dashboard_appointmentCount[1]);
		if(providedDate.equals(Currentdate)) {	
				
				assertTrue((Arrays.asList(arr[0]+1).toString()).contains(dashboard.getCount_todayApp()));
				System.out.println("Appointment count updated on dashboard");
		   }
			
		else {
			assertTrue((Arrays.asList(arr[1]+1).toString()).contains(dashboard.getCount_upcomingApp()));
			System.out.println("Appointment count updated on dashboard");
		}
	}
	
	@Then("^validate the appointment details from appointment view page$")
	public void validate_appointmentDetails_viewPage() throws ParseException, InterruptedException {
		B_appointment.clickViewappointment();
		appointmentView.wait_pageLoadercomplate();
		appointmentView.get_appointmentDetails_viewPage();
		assertTrue(Arrays.asList(B_appointment.appointmentID_bookingScreen[0]).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[0])));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[11].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[5].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[5].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[1].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[4].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[3].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[7].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[2].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[6].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[4].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[8].replace(" ", "")).equals(Arrays.asList(appointmentView.appointmentViewpage_getDetails[6].replace(" ", ""))));	
		
			if((Arrays.asList(B_appointment.bookAppointment_details[4].replace(" ", "")).toString().contains(("Online Consultation").replace(" ", "")))) {
				assertTrue(B_appointment.appointmentView_videoCall().getText().equalsIgnoreCase("Video Call"));
			}
			else if((Arrays.asList(B_appointment.bookAppointment_details[4].replace(" ", "")).toString().contains(("Clinic Visit").replace(" ", "")))) {
				assertFalse(B_appointment.appointmentView_videoCall().getText().equalsIgnoreCase("Video Call"));
				}
			}
	
	@Then("^Check the appointment details from my treatment module$")
	public void check_myTreatment_appointmentDetails() {
		myTreatment.click_myTreatmentmodule();
		myTreatment.wait_pageLoadercomplate();
		List<String> List_appointmentID = new ArrayList<String>();
		List_appointmentID = Arrays.asList(B_appointment.appointmentID_bookingScreen);
		myTreatment.get_Mytreatmentdetails_listPage(List_appointmentID);
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[11].replace(" ", "")).equals(Arrays.asList(myTreatment.myTreatment_gridDetails[0].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[4].replace(" ", "")).equals(Arrays.asList(myTreatment.myTreatment_gridDetails[1].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[5].replace(" ", "")).equals(Arrays.asList(myTreatment.myTreatment_gridDetails[2].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[6].replace(" ", "")).equals(Arrays.asList(myTreatment.myTreatment_gridDetails[3].replace(" ", ""))));
		assertTrue(Arrays.asList(B_appointment.bookAppointment_details[7].replace(" ", "")).equals(Arrays.asList(myTreatment.myTreatment_gridDetails[4].replace(" ", ""))));
		System.out.println("Appointment details stored on my treatment module");
	}
}
