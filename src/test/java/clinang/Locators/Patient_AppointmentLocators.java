package clinang.Locators;

import org.openqa.selenium.By;

public class Patient_AppointmentLocators{
	
	public By appointmentModule =By.xpath("//a[@href='/portal/appointmentlist/Today']");
	public By appointmentList_today = By.xpath("//*[(normalize-space(text())='Today')]");
	public By appointmentList_upcoming = By.xpath("//*[(normalize-space(text())='Upcoming')]");
	public By appointmentList_past = By.xpath("//*[(normalize-space(text())='Past')]");
	public By appointmentList_cancelled =By.xpath("//*[(normalize-space(text())='Cancelled')]");
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
	public By appointmentView_comment =By.xpath("//mat-card/div[3]/div/div[3]//following-sibling::p");
	public By appointmentView_followUpcomment =By.xpath("//mat-card/div[3]/div/div[4]//following-sibling::p");
	public By cancelConfirm_alertBox = By.xpath("//div[@class='cancelappt-modal']");
	public By cancelButton = By.xpath("//button[@class='cancel-button mat-raised-button ng-star-inserted']");
	public By cancelConfirm_button =By.xpath("//*[(normalize-space(text())='Confirm')]");
	public By upload_medicalReport = By.id("file");
	public By medicalReport_description = By.xpath("//textarea[@formcontrolname='description']");
	public By submit_medicalReport = By.xpath("//*[(normalize-space(text())='Submit')]");
	public By get_medicalReports_spans = By.xpath("//div[@class='patient-uploads']//*[@class='ng-star-inserted']");
	public By deleteReport_confirm = By.xpath("//button[@class='delbtn mat-raised-button']//child::span[(normalize-space(text())='Yes')]");
	public By patientUploads = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']");
	public By bookFollowup_button = By.xpath("//*[(normalize-space(text())='Book Follow Up')]");
	public By bookFollowup_fee = By.xpath("//mat-dialog-content[@class='mat-dialog-content']//child::tbody/tr[1]/td");
	public By bookFollowup_comment =By.xpath("//mat-dialog-content[@class='mat-dialog-content']//child::tbody/tr[2]/td");
	public By accept_bookFollowup = By.xpath("//mat-dialog-content[@class='mat-dialog-content']//child::button/span[(normalize-space(text())='Book Follow Up')]");
	public By appointment_tbody = By.xpath("//table[@class='mat-table']//child::tbody");
}