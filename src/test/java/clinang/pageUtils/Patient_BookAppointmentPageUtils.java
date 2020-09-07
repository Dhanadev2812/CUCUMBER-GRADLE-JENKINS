package clinang.pageUtils;

import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_BookAppointmentLocators;
import clinang.webDriverUtils.CustomDriver;

import org.openqa.selenium.By;

public class Patient_BookAppointmentPageUtils extends CustomDriver {
	
	Patient_BookAppointmentLocators Bookappoinment_Locators = new Patient_BookAppointmentLocators();
	
	private WebElement goTo_bookAppointment() {
		return findElement(Bookappoinment_Locators.moveTo_bookAppointment);
	}

	public void click_bookAppointment() {
		goTo_bookAppointment().click();
	}
	
	
	
	
	
	
}
