package clinang.pageUtils;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	Patient_MytreatmentPageUtils myTreatmentPageUtils = new Patient_MytreatmentPageUtils();
	public String patientFile;
	public String requireddate;
	public String appointmentDateTime;
	private String nextRow;
	private String[] medicalReportname;
	private String[] drugName;
	private String[] dosage;
	private String[] frequency;
	private String[] drug_days;
	private String[] beforeOrafter;
	public String patient_totalCount;
	
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_PatientLocators.pageLoader);
	}	
	private WebElement patientModule() {
		return findElement(C_Admin_PatientLocators.patientModule);
	}
	public void click_patientModule() {
		patientModule().click();
	}
	public WebElement patient_tbody() {
		return findElement(C_Admin_PatientLocators.patientTbody);
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
	public WebElement wait_patientTable() {
		return waitForElementPresent(C_Admin_PatientLocators.patientTable);
	}
	private WebElement grid_ID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	private WebElement paginationNext() {
		return findElement(C_Admin_PatientLocators.paginationNext);
	}
	private WebElement paginationFirst() {
		return findElement(C_Admin_PatientLocators.paginationFirstPage);
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
	private WebElement backTopatientDetails(String AppointmentID) {
		return findElement(By.xpath("//a[@href='/portal/admin-patient/"+AppointmentID+"']"));
	}
	private WebElement medicalReportedit(String appointmentID) {
		return findElement(By.xpath("//td[contains(text(),'"+ appointmentID +"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='Medical Record']"));
	}
	private WebElement medicalTreatmentedit(String appointmentID) {
		return findElement(By.xpath("//td[contains(text(),'"+ appointmentID +"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='Medical Treatment']"));
	}
	public WebElement close_popUp() {
		return findElement(C_Admin_PatientLocators.closePopUp);
	}
	public WebElement medicalReport_noRecord() {
		return findElement(C_Admin_PatientLocators.medicalReport_Norecord);
	}
	private WebElement close_medicalTreatment() {
		return findElement(C_Admin_PatientLocators.closeMedicaltreatment);
	}
	private WebElement totalPatientcount() {
		return findElement(C_Admin_PatientLocators.totalPatientcount);
	}
	public void get_totalPatientcount() {
		String[] countList = totalPatientcount().getText().split("of");
		this.patient_totalCount = countList[1].replaceAll("\\s+", "");
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
	
	public void validate_patient_personalDetails() throws IOException  {
		int lastRow =rowSize(patientFile,"PersonalDetails");
		
		if(wait_patientTable().isDisplayed()==true) {
			wait_pageLoad_complate();
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
			int excelRow=1;
		    EXCELLOOP:
			while(excelRow<=lastRow) {
				System.out.println("Start validating patient personal details for patient ID:"+" "+integerConverter_excel(patientFile,"PersonalDetails",excelRow,0));
				TABLElOOP:
				for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
					if(TotalRowsList.size()-1==1) {
						for(int tableCol = 2; tableCol<=5;tableCol++) {
							assertTrue(grid_patient_personalDetails_single(tableCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",excelRow,tableCol-1).replaceAll("\\s+", "")));	
						}
						paginationFirst().click();
						excelRow++;
						break TABLElOOP;
					}	
					else if(integerConverter_excel(patientFile,"PersonalDetails",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						for(int tableCol = 2; tableCol<=5;tableCol++) {
							assertTrue(grid_patient_personalDetails(tableRow,tableCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"PersonalDetails",excelRow,tableCol-1).replaceAll("\\s+", "")));	
						}
						paginationFirst().click();
						excelRow++;
						break TABLElOOP;
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appoointment ID not found");
						assert false;
						break EXCELLOOP;
					}
					if((paginationNext().isEnabled()==true)&&(tableRow==TotalRowsList.size()-1)) {
						paginationNext().click();
						int currentExcelrow = excelRow;
						excelRow = currentExcelrow;
					}
				}				
			}
		}
	}
	
	public void validateMedicalhistory() throws IOException {
		int lastRow =rowSize(patientFile,"MedicalHistory");
		int lastCol = columnSize(patientFile, "MedicalHistory");
		
		if(wait_patientTable().isDisplayed()==true) {
			wait_pageLoad_complate();
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));			 	
			int excelRow=1;
			
			EXCELLOOP:
			while(excelRow<=lastRow) {	
				System.out.println("Start validation medical history details for patient ID:"+" "+integerConverter_excel(patientFile,"MedicalHistory",excelRow,0));
				TABLElOOP:
				for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
					if(integerConverter_excel(patientFile,"MedicalHistory",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalHistory",excelRow, 0)).click();
						wait_pageLoad_complate();
						for(int excelCol = 1; excelCol<=lastCol;excelCol++) {
							wait_medicalHistorytable();
							if(excelCol<=4) {
								assertTrue(medicalHistory_row1(excelCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replaceAll("\\s+", "")));	
							}
							else if(excelCol<=8 && excelCol>4) {
								assertTrue(medicalHistory_row2(excelCol-4).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replaceAll("\\s+", "")));	
							}
							else if(excelCol==9) {
								assertTrue(allergy().getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replaceAll("\\s+", "")));
							}
							else if(excelCol==10) {
								assertTrue(medicalHistory().getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(patientFile,"MedicalHistory",excelRow,excelCol-1).replaceAll("\\s+", "")));
							}	
						}
						backTopatient_option().click();
						excelRow++;
						break TABLElOOP;
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appoointment ID not found");
						assert false;
						break EXCELLOOP;
					}
					if((paginationNext().isEnabled()==true)&&(tableRow==TotalRowsList.size()-1)) {
						paginationNext().click();
						int currentExcelrow = excelRow;
						excelRow = currentExcelrow;
					}
				}	
			}
		}	
	}
	public void patientAppointment_ReadExcel(int excelRow,int lastCol) throws IOException, ParseException {
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
				  if(integerConverter_excel(patientFile,"Appointments",excelRow, 13).contentEquals("Cancelled")) {
					  appointmentPageUtils.Click_appointmentList_cancelled();
				  }
			    break;
			  case 3: 
				  appointmentStepdefs.find_appointmentID(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol));
				  System.out.println("Appointment ID:"+" "+integerConverter_excel(patientFile,"Appointments",excelRow, excelCol));
				  break;
			  case 4: 
				  appointmentPageUtils.get_appointmentDetails_viewPage();
				  String[] appointmentTime=integerConverter_excel(patientFile,"Appointments",excelRow, excelCol).split(" "); 
				  if(appointmentTime[3].startsWith("0")) {
						String[] appointmentTime_hr = appointmentTime[3].split(":");
						String appointmentHr_replace = appointmentTime_hr[0].replace("0", " ");
						String newAppointmenttime = appointmentHr_replace+":"+appointmentTime_hr[1]+" "+appointmentTime[4];
						 appointmentDateTime = appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+newAppointmenttime;
					}	
					
					else {
						appointmentDateTime =  appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+" "+appointmentTime[3]+" "+appointmentTime[4];
					}
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[5]).contains(appointmentDateTime));
				  System.out.println("Appointment date:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[5]));
				  break;
			  case 5: 
				  wait_pageLoad_complate();
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[3]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Appointment type:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[3]));
				  break;
			  case 6:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[1]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Speciality :"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[1]));
				  break;
			  case 7:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[4]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Doctor Name:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[4]));
				  break;
			  case 9:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[2]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Clinic name:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[2]));
				  break;
			  case 10:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Chief complaints:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]));
				  break;
			  case 11:
				  if(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol).equalsIgnoreCase("")) {
					System.out.println("No Followup Comments Updated");  
				  }
				  else {
					  appointmentPageUtils.get_followUpcomment_viewPage();
					  assertTrue(Arrays.asList(appointmentPageUtils.followUpcomment_viewPage_get[0]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
					  System.out.println("Followup:"+" "+ Arrays.asList(appointmentPageUtils.followUpcomment_viewPage_get[0]));
				  }
				  break;
			 }
		 }
	}
	public void validate_appointmentDetails() throws IOException, ParseException, InterruptedException {	
		int lastRow =rowSize(patientFile,"Appointments");
		int lastCol = columnSize(patientFile, "Appointments");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {	
			System.out.println("Start validating patient appointment details for patient ID"+" "+integerConverter_excel(patientFile,"Appointments",excelRow, 0));
			String previousRow = integerConverter_excel(patientFile,"Appointments",excelRow-1, 0);
			String currentRow =  integerConverter_excel(patientFile,"Appointments",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(patientFile,"Appointments",excelRow+1, 0);
			}
			
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					patientAppointment_ReadExcel(excelRow, lastCol);
					backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
					wait_pageLoad_complate();
					backTopatient_option().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(patientFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						patientAppointment_ReadExcel(excelRow, lastCol);
						backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					
					if(integerConverter_excel(patientFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						patientAppointment_ReadExcel(excelRow, lastCol);
						backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					patientAppointment_ReadExcel(excelRow, lastCol);
					backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
					wait_pageLoad_complate();
					backTopatient_option().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
		
					if(integerConverter_excel(patientFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						patientAppointment_ReadExcel(excelRow, lastCol);
						backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}		
				}		
				else if((previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					patientAppointment_ReadExcel(excelRow, lastCol);
					backTopatientDetails(integerConverter_excel(patientFile,"Appointments",excelRow, 0)).click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
				}		
				if((paginationNext().isEnabled()==true)&&(tableRow==TotalRowsList.size()-1)) {
					paginationNext().click();
					int currentExcelrow = excelRow;
					excelRow = currentExcelrow;
						}
					}	
				}
			}
		}
	public void findAppointment_medicalReport(String appointmentID) {
		wait_pageLoad_complate();
		whileLoop:
		while(true) {
			if(appointmentPageUtils.wait_appointmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
				int tableRow = 1;					
				while(tableRow<=TotalRowsList.size()-1) {
					System.out.println("Started downloading medical report for:"+" "+appointmentID);
					if(TotalRowsList.size()-1==1) {
						assertTrue(appointmentPageUtils.grid_appointmentID_single().getText().contentEquals(appointmentID));
						medicalReportedit(appointmentID).click();
						wait_pageLoad_complate();
						break whileLoop;		
					}
					else if(appointmentID.contentEquals(grid_ID(tableRow).getText())) {
						medicalReportedit(appointmentID).click();
						wait_pageLoad_complate();
						break whileLoop;															 			 
					} 
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+appointmentID+" "+"not found");
						assert false;
					}
					else if(TotalRowsList.size()-1==0) {
						System.out.println("No records found");
						assert false;
					}
					tableRow++;
				} 
				if(paginationNext().isEnabled()==true) {
					paginationNext().click();
					}														
				}	
			}
	}
	public void patientMedicalreport_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {
		for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 wait_pageLoad_complate();
			 switch (columnCount) {
			  case 1:	
				  String appointmentDate = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  requireddate = old_format.format(new_format);
				  break;
			  case 2:
				  String Zone = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
			    break;
			  case 3: 
				  findAppointment_medicalReport(integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol));
				  break;	
			  case 4:
				  medicalReportname = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol).split(",");
				  break;
			  case 5:
				  String[] medicalReportdescription = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol).split(",");
				  validateMedicalreportDetails_withReadexcel(medicalReportname, medicalReportdescription);
			 }  			 
		}
	}
	public void validateMedicalreportDetails_withReadexcel(String[] medicalReportname,String[] medicalReportdescription) throws InterruptedException {
		wait_pageLoad_complate();
		int numberOfrecord_medicalReport = Integer.parseInt(appointmentPageUtils.get_span_medicalReports().getAttribute("childElementCount"));   
		int fileCount = medicalReportname.length;
		loop1:
		for (int i = 0;i<fileCount; i++) {
			String reportName = medicalReportname[i];
			String reportDescription = medicalReportdescription[i];
			loop02:
			for(int j=1;j<numberOfrecord_medicalReport+1;j++) {	
				if(reportName.equalsIgnoreCase(("No Documents uploaded").replace("//s+",""))) {	
					assertTrue(reportName.replaceAll("\\s+","").equalsIgnoreCase(medicalReport_noRecord().getText().replace(" ","")));
					System.out.println("No Documents uploaded");
					close_popUp().click();
				}
				else if(reportName.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportName(j).getText().replaceAll("\\s+", ""))) {
					if(reportDescription.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", ""))) {
						appointmentPageUtils.downloadAllreport();
						close_popUp().click();
						assert true;
						break loop02;
					}
				}		
				if(j==numberOfrecord_medicalReport) {
					if(reportName.replaceAll("\\s+", "").equalsIgnoreCase(("No Documents uploaded").replaceAll("\\s+", ""))) {
						assert true;
					}
					else if(reportName.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportName(numberOfrecord_medicalReport).getText().replaceAll("\\s+", ""))) {
						if(reportDescription.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", ""))) {
							assert true;
							break loop02;
						}
						else {
							System.out.println("Report Description"+" "+"for"+" "+reportName+" "+"is not available");
							assert false;
						}
					}
					else {
						System.out.println("Report Name"+" "+reportName+" "+"is not available");
						assert false;
					}
					break loop1;
				}		
			}	
			break loop1;
		}
	}
	public void validate_medicalReport() throws IOException, ParseException, InterruptedException {
		int lastRow =rowSize(patientFile,"MedicalRecord");
		int lastCol = columnSize(patientFile, "MedicalRecord");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {		
			String previousRow = integerConverter_excel(patientFile,"MedicalRecord",excelRow-1, 0);
			String currentRow =  integerConverter_excel(patientFile,"MedicalRecord",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(patientFile,"MedicalRecord",excelRow+1, 0);
			}
			
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					patientMedicalreport_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					backTopatient_option().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalRecord",excelRow, 0)).click();
						patientMedicalreport_ReadExcel(excelRow, lastCol);
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalRecord",excelRow, 0)).click();
						wait_pageLoad_complate();
						patientMedicalreport_ReadExcel(excelRow, lastCol);
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					patientMedicalreport_ReadExcel(excelRow, lastCol);
					backTopatient_option().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalRecord",excelRow, 0)).click();
						patientMedicalreport_ReadExcel(excelRow, lastCol);
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		
				}		
				else if((previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					patientMedicalreport_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
				}		
				if((paginationNext().isEnabled()==true)&&(tableRow==TotalRowsList.size()-1)) {
					paginationNext().click();
					int currentExcelrow = excelRow;
					excelRow = currentExcelrow;
						}
					}	
				}
			}
		}
	public void findAppointment_myTreatment(String appointmentID) {
		wait_pageLoad_complate();
		whileLoop:
		while(true) {
			if(appointmentPageUtils.wait_appointmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
				int tableRow = 1;					
				while(tableRow<=TotalRowsList.size()-1) {
					System.out.println("Start Validating medical report for appointment ID:"+" "+appointmentID);
					if(TotalRowsList.size()-1==1) {
						assertTrue(appointmentPageUtils.grid_appointmentID_single().getText().contentEquals(appointmentID));
						medicalTreatmentedit(appointmentID).click();
						wait_pageLoad_complate();
						break whileLoop;		
					}
					else if(appointmentID.contentEquals(grid_ID(tableRow).getText())) {
						medicalTreatmentedit(appointmentID).click();
						wait_pageLoad_complate();
						break whileLoop;															 			 
					} 
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+appointmentID+" "+"not found");
						assert false;
					}
					else if(TotalRowsList.size()-1==0) {
						System.out.println("No records found");
						assert false;
					}
					tableRow++;
				} 
				if(paginationNext().isEnabled()==true) {
					paginationNext().click();
					}														
				}	
			}
	}
	public void Medicaltreatment_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {
		for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 switch (columnCount) {
			  case 1:	
				  String appointmentDate = integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  requireddate = old_format.format(new_format);
				  break;
			  case 2:
				  String Zone = integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
			    break;
			  case 3: 
				  findAppointment_myTreatment(integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol));
				  break;
			  case 4:
				  wait_pageLoad_complate();
				  assertTrue(myTreatmentPageUtils.clinicNote().getText().replace("/s+", "").contentEquals((integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replace("/s+", "")));	
				  break;
			  case 5:
				  assertTrue(myTreatmentPageUtils.observation().getText().replaceAll("\\s+", "").contentEquals((integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", ""))); 
				  break;
			  case 6:
				  assertTrue(myTreatmentPageUtils.diagnosis().getText().replaceAll("\\s+", "").contentEquals((integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "")));
				  break;
			  case 7:
				  drugName = (integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 8:
				  dosage =(integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 9:
				  frequency = (integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 10:
				  drug_days = (integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 11:
				  beforeOrafter = (integerConverter_excel(patientFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");  
				  validate_and_download_Prescription(drugName,dosage,frequency,drug_days,beforeOrafter);
				  break;
			 }  			 
		}
	}
	public void validate_and_download_Prescription(String[] drugName,String[] dosage,String[] frequency,String[] drug_days,String[] beforeOrafter) {
		wait_pageLoad_complate();
		int fileCount = drugName.length;
		System.out.println("Validate and Downloading prescription");
		for (int i=0; i<fileCount; i++) {	
			int numberOf_prescriptions = Integer.parseInt(myTreatmentPageUtils.prescripionTable().getAttribute("childElementCount"));
			Loop2:
			for(int j=1; j<=numberOf_prescriptions; j++) {
				if(numberOf_prescriptions==1) {
					assertTrue(Arrays.asList(drugName[0].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_single(1).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Validated drug name");
					assertTrue(Arrays.asList(dosage[0].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_single(2).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Validated drug dosage");
					assertTrue(Arrays.asList(frequency[0].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_single(3).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Validated drug frequency");
					assertTrue(Arrays.asList(drug_days[0].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_single(4).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Vaalidated drug days");
					assertTrue(Arrays.asList(beforeOrafter[0].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_single(5).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Vaalidate drug taken before/after");
					break Loop2;
				}
				else if(Arrays.asList(drugName[i]).contains(myTreatmentPageUtils.prescriptionDetails_multiple(j,1).getText().replaceAll("\\s+", ""))) {
					System.out.println("Validated drug name");
					assertTrue(Arrays.asList(dosage[i].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_multiple(j,2).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Validated drug dosage");
					assertTrue(Arrays.asList(frequency[i].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_multiple(j,3).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Validated drug frequency");
					assertTrue(Arrays.asList(drug_days[i].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_multiple(j,4).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Vaalidated drug days");
					assertTrue(Arrays.asList(beforeOrafter[i].equalsIgnoreCase(myTreatmentPageUtils.prescriptionDetails_multiple(j,5).getText().replaceAll("//s+", ""))) != null);
					System.out.println("Vaalidate drug taken before/after");
					break Loop2;
				}
				else if(j==numberOf_prescriptions) {
					if(Arrays.asList(drugName[i]).contains(myTreatmentPageUtils.prescriptionDetails_multiple(j,1).getText().replaceAll("\\s+", ""))) {
						assert true;
					}
					else {
						System.out.println("Drug name not found");
						assert false;
					}
				}
				else if(numberOf_prescriptions==0) {
					assert false;
				}
			}
		}
		myTreatmentPageUtils.eprescription().click();
		close_medicalTreatment().click();
		wait_pageLoad_complate();
	}
	public void validate_Medicaltreatment() throws IOException, ParseException, InterruptedException {
		int lastRow =rowSize(patientFile,"MedicalTreatments");
		int lastCol = columnSize(patientFile, "MedicalTreatments");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_patientTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_PatientLocators.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {		
			String previousRow = integerConverter_excel(patientFile,"MedicalTreatments",excelRow-1, 0);
			String currentRow =  integerConverter_excel(patientFile,"MedicalTreatments",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(patientFile,"MedicalTreatments",excelRow+1, 0);
			}
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					Medicaltreatment_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					backTopatient_option().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalTreatments",excelRow, 0)).click();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalTreatments",excelRow, 0)).click();
						wait_pageLoad_complate();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						backTopatient_option().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					Medicaltreatment_ReadExcel(excelRow, lastCol);
					backTopatient_option().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewpatient(integerConverter_excel(patientFile,"MedicalTreatments",excelRow, 0)).click();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(patientFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		
				}		
				else if((previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					Medicaltreatment_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
				}		
				if((paginationNext().isEnabled()==true)&&(tableRow==TotalRowsList.size()-1)) {
					paginationNext().click();
					int currentExcelrow = excelRow;
					excelRow = currentExcelrow;
						}
					}	
				}
			}
		}
	public void verify_tableIsempty()  {
		if(patient_tbody().getText().isEmpty()==false) {
			assert true;
		}
		else {
			System.out.println("Table is empty,No data available");
			assert false;
		}
		
	}
	}

