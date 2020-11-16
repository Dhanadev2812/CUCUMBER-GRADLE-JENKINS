package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_PatientLocators {
	public By patientModule = By.xpath("//a[@href='/portal/admin-patient']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By create = By.xpath("//button[@class='cpat-btn mat-raised-button']");
	public By firstName = By.xpath("//input[@formcontrolname='firstname']");
	public By lastName = By.xpath("//input[@formcontrolname='lastname']");
	public By email =By.xpath("//input[@formcontrolname='email']");
	public By password = By.xpath("//input[@formcontrolname='password']");
	public By register = By.xpath("//button[@class='form-subbtn mat-raised-button']");
	public By messageBox = By.xpath("//mat-card[@class='messagebox mat-card ng-star-inserted']");
	public By closeMessagebox =By.xpath("//i[@class='mdi mdi-window-close mdi-18px']");
	public By firstName_alert = By.xpath("//form/div[1]//child::mat-error[@role='alert']/p");
	public By lastName_alert =By.xpath("//form/div[2]//child::mat-error[@role='alert']/p");
	public By email_alert =By.xpath("//form/div[3]//child::mat-error[@role='alert']/p");
	public By password_alert =By.xpath("//form/div[4]//child::mat-error[@role='alert']/p");
	public By patientID = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']//child::tr/td[1]");
	public By patientTable = By.xpath("//table");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
	public By paginationFirstPage = By.xpath("//button[@aria-label='First page']");
	public By allergy = By.xpath("//*[(normalize-space(text())='Allergy')]//following-sibling::p/p");
	public By history = By.xpath("//*[(normalize-space(text())='History')]//following-sibling::p/p");
	public By medicalHistory_table =By.xpath("//table[@class='table ng-star-inserted']");
	public By backTopatient = By.xpath("//a[@href='/portal/admin-patient']");
	public By bactTopatientDetails = By.xpath("//a[@href='/portal/admin-patient/1']");
	public By closePopUp =By.xpath("//span[@class='mdi mdi-close']");
	public By medicalReport_Norecord = By.xpath("//div[@class='norecord']");
	public By closeMedicaltreatment = By.xpath("//span[@class='mdi mdi-close']");
	public By totalPatientcount = By.xpath("//div[@class='mat-paginator-range-label']");
	public By patientTbody = By.xpath("//table[@class='mat-table']//child::tbody");
}