package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import clinang.patient_Locators.Patient_DashboardLocators;
import clinang.webDriverUtils.CustomDriver;


public class Patient_DashboardPageUtils extends CustomDriver{
		
	Patient_DashboardLocators DashboardLocators = new Patient_DashboardLocators();
	
	public WebElement dashboardField() {
		return findElement(DashboardLocators.dashboardField);		
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
	
	private WebElement todayAppointment() {
		return findElement(DashboardLocators.todayAppointment);		
	}
	
	public void clickTodayappointment() {		
		todayAppointment().click();
	}
	
	public void getCount_todayApp() {		
		todayAppointment().getText();
		System.out.println(todayAppointment().getText());
	}
	
	private WebElement upcomingAppointment() {
		return findElement(DashboardLocators.upcomingAppointment);
	}
	
	public void clickUpcomingappointment() {		
		upcomingAppointment().click();
	}
	
	public void getCount_upcomingApp() {		
		upcomingAppointment().getText();
		System.out.println(upcomingAppointment().getText());
	}
	
	private WebElement cancelledAppointment() {
		return findElement(DashboardLocators.cancelledAppointment);
	}
	
	public void clickCancelledappointment() {		
		cancelledAppointment().click();
	}
	
	public void getCount_cancelledApp() {		
		upcomingAppointment().getText();
		System.out.println(cancelledAppointment().getText());
	}
	
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
	
	private WebElement click_countryDropdown() {
		return findElement(DashboardLocators.click_countryDropdown);
	}
	
	private WebElement select_countryField(String country) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+country+"'"+")]/ancestor::mat-option"));
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
	 	
	public void upload_profileImg(String img_path) throws InterruptedException {	
		Thread.sleep(2000);
		profile_img().sendKeys(img_path);
	}
	
	public WebElement profileEditform() {
		return findElement(DashboardLocators.profileEditform);
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
			  System.out.println(String.valueOf(profileUpdate_input));
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
	
	public String gettext_profileEditform() {
		return(profileEditform().getText());
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
	 
	 public WebElement profile_firstName() {
		 return findElement(DashboardLocators.profile_firstName);
	 }
	 
	 public void get_profile_firstName() {
		 //wait_profileView();
		 profile_firstName().getText();
	 }
	 
	 private WebElement profile_mob() {
		 return findElement(DashboardLocators.profile_mob);
	 }
	 
	 public void get_profile_mob() throws InterruptedException {	
		 wait_profileView();
		 profile_mob().getText();
	 }	 
	 
	 private WebElement profile_email() {
		 return findElement(DashboardLocators.profile_email);
	 }
	 
	 public void get_profile_email() throws InterruptedException {	
		 wait_profileView();
		 profile_email().getText();
	 }
	 
	 public WebElement profile_bloodGroup() throws InterruptedException {
		 Thread.sleep(3000);
		 return findElement(DashboardLocators.profile_bloodGroup);
	 }
	 
	 public void get_profile_bloodGroup() throws InterruptedException {	
		 wait_profileView();
		 profile_bloodGroup().getText();
	 }
	 
	 public WebElement profile_age() {
		 return findElement(DashboardLocators.profile_age);
	 }
	 
	 public void get_profile_age() throws InterruptedException {	
		 wait_profileView();
		 profile_age().getText();
	 }
	 
	 private WebElement profile_lastName() {
		 return findElement(DashboardLocators.profile_lastName);
	 }
	 
	 public void get_profile_lastName() throws InterruptedException {	
		 wait_profileView();
		 profile_lastName().getText();
	 }
	 
	 public WebElement profile_DOB() throws InterruptedException {
		 Thread.sleep(3000);
		 return findElement(DashboardLocators.profile_DOB);
	 }
	 
	 public String get_profile_DOB() throws InterruptedException {	
		 wait_profileView();
		 return profile_DOB().getText();
	 }
	 
	 public String dob_changedformat() throws InterruptedException, ParseException {
		 	 
		 	final String givenDateFormat = "dd MMM,yyyy";
			final String newFormat = "dd/MM/yyyy";	
			String givenDOB = get_profile_DOB();
			
			SimpleDateFormat new_dob = new SimpleDateFormat(givenDateFormat);
			Date dob = new_dob.parse(givenDOB);
			new_dob.applyPattern(newFormat);
			String required_dob = new_dob.format(dob);
			
			return required_dob;
	 }
	 
	 public WebElement table() {
		 return waitForElementDisplayed(By.xpath("//table[@class='table']"));
	 }
	 public WebElement profile_gender() throws InterruptedException {
		 //table();
		 Thread.sleep(3000);
		 return waitForElementDisplayed(DashboardLocators.profile_gender);
	 }
	 
	 public void get_profile_gender() throws InterruptedException {	
		 profile_gender().getText();
	 }	 
	 
	 private WebElement profile_address() {
		 return findElement(DashboardLocators.profile_address);
	 }
	 public void get_profile_address() {
		 wait_profileView();
		 profile_address().getText();
	 }
	
	 }



