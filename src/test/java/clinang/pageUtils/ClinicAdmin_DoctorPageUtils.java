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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;

import clinang.Locators.ClinicAdmin_DoctorLocator;
import clinang.stepDefs.Patient_AppointmentStepDefs;
import clinang.webDriverUtils.CustomDriver;

public class ClinicAdmin_DoctorPageUtils extends CustomDriver {
	ClinicAdmin_DoctorLocator C_Admin_doctorLocator = new ClinicAdmin_DoctorLocator();
	Patient_AppointmentStepDefs appointmentStepdefs = new Patient_AppointmentStepDefs();
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	Patient_MytreatmentPageUtils myTreatmentPageUtils = new Patient_MytreatmentPageUtils();
	ClinicAdmin_PatientPageUtils C_Admin_patientPageUtils = new ClinicAdmin_PatientPageUtils();
	public String[] latestDoctor_withoutProfile;
	public String[] doctorName_input;
	private String doctorFile;
	private String nextRow;
	private String requireddate;
	private String appointmentDateTime;
	private String[] medicalReportname;
	private String[] drugName;
	private String[] dosage;
	private String[] frequency;
	private String[] drug_days;
	private String[] beforeOrafter;
	
	private WebElement doctorModule() {
		return findElement(C_Admin_doctorLocator.doctorModule);
	}
	public void click_doctorModule() {
		doctorModule().click();
	}
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_doctorLocator.pageLoader);
	}
	private WebElement createDoctor() {
		return findElement(C_Admin_doctorLocator.createDoctor);
	}
	public void click_createDoctor() {
		createDoctor().click();
	}
	private WebElement doctorFirstname() {
		return findElement(C_Admin_doctorLocator.doctorFirstname);
	}
	private WebElement doctorLastname() {
		return findElement(C_Admin_doctorLocator.doctorLastname);
	}
	private WebElement doctorEmailid() {
		return findElement(C_Admin_doctorLocator.doctorEmail);
	}
	private WebElement specialityField() {
		return findElement(C_Admin_doctorLocator.speciality_field);
	}
	private WebElement speciality_dropDown() {
		return waitForElementClick(C_Admin_doctorLocator.speciality_dropDown);
	}
	private void moveTospeciality_dropDown() {
		 scrollTofindElement(speciality_dropDown());
	}
	private WebElement selectSpeciality(String speciality) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+speciality+"'"+")]/ancestor::mat-option"));
	}
	private WebElement doctor_domesticConsultationFee() {
		return findElement(C_Admin_doctorLocator.doctorDomesticconsultationFee);
	}
	private WebElement doctor_overseasConsultationFee() {
		return findElement(C_Admin_doctorLocator.doctorOverseasconsultationFee);
	}
	private WebElement doctor_domesticFollowupfee() {
		return findElement(C_Admin_doctorLocator.doctorDomesticfollowupFee);
	}
	private WebElement doctor_overseasFollowfee() {
		return findElement(C_Admin_doctorLocator.doctorOverseasfollowupFee);
	}
	private WebElement doctor_password() {
		return findElement(C_Admin_doctorLocator.doctorPassword);
	}
	public WebElement register() {
		return findElement(C_Admin_doctorLocator.register);
	}
	public WebElement alertBox() {
		return findElement(C_Admin_doctorLocator.alertBox);
	}
	public WebElement close_alertBox() {
		return findElement(C_Admin_doctorLocator.closeAlertbox);
	}
	public WebElement newDoctor_latest() {
		return findElement(C_Admin_doctorLocator.newDoctorID_latest);
	}
	public WebElement newDoctorname_latest() {
		return findElement(C_Admin_doctorLocator.newDoctorName_latest);
	}
	public WebElement newDoctorstatus_latest() {
		return findElement(C_Admin_doctorLocator.newDoctorStatus_latest);
	}
	public WebElement doctorWithoutprofile_tab() {
		return findElement(C_Admin_doctorLocator.doctorWithoutprofile);
	}
	private WebElement doctorWithprofile_tab() {
		return findElement(C_Admin_doctorLocator.doctorWithprofile);
	}
	public WebElement alert_firstName() {
		return findElement(C_Admin_doctorLocator.alert_firstName);
	}
	public WebElement alert_lastName() {
		return findElement(C_Admin_doctorLocator.alert_lastName);
	}
	public WebElement alert_email() {
		return findElement(C_Admin_doctorLocator.alert_email);
	}
	public WebElement alert_doemsticConsultingfees() {
		return findElement(C_Admin_doctorLocator.alert_domesticConsultingfee);
	}
	public WebElement alert_overseasConsultingfees() {
		return findElement(C_Admin_doctorLocator.alert_overseasConsultingfee);
	}
	public WebElement alert_domesticFollowupfees() {
		return findElement(C_Admin_doctorLocator.alert_domesticFollowupfee);
	}
	public WebElement alert_overseasFollowupfees() {
		return findElement(C_Admin_doctorLocator.alert_overseasFollowupfee);
	}
	public WebElement alert_password() {
		return findElement(C_Admin_doctorLocator.alert_password);
	}
	private WebElement wait_doctorTable() {
		return waitForElementPresent(C_Admin_doctorLocator.doctorTable);
	}
	private WebElement grid_doctor_personalDetails(int row,int col) {
		return findElement(By.xpath("//table/tbody/tr["+row+"]/td["+col+"]"));
	}
	private WebElement grid_doctor_personalDetails_single(int col) {
		return findElement(By.xpath("//table/tbody/tr/td["+col+"]"));
	}
	private WebElement paginationNext() {
		return findElement(C_Admin_doctorLocator.paginationNext);
	}
	private WebElement paginationFirst() {
		return findElement(C_Admin_doctorLocator.paginationFirstPage);
	}
	private WebElement grid_ID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	private WebElement backTodoctorDetails(String AppointmentID) {
		return findElement(By.xpath("//a[@href='/portal/admin-doctor/"+AppointmentID+"']"));
	}
	private WebElement backTodoctor() {
		return findElement(By.xpath("//a[@href='/portal/admin-doctor']"));
	}
	private WebElement grid_viewdoctor(String doctorID) {
		return findElement(By.xpath("//td[(normalize-space(text())='"+doctorID+"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View']"));
	}
	private WebElement wait_viewProfiletable() {
		return fluentWait(C_Admin_doctorLocator.viewProfile_table);
	}
	private WebElement viewProfile_row1(int row) {
		return findElement(By.xpath("//table/div/div[1]/tbody/tr["+row+"]/td"));
	}
	private WebElement viewProfile_row2(int row) {
		return findElement(By.xpath("//table/div/div[2]/tbody/tr["+row+"]/td"));
	}
	private WebElement view_aboutMe() {
		return findElement(C_Admin_doctorLocator.aboutMe);
	}
	private WebElement medicalReportedit(String appointmentID) {
		return findElement(By.xpath("//td[contains(text(),'"+ appointmentID +"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='Medical Record']"));
	}
	public WebElement medicalReport_noRecord() {
		return findElement(C_Admin_doctorLocator.medicalReport_Norecord);
	}
	private WebElement close_medicalReport() {
		return findElement(C_Admin_doctorLocator.closeMedicalreport);
	}
	public void getLatestdoctorID() {
		doctorWithoutprofile_tab().click();
		wait_pageLoad_complate();
		this.latestDoctor_withoutProfile = new String[] {newDoctor_latest().getText()};
		doctorWithprofile_tab().click();
	}
	public String passDoctordetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>doctor_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : doctor_input) {
			  doctorFirstname().sendKeys(data.get("FirstName"));
			  doctorLastname().sendKeys(data.get("LastName"));
			  doctorEmailid().sendKeys(data.get("EmailID"));
			  moveTospeciality_dropDown();
			  Thread.sleep(5000);
			  speciality_dropDown().click();
			  selectSpeciality(data.get("Speciality")).click();
			  doctor_domesticConsultationFee().sendKeys(data.get("DomesticConsultingFee"));
			  doctor_overseasConsultationFee().sendKeys(data.get("OverseasConsultingFee"));
			  doctor_domesticFollowupfee().sendKeys(data.get("DomesticFollowupFee"));
			  doctor_overseasFollowfee().sendKeys(data.get("OverseasFollowupFee"));
			  doctor_password().sendKeys(data.get("Password"));	  
			  this.doctorName_input = new String[] {"Dr."+data.get("FirstName")+data.get("LastName")};
		  } 	
		return String.valueOf(doctor_input);		
		  }	 
	public void skip_mndatory_createDoctor() {
		doctorFirstname().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctorLastname().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctorEmailid().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_domesticConsultationFee().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_overseasConsultationFee().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_domesticFollowupfee().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_overseasFollowfee().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_password().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		doctor_overseasFollowfee().click();
	}
	public void get_doctorFile(String doctor_details_file) {
		doctorFile = doctor_details_file;	
	}
	public void validate_doctor_details_listPage() throws IOException  {
		int lastRow =rowSize(doctorFile,"Doctordetails");
		
		if(wait_doctorTable().isDisplayed()==true) {
			wait_pageLoad_complate();
			WebElement TargetRows = findElement(C_Admin_doctorLocator.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
			int excelRow=1;
		    EXCELLOOP:
			while(excelRow<=lastRow) {
				TABLElOOP:
				for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
					if(TotalRowsList.size()-1==1) {
						for(int tableCol = 1; tableCol<=4;tableCol++) {
							assertTrue(grid_doctor_personalDetails_single(tableCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(doctorFile,"Doctordetails",excelRow,tableCol-1).replaceAll("\\s+", "")));	
						}
						paginationFirst().click();
						excelRow++;
						break TABLElOOP;
					}	
					else if(integerConverter_excel(doctorFile,"Doctordetails",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						for(int tableCol = 1; tableCol<=4;tableCol++) {
							assertTrue(grid_doctor_personalDetails(tableRow,tableCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(doctorFile,"Doctordetails",excelRow,tableCol-1).replaceAll("\\s+", "")));	
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
	
	public void doctorAppointment_ReadExcel(int excelRow,int lastCol) throws IOException, ParseException {
		 for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 switch (columnCount) {
			  case 1:		
				  String appointmentDate = integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  requireddate = old_format.format(new_format);
				  break;
			  case 2:
				  String Zone = integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
				  if(integerConverter_excel(doctorFile,"Appointments",excelRow, 13).contentEquals("Cancelled")) {
					  appointmentPageUtils.Click_appointmentList_cancelled();
				  }
			    break;
			  case 3: 
				  appointmentStepdefs.find_appointmentID(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol));
				  break;
			  case 4: 
				  appointmentPageUtils.get_appointmentDetails_viewPage();
				  String[] appointmentTime=integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol).split(" "); 
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
				  break;
			  case 5: 
				  wait_pageLoad_complate();
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[3]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  break;
			  case 6:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[1]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  break;
			  case 7:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[4]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  break;
			  case 9:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[2]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  break;
			  case 10:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  break;
			  case 11:
				  if(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol).equalsIgnoreCase("")) {
					System.out.println("No Followup Comments Updated");  
				  }
				  else {
					  appointmentPageUtils.get_followUpcomment_viewPage();
					  assertTrue(Arrays.asList(appointmentPageUtils.followUpcomment_viewPage_get[0]).contains(integerConverter_excel(doctorFile,"Appointments",excelRow, excelCol)));
				  }
				  break;
			 }
		 }
	}
	
	public void validate_appointmentDetails() throws IOException, ParseException, InterruptedException {	
		int lastRow =rowSize(doctorFile,"Appointments");
		int lastCol = columnSize(doctorFile, "Appointments");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_doctorTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_doctorLocator.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {		
			String previousRow = integerConverter_excel(doctorFile,"Appointments",excelRow-1, 0);
			String currentRow =  integerConverter_excel(doctorFile,"Appointments",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(doctorFile,"Appointments",excelRow+1, 0);
			}
			
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					doctorAppointment_ReadExcel(excelRow, lastCol);
					backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
					wait_pageLoad_complate();
					backTodoctor().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(doctorFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						doctorAppointment_ReadExcel(excelRow, lastCol);
						backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					
					if(integerConverter_excel(doctorFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						doctorAppointment_ReadExcel(excelRow, lastCol);
						backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					doctorAppointment_ReadExcel(excelRow, lastCol);
					backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
					wait_pageLoad_complate();
					backTodoctor().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
		
					if(integerConverter_excel(doctorFile,"Appointments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						doctorAppointment_ReadExcel(excelRow, lastCol);
						backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"Appointments",excelRow,0)+" "+"not found");
						assert false;
					}		
				}		
				else if((previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					doctorAppointment_ReadExcel(excelRow, lastCol);
					backTodoctorDetails(integerConverter_excel(doctorFile,"Appointments",excelRow, 0)).click();
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
	
	public void validateDoctorpersonalDetails() throws IOException {
		int lastRow =rowSize(doctorFile,"Doctor-personaldetails");
		int lastCol = columnSize(doctorFile, "Doctor-personaldetails");
		
		if(wait_doctorTable().isDisplayed()==true) {
			wait_pageLoad_complate();
			WebElement TargetRows = findElement(C_Admin_doctorLocator.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));			 	
			int excelRow=1;
			
			EXCELLOOP:
			while(excelRow<=lastRow) {	
				TABLElOOP:
				for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
					wait_pageLoad_complate();
					if(integerConverter_excel(doctorFile,"Doctor-personaldetails",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"Doctor-personaldetails",excelRow, 0)).click();
						wait_pageLoad_complate();
						for(int excelCol = 1; excelCol<=lastCol;excelCol++) {
							wait_viewProfiletable();
							if(excelCol<=5) {
								assertTrue(viewProfile_row1(excelCol).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(doctorFile,"Doctor-personaldetails",excelRow,excelCol).replaceAll("\\s+", "")));	
							}
							else if(excelCol<=10 && excelCol>5) {
								assertTrue(viewProfile_row2(excelCol-5).getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(doctorFile,"Doctor-personaldetails",excelRow,excelCol).replaceAll("\\s+", "")));	
							}
							else if(excelCol==11) {
								assertTrue(view_aboutMe().getText().replaceAll("\\s+", "").equalsIgnoreCase(integerConverter_excel(doctorFile,"Doctor-personaldetails",excelRow,excelCol).replaceAll("\\s+", "")));
							}	
						}
						backTodoctor().click();
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
	public void doctorMedicalreport_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {
		for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 wait_pageLoad_complate();
			 switch (columnCount) {
			  case 1:	
				  String appointmentDate = integerConverter_excel(doctorFile,"MedicalRecord",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  requireddate = old_format.format(new_format);
				  break;
			  case 2:
				  String Zone = integerConverter_excel(doctorFile,"MedicalRecord",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
			    break;
			  case 3: 
				  C_Admin_patientPageUtils.findAppointment_medicalReport(integerConverter_excel(doctorFile,"MedicalRecord",excelRow, excelCol));
				  break;	
			  case 4:
				  medicalReportname = integerConverter_excel(doctorFile,"MedicalRecord",excelRow, excelCol).split(",");
				  break;
			  case 5:
				  String[] medicalReportdescription = integerConverter_excel(doctorFile,"MedicalRecord",excelRow, excelCol).split(",");
				  C_Admin_patientPageUtils.validateMedicalreportDetails_withReadexcel(medicalReportname, medicalReportdescription);
			 }  			 
		}
	}
	
	public void validate_medicalReport() throws IOException, ParseException, InterruptedException {
		int lastRow =rowSize(doctorFile,"MedicalRecord");
		int lastCol = columnSize(doctorFile, "MedicalRecord");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_doctorTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_doctorLocator.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {		
			String previousRow = integerConverter_excel(doctorFile,"MedicalRecord",excelRow-1, 0);
			String currentRow =  integerConverter_excel(doctorFile,"MedicalRecord",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(doctorFile,"MedicalRecord",excelRow+1, 0);
			}
			
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					doctorMedicalreport_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					backTodoctor().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalRecord",excelRow, 0)).click();
						doctorMedicalreport_ReadExcel(excelRow, lastCol);
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalRecord",excelRow, 0)).click();
						wait_pageLoad_complate();
						doctorMedicalreport_ReadExcel(excelRow, lastCol);
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					doctorMedicalreport_ReadExcel(excelRow, lastCol);
					backTodoctor().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalRecord",excelRow, 0)).click();
						doctorMedicalreport_ReadExcel(excelRow, lastCol);
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalRecord",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		
				}		
				else if((previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					doctorMedicalreport_ReadExcel(excelRow, lastCol);
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
	
	public void Medicaltreatment_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {
		for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 switch (columnCount) {
			  case 1:	
				  String appointmentDate = integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  requireddate = old_format.format(new_format);
				  break;
			  case 2:
				  String Zone = integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
			    break;
			  case 3: 
				  C_Admin_patientPageUtils.findAppointment_myTreatment(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol));
				  break;
			  case 4:
				  wait_pageLoad_complate();
				  assertTrue(myTreatmentPageUtils.clinicNote().getText().replace("/s+", "").contentEquals((integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replace("/s+", "")));	
				  break;
			  case 5:
				  assertTrue(myTreatmentPageUtils.observation().getText().replaceAll("\\s+", "").contentEquals((integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", ""))); 
				  break;
			  case 6:
				  assertTrue(myTreatmentPageUtils.diagnosis().getText().replaceAll("\\s+", "").contentEquals((integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "")));
				  break;
			  case 7:
				  drugName = (integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 8:
				  dosage =(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 9:
				  frequency = (integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 10:
				  drug_days = (integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");
				  break;
			  case 11:
				  beforeOrafter = (integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, excelCol)).replaceAll("\\s+", "").split("/");  
				  System.out.println(Arrays.asList(beforeOrafter));
				  C_Admin_patientPageUtils.validate_and_download_Prescription(drugName,dosage,frequency,drug_days,beforeOrafter);
				  break;
			 }  			 
		}
	}
	public void validate_Medicaltreatment() throws IOException, ParseException, InterruptedException {
		int lastRow =rowSize(doctorFile,"MedicalTreatments");
		int lastCol = columnSize(doctorFile, "MedicalTreatments");
		int excelRow=1;
		
		wait_pageLoad_complate();
		if(wait_doctorTable().isDisplayed()==true) {
			WebElement TargetRows = findElement(C_Admin_doctorLocator.targetRow);
			List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));	
		EXCELOOP:
		while(excelRow<=lastRow) {		
			String previousRow = integerConverter_excel(doctorFile,"MedicalTreatments",excelRow-1, 0);
			String currentRow =  integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, 0);
			if(!(excelRow==lastRow)) {
				nextRow =  integerConverter_excel(doctorFile,"MedicalTreatments",excelRow+1, 0);
			}
			TABLElOOP:
			for(int tableRow=1;tableRow<=TotalRowsList.size()-1;tableRow++) {
				wait_pageLoad_complate();	
				
				if((previousRow.contentEquals(currentRow)) && (excelRow==lastRow)){
					Medicaltreatment_ReadExcel(excelRow, lastCol);
					wait_pageLoad_complate();
					backTodoctor().click();
					wait_pageLoad_complate();
					break EXCELOOP;				
				}
				else if(!(previousRow.contentEquals(currentRow)) && (excelRow==lastRow)) {
					if(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, 0)).click();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break EXCELOOP;
					 }
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}
				}
				else if(!(previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, 0)).click();
						wait_pageLoad_complate();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						backTodoctor().click();
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;			
					}
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
						assert false;
					}		 
				}							 				 					 
				else if((previousRow.contentEquals(currentRow)) && !(nextRow.contentEquals(currentRow))) {
					wait_pageLoad_complate();
					Medicaltreatment_ReadExcel(excelRow, lastCol);
					backTodoctor().click();
					wait_pageLoad_complate();
					excelRow++;
					break TABLElOOP;
					}		
				else if(!(previousRow.contentEquals(currentRow)) && (nextRow.contentEquals(currentRow))) {
					if(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "").equalsIgnoreCase(grid_ID(tableRow).getText().replaceAll("\\s+", ""))) {
						grid_viewdoctor(integerConverter_excel(doctorFile,"MedicalTreatments",excelRow, 0)).click();
						Medicaltreatment_ReadExcel(excelRow, lastCol);
						wait_pageLoad_complate();
						excelRow++;
						break TABLElOOP;
					 }		
					else if((paginationNext().isEnabled()==false)&&(tableRow==TotalRowsList.size()-1)){
						System.out.println("Appointment ID"+" "+integerConverter_excel(doctorFile,"MedicalTreatments",excelRow,0).replaceAll("\\s+", "")+" "+"not found");
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
}