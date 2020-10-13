package clinang.Locators;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;

public class Patient_MytreatmentLocators extends CustomDriver{
	
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By myTreatment_module = By.xpath("//a[@href='/portal/my-treatments']");
	public By close_myTreatment_popup = By.xpath("//span[@class='mdi mdi-close']");
	public By clinicalNote = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']/div[1]//child::p");
	public By observation = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']/div[2]//child::p");
	public By diagnosis = By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']/div[3]//child::p");
	public By eprescription = By.xpath("//button[@class='edownbutton mat-raised-button']");
	public By prescriptionTable = By.xpath("//div[@class='patient-report-download']//child::tbody");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By treatmentTable = By.xpath("//table");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
}