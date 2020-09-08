package clinang.pageUtils;

import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_BookAppointmentLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Patient_BookAppointmentPageUtils extends CustomDriver {
	
	Patient_BookAppointmentLocators Bookappoinment_Locators = new Patient_BookAppointmentLocators();
	
	private WebElement goTo_bookAppointment() {
		return findElement(Bookappoinment_Locators.moveTo_bookAppointment);
	}

	public void click_bookAppointment() {
		goTo_bookAppointment().click();
	}
	
	private WebElement mobile() {
		return findElement(Bookappoinment_Locators.mobile);
	}
	
	private WebElement online_radioButton() {
		return findElement(Bookappoinment_Locators.online_radioButton);
	}
	
	private WebElement clinicVisit_radioButton() {
		return findElement(Bookappoinment_Locators.clinicVisit_radioButton);
	}
	
	private WebElement speciality_dropDown() {
		return findElement(Bookappoinment_Locators.specility_dropDown);
	}
	
	public String passAppointmentdetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>appointment_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : appointment_input) {
			  
			  mobile().click();
			  mobile().sendKeys(data.get("mobile"));
			  if(data.get("appointment_type").equals("Online Consultation")) {
				  online_radioButton().click();		  
			  }
			  else if (data.get("appointment_type").equals("Clinic Visit")) {
				  clinicVisit_radioButton().click();
			  }	
			  
			  speciality_dropDown().click();
		  } 
		
		return String.valueOf(appointment_input);
		
		  }	 
	
	
	
	
	
	
}
