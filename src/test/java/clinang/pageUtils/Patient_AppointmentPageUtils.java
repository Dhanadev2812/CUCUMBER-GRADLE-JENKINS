package clinang.pageUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_AppointmentLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_AppointmentPageUtils extends CustomDriver{
	
	Patient_AppointmentLocators appointmentLocators = new Patient_AppointmentLocators();
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	
	private WebElement appointmentModule() {
		return findElement(appointmentLocators.appointmentModule);
	}
	
	public void Click_appointmentModule() {
		appointmentModule().click();
	}
	
	private WebElement appointmentList_today() {
		return findElement(appointmentLocators.appointmentList_today);
	}
	
	public void Click_appointmentList_today() {
		appointmentList_today().click();
	}
	
	private WebElement appointmentList_upcoming() {
		return findElement(appointmentLocators.appointmentList_upcoming);
	}
	
	public void Click_appointmentList_upcoming() {
		appointmentList_upcoming().click();
	}
	
	private WebElement appointmentList_past() {
		return findElement(appointmentLocators.appointmentList_past);
	}
	
	public void Click_appointmentList_past() {
		appointmentList_past().click();
	}
	
	private WebElement appointmentList_cancelled() {
		return findElement(appointmentLocators.appointmentList_cancelled);
	}
	
	public void Click_appointmentList_cancelled() {
		appointmentList_cancelled().click();
	}
	
	private WebElement paginationNext() {
		return findElement(appointmentLocators.paginationNext);
	}
	
	private WebElement wait_appointmentTable() {
		return findElement(appointmentLocators.appointmentTable);
	}
	
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	
	private WebElement grid_viewAppointment(String appointmentID) {
		return findElement(By.xpath("//td[contains(text(),'"+ appointmentID +"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View Appointment']"));
	}
	
	private WebElement reschedulebutton() {
		return findElement(appointmentLocators.rescheduleButton);
	}
	
	public void Click_reschedule() {
		reschedulebutton().click();
	}
	
	public WebElement slot(String slot) {
		return findElement(By.xpath("//span[(normalize-space(text())"+"="+"'"+slot+"'"+")]"));	
	}
	
	private WebElement comment() {
		return findElement(appointmentLocators.reschedule_comment);
	}
	
	public void enter_rescheduleComment(String comment) {
		comment().sendKeys(comment);
	}
	
	private WebElement submitReschedule_button() {
		return findElement(appointmentLocators.submitReschedule);
	}
	
	public void submit_Reschedule() {
		submitReschedule_button().click();
	}
	
	private WebElement messageBox() {
		return findElement(appointmentLocators.messageBox);
	}
	
	public String get_message() {
		return messageBox().getText();
	}
	
	public void wait_pageLoadercomplate() {
		 Loader(appointmentLocators.appointment_Loader);
	}
	public void findAppointment(String appointmentID ) {
		
		wait_pageLoadercomplate();
		whileLoop:
		while(true) {
			
			if(wait_appointmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(appointmentLocators.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {			
						if(appointmentID.contains(grid_appointmentID(i).getText())) {
							grid_viewAppointment(appointmentID).click();
							wait_pageLoadercomplate();
							break whileLoop;															 			 
						} i++;
					} 
				if(paginationNext().isEnabled()==true) {
					paginationNext().click();
					}														
				}	
			}
	}
	
	public void reschedule() {
		Click_reschedule();
		
	}
}