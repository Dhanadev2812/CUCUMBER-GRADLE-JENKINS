package clinang.patient_Locators;

import org.openqa.selenium.By;

public class Patient_BookAppointmentLocators  {
	
	public By moveTo_bookAppointment = By.xpath("//a[@href='/portal/book-appointment']");
	public By mobile = By.xpath("//input[@formcontrolname='mobile']");
	public By online_radioButton = By.xpath("//mat-radio-button[@value='online']");
	public By clinicVisit_radioButton = By.xpath("//mat-radio-button[@value='visit_to_clinic']");
	public By specility_dropDown = By.xpath("//*[@formcontrolname='speciality']/div/div[2]/div");
	public By doctor_dropDown = By.xpath("//*[@id='mat-select-1']/div/div[2]/div");
	public By open_calenderField =By.xpath("//button[@aria-label='Open calendar']");
	public By CurrentPeriod = By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]");
	public By Currentyear=By.xpath("//button[@aria-label='Choose date']");
	public By previousArrow = By.xpath("//button[@aria-label='Previous 20 years']");
	public By nextArrow =By.xpath("//button[@aria-label='Next 20 years']");
	public By chiefComment = By.xpath("//textarea[@formcontrolname='comment']");
	public By slot_row_null = By.xpath("//p[@class='center']");
	public By slot_get = By.xpath("//*[@class='slot-button1 mat-raised-button']");
	
}