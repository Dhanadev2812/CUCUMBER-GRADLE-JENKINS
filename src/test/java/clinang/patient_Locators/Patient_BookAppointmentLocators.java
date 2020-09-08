package clinang.patient_Locators;

import org.openqa.selenium.By;

public class Patient_BookAppointmentLocators  {
	
	public By moveTo_bookAppointment = By.xpath("//a[@href='/portal/book-appointment']");
	public By mobile = By.xpath("//input[@formcontrolname='mobile']");
	public By online_radioButton = By.xpath("//mat-radio-button[@value='online']");
	public By clinicVisit_radioButton = By.xpath("//mat-radio-button[@value='visit_to_clinic']");
	public By specility_dropDown = By.xpath("//div[@class='mat-select-arrow']");
	
}