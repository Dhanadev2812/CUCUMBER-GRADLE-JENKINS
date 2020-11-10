package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_DashboardLocators {
	
	public By dashboardModule =By.xpath("//a[@href='/portal/admin-dashboard']");
	public By dashboard_calender = By.xpath("//div[@class='dashboard']//child::div[3]");
	public By todayAppointmentcount  = By.xpath("//a[@href='/portal/appointmentlist/Today']/mat-card/div[2]//child::h3");
	public By upcomingAppointmentcount  = By.xpath("//a[@href='/portal/appointmentlist/Upcoming']/mat-card/div[2]//child::h3");
	public By totalPatient = By.xpath("//a[@href='/portal/admin-patient']/mat-card/div[2]//child::h3");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");

}