package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import clinang.patient_Locators.Patient_DashboardLocators;
import clinang.webDriverUtils.CustomDriver;


public class Patient_DashboardPageUtils extends CustomDriver{
		
	Patient_DashboardLocators DashboardLocators = new Patient_DashboardLocators();
	Patient_LoginPageUtils loginPage = new Patient_LoginPageUtils();
	public static String[] editpageArr = null;
	
	//dashboard
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
	
	public String gettext_profileEditform() {
		return(profileEditform().getText());
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
	 
	 }



