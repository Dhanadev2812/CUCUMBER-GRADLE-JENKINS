package clinang.patient_Locators;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;

public class Patient_MedicalHistoryLocators extends CustomDriver{
	
	public By wait_medicalHistoryField = By.xpath("//a[@href='/portal/medicalhistory']");
	public By form_medicalHistory =By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']");
	public By gender_maleField = By.xpath("//*[contains(text(),'Male')]");
	public By gender_femaleField = By.xpath("//*[contains(text(),'Female')]");
	public By select_bloodGroupdropDwon =By.xpath("//div[@class='mat-select-arrow']");
	public By bloodGroupfield =By.xpath("//div[@class='mat-select-value']");
	public By age =By.xpath("//input[@formcontrolname='age']");
	public By weight =By.xpath("//input[@formcontrolname='weight']");
	public By height =By.xpath("//input[@formcontrolname='height']");
	public By allergy =By.xpath("//div[7]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']");
	public By medicalHistory=By.xpath("//div[8]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']");
	public By open_calenderField =By.xpath("//button[@aria-label='Open calendar']");
	public By CurrentPeriod = By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]");
	public By Currentyear=By.xpath("//button[@aria-label='Choose date']");
	public By previousArrow = By.xpath("//button[@aria-label='Previous 20 years']");
	public By nextArrow =By.xpath("//button[@aria-label='Next 20 years']");
	public By clickSave = By.xpath("//button[@class='reschedule-button mat-raised-button']");
	public By clickCancel =By.xpath("//button[@class='cancel-button mat-raised-button']");
	public By clickUpdate = By.xpath("//span[contains(text(),'Update')]");
	public By alertBox=By.xpath("//div[@class='msgtext']");
	public By closeAlert_field=By.xpath("//i[@class='mdi mdi-window-close mdi-18px']");
	public By gender_male = By.xpath("//mat-radio-button[@value='1']");
	public By gender_female =By.xpath("//mat-radio-button[@value='2']");
	public By dobField = By.name("dob");
}