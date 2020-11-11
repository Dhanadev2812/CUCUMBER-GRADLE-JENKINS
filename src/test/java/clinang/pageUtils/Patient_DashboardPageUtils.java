package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import clinang.Locators.Patient_DashboardLocators;
import clinang.webDriverUtils.CustomDriver;


public class Patient_DashboardPageUtils extends CustomDriver{
		
	Patient_DashboardLocators DashboardLocators = new Patient_DashboardLocators();
	Patient_LoginPageUtils loginPage = new Patient_LoginPageUtils();
	public String[] dashboard_appointmentCount;
	public static String[] editpageArr = null;
	public static String[] patient_Country_Array = null;
	
	//dashboard
	public WebElement dashboardField() {
		return findElement(DashboardLocators.dashboardField);		
	 }
	public  List<WebElement> isLogoutpresent() {
		return findElement_list(DashboardLocators.wait_logoutView);
	}
	private WebElement wait_logoutView() {
		return waitForElementDisplayed(DashboardLocators.wait_logoutView);
	}
	
	public void clickLogout() {	
		wait_logoutView().click();
	}
	
	public WebElement wait_profileView() {
		return waitForElementDisplayed(DashboardLocators.wait_profileView);
	}
	
	public WebElement todayAppointment() {
		return findElement(DashboardLocators.todayAppointment);		
	}
	
	public void clickTodayappointment() {		
		todayAppointment().click();
	}
	
	public String getCount_todayApp() {		
		return todayAppointment().getText();
	}
	
	private WebElement upcomingAppointment() {
		return findElement(DashboardLocators.upcomingAppointment);
	}
	
	public void clickUpcomingappointment() {		
		upcomingAppointment().click();
	}
	
	public String getCount_upcomingApp() {		
		return upcomingAppointment().getText();
	}
	
	private WebElement cancelledAppointment() {
		return findElement(DashboardLocators.cancelledAppointment);
	}
	
	public void clickCancelledappointment() {		
		cancelledAppointment().click();
	}
	
	public String getCount_cancelledApp() {		
		return cancelledAppointment().getText();
	}
	public void fluentWait_profileMail() {	
		waitForElementPresent(By.xpath("//td[(normalize-space(text())"+"="+"'"+loginPage.str_userName+"'"+")]"));
	}
	public WebElement profile_firstName() {
		 return findElement(DashboardLocators.profile_firstName);
	 }
	 
	 public WebElement profile_mob() throws InterruptedException {
		 return findElement(DashboardLocators.profile_mob);
	 }
	 
	 public WebElement profile_email() throws InterruptedException {
		 return findElement(DashboardLocators.profile_email);
	 }
	 
	 public WebElement profile_bloodGroup() throws InterruptedException {
		 return findElement(DashboardLocators.profile_bloodGroup);
	 }
	 
	 public WebElement profile_age() throws InterruptedException {
		 return findElement(DashboardLocators.profile_age);
	 }
	 
	 private WebElement profile_lastName() {
		 return findElement(DashboardLocators.profile_lastName);
	 }
	 
	 public WebElement profile_DOB() throws InterruptedException {
		 return findElement(DashboardLocators.profile_DOB);
	 }
	 
	 public WebElement profile_gender() throws InterruptedException {
		 return waitForElementDisplayed(DashboardLocators.profile_gender);
	 }
	 
	 public WebElement profile_address() throws InterruptedException {
		 return findElement(DashboardLocators.profile_address);
	 }
	 
	 public String dob_changedformat() throws InterruptedException, ParseException {
		 	 
		 	final String givenDateFormat = "dd MMM,yyyy";
			final String newFormat = "dd/MM/yyyy";	
			String givenDOB = profile_DOB().getText();
			
			SimpleDateFormat new_dob = new SimpleDateFormat(givenDateFormat);
			Date dob = new_dob.parse(givenDOB);
			new_dob.applyPattern(newFormat);
			String required_dob = new_dob.format(dob);
			
			return required_dob;
	 }
	 
	//editprofile
	private WebElement editProfile() {
		return findElement(DashboardLocators.editProfile);
	} 
	
	public void clickEditProfile() {		
		editProfile().click();
	}	
	
	private WebElement mobileNumberField() {
		return findElement(DashboardLocators.mobileNumberField);
	}
	
	public void clear_mobileNumberField() {		
		mobileNumberField().clear();
	}
	
	private WebElement addressField() {
		return findElement(DashboardLocators.addressField);
	}
	
	public void clear_addressField() {		
		addressField().clear();
	}
	
	private WebElement streetField() {
		return findElement(DashboardLocators.streetField);
	}
	
	public void clear_streetField() {		
		streetField().clear();
	}
	
	private WebElement cityField() {
		return findElement(DashboardLocators.cityField);
	}
	
	public void clear_cityField() {		
		cityField().clear();
	}
	private WebElement stateField() {
		return findElement(DashboardLocators.stateField);
	}
	
	public void clear_stateField() {		
		stateField().clear();
	}
	
	public WebElement country() {
		return waitForElementDisplayed(DashboardLocators.country);
	}
	
