package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_AppointmentLocators {
	public By appointmentModule = By.xpath("//a[@href='/portal/appointmentlist/Today']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By backToappointment = By.xpath("//mat-icon[(normalize-space(text())='chevron_left')]");
	public By totalAppointmentcount = By.xpath("//div[@class='mat-paginator-range-label']");
	public By AppointmentTbody = By.xpath("//table[@class='mat-table']//child::tbody");
}