package clinang.pageUtils;

import org.openqa.selenium.By;

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
	
	public void passProfiledetails(DataTable inputs) throws InterruptedException  {
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
			  
		  }	 
		 
		 	}
	 private WebElement clickSave() {
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
	 
	 public void scrollTodashboard() {
		 scrollTofindElement(dashboardField());		
	 }	
	 
	 public WebElement dashboardField() {
		return findElement(By.xpath("//*[contains(text(),'Dashboard')]"));		
	 }
	 
	 public void clickDashboard() {
		 dashboardField().click();
	 }
	 
	 private WebElement profile_mob() {
		 return findElement(By.xpath("//table/div/div[1]/tbody/tr[2]/td"));
	 }
	 
	 public void get_profile_mob() throws InterruptedException {	
		 wait_profileView();
		 profile_mob().getText();
		 System.out.println(profile_mob().getText());
		 System.out.println("");
	 }
	 	 	 
}