	public void scrollTocountry() {
		scrollTofindElement(country());
	}

	private WebElement click_countryDropdown() {
		return findElement(DashboardLocators.click_countryDropdown);
	}
	
	private WebElement select_countryField(String country) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+country+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement pincodeField() {
		return findElement(DashboardLocators.pincodeField);
	}
	
	public void clear_pincodeField()  {	
		pincodeField().clear();
	}
	
	private WebElement profile_img() {
		return findElement(DashboardLocators.profile_imageUpload);	
	}
	
	 public void scrollToupdateImg() {
		 scrollTofindElement(profile_img());		
	 }	
	 	
	public void upload_profileImg(String File_path) throws InterruptedException {	
		Thread.sleep(2000);
		File profileImage = new File(File_path);
		profile_img().sendKeys(profileImage.getAbsolutePath());
	}
		
	public WebElement clickSave() {
		 return findElement(DashboardLocators.clickSave);
	 }
	 
	 private WebElement clickCancel() {
		  return findElement(DashboardLocators.clickCancel);
	  }
	 
	 private WebElement alertBox() {
			return findElement(DashboardLocators.alertBox);		
		}	 
	 public WebElement mobileAlert() {
		 return findElement(DashboardLocators.mobileAlert);
	 }
	 public WebElement addressAlert() {
		 return findElement(DashboardLocators.addressAlert);
	 }
	 public WebElement streetAlert() {
		 return findElement(DashboardLocators.streetAlert);
	 }
	 public WebElement cityAlert() {
		 return findElement(DashboardLocators.cityAlert);
	 }
	 public WebElement stateAlert() {
		 return findElement(DashboardLocators.stateAlert);
	 }
	 public WebElement pincodeAlert() {
		 return findElement(DashboardLocators.pincodeAlert);
	 }

	public String passProfiledetails(DataTable inputs) throws InterruptedException  {
		List<Map<String, String>> profileUpdate_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : profileUpdate_input) {
			  Thread.sleep(8000);
			  clear_mobileNumberField();
			  mobileNumberField().sendKeys(data.get("mobile_number"));  
			  clear_addressField();
			  addressField().sendKeys(data.get("address")); 
			  clear_streetField();
			  streetField().sendKeys(data.get("street")); 	
			  clear_cityField();
			  cityField().sendKeys(data.get("city"));  
			  clear_stateField();
			  stateField().sendKeys(data.get("state")); 
			  clear_pincodeField();			  
			  pincodeField().sendKeys(data.get("pincode"));
			  click_countryDropdown().click();				  
			  select_countryField(data.get("country")).click();		
			  //System.out.println(String.valueOf(profileUpdate_input));
		  } 
		
		return String.valueOf(profileUpdate_input);
		  }	 	
	
	public void updateProfile_nullValue() throws InterruptedException {
		Thread.sleep(3000);
		mobileNumberField().click();
		mobileNumberField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		Thread.sleep(1000);
		addressField().click();
		addressField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		Thread.sleep(1000);
		streetField().click();
		streetField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		Thread.sleep(1000);
		cityField().click();
		cityField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		Thread.sleep(1000);
		stateField().click();
		stateField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		Thread.sleep(1000);
		pincodeField().click();
		pincodeField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		clickSave().click();
	}
		
	public void get_editFormdata() {
		String get_mobileNum =  mobileNumberField().getAttribute("value");
		String get_address = addressField().getAttribute("value");
		String get_street = streetField().getAttribute("value");
		String get_city = cityField().getAttribute("value");
		String get_pincode = pincodeField().getAttribute("value");
		String get_state = stateField().getAttribute("value");
		String combinedAddresss = get_address+","+" "+get_street+","+" "+get_city+"-"+get_pincode+","+" "+get_state;	
		
		this.editpageArr = new String[] {get_mobileNum,combinedAddresss};
	 }
	 
	 public void select_option(String option) {
		 if(option.equals("save")) {
			 clickSave().click();
		 }
		 else if(option.equals("cancel")) {
			 clickCancel().click();		 
		 }
	 }
	 
	public String get_alertMessage() {
		return(alertBox().getText());
	}
	
	 public void scrollTodashboard() {
		 scrollTofindElement(dashboardField());		
	 }	
	   
	 public void clickDashboard() {
		 dashboardField().click();
	 }
	 
	 public List<String> patient_country() throws InterruptedException {
			scrollTocountry();
			Thread.sleep(2000);
			String patientCountry = country().getText();
			this.patient_Country_Array = new String[] {patientCountry};
			return Arrays.asList(patient_Country_Array);
			
		}
	 
	 public List<String> appointmentCount() throws InterruptedException {
		 Thread.sleep(2000);
		 String todayAppointment_count = getCount_todayApp();
		 String upcomingAppointment_count =getCount_upcomingApp();
		 String cancelledAppointment_count =getCount_cancelledApp();
		 this.dashboard_appointmentCount = new String[] {todayAppointment_count,upcomingAppointment_count,cancelledAppointment_count};
		 return Arrays.asList(dashboard_appointmentCount);
		 
	 }
	 
	 }



