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
	public By newDoctor_latest = By.xpath("//table/tbody/tr[1]/td[1]");
	public By doctorWithoutprofile = By.xpath("//div[@class='mat-tab-labels']//following-sibling::div[@aria-controls='mat-tab-content-0-1']");
	public By doctorWithprofile = By.xpath("//div[@class='mat-tab-labels']//following-sibling::div[@aria-controls='mat-tab-content-0-0']");

}