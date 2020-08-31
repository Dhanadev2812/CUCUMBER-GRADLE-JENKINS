package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class Patient_DashboardPageUtils extends CustomDriver{
		
	private WebElement wait_logoutView() {
		return waitForElementDisplayed(By.xpath("//img[@class='user-logout']"));
	}
	
	public void clickLogout() {	
		wait_logoutView().click();
	}
	
	public WebElement wait_profileView() {
		return waitForElementDisplayed(By.xpath("//table"));
	}
	
	private WebElement todayAppointment() {
		return findElement(By.xpath("//h3[@class='tot-appointment']"));
		
	}
	public void clickTodayappointment() {		
		todayAppointment().click();
	}
	
	public void getCount_todayApp() {		
		todayAppointment().getText();
		System.out.println(todayAppointment().getText());
	}
	
	private WebElement upcomingAppointment() {
		return findElement(By.xpath("//h3[@class='up-appointment']"));
	}
	
	public void clickUpcomingappointment() {		
		upcomingAppointment().click();
	}
	
	public void getCount_upcomingApp() {		
		upcomingAppointment().getText();
		System.out.println(upcomingAppointment().getText());
	}
	
	private WebElement cancelledAppointment() {
		return findElement(By.xpath("//h3[@class='can-appointment']"));
	}
	
	public void clickCancelledappointment() {		
		cancelledAppointment().click();
	}
	
	public void getCount_cancelledApp() {		
		upcomingAppointment().getText();
		System.out.println(cancelledAppointment().getText());
	}
	
	private WebElement editProfile() {
		return findElement(By.xpath("//button[@class='mat-raised-button']"));
	} 
	
	public void clickEditProfile() {		
		editProfile().click();
	}	
	
	private WebElement mobileNumberField() {
		return findElement(By.xpath("//input[@formcontrolname='phone']"));
	}
	
	public void clear_mobileNumberField() {		
		mobileNumberField().clear();
	}
	
	private WebElement addressField() {
		return findElement(By.xpath("//input[@formcontrolname='address']"));
	}
	
	public void clear_addressField() {		
		addressField().clear();
	}
	
	private WebElement streetField() {
		return findElement(By.xpath("//input[@formcontrolname='street']"));
	}
	
	public void clear_streetField() {		
		streetField().clear();
	}
	
	private WebElement cityField() {
		return findElement(By.xpath("//input[@formcontrolname='city']"));
	}
	
	public void clear_cityField() {		
		cityField().clear();
	}
	private WebElement stateField() {
		return findElement(By.xpath("//input[@formcontrolname='state']"));
	}
	
	public void clear_stateField() {		
		stateField().clear();
	}
	
	private WebElement click_countryField() {
		return findElement(By.xpath("//div[@class='mat-select-value']"));
	}
	
	private WebElement select_countryField(String country) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+country+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement pincodeField() {
		return findElement(By.xpath("//input[@formcontrolname='pincode']"));
	}
	
	public void clear_pincodeField()  {	
		pincodeField().clear();
	}
	
	private WebElement profile_img() {
		return findElement(By.xpath("//*[@id='imageUpload']"));	
	}
	
	 public void scrollToupdateImg() {
		 scrollTofindElement(profile_img());		
	 }	
	 	
	public void upload_profileImg(String img_path) throws InterruptedException {	
		Thread.sleep(2000);
		profile_img().sendKeys(img_path);
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
			  click_countryField().click();				  
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
	
	public WebElement profileEditform() {
		return findElement(By.xpath("//mat-card[@class='section-space mat-card']"));
	}
	
	public String gettext_profileEditform() {
		//System.out.println(profileEditform().getText());
		return(profileEditform().getText());
	}
	
	 public WebElement clickSave() {
		 return findElement(By.xpath("//button[@class='reschedule-button mat-raised-button']"));
	 }
	 
	 private WebElement clickCancel() {
		  return findElement(By.xpath("//button[@class='cancel-button mat-raised-button']"));
	  }
	 
	 public void select_option(String option) {
		 if(option.equals("save")) {
			 clickSave().click();
		 }
		 else if(option.equals("cancel")) {
			 clickCancel().click();		 
		 }
	 }
	 
	private WebElement alertBox() {
		return findElement(By.xpath("//div[@class='msgtext']"));		
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());
	}
	
	 public void scrollTodashboard() {
		 scrollTofindElement(dashboardField());		
	 }	
	 
	 public WebElement dashboardField() {
		return findElement(By.xpath("//*[contains(text(),'Dashboard')]"));		
	 }
	 
	 public void clickDashboard() {
		 dashboardField().click();
	 }
	 
	 public WebElement profile_firstName() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[1]/td"));
	 }
	 
	 public void get_profile_firstName() {
		 wait_profileView();
		 profile_firstName().getText();
		 System.out.println(profile_firstName().getText());
	 }
	 
	 private WebElement profile_mob() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[2]/td"));
	 }
	 
	 public void get_profile_mob() throws InterruptedException {	
		 wait_profileView();
		 profile_mob().getText();
		 System.out.println(profile_mob().getText());
	 }	 
	 
	 private WebElement profile_email() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[3]/td"));
	 }
	 
	 public void get_profile_email() throws InterruptedException {	
		 wait_profileView();
		 profile_email().getText();
		 System.out.println(profile_email().getText());
	 }
	 
	 private WebElement profile_bloodGroup() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[4]/td"));
	 }
	 
	 public void get_profile_bloodGroup() throws InterruptedException {	
		 wait_profileView();
		 profile_bloodGroup().getText();
		 System.out.println(profile_bloodGroup().getText());
	 }
	 
	 public WebElement profile_age() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[5]/td"));
	 }
	 
	 public void get_profile_age() throws InterruptedException {	
		 wait_profileView();
		 profile_age().getText();
		 System.out.println(profile_age().getText());
	 }
	 
	 private WebElement profile_lastName() {
		 return findElement(By.xpath("//table/div/div[2]/tbody/tr[1]/td"));
	 }
	 
	 public void get_profile_lastName() throws InterruptedException {	
		 wait_profileView();
		 profile_lastName().getText();
		 System.out.println(profile_lastName().getText());
	 }
	 
	 private WebElement profile_DOB() {
		 return findElement(By.xpath("//table/div/div[2]/tbody/tr[2]/td"));
	 }
	 
	 public void get_profile_DOB() throws InterruptedException {	
		 wait_profileView();
		 profile_DOB().getText();
		 System.out.println(profile_DOB().getText());
	 }
	 
	 private WebElement profile_gender() {
		 return findElement(By.xpath("//table/div/div[2]/tbody/tr[3]/td"));
	 }
	 
	 public void get_profile_gender() throws InterruptedException {	
		 wait_profileView();
		 profile_gender().getText();
		 System.out.println(profile_gender().getText());
	 }
	 
	 private WebElement profile_address() {
		 return findElement(By.xpath("//table/div/div[2]/tbody/tr[4]/td"));
	 }
	 public void get_profile_address() {
		 wait_profileView();
		 profile_address().getText();
		 System.out.println(profile_address().getText());
	 }
	 
	 public void dashboard_data() throws InterruptedException {
		 Thread.sleep(9000);
		 //wait_profileView();
		 get_profile_firstName();
		 get_profile_mob();
		 get_profile_email();
		 get_profile_bloodGroup();
		 get_profile_age();
		 get_profile_lastName();
		 get_profile_DOB();
		 get_profile_gender();
		 get_profile_address();
		 
	 }
	 
	
	 }



