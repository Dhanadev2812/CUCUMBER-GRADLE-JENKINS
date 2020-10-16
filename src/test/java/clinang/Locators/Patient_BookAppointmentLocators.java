package clinang.Locators;

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
	public By speciality_dropDown = By.xpath("//*[@formcontrolname='speciality']/div");
	public By doctor_dropDown = By.xpath("//*[@formcontrolname='doctor']/div/div[1]");
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
	public By card = By.xpath("//button[@method='card']");
	public By upi = By.xpath("//button[@method='upi']");
	public By netbanking = By.xpath("//button[@method='netbanking']");
	public By wallet = By.xpath("//button[@method='wallet']");
	public By emi = By.xpath("//button[@method='emi']");
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
	public By paymentForm_pay = By.id("footer");
	public By razorPay_form = By.xpath("//form[@method='post']");
	public By razorPay_success = By.xpath("//button[@class='success']");
	public By razorPay_failure =By.xpath("//button[@class='danger']");
	public By pageLoader = By.xpath("//*[@class='loader-container ng-star-inserted']");
	public By viewAppointmentButton = By.xpath("//span[(normalize-space(text())='View Appointment')]");
	public By wait_netBanking_form = By.xpath("//div[@tab='netbanking']");
	public By search_bank = By.xpath("//button[@id='bank-select']");
	public By bankSearch_textField = By.xpath("//input[@class='no-escape svelte-1l2wmbb']");
	public By appointment_successForm_speciality = By.xpath("//table/div/div[1]/tbody/tr[1]/td");
	public By appointment_successForm_date = By.xpath("//table/div/div[2]/tbody/tr[1]/td");
	public By appointment_successForm_clinic = By.xpath("//table/div/div[1]/tbody/tr[2]/td");
	public By appointment_successForm_time = By.xpath("//table/div/div[2]/tbody/tr[2]/td");
	public By appointment_successForm_doctor = By.xpath("//table/div/div[1]/tbody/tr[3]/td");
	public By appointment_successForm_type = By.xpath("//table/div/div[2]/tbody/tr[3]/td");
	public By appointment_successForm_appointmentID = By.xpath("//div[@class='col-lg-10']");
	public By appointmentView_videoCallicon = By.xpath("//div[@class='button-right']");
	
	
}