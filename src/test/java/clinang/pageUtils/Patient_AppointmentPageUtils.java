package clinang.pageUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_AppointmentLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_AppointmentPageUtils extends CustomDriver{
	
	Patient_AppointmentLocators appointmentLocators = new Patient_AppointmentLocators();
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	private String activeSlot;
	public String[] reschedule_appointmentDetails;
	public String[] appointmentViewpage_getDetails;
	private String appointmentDateTime;
	
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
	
	private WebElement reschedule_dateOfappointment() {
		return findElement(appointmentLocators.reschedule_get_dateOfappointment);
	}
	
	private List<WebElement> slot_activeCheck() {
		return findElement_list(appointmentLocators.slotList_active_check);
	}
	
	private WebElement reschedule_closeAlert() {
		return findElement(appointmentLocators.reschedule_closeAlert);
	}
	
	public void click_reschedule_closeAlert() {
		reschedule_closeAlert().click();
	}
	
	private WebElement appointmentView_getAppointmentID() {
		return findElement(appointmentLocators.appointmentView_getAppointmentID);
	}
	
	private WebElement appointmentView_getSpeciality() {
		return findElement(appointmentLocators.appointmentView_getSpeciality);
	}
	
	private WebElement appointmentView_getClinic() {
		return findElement(appointmentLocators.appointmentView_getClinic);
	}
	
	private WebElement appointmentView_getDatetime() {
		return findElement(appointmentLocators.appointmentView_getDatetime);
	}
	
	private WebElement appointmentView_getType() {
		return findElement(appointmentLocators.appointmentView_getType);
	}
	
	private WebElement appointmentView_getDoctor() {
		return findElement(appointmentLocators.appointmentView_getDoctor);
	}
	
	private WebElement appointmentView_comment() {
		return findElement(appointmentLocators.appointmentView_comment);
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
		
	public void get_rescheduleDetails() throws ParseException {
		String dateOfappointment_reschedulePage = reschedule_dateOfappointment().getAttribute("value");		
		
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
	    SimpleDateFormat format2 = new SimpleDateFormat("MMM dd, yyyy");
	    Date date = format1.parse(dateOfappointment_reschedulePage);
	    String appointmentDate = format2.format(date);
	    
	    List<WebElement> spanList = slot_activeCheck();	
		for( WebElement slot: spanList){
			String getClass =slot.getAttribute("class");
			if(getClass.contains("activeslotbutton")) {
				activeSlot = slot.getText();
				
				 break;
			}						
		}
		
		String reschedule_comment = comment().getAttribute("value");
		String appointment = appointmentDate +" "+activeSlot;	
		this.reschedule_appointmentDetails = new String[] {appointment,reschedule_comment};
	}
	
	public void get_appointmentDetails_viewPage() throws ParseException {
		
		String appointmentID = appointmentView_getAppointmentID().getText();	
		String speciality = appointmentView_getSpeciality().getText();
		String clinic = appointmentView_getClinic().getText();
		String dateAndtime = appointmentView_getDatetime().getText();
		String type = appointmentView_getType().getText();
		String doctor = appointmentView_getDoctor().getText();
		String comment = appointmentView_comment().getText();
		
		String[] appointmentTime=appointmentView_getDatetime().getText().split(" ");
		
		if(appointmentTime[3].startsWith("0")) {
			String[] appointmentTime_hr = appointmentTime[3].split(":");
			String appointmentHr_replace = appointmentTime_hr[0].replace("0", " ");
			String newAppointmenttime = appointmentHr_replace+":"+appointmentTime_hr[1]+" "+appointmentTime[4];
			 appointmentDateTime = appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+newAppointmenttime;
		}	
		
		else {
			appointmentDateTime =  appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+" "+appointmentTime[3]+" "+appointmentTime[4];
		}
		
		this.appointmentViewpage_getDetails = new String[] {appointmentID,speciality,clinic,type,doctor,appointmentDateTime,comment};
		
	}
}