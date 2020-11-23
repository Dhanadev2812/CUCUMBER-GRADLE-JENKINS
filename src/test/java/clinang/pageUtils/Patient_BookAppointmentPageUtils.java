package clinang.pageUtils;

import org.openqa.selenium.WebElement;

import clinang.Locators.Patient_BookAppointmentLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

public class Patient_BookAppointmentPageUtils extends CustomDriver {
	
	Patient_BookAppointmentLocators Bookappoinment_Locators = new Patient_BookAppointmentLocators();
	Patient_DashboardPageUtils editProfile = new Patient_DashboardPageUtils();
	
	String givenDate;
	public Integer current_date;
	public Integer current_month;
	public Integer current_year;
	private String CurrentTime_newTimeformat;
	public int expectedDate;
	public Integer expectedMonth_F02;
	public Integer expectedYear;
	private String requiredDate;
	private String monthRequired;
	private String requiredYear;
	private String appointmentType_appointmentPage;
	private String activeSlot;
	public static String[] appointmentID_bookingScreen;
	public static String[] bookAppointment_details = null;
	public static String[] consultationFee_appointmentBooking = null;
	
	
	private WebElement goTo_bookAppointment() {
		return findElement(Bookappoinment_Locators.moveTo_bookAppointment);
	}

	public void click_bookAppointment() {
		goTo_bookAppointment().click();
	}
	private WebElement firstName() {
		return findElement(Bookappoinment_Locators.firstName_appointmentFrom);
	}
	private WebElement lastName() {
		return findElement(Bookappoinment_Locators.lastName_appointmentFrom);
	}
	private WebElement email() {
		return findElement(Bookappoinment_Locators.email_appointmentFrom);
	}
	public WebElement mobile() {
		return findElement(Bookappoinment_Locators.mobile);
	}
	
	public WebElement online_radioButton() {
		return findElement(Bookappoinment_Locators.online_radioButton);
	}
	
	public WebElement clinicVisit_radioButton() {
		return findElement(Bookappoinment_Locators.clinicVisit_radioButton);
	}
	
	private WebElement specialityField() {
		return findElement(Bookappoinment_Locators.speciality_field);
	}
	
	private WebElement speciality_dropDown() {
		return waitForElementClick(Bookappoinment_Locators.speciality_dropDown);
	}
	private void moveTospeciality_dropDown() {
		 scrollTofindElement(speciality_dropDown());
	}
	private WebElement selectSpeciality(String speciality) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+speciality+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement doctorField() {
		return findElement(Bookappoinment_Locators.doctor_field);
	}
	private WebElement doctor_dropDown() {
		return waitForElementClick(Bookappoinment_Locators.doctor_dropDown);
	}
	private void moveTodoctor_dropDown() {
		 scrollTofindElement(doctor_dropDown());
	}
	private WebElement select_doctor(String doctor) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+doctor+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement clinicField() {
		return findElement(Bookappoinment_Locators.clinic_field);
	}
	
	public WebElement chiefComment() {
		return findElement(Bookappoinment_Locators.chiefComment);
	}
	
	private WebElement dateOfappointment() {
		return findElement(Bookappoinment_Locators.dateOfappointment_field);
	}
	//datepicker
	private WebElement open_calenderField() {
		return findElement(Bookappoinment_Locators.open_calenderField);
	}
	
	public void openCalender() {
		open_calenderField().click();
	}
	
	 public WebElement CurrentPeriod() {
		 return findElement(Bookappoinment_Locators.CurrentPeriod);
	 }
	 
	public void view_yearTable() {
		CurrentPeriod().click();
	}
	private WebElement Currentyear() {
		return findElement(Bookappoinment_Locators.Currentyear);
	}
	
	private WebElement previousArrow() {
		return findElement(Bookappoinment_Locators.previousArrow);
	}
	
	private WebElement nextArrow() {
		return findElement(Bookappoinment_Locators.nextArrow);
	}
	
	private WebElement yearTable(String YEAR) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+YEAR+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectMonth(String MONTH) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+MONTH+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectDate(String DATE) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+DATE+"'"+")]/ancestor::td"));
	}
	private List<WebElement> slot_activeCheck() {
		return findElement_list(Bookappoinment_Locators.slotList_active_check);
	}
	private WebElement slotForm_null() {
		return findElement(Bookappoinment_Locators.slot_row_null);
	}
	
	private List<WebElement> slot_get() {	
		return findElement_list(Bookappoinment_Locators.slot_get);	
	}
	
	private WebElement slot(String slot) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+slot+"'"+")]"));	
	}
	
	public void clickSlot(String slot) {
		System.out.println("Finding provided slots");
		slot(slot).click();
	}
	
	public WebElement payNow_button() {
		return findElement(Bookappoinment_Locators.payNow_button);
	}
	
	public void clickPaynow() {
		payNow_button().click();
	}
	
	private WebElement consultationFee() {
		return findElement(Bookappoinment_Locators.consultationFee);
	}
	
	public String get_consultationFee() {
		String text = consultationFee().getText();
		String[] fee=text.split(" ");
		String consultation_fee = fee[8].replaceAll("[^0-9.]", "");
		this.consultationFee_appointmentBooking = new String[] {consultation_fee};
		return consultation_fee;	
	}
	
	private WebElement iframe_in() {
		return findElement(Bookappoinment_Locators.iframe_in);
	}
	
	public void switch_frameIn() {
		switchToIframe(iframe_in());
	}
	
	public void switch_frameOut() {
		switchOutOfIframe();
	}
	
	private WebElement wait_paymentForm() {
		return waitForElementDisplayed(Bookappoinment_Locators.payment_form);
	}
	
	private WebElement card() {
		return waitForElementClick(Bookappoinment_Locators.card);
	}
	
	private WebElement upi() {
		return waitForElementClick(Bookappoinment_Locators.upi);
	}
	
	private WebElement netbanking() {
		return waitForElementClick(Bookappoinment_Locators.netbanking);
	}
	
	private WebElement wallet() {
		return waitForElementClick(Bookappoinment_Locators.wallet);
	}
	
	private WebElement emi() {
		return waitForElementClick(Bookappoinment_Locators.emi);
	}
	
	private WebElement skipSavedcard() {
		return findElement(Bookappoinment_Locators.skipSavedcard);
	}
	
	private WebElement paymentForm_mobile() {
		return waitForElementDisplayed(Bookappoinment_Locators.paymentForm_mobile);
	}
	
	private WebElement paymentForm_amount() {
		return waitForElementDisplayed(Bookappoinment_Locators.paymentForm_amount);
	}
	
	public String get_paymentForm_amount() {
		String paymentAmount = paymentForm_amount().getText();
		  String[] fee=paymentAmount.split(" ");
		  String paymentForm_amount = fee[1].replaceAll("[^0-9.]", "");
		  return paymentForm_amount;
	}
	
	private WebElement cardNumber() {
		return findElement(Bookappoinment_Locators.card_cardNum);
	}
	
	private WebElement cardExpirey() {
		return findElement(Bookappoinment_Locators.card_cardExpiry);
	}
	
	private WebElement cardHolder() {
		return findElement(Bookappoinment_Locators.card_holderName);
	}
	private WebElement cardCvv() {
		return findElement(Bookappoinment_Locators.card_cvv);
	}

	private WebElement cardRemember() {
		return findElement(Bookappoinment_Locators.rememberCard);
	}	
	private WebElement enterUPI() {
		return findElement(Bookappoinment_Locators.enterUpi);
	}
	private WebElement upi_errorMessage() {
		return findElement(Bookappoinment_Locators.upi_errorMessage);
	}
	private WebElement upiForm() {
		return findElement(Bookappoinment_Locators.upiForm);
	}
	private WebElement wallet_mobikwik() {
		return findElement(Bookappoinment_Locators.wallet_mobikwik);
	}
	private WebElement wallet_freecharger() {
		return findElement(Bookappoinment_Locators.wallet_freecharger);
	}
	private WebElement wallet_airtelMoney() {
		return findElement(Bookappoinment_Locators.wallet_airtelMoney);
	}
	private WebElement wallet_jioMoney() {
		return findElement(Bookappoinment_Locators.wallet_jioMoney);
	}
	private WebElement wallet_payzapp() {
		return findElement(Bookappoinment_Locators.wallet_payzapp);
	}
	private WebElement wait_netBankingform() {
		return waitForElementDisplayed(Bookappoinment_Locators.wait_netBanking_form);
	}
	
	private WebElement netBanking_grid_bankList(String Bank) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+Bank+"'"+")]"));
	}
	
	private WebElement searchBank() {
		return findElement(Bookappoinment_Locators.search_bank);
	}
	
	private WebElement bankSearch_textField() {
		return findElement(Bookappoinment_Locators.bankSearch_textField);
	}
	
	private WebElement bankList() {
		return findElement(By.xpath("//div[@class='list svelte-1l2wmbb']"));
	}
	
	private WebElement bankType(String bankType) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+bankType+"'"+")]"));
	}
	
	private WebElement payment_pay() {
		return findElement(Bookappoinment_Locators.paymentForm_pay);
	}
	private void moveTo_payment_pay() {
		 scrollTofindElement(payment_pay());
	}
	
	public WebElement wait_razorPayForm() {
		return waitForElementDisplayed(Bookappoinment_Locators.razorPay_form);
	}
	
	private WebElement razorPaysuccess() {
		return waitForElementDisplayed(Bookappoinment_Locators.razorPay_success);
	}
	
	private WebElement  razorPayFailure() {
		return waitForElementDisplayed(Bookappoinment_Locators.razorPay_failure);
	}
	
	public void razorPay_clickSuccess() {
		razorPaysuccess().click();
	}
	
	public void razorPay_clickFailure() {
		razorPayFailure().click();
	}
	
	public void pageLoader() {
		 Loader(Bookappoinment_Locators.pageLoader);
	}
	private WebElement viewAppointmentButton() {
		return waitForElementDisplayed(Bookappoinment_Locators.viewAppointmentButton);
	}
	
	public void clickViewappointment()  {
		viewAppointmentButton().click();
	}
	
	public WebElement appointmentSuccessform_speciality() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_speciality);
	}
	
	public  WebElement appointmentSuccessform_date() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_date);
	}
	
	public  WebElement appointmentSuccessform_clinic() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_clinic);
	}
	
	public  WebElement appointmentSuccessform_time() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_time);
	}
	public String get_appointmentSuccessform_time() {
		String[] appointmentTime=appointmentSuccessform_time().getText().split(":");
		String appointmentTime_Hours = appointmentTime[0];
		if(appointmentTime_Hours.startsWith("0")) {
			String appointmentTime_replace = appointmentTime_Hours.replace("0", " ");
			String newAppointmenttime = appointmentTime_replace+":"+appointmentTime[1];
			return newAppointmenttime;
		}	
		else {
			String appointment_Time = appointmentSuccessform_time().getText();
			return appointment_Time;
		}
		
	}
	
	public  WebElement appointmentSuccessform_doctor() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_doctor);
		
	}
	
	public  WebElement appointmentSuccessform_type() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_type);
	}
	
	public WebElement appointmentSuccessform_appointmentID() {
		return waitForElementDisplayed(Bookappoinment_Locators.appointment_successForm_appointmentID);
	}
	public WebElement appointmentView_videoCall() {
		return findElement(Bookappoinment_Locators.appointmentView_videoCallicon);
	}
	
	public String get_successForm_appointmentID() {
		String[] appointmentID=appointmentSuccessform_appointmentID().getText().split(" ");
		String appointment_ID = appointmentID[7];
		this.appointmentID_bookingScreen = new String[] {appointment_ID};
		return appointment_ID;
	}
	public String passAppointmentdetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>appointment_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : appointment_input) {
			  
			  mobile().click();
			  mobile().clear();
			  mobile().sendKeys(data.get("mobile"));
			  if(data.get("appointment_type").equals("Online Consultation")) {
				  online_radioButton().click();		  
			  }
			  else if (data.get("appointment_type").equals("Clinic Visit")) {
				  clinicVisit_radioButton().click();
			  }		  
			  moveTospeciality_dropDown();
			  Thread.sleep(5000);
			  speciality_dropDown().click();
			  selectSpeciality(data.get("speciality")).click();
			  moveTodoctor_dropDown();
			  Thread.sleep(5000);
			  doctor_dropDown().click();
			  select_doctor(data.get("doctor")).click();
			  chiefComment().sendKeys(data.get("chief_complaint"));
		  } 
		
		return String.valueOf(appointment_input);
		
		  }	 
	
	public void get_dateOfappointment(String dateofappointment) throws ParseException  {
		
		final String givenDateFormat = "dd/MM/yyyy";
		final String year = "yyyy";
		final String month = "MMM";
		final String date = "dd";
		givenDate = dateofappointment;	

		SimpleDateFormat year_format = new SimpleDateFormat(givenDateFormat);
		Date Year = year_format.parse(givenDate);
		year_format.applyPattern(year);
		requiredYear = year_format.format(Year);
	
		SimpleDateFormat month_format = new SimpleDateFormat(givenDateFormat);
		Date Month = month_format.parse(givenDate);
		month_format.applyPattern(month);
		String requiredMonth = month_format.format(Month);
		
		SimpleDateFormat date_format = new SimpleDateFormat(givenDateFormat);
		Date Date = date_format.parse(givenDate);
		date_format.applyPattern(date);
		requiredDate = date_format.format(Date);
		
		expectedYear=Integer.valueOf((requiredYear).replaceAll(" ", ""));
		expectedDate = Integer.valueOf((requiredDate).replaceAll(" ", ""));
		monthRequired = requiredMonth.toUpperCase();
		
		String[] expectedMonth_F2 = givenDate.split("/"); 	
		expectedMonth_F02 =Integer.valueOf(expectedMonth_F2[1].replaceAll(" ", ""));

	}
	
	public void selectDatefromDatepicker() {
		
		open_calenderField().click();
		view_yearTable();
		
		while(true)
			
			if(requiredYear!=null) {
				String years = Currentyear().getText();
				String[] yearList = years.split("–"); 	
				int strat_year=Integer.valueOf(yearList[0].replaceAll(" ", ""));
				int end_year = Integer.valueOf(yearList[1].replaceAll(" ", ""));
				
				if(expectedYear>=strat_year && expectedYear<=end_year) {
					 if(yearTable(requiredYear).isDisplayed()== true) {
					 yearTable(requiredYear).click();	
					 selectMonth(monthRequired).click();
					 if(requiredDate.startsWith("0")) {
						 String requiredDate_replace = requiredDate.replace("0", "");
						 selectDate(requiredDate_replace).click();
					 }
					 else {
						 selectDate(requiredDate).click();
					 }
					 

				 } 	break;					
				} 
				else if(expectedYear<strat_year) {
					 previousArrow().click();	
			}		
				else if(expectedYear>end_year) {
						nextArrow().click();
					}	
				}
			else {
				break;
			}		
	}
	
	public void currentDateandTime(String Zone) {
		
		Instant instant = Instant.now();
		LocalDateTime dateTimeInstant = LocalDateTime.ofInstant(instant, ZoneId.of(Zone));
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
		String date = dateTimeInstant.format(formatDate);
		
		long n = 2;
		LocalDateTime extraTime = dateTimeInstant.plusHours(n);
		CurrentTime_newTimeformat = extraTime.format(formatTime);
		
		String[] current_date_split = date.split("/"); 	
		current_date=Integer.valueOf(current_date_split[0].replaceAll("//s+", ""));
		current_month = Integer.valueOf(current_date_split[1].replaceAll("//s+", ""));
		current_year = Integer.valueOf(current_date_split[2].replaceAll("//s+", ""));
	}
	
	public void compare_date() {
		
		if(expectedYear<current_year) {
			System.out.println("PAST YEAR");
			assert false;	
		}
		else if(expectedYear>current_year) {
			assert true;	
		}
		else if(expectedYear.equals(current_year)) {
			if(expectedMonth_F02<current_month) {
				System.out.println("PAST MONTH");
				assert false;
			}
			else if(expectedMonth_F02>current_month) {
				assert true;
			}
			else if(expectedMonth_F02.equals(current_month)) {
				if(expectedDate<current_date) {
					assert false;
					System.out.println("PAST DATE");
				}
				else if(expectedDate>current_date) {
					assert true;
				}
				else if(expectedDate==current_date) {
					assert true;
				}
			}
		}
	}
	
	public void compareDate_upcoming() {
		if(expectedYear>current_year) {
			System.out.println("Upcoming YEAR");
			assert false;	
		}
		else if(expectedYear<current_year) {
			assert true;	
		}
		else if(expectedYear.equals(current_year)) {
			if(expectedMonth_F02>current_month) {
				System.out.println("Upcoming MONTH");
				assert false;
			}
			else if(expectedMonth_F02<current_month) {
				assert true;
			}
			else if(expectedMonth_F02.equals(current_month)) {
				if(expectedDate>current_date) {
					assert false;
					System.out.println("Upcoming DATE");
				}
				else if(expectedDate<current_date) {
					assert true;
				}
				else if(expectedDate==current_date) {
					assert true;
				}
			}
		}
	}
	public void check_slot() throws ParseException {
		String providedDate = (expectedDate+"/"+expectedMonth_F02+"/"+expectedYear);
		String Currentdate = (current_date+"/"+current_month+"/"+current_year);
		if(providedDate.equals(Currentdate)) {
			try {
				if(slotForm_null().isDisplayed()==true) {
					System.out.println(slotForm_null().getText());
					assert false;
					}
			    } 
			catch (Exception e) {
				List<WebElement> spanList = slot_get();			
				for( WebElement slot: spanList){	   
				    //12 hrs into 24hrs 
					SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
					SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
					Date date = parseFormat.parse(slot.getAttribute("innerHTML"));
					String slotTime = displayFormat.format(date);
					
					int compareTime = slotTime.compareTo(CurrentTime_newTimeformat);
						if(compareTime<0) {
							System.out.println("slot time is lessthan the current time");
							assert false;
						}
						else if(compareTime>0) {
							//System.out.println("slot time is greater than the current time");
							assert true;
						}
						else if(compareTime==0) {
							//"slot time is equal to the current time"
							assert true;
						}				
				}		     			      
			}		
		}
		else {
			try {
				if(slotForm_null().isDisplayed()==true) {
					System.out.println(slotForm_null().getText());
					assert false;
					}
			    } 
			catch (Exception e) {
				assert true;
			}			
		}
	}	
	
	public String getCurrentcountryCode() {
		Locale currentCountrycode_obj = Locale.getDefault();
		String currentCountryCode = currentCountrycode_obj.getCountry();
        System.out.println("currentCountrycode: " + currentCountryCode);
		return currentCountryCode;
	}
	public String getCurrentcountry() {	
		Locale currentCountry_obj = Locale.getDefault();
		String currentCountry = currentCountry_obj.getDisplayCountry();
		return currentCountry;
                      
		/*Locale specificCountry_obj =new Locale("ENGLISH", "USA");
        String specificCountry = specificCountry_obj.getCountry();        
        System.out.println("Specific counrtry : " + specificCountry);
        return specificCountry;  */
	}
	
	public String check_patient_fee(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>patientFee = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : patientFee) {
			  
			  if((Arrays.asList(editProfile.patient_Country_Array)).contains(getCurrentcountry())) {
				  assertTrue(data.get("Domestic Consulting Fee").equals(get_consultationFee()));
			  }		 
			  else if((Arrays.asList(editProfile.patient_Country_Array)).contains(getCurrentcountryCode())) {
				  assertTrue(data.get("Domestic Consulting Fee").equals(get_consultationFee()));
			  }
			  else {
				  assertTrue(data.get("Overseas Consulting Fee").equals(get_consultationFee()));
			  }
		  }
		  return String.valueOf(patientFee);
			  
		  }
	
	public void get_appointmentDetails() throws ParseException {
		String firstName_appointmentPage = firstName().getAttribute("value");
		String lastName_appointmentPage = lastName().getAttribute("value");
		String email_appointmentPage = email().getAttribute("value");
		String mobile= mobile().getAttribute("value");
		String mobile_appointmentPage = "+91"+mobile;
		String online_class__appointmentPage = online_radioButton().getAttribute("class");
		String clinic_class__appointmentPage = clinicVisit_radioButton().getAttribute("class");
		String speciality_appointmentPage = specialityField().getText();
		String doctor_appointmentPage = doctorField().getText();
		String clinic_appointmentPage = clinicField().getAttribute("value");
		String complaint_appointmentPage = chiefComment().getAttribute("value");		
		String dateOfappointment_appointmentPage = dateOfappointment().getAttribute("value");		
	
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
	    SimpleDateFormat format2 = new SimpleDateFormat("MMM dd, yyyy");
	    Date date = format1.parse(dateOfappointment_appointmentPage);
	    String appointmentDate = format2.format(date);
		
		if(online_class__appointmentPage.contains("radio-checked")) {
			   appointmentType_appointmentPage = online_radioButton().getText();
		 }
		 else if(clinic_class__appointmentPage.contains("radio-checked")) {
			   appointmentType_appointmentPage = clinicVisit_radioButton().getText();
		 }
		 else {
			 System.out.println("No check box selected");
		 }		 
		
		List<WebElement> spanList = slot_activeCheck();	
		for( WebElement slot: spanList){
			String getClass =slot.getAttribute("class");
			if(getClass.contains("activeslotbutton")) {
				activeSlot = slot.getText();
				 break;
			}						
		}
		
		String appointment = appointmentDate +" "+activeSlot;
		
		this.bookAppointment_details = new String[] {firstName_appointmentPage,lastName_appointmentPage,email_appointmentPage,mobile_appointmentPage,
				appointmentType_appointmentPage,speciality_appointmentPage,doctor_appointmentPage,clinic_appointmentPage,complaint_appointmentPage,appointmentDate,activeSlot,appointment};
	}
	
	public String paymentMethod_card(DataTable inputs) throws ParseException, InterruptedException  {
		List<Map<String, String>>paymentMethod_card = inputs.asMaps(String.class, String.class);
		
		  for (Map<String, String> data : paymentMethod_card) {
			  switch_frameIn();
			  wait_paymentForm();
			  try {
				  Thread.sleep(2000);
				  card().click();
			  }
			  
			  catch (StaleElementReferenceException e) {
				  card();
				  card().click();
			  }
			  try {
				  if(skipSavedcard().isDisplayed()==true) {
					  skipSavedcard().click();
				  }
			  }
			  catch (Exception e) {
				  assert true;
			  }
			  
			  assertTrue(Arrays.asList(bookAppointment_details).contains(paymentForm_mobile().getText()));
			  assertTrue(Arrays.asList(consultationFee_appointmentBooking).contains(get_paymentForm_amount()));		
			  cardNumber().sendKeys(data.get("card_number"));
			  cardExpirey().sendKeys(data.get("card_expiry-MM/YY"));
			  cardHolder().clear();
			  cardHolder().sendKeys(data.get("card_holder"));
			  cardCvv().sendKeys(data.get("card_cvv"));
			  
			  if(cardRemember().isEnabled()) {
				  payment_pay().click();
				  skipSavedcard().click();
			  }
			  else {
				  cardRemember().click();
				  payment_pay().click();
				  skipSavedcard().click();
			  }
		  }
		 switch_frameOut();
		return String.valueOf(paymentMethod_card);
	}
	
	public String paymentMethod_upi(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			  switch_frameIn();
			  wait_paymentForm();
			  try {
				  upi().click();
			  }
			  
			  catch (StaleElementReferenceException e) {
				  upi();
				  upi().click();
			  }
			  pageLoader();
			  enterUPI().sendKeys((data.get("UPI_id")));
			  payment_pay().click();
			  
			  if(upiForm().getText().contains("Please accept the request from Razorpay's VPA on your UPI app")) {
				  System.out.println("Please accept the request from Razorpay's VPA on your UPI app");
			  }
			  else if(upiForm().getText().contains("Please enter a valid VPA of the form username@bank")) {
				  System.out.println("Please enter a valid VPA of the form username@bank");
				  assert false;
			  }
			  else if(upi_errorMessage().getText().contains("Invalid VPA") || (upi_errorMessage().getText().contains("Please enter a valid Virtual Payment Address"))) {
					System.out.println("Invalid VPA.\r\n" + 
					  		"Please enter a valid Virtual Payment Address");
					assert false;
				}
			  }	  
		 switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_netbanking(DataTable inputs) throws ParseException, InterruptedException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();
			 
			 try {
				 Thread.sleep(2000);
				 netbanking().click();
			  }
			  
			  catch (StaleElementReferenceException e) {
				  netbanking();
				  netbanking().click();
			  }
			 
			 wait_netBankingform();	 
			 
			 assertTrue(Arrays.asList(bookAppointment_details).contains(paymentForm_mobile().getText()));
			 assertTrue(Arrays.asList(consultationFee_appointmentBooking).contains(get_paymentForm_amount()));
			 try {
				 if(netBanking_grid_bankList(data.get("netbanking_bankname")).isDisplayed()==true) {
					 netBanking_grid_bankList(data.get("netbanking_bankname")).click();
				 }			 
				    } 
				catch (Exception e) {
					searchBank().click();
					bankSearch_textField().sendKeys(data.get("netbanking_bankname"));
					assertTrue(bankList().getText().contains(data.get("netbanking_bankname")));
					bankSearch_textField().sendKeys(Keys.ENTER); 
				}
			 try {
				 if(bankType(data.get("bank_type")).isDisplayed()==true) {
					 bankType(data.get("bank_type")).click();
					 payment_pay().click();
				 }
			 }
			 catch(Exception e)
			 {
				 moveTo_payment_pay();
				 payment_pay().click();
			 }		 		 
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_wallet(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();
			 
			 try {
				 wallet().click();
			  }
			  
			  catch (StaleElementReferenceException e) {
				  wallet();
				  wallet().click();
			  }
			 String walletType = data.get("wallet_type");
			 switch (walletType) {
			 	case "Mobikwik" :
			 		wallet_mobikwik().click();
			 		payment_pay().click();
			 		break;
			 	case "Freecharger" :
			 		wallet_freecharger().click();
			 		payment_pay().click();
			 		break;
			 	case "Airtelmoney":
			 		wallet_airtelMoney().click();
			 		payment_pay().click();
			 		break;
			 	case "Jiomoney":
			 		wallet_jioMoney().click();
			 		payment_pay().click();
			 		break;
			 	case "Payzapp":
			 		wallet_payzapp().click();
			 		payment_pay().click();
			 		break;
			 }
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_emi(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();	 
			 
			 try {
				 emi().click();
			  }
			  
			  catch (StaleElementReferenceException e) {
				  emi();
				  emi().click();
			  }
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}			
}
