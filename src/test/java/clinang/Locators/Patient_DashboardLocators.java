package clinang.Locators;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;

public class Patient_DashboardLocators extends CustomDriver{
	 //Dashboard
	 public By dashboardField =By.xpath("//*[(normalize-space(text())='Dashboard')]");
	 public By wait_logoutView = By.xpath("//img[@class='user-logout']");
	 public By wait_profileView = By.xpath("//table");
	 public By todayAppointment = By.xpath("//a[@routerlink='/portal/appointmentlist/Today']/mat-card/div[2]/h3");
	 public By upcomingAppointment = By.xpath("//a[@routerlink='/portal/appointmentlist/Upcoming']/mat-card/div[2]/h3");
	 public By cancelledAppointment = By.xpath("//a[@routerlink='/portal/appointmentlist/Cancelled']/mat-card/div[2]/h3");
	 public By profile_firstName = By.xpath("//table/div/div[1]/tbody/tr[1]/td");
	 public By profile_mob = By.xpath("//table/div/div[1]/tbody/tr[2]/td");
	 public By profile_email = By.xpath("//table/div/div[1]/tbody/tr[3]/td");
	 public By profile_bloodGroup = By.xpath("//table/div/div[1]/tbody/tr[4]/td");
	 public By profile_age = By.xpath("//table/div/div[1]/tbody/tr[5]/td");
	 public By profile_lastName = By.xpath("//table/div/div[2]/tbody/tr[1]/td");
	 public By profile_DOB = By.xpath("//table/div/div[2]/tbody/tr[2]/td");
	 public By profile_gender =By.xpath("//table/div/div[2]/tbody/tr[3]/td");
	 public By profile_address = By.xpath("//table/div/div[2]/tbody/tr[4]/td");
	 
	 //EditProfile
	 public By editProfile = By.xpath("//button[@class='mat-raised-button']");
	 public By mobileNumberField = By.xpath("//input[@formcontrolname='phone']");
	 public By addressField =By.xpath("//input[@formcontrolname='address']");
	 public By streetField = By.xpath("//input[@formcontrolname='street']");
	 public By cityField = By.xpath("//input[@formcontrolname='city']");
	 public By stateField = By.xpath("//input[@formcontrolname='state']");
	 public By country = By.xpath("//*[@class='mat-select-value']");
	 public By click_countryDropdown = By.xpath("//div[@class='mat-select-value']");
	 public By pincodeField = By.xpath("//input[@formcontrolname='pincode']");
	 public By profile_imageUpload = By.xpath("//*[@id='imageUpload']");
	 public By profileEditform = By.xpath("//mat-card[@class='section-space mat-card']");
	 public By clickSave = By.xpath("//button[@class='reschedule-button mat-raised-button']");
	 public By clickCancel = By.xpath("//button[@class='cancel-button mat-raised-button']");
	 public By alertBox =By.xpath("//div[@class='msgtext']");
	 
}