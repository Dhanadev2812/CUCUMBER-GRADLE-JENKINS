package clinang.patient_Locators;

import org.openqa.selenium.By;

public class Patient_BookAppointmentLocators  {
	
	public By moveTo_bookAppointment = By.xpath("//a[@href='/portal/book-appointment']");
	public By firstName_appointmentFrom= By.xpath("//input[@formcontrolname='fname']");
	public By lastName_appointmentFrom = By.xpath("//input[@formcontrolname='lname']");
	public By email_appointmentFrom = By.xpath("//input[@formcontrolname='email']");
	public By mobile = By.xpath("//input[@formcontrolname='mobile']");
	public By online_radioButton = By.xpath("//mat-radio-button[@value='online']");
	public By clinicVisit_radioButton = By.xpath("//mat-radio-button[@value='visit_to_clinic']");
	public By speciality_field = By.xpath("//*[@formcontrolname='speciality']/div/div[1]");
	public By doctor_field =By.xpath("//*[@formcontrolname='doctor']/div/div[1]");
	public By clinic_field =By.xpath("//input[@formcontrolname='clinic']");
	public By speciality_dropDown = By.xpath("//*[@formcontrolname='speciality']/div/div[2]/div");
	public By doctor_dropDown = By.xpath("//*[@formcontrolname='doctor']/div/div[2]/div");
	public By dateOfappointment_field = By.xpath("//input[@formcontrolname='dateofappointment']");
	public By open_calenderField =By.xpath("//button[@aria-label='Open calendar']");
	public By CurrentPeriod = By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]");
	public By Currentyear=By.xpath("//button[@aria-label='Choose date']");
	public By previousArrow = By.xpath("//button[@aria-label='Previous 20 years']");
	public By nextArrow =By.xpath("//button[@aria-label='Next 20 years']");
	public By chiefComment = By.xpath("//textarea[@formcontrolname='comment']");
	public By slotList_active_check = By.xpath("//div[@class='form-group']//button[@type='button']");
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
	public By skipSavedcard = By.id("otp-sec");
	public By paymentForm_mobile = By.id("user");
	public By paymentForm_amount = By.id("amount");
	public By card_cardNum = By.id("card_number");
	public By card_cardExpiry = By.id("card_expiry");
	public By card_holderName = By.id("card_name");
	public By card_cvv = By.id("card_cvv");
	public By rememberCard = By.id("should-save-card");
	public By paymentForm_pay = By.id("footer-cta");
	public By razorPay_form = By.xpath("//form[@method='post']");
	public By razorPay_success = By.xpath("//button[@class='success']");
	public By razorPay_failure =By.xpath("//button[@class='danger']");
	public By viewAppointmentButton = By.xpath("//div[(normalize-space(text())='View Appointment')]");
}