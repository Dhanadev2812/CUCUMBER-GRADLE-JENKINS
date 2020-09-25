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
}