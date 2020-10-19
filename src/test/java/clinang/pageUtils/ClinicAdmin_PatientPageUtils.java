package clinang.pageUtils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_PatientLocators;
import clinang.stepDefs.Patient_AppointmentStepDefs;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class ClinicAdmin_PatientPageUtils extends CustomDriver{
	
	ClinicAdmin_PatientLocators C_Admin_PatientLocators = new ClinicAdmin_PatientLocators();
	Patient_AppointmentStepDefs appointmentStepdefs = new Patient_AppointmentStepDefs();
	private String patientFile;
	private String newappointmentDate;
	private String requireddate;
	
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
	private WebElement grid_viewpatient(String patientID) {
		return findElement(By.xpath("//td[(normalize-space(text())='"+patientID+"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View']"));
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
	
	private WebElement medicalHistory_row1(int row) {
		return findElement(By.xpath("//table/div[1]/div[2]/tbody/tr["+row+"]/td"));
	}
	private WebElement medicalHistory_row2(int row) {
		return findElement(By.xpath("//table/div[1]/div[3]/tbody/tr["+row+"]/td"));
	}
	private WebElement allergy() {
		return findElement(C_Admin_PatientLocators.allergy);
	}
	private WebElement medicalHistory() {
		return findElement(C_Admin_PatientLocators.history);
	}
	private WebElement wait_medicalHistorytable() {
		return fluentWait(C_Admin_PatientLocators.medicalHistory_table);
	}
	private WebElement backTopatient_option() {
		return findElement(C_Admin_PatientLocators.backTopatient);
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
	
	public void verify_patient_personalDetails() throws IOException  {
		int lastRow =rowSize(patientFile,"PersonalDetails");
		int lastCol = columnSize(patientFile, "PersonalDetails");
		
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
				 	
			int excelRow=1;
			while(excelRow<=lastRow) {
				
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				if(TotalRowsList.size()-1==1) {
					for(int tableCol = 2; tableCol<=5;tableCol++) {
						assertTrue(grid_patient_personalDetails_single(tableCol).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",excelRow,tableCol-1).replace(" ", "")));	
					}
					break TABLElOOP;
				}	
				else if(integerConverter_excel(patientFile,"PersonalDetails",excelRow,0).replace(" ", "").equalsIgnoreCase(grid_appointmentID(tableRow).getText().replace(" ", ""))) {
					for(int tableCol = 2; tableCol<=5;tableCol++) {
						assertTrue(grid_patient_personalDetails(tableRow,tableCol).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",excelRow,tableCol-1).replace(" ", "")));	
					}
					break TABLElOOP;
				}
				else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
					assert false;
				}									
			}				
		excelRow++;
		}
		if(paginationNext().isEnabled()==true) {
			paginationNext().click();
			}
		}
	}
	
	public void verifyMedicalhistory() throws IOException {
		int lastRow =rowSize(patientFile,"MedicalHistory");
		int lastCol = columnSize(patientFile, "MedicalHistory");
		
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));			 	
			int excelRow=1;
			while(excelRow<=lastRow) {
				
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
					
				if(integerConverter_excel(patientFile,"MedicalHistory",excelRow,0).replace(" ", "").equalsIgnoreCase(grid_appointmentID(tableRow).getText().replace(" ", ""))) {
					grid_viewpatient(integerConverter_excel(patientFile,"MedicalHistory",excelRow, 0)).click();
					wait_pageLoad_complate();
					for(int excelCol = 1; excelCol<=lastCol;excelCol++) {
						wait_medicalHistorytable();
						if(excelCol<=4) {
							assertTrue(medicalHistory_row1(excelCol).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replace(" ", "")));	
						}
						else if(excelCol<=8 && excelCol>4) {
							assertTrue(medicalHistory_row2(excelCol-4).getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replace(" ", "")));	
						}
						else if(excelCol==9) {
							assertTrue(allergy().getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replace(" ", "")));
						}
						else if(excelCol==10) {
							assertTrue(medicalHistory().getText().replace(" ", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replace(" ", "")));
						}	
					}
					backTopatient_option().click();
					break TABLElOOP;
				}
				else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
					assert false;
				}									
			}				
		excelRow++;
		}
		if(paginationNext().isEnabled()==true) {
			paginationNext().click();
			}
		}	
	}
	
	public void verify_appointmentDetails() throws IOException, ParseException {
		int lastRow =rowSize(patientFile,"Appointments");
		int lastCol = columnSize(patientFile, "Appointments");
		
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));			 	
			int excelRow=1;
			while(excelRow<=lastRow) {
				
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				 if(integerConverter_excel(patientFile,"Appointments",excelRow,0).replace(" ", "").equalsIgnoreCase(grid_appointmentID(tableRow).getText().replace(" ", ""))) {
					 grid_viewpatient(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
					 wait_pageLoad_complate();
					 for(int excelCol=1;excelCol<=lastCol;excelCol++) {
						 int columnCount = excelCol;
						 switch (columnCount) {
						  case 1:		
							String appointmentDate = integerConverter_excel(patientFile,"Appointments",excelRow, excelCol);
							final String givenDateFormat = "dd/MM/yyyy";
						    SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
							Date new_format = old_format.parse(appointmentDate);
							old_format.applyPattern("dd/MM/yyyy");
							requireddate = old_format.format(new_format);
						    break;
						  case 2:
							  String Zone = integerConverter_excel(patientFile,"Appointments",excelRow, excelCol);
							  appointmentStepdefs.compare__date(requireddate, Zone); 
						    break;
						  case 3: 
							  appointmentStepdefs.find_appointmentID(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol));
							  break;
						 }
					 }
					
					break TABLElOOP;
				}
				else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
					assert false;
				}									
			}				
		excelRow++;
		}
		if(paginationNext().isEnabled()==true) {
			paginationNext().click();
			}
		}	
	}
}