package clinang.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

public class ClinicAdmin_ProfileupdateLocators {
	public By clinicAdmin_module = By.xpath("//a[@href='/portal/admin-clinicalupdate']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By edit = By.xpath("//tbody/tr//following-sibling::td[contains(@class, 'mat-cell cdk-column-action mat-column-action ng-star-inserted')]//*[local-name()='svg']");
	public By edit_imageUpload = By.xpath("//input[@id='imageUpload']");
	public By edit_clinicName = By.xpath("//input[@formcontrolname='clinicname']");
	public By edit_clinicAddress = By.xpath("//input[@formcontrolname='address']");
	public By edit_clinicStreet = By.xpath("//input[@formcontrolname='street']");
	public By edit_clinicCity = By.xpath("//input[@formcontrolname='city']");
	public By edit_clinicState = By.xpath("//input[@formcontrolname='state']");
	public By edit_clinicPincode = By.xpath("//input[@formcontrolname='pincode']");
	public By edit_clinicPhone = By.xpath("//input[@formcontrolname='clinicphone']");
	public By edit_clinicEmail = By.xpath("//input[@formcontrolname='clinicemail']");
	public By countryDropdown = By.xpath("//mat-select[@formcontrolname='country']//child::div[@class='mat-select-arrow-wrapper']");
	public By submit =By.xpath("//button[@type='submit']");
	public By messagebox = By.xpath("//div[@class='msgtext']");
	public By close_messagebox = By.xpath("//i[@class='mdi mdi-window-close mdi-18px']");
	public By grid_clinicName =By.xpath("//tbody/tr/td[1]");
	public By clinicName_alert = By.xpath("//form/div[2]/div[1]//child::mat-error[@role='alert']/p");
	public By clinicAddress_alert = By.xpath("//form/div[2]/div[2]//child::mat-error[@role='alert']/p");
	public By clinicStreet_alert = By.xpath("//form/div[2]/div[3]//child::mat-error[@role='alert']/p");
	public By clinicCity_alert = By.xpath("//form/div[2]/div[4]//child::mat-error[@role='alert']/p");
	public By clinicState_alert = By.xpath("//form/div[2]/div[5]//child::mat-error[@role='alert']/p");
	public By clinicPincode_alert = By.xpath("//form/div[2]/div[7]//child::mat-error[@role='alert']/p");
	public By clinicEmail_alert = By.xpath("//form/div[2]/div[8]//child::mat-error[@role='alert']/p");
	public By clinicphone_alert = By.xpath("//form/div[2]/div[9]//child::mat-error[@role='alert']/p");

}
