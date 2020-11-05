package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_DoctorLocator {
	
	public By doctorModule = By.xpath("//a[@href='/portal/admin-doctor']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By createDoctor = By.xpath("//button[@class='cpat-btn mat-raised-button']");
	public By doctorFirstname = By.xpath("//input[@formcontrolname='firstname']");
	public By doctorLastname = By.xpath("//input[@formcontrolname='lastname']");
	public By doctorEmail = By.xpath("//input[@formcontrolname='email']");
	public By doctorDomesticconsultationFee = By.xpath("//input[@formcontrolname='domesticfees']");
	public By doctorOverseasconsultationFee = By.xpath("//input[@formcontrolname='overseasfees']");
	public By doctorDomesticfollowupFee = By.xpath("//input[@formcontrolname='domesticfollowfees']");
	public By doctorOverseasfollowupFee = By.xpath("//input[@formcontrolname='overseasfollowfees']");
	public By doctorPassword = By.xpath("//input[@formcontrolname='password']");
	public By speciality_field = By.xpath("//*[@formcontrolname='speciality']/div/div[1]");
	public By speciality_dropDown = By.xpath("//*[@formcontrolname='speciality']/div");
	public By register = By.xpath("//span[(normalize-space(text())='Register')]/ancestor::button");
	public By alertBox = By.xpath("//div[@class='msgtext']");
	public By closeAlertbox =By.xpath("//i[@class='mdi mdi-window-close mdi-18px']");
	public By newDoctorID_latest = By.xpath("//table/tbody/tr[1]/td[1]");
	public By newDoctorName_latest = By.xpath("//table/tbody/tr[1]/td[2]");
	public By newDoctorStatus_latest =By.xpath("//table/tbody/tr[1]/td[3]//following-sibling::mat-slide-toggle");
	public By doctorWithoutprofile = By.xpath("//div[@class='mat-tab-labels']//following-sibling::div[@aria-controls='mat-tab-content-0-1']");
	public By doctorWithprofile = By.xpath("//div[@class='mat-tab-labels']//following-sibling::div[@aria-controls='mat-tab-content-0-0']");
	public By alert_firstName = By.xpath("//form/div/div[1]/div/mat-form-field//child::mat-error");
	public By alert_lastName =By.xpath("//form/div/div[2]/div/mat-form-field//child::mat-error");
	public By alert_email =By.xpath("//form/div/div[3]/div/mat-form-field//child::mat-error");
	public By alert_domesticConsultingfee =By.xpath("//form/div/div[5]/div/mat-form-field//child::mat-error");
	public By alert_overseasConsultingfee =By.xpath("//form/div/div[6]/div/mat-form-field//child::mat-error");
	public By alert_domesticFollowupfee =By.xpath("//form/div/div[7]/div/mat-form-field//child::mat-error");
	public By alert_overseasFollowupfee =By.xpath("//form/div/div[8]/div/mat-form-field//child::mat-error");
	public By alert_password =By.xpath("//form/div/div[9]/div/mat-form-field//child::mat-error");
	public By doctorTable = By.xpath("//table");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
	public By paginationFirstPage = By.xpath("//button[@aria-label='First page']");
	public By viewProfile_table =By.xpath("//table[@class='table ng-star-inserted']");
	public By aboutMe = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']//child::p");
	public By medicalReport_Norecord = By.xpath("//div[@class='norecord']");
	public By closeMedicalreport =By.xpath("//span[@class='mdi mdi-close']");
	public By closeMedicaltreatment = By.xpath("//span[@class='mdi mdi-close']");
}