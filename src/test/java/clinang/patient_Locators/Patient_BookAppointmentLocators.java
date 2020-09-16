package clinang.patient_Locators;

import org.openqa.selenium.By;

public class Patient_BookAppointmentLocators  {
	
	public By moveTo_bookAppointment = By.xpath("//a[@href='/portal/book-appointment']");
	public By mobile = By.xpath("//input[@formcontrolname='mobile']");
	public By online_radioButton = By.xpath("//mat-radio-button[@value='online']");
	public By clinicVisit_radioButton = By.xpath("//mat-radio-button[@value='visit_to_clinic']");
	public By specility_dropDown = By.xpath("//*[@formcontrolname='speciality']/div/div[2]/div");
	public By doctor_dropDown = By.xpath("//*[@formcontrolname='doctor']/div/div[2]/div");
	public By open_calenderField =By.xpath("//button[@aria-label='Open calendar']");
	public By CurrentPeriod = By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]");
	public By Currentyear=By.xpath("//button[@aria-label='Choose date']");
	public By previousArrow = By.xpath("//button[@aria-label='Previous 20 years']");
	public By nextArrow =By.xpath("//button[@aria-label='Next 20 years']");
	public By chiefComment = By.xpath("//textarea[@formcontrolname='comment']");
	public By slot_row_null = By.xpath("//p[@class='center']");
	public By slot_get = By.xpath("//div[@class='form-group']//*[@class='ng-star-inserted']//descendant::span");
	public By payNow_button = By.xpath("//button[@class='paynow-btn mat-raised-button']");
	public By consultationFee = By.xpath("//p[@class='text-center']");
	public By card = By.xpath("//div[(normalize-space(text())='Card')]");
	public By upi = By.xpath("//div[(normalize-space(text())='UPI / QR')]");
	public By netbanking = By.xpath("//div[(normalize-space(text())='Netbanking')]");
	public By wallet = By.xpath("//div[(normalize-space(text())='Wallet')]");
	public By emi = By.xpath("//div[(normalize-space(text())='EMI')]");
	public By iframe_in =By.xpath("//iframe[@class='razorpay-checkout-frame']");
	public By payment_form = By.id("content");
}