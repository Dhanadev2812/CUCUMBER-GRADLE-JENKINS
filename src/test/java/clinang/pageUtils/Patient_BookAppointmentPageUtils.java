package clinang.pageUtils;

import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_BookAppointmentLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Patient_BookAppointmentPageUtils extends CustomDriver {
	
	Patient_BookAppointmentLocators Bookappoinment_Locators = new Patient_BookAppointmentLocators();
	Patient_DashboardPageUtils editProfile = new Patient_DashboardPageUtils();
	
	String givenDate;
	private Integer current_date;
	private Integer current_month;
	private Integer current_year;
	private String CurrentTime_newTimeformat;
	private int expectedDate;
	private Integer expectedMonth_F02;
	private Integer expectedYear;
	private String requiredDate;
	private String monthRequired;
	private String requiredYear;
	
	
	private WebElement goTo_bookAppointment() {
		return findElement(Bookappoinment_Locators.moveTo_bookAppointment);
	}

	public void click_bookAppointment() {
		goTo_bookAppointment().click();
	}
	
	private WebElement mobile() {
		return findElement(Bookappoinment_Locators.mobile);
	}
	
	private WebElement online_radioButton() {
		return findElement(Bookappoinment_Locators.online_radioButton);
	}
	
	private WebElement clinicVisit_radioButton() {
		return findElement(Bookappoinment_Locators.clinicVisit_radioButton);
	}
	
	private WebElement speciality_dropDown() {
		return waitForElementDisplayed(Bookappoinment_Locators.specility_dropDown);
	}
	
	private WebElement selectSpeciality(String speciality) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+speciality+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement doctor_dropDown() {
		return waitForElementDisplayed(Bookappoinment_Locators.doctor_dropDown);
	}
	
	private WebElement select_doctor(String doctor) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+doctor+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement chiefComment() {
		return findElement(Bookappoinment_Locators.chiefComment);
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
		return waitForElementPresent(Bookappoinment_Locators.card);
	}
	
	private WebElement upi() {
		return waitForElementPresent(Bookappoinment_Locators.upi);
	}
	
	private WebElement netbanking() {
		return waitForElementPresent(Bookappoinment_Locators.netbanking);
	}
	
	private WebElement wallet() {
		return waitForElementPresent(Bookappoinment_Locators.wallet);
	}
	
	private WebElement emi() {
		return waitForElementPresent(Bookappoinment_Locators.emi);
	}

	public String passAppointmentdetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>appointment_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : appointment_input) {
			  
			  mobile().click();
			  mobile().sendKeys(data.get("mobile"));
			  if(data.get("appointment_type").equals("Online Consultation")) {
				  online_radioButton().click();		  
			  }
			  else if (data.get("appointment_type").equals("Clinic Visit")) {
				  clinicVisit_radioButton().click();
			  }	
			  Thread.sleep(5000);			  
			  speciality_dropDown().click();
			  selectSpeciality(data.get("speciality")).click();
			  Thread.sleep(6000);
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
		
		expectedYear=Integer.parseInt(requiredYear);
		expectedDate = Integer.parseInt(requiredDate);
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
					 selectDate(requiredDate).click();

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
		//System.out.println(CurrentTime_newTimeformat);	
		
		String[] current_date_split = date.split("/"); 	
		current_date=Integer.valueOf(current_date_split[0].replaceAll(" ", ""));
		current_month = Integer.valueOf(current_date_split[1].replaceAll(" ", ""));
		current_year = Integer.valueOf(current_date_split[2].replaceAll(" ", ""));
	}
	
	public void compare_date() {
		
		if(expectedYear<current_year) {
			System.out.println("Year<current year");
			assert false;	
		}
		else {
			if(expectedMonth_F02<current_month) {
				System.out.println("Month<current month");
				assert false;
			}
			else {
				if(expectedDate<current_date) {
					System.out.println("Date<Current Date");
					assert false;	
				}
				else {
					assert true;
				}
			}
		}
	}
	
	public void check_slot() throws ParseException {

		if(expectedDate==current_date) {
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
							//"slot time is lessthan the current time"
							assert false;
						}
						else if(compareTime>0) {
							//"slot time is greater than the current time"
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
		System.out.println("country"+currentCountry);
		return currentCountry;
                      
		/*Locale specificCountry_obj =new Locale("ENGLISH", "USA");
		 //for country code - USA
         //String specificCountry = specificCountry_obj.getCountry();
         //for country united states
        String specificCountry = specificCountry_obj.getDisplayCountry();
        System.out.println("Specific counrtry : " + specificCountry);
        return specificCountry;  */
	}
	
	public String check_patient_fee(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>patientFee = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : patientFee) {
			  
			  if((Arrays.asList(editProfile.patient_Country_Array)).contains(getCurrentcountry())) {
				  System.out.println("Domestic fee");
				  assertTrue(data.get("Domestic Consulting Fee").equals(get_consultationFee()));
			  }		 
			  else if((Arrays.asList(editProfile.patient_Country_Array)).contains(getCurrentcountryCode())) {
				  System.out.println("Domestic fee");
				  assertTrue(data.get("Domestic Consulting Fee").equals(get_consultationFee()));
			  }
			  else {
				  System.out.println("Overseas");
				  assertTrue(data.get("Overseas Consulting Fee").equals(get_consultationFee()));
			  }
		  }
		  return String.valueOf(patientFee);
			  
		  }
	
	public String paymentMethod_card(DataTable inputs) throws ParseException, InterruptedException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			  switch_frameIn();
			  wait_paymentForm();
			  card().click();
		  }
		 switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_upi(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			  switch_frameIn();
			  wait_paymentForm();
			  upi().click();
		  }
		 switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_netbanking(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();
			 netbanking().click();
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_wallet(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();
			 wallet().click();
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	public String paymentMethod_emi(DataTable inputs) throws ParseException  {
		List<Map<String, String>>paymentMethod = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : paymentMethod) {
			 switch_frameIn();
			 wait_paymentForm();
			 emi().click();
		  }
		  switch_frameOut();
		return String.valueOf(paymentMethod);
	}
	
	
}
