package clinang.patient_Locators;

import org.openqa.selenium.By;

public class Patient_AppointmentLocators{
	
	public By appointmentModule =By.xpath("//a[@href='/portal/appointmentlist/Today']");
	public By appointmentList_today = By.id("Today");
	public By appointmentList_upcoming = By.id("Upcoming");
	public By appointmentList_past = By.id("Past");
	public By appointmentList_cancelled =By.id("Cancelled");
	public By appointment_Loader = By.xpath("//img[class='pl-3 loader']");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
	public By appointmentTable = By.xpath("//table");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By rescheduleButton = By.xpath("//*[(normalize-space(text())='Reschedule')]");
	public By reschedule_comment = By.xpath("//textarea[@formcontrolname='comment']");
	public By submitReschedule =By.xpath("//button[@class='cancel-button mat-raised-button']");
	public By messageBox = By.xpath("//div[@class='msgtext']");
	public By reschedule_get_dateOfappointment = By.xpath("//input[@formcontrolname='dateofappointment']");
	public By slotList_active_check = By.xpath("//div[@class='form-group']//button[@type='button']");
	public By closeAlertbox =By.xpath("//i[@class='mdi mdi-window-close mdi-18px']");
	public By appointmentView_getAppointmentID = By.xpath("//table/div/div[1]/tbody/tr[1]/td");
	public By appointmentView_getSpeciality = By.xpath("//table/div/div[1]/tbody/tr[2]/td");
	public By appointmentView_getClinic =By.xpath("//table/div/div[1]/tbody/tr[3]/td");
	public By appointmentView_getDatetime = By.xpath("//table/div/div[2]/tbody/tr[1]/td");
	public By appointmentView_getType = By.xpath("//table/div/div[2]/tbody/tr[2]/td");
	public By appointmentView_getDoctor = By.xpath("//table/div/div[2]/tbody/tr[3]/td");
	public By appointmentView_comment =By.xpath("//span[@class='ng-star-inserted']//following-sibling::p");
	public By cancelConfirm_alertBox = By.xpath("//div[@class='cancelappt-modal']");
	public By cancelButton = By.xpath("//button[@class='cancel-button mat-raised-button ng-star-inserted']");
	public By cancelConfirm_button =By.xpath("//*[(normalize-space(text())='Confirm')]");
	public By upload_medicalReport = By.id("file");
	public By medicalReport_description = By.xpath("//textarea[@formcontrolname='description']");
	public By submit_medicalReport = By.xpath("//*[(normalize-space(text())='Submit')]");
	public By get_medicalReports_spans = By.xpath("//div[@class='patient-uploads']//*[@class='ng-star-inserted']");

}