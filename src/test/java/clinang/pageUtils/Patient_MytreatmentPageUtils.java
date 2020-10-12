package clinang.pageUtils;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.patient_Locators.Patient_MytreatmentLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class Patient_MytreatmentPageUtils extends CustomDriver{
	
	Patient_MytreatmentLocators myTreatment_Locator = new Patient_MytreatmentLocators();
	public String[] myTreatment_gridDetails;
	private String appointmentDateTime;
	
	public void wait_pageLoadercomplate() {
		 Loader(myTreatment_Locator.pageLoader);
	}
	
	private WebElement myTreatmentmodule() {
		return findElement(myTreatment_Locator.myTreatment_module);
	}
	
	public void click_myTreatmentmodule() {
		myTreatmentmodule().click();
	}
	
	private WebElement grid_viewMytreatment(String appointmentID) {
		return findElement(By.xpath("//td[(normalize-space(text())='"+appointmentID+"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View Treatment']"));
	}
	private WebElement close_myTreatment() {
		return findElement(myTreatment_Locator.close_myTreatment_popup);
	}
	private WebElement clinicNote() {
		return findElement(myTreatment_Locator.clinicalNote);
	}
	private WebElement observation() {
		return findElement(myTreatment_Locator.observation);
	}
	private WebElement diagnosis() {
		return findElement(myTreatment_Locator.diagnosis);
	}
	private WebElement prescriptionDetails_single(int column) {
		return findElement(By.xpath("//div[@class='patient-report-download']//child::table/tbody/tr/td["+column+"]"));
	}
	private WebElement prescriptionDetails_multiple(int row,int column) {
		return findElement(By.xpath("//div[@class='patient-report-download']//child::table/tbody/tr["+row+"]/td["+column+"]"));
	}
	private WebElement eprescription() {
		return findElement(myTreatment_Locator.eprescription);
	}
	private WebElement prescripionTable() {
		return findElement(myTreatment_Locator.prescriptionTable);
	}
	
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	private WebElement grid_dateTime(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
	}
	private WebElement grid_type(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
	}
	private WebElement grid_speciality(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
	}
	private WebElement grid_doctor(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]"));
	}
	private WebElement grid_clinicName(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]"));
	}
	private WebElement wait_treatmentTable() {
		return waitForElementDisplayed(myTreatment_Locator.treatmentTable);
	}
	private WebElement pagination_next() {
		return findElement(myTreatment_Locator.paginationNext);
	}
	
	

	public void check_cancelled_appointmentID(List<String> appointmentId) throws InterruptedException {		
		wait_pageLoadercomplate();	
		whileloop:
		while(true) {
			
			if(wait_treatmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(myTreatment_Locator.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {	
						if(appointmentId.contains(grid_appointmentID(i).getText())) {
							System.out.println("Cancelled appointment exhibits on my treatment list");
							assert false;
							break whileloop;							 					 							 		 
						} 
						else {
							if(!(appointmentId.contains(grid_appointmentID(i).getText()))) {
								if(i==TotalRowsList.size()-1) {
									assert true;
									break whileloop;		
								}			 					 							 		 
							} 
							assert true;
						}
						i++;
					} 
				if(pagination_next().isEnabled()==true) {
					pagination_next().click();
					}														
				}	
			}	
	}
	
	public void get_myTreatment(String myTreatmentfile) throws IOException {
			
			FileInputStream fs = new FileInputStream(myTreatmentfile);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int lastRow = sheet.getLastRowNum();
			
			for (int i = 1; i<=lastRow; i++) {		
				XSSFCell ID = sheet.getRow(i).getCell(0);
				DataFormatter formatter = new DataFormatter();
				System.out.println(formatter.formatCellValue(ID));
				grid_viewMytreatment(formatter.formatCellValue(ID)).click();
				wait_pageLoadercomplate();
				
				assertTrue(clinicNote().getText().replace(" ", "").contentEquals(sheet.getRow(i).getCell(1).toString().replace(" ", "")));	
				assertTrue(observation().getText().replace(" ", "").contentEquals(sheet.getRow(i).getCell(2).toString().replace(" ", "")));
				assertTrue(diagnosis().getText().replace(" ", "").contentEquals(sheet.getRow(i).getCell(3).toString().replace(" ", "")));
				
				close_myTreatment().click();
				wait_pageLoadercomplate();
		}
	}
		
	public void downloadPrescription(String appointmentID,DataTable prescription) {
		wait_pageLoadercomplate();
		List<List<String>> data = prescription.asLists(String.class);	
		int fileCount = data.size();
		grid_viewMytreatment(appointmentID).click();
		wait_pageLoadercomplate();
		
		for (int i = 1; i<fileCount; i++) {		
			int numberOf_prescriptions = Integer.parseInt(prescripionTable().getAttribute("childElementCount"));
			
			Loop2:
			for(int j=1; j<=numberOf_prescriptions; j++) {
				Loop3:
				for(int k=1;k<=5;k++) {
					if(data.get(i).get(0).replace(" ", "").contentEquals(prescriptionDetails_multiple(j,1).getText().replace(" ", ""))) {
						assertTrue(data.get(i).get(k-1).replace(" ", "").contentEquals(prescriptionDetails_multiple(j,k).getText().replace(" ", "")));
						if(k==5) {
							break Loop2;
						}
					}
					
					else if(j==numberOf_prescriptions) {
						if(data.get(i).get(0).replace(" ", "").contentEquals(prescriptionDetails_multiple(j,1).getText().replace(" ", ""))) {	
							assertTrue(data.get(i).get(k-1).replace(" ", "").contentEquals(prescriptionDetails_multiple(j,k).getText().replace(" ", "")));
							break Loop2;
						}	
						else {
							assert false;
						}
						
					}	
					else {
						break Loop3;
					}
				}
			}			
		}
		eprescription().click();
		close_myTreatment().click();
		wait_pageLoadercomplate();
	}
	
	public void get_Mytreatmentdetails_listPage(List<String> appointmentId) {
		
		wait_pageLoadercomplate();
		whileloop:
		while(true) {
			
			if(wait_treatmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(myTreatment_Locator.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {			
						if(appointmentId.contains(grid_appointmentID(i).getText())) {
							
							String appointmentDateTime01 = grid_dateTime(i).getText();
							String type = grid_type(i).getText();
							String speciality = grid_speciality(i).getText();
							String doctor = grid_doctor(i).getText();
							String clinic = grid_clinicName(i).getText();
							
							String[] appointmentTime=grid_dateTime(i).getText().split(" ");
							if(appointmentTime[3].startsWith("0")) {
								String[] appointmentTime_hr = appointmentTime[3].split(":");
								String appointmentHr_replace = appointmentTime_hr[0].replace("0", " ");
								String newAppointmenttime = appointmentHr_replace+":"+appointmentTime_hr[1]+" "+appointmentTime[4];
								 appointmentDateTime = appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+newAppointmenttime;
							}	
							
							else {
								appointmentDateTime =  appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+" "+appointmentTime[3]+" "+appointmentTime[4];
							}
							
							this.myTreatment_gridDetails = new String[] {appointmentDateTime,type,speciality,doctor,clinic};
							 break whileloop;			 
						} i++;
					} 
				if(pagination_next().isEnabled()==true) {
					pagination_next().click();
					}														
				}	
			}
	
	}
	
	
	}
