package clinang.pageUtils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_PatientLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class ClinicAdmin_PatientPageUtils extends CustomDriver{
	
	ClinicAdmin_PatientLocators C_Admin_PatientLocators = new ClinicAdmin_PatientLocators();
	private String patientFile;
	
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_PatientLocators.pageLoader);
	}
	
	private WebElement patientModule() {
		return findElement(C_Admin_PatientLocators.patientModule);
	}
	public void click_patientModule() {
		patientModule().click();
	}
	private WebElement createPatient() {
		return findElement(C_Admin_PatientLocators.create);
	}
	public void click_createPatient() {
		createPatient().click();
	}
	private WebElement firstName() {
		return findElement(C_Admin_PatientLocators.firstName);
	}
	private WebElement lastName() {
		return findElement(C_Admin_PatientLocators.lastName);
	}
	private WebElement email() {
		return findElement(C_Admin_PatientLocators.email);
	}
	private WebElement password() {
		return findElement(C_Admin_PatientLocators.password);
	}
	public WebElement register() {
		return findElement(C_Admin_PatientLocators.register);
	}
	public void click_register() {
		register().click();
	}
	public WebElement messageBox() {
		return findElement(C_Admin_PatientLocators.messageBox);
	}
	private WebElement closeMessagebox() {
		return findElement(C_Admin_PatientLocators.closeMessagebox);
	}
	public void click_close_messageBox() {
		closeMessagebox().click();
	}
	public WebElement firstName_alert() {
		return findElement(C_Admin_PatientLocators.firstName_alert);
	}
	public WebElement lastName_alert() {
		return findElement(C_Admin_PatientLocators.lastName_alert);
	}
	public WebElement email_alert() {
		return findElement(C_Admin_PatientLocators.email_alert);
	}
	public WebElement password_alert() {
		return findElement(C_Admin_PatientLocators.password_alert);
	}
	private WebElement grid_viewpatient(String appointmentID) {
		return findElement(By.xpath("//td[(normalize-space(text())='"+appointmentID+"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View']"));
	}
	private WebElement grid_patient_personalDetails(int row,int col) {
		return findElement(By.xpath("//table/tbody/tr["+row+"]/td["+col+"]"));
	}
	private WebElement grid_patient_personalDetails_single(int col) {
		return findElement(By.xpath("//table/tbody/tr/td["+col+"]"));
	}
	private WebElement wait_patientTable() {
		return waitForElementPresent(C_Admin_PatientLocators.patientTable);
	}
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	private WebElement paginationNext() {
		return findElement(C_Admin_PatientLocators.paginationNext);
	}
	public String passPatientdetails(DataTable inputs)   {
		List<Map<String, String>> clinicPatient_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : clinicPatient_input) {
			  wait_pageLoad_complate();
			  firstName().clear();
			  firstName().sendKeys(data.get("firstName"));
			  lastName().clear();
			  lastName().sendKeys(data.get("lastName"));
			  email().clear();
			  email().sendKeys(data.get("email"));
			  password().clear();
			  password().sendKeys(data.get("password"));
			  
		  }
		  return String.valueOf(clinicPatient_input);
		  }
	public void skipMandatoryinputs() {
		 firstName().click();
		 lastName().click();
		 email().click();
		 password().click();
		 email().click();
	}
	
	public String passInvalidpatientDetails(DataTable inputs)   {
		List<Map<String, String>> clinicPatient_invalidinput = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : clinicPatient_invalidinput) {
			  wait_pageLoad_complate();
			  firstName().clear();
			  firstName().sendKeys(data.get("firstName"));
			  lastName().clear();
			  lastName().sendKeys(data.get("lastName"));
			  email().clear();
			  email().sendKeys(data.get("email"));
			  password().clear();
			  password().sendKeys(data.get("password"));
			  email().click();
		  }
		  return String.valueOf(clinicPatient_invalidinput);
		  }
	public void get_patientFile(String patient_details_file) {
		patientFile = patient_details_file;	
	}
	public void verify_patient_personalDetails() throws IOException {
		
		int lastRow =rowSize(patientFile,"PersonalDetails");
		int lastCol = columnSize(patientFile, "PersonalDetails");
		
		whileLoop:
			while(true) {
				
				if(wait_patientTable().isDisplayed()==true) {
					WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
					List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
						int i = 1;					
						while(i<=TotalRowsList.size()-1) {	
							if(TotalRowsList.size()-1==1) {
								for (int j = 1; j<=lastRow;j++) {	
									for (int k = 1; k<=lastCol; k++) {
										assertTrue(grid_patient_personalDetails_single(k+1).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",j, k).replace(" ", "")));																			
									}
								}
								break whileLoop;	
							}
							else if(integerConverter_excel(patientFile,"PersonalDetails",1, 0).equals(grid_appointmentID(i).getText())) {
								for (int j = 1; j<=lastRow;j++) {	
									for (int k = 1; k<=lastCol; k++) {
										assertTrue(grid_patient_personalDetails(i,k+1).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",j, k).replace(" ", "")));																			
									}
								}
								break whileLoop;															 			 
							} 
							else if((paginationNext().isEnabled()==false)&&(i==TotalRowsList.size()-1)){
								assert false;
							}		
							i++;
						} 
					if(paginationNext().isEnabled()==true) {
						paginationNext().click();
						}														
					}	
				}
	}
	public void verify_medicalHistory() {
		
	}
}