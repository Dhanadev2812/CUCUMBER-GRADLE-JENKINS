package clinang.pageUtils;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import clinang.Locators.ClinicAdmin_AppointmentLocators;
import clinang.stepDefs.Patient_AppointmentStepDefs;
import clinang.webDriverUtils.CustomDriver;

public class ClinicAdmin_AppointmentPageUtils extends CustomDriver{
	ClinicAdmin_AppointmentLocators C_Admin_appointmentLocator = new ClinicAdmin_AppointmentLocators();
	ClinicAdmin_PatientPageUtils C_Admin_patientPageUtils = new ClinicAdmin_PatientPageUtils();
	Patient_AppointmentStepDefs appointmentStepdefs = new Patient_AppointmentStepDefs();
	Patient_AppointmentPageUtils appointmentPageUtils = new Patient_AppointmentPageUtils();
	private String patientFile;
	private String appointmentDateTime;
	private String requireddate;
	private String[] medicalReportname;
	public String totalAppointmentcount;
	
	private WebElement appointmentModule() {
		return findElement(C_Admin_appointmentLocator.appointmentModule);
	}
	public void click_appointmentModule() {
		appointmentModule().click();
	}
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_appointmentLocator.pageLoader);
	}	
	private WebElement backToappointment() {
		return findElement(C_Admin_appointmentLocator.backToappointment);
	}
	private WebElement totalAppointmentcount() {
		return findElement(C_Admin_appointmentLocator.totalAppointmentcount);
	}
	public String get_totalAppointmentcount() {
		String[] countList = totalAppointmentcount().getText().split("of");
		String totalAppointmentcount = countList[1].replaceAll("\\s+", "");
		return totalAppointmentcount;
	}
	public void get_patientFile(String patient_details_file) {
		patientFile = patient_details_file;	
	}
	public void Appointment_ReadExcel(int excelRow,int lastCol) throws IOException, ParseException, InterruptedException {
		System.out.println("                                                     ");
		System.out.println("Start validating appointment ID :"+" "+ integerConverter_excel(patientFile,"Appointments",excelRow, 3));
		 for(int excelCol=1;excelCol<=lastCol;excelCol++) {
			 int columnCount = excelCol;
			 switch (columnCount) {
			  case 1:		
				  String appointmentDate = integerConverter_excel(patientFile,"Appointments",excelRow, excelCol);
				  final String givenDateFormat = "dd/MM/yyyy";
				  SimpleDateFormat old_format = new SimpleDateFormat("MMM dd, yyyy");
				  Date new_format = old_format.parse(appointmentDate);
				  old_format.applyPattern("dd/MM/yyyy");
				  C_Admin_patientPageUtils.requireddate = old_format.format(new_format);
				  System.out.println("Patient ID :"+" "+ integerConverter_excel(patientFile,"Appointments",excelRow, 0));
				  break;
			  case 2:
				  String Zone = integerConverter_excel(patientFile,"Appointments",excelRow, excelCol);
				  appointmentStepdefs.compare__date(C_Admin_patientPageUtils.requireddate, Zone);
				  if(integerConverter_excel(patientFile,"Appointments",excelRow, 13).contentEquals("Cancelled")) {
					  appointmentPageUtils.Click_appointmentList_cancelled();
				  }
			    break;
			  case 3:
				  wait_pageLoad_complate();
				  appointmentStepdefs.find_appointmentID(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol));
				  System.out.println("Appointment ID:"+" "+integerConverter_excel(patientFile,"Appointments",excelRow, excelCol));
				  break;
			  case 4: 
				  wait_pageLoad_complate();
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
				  System.out.println("Appointment Date:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[5]));
				  break;
			  case 5: 
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[3]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Appointment type:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[3]));
				  break;
			  case 6:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[1]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Appointment speciality:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[1]));
				  break;
			  case 7:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[4]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Doctor Name:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[4]));
				  break;
			  case 9:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[2]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Clinic Name:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[2]));
				  break;
			  case 10:
				  assertTrue(Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
				  System.out.println("Chief complaint:"+" "+Arrays.asList(appointmentPageUtils.appointmentViewpage_getDetails[6]));
				  break;
			  case 11:
				  if(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol).equalsIgnoreCase("")) {
					  String appointmentID = integerConverter_excel(patientFile,"Appointments",excelRow, 3);
					  System.out.println("No Followup Comments Updated for"+" appointment ID:"+" "+ appointmentID );  
				  }
				  else {
					  appointmentPageUtils.get_followUpcomment_viewPage();
					  assertTrue(Arrays.asList(appointmentPageUtils.followUpcomment_viewPage_get[0]).contains(integerConverter_excel(patientFile,"Appointments",excelRow, excelCol)));
					  System.out.println("Followup :"+" "+Arrays.asList(appointmentPageUtils.followUpcomment_viewPage_get[0]));
				  }
				  break;
			 }
			 wait_pageLoad_complate();
		 }
	}
	public void validate_appointmentDetails() throws IOException, ParseException, InterruptedException {	
		int lastRow =rowSize(patientFile,"Appointments");
		int lastCol = columnSize(patientFile, "Appointments");
		int excelRow=1;
		while(excelRow<=lastRow) {
			Appointment_ReadExcel(excelRow, lastCol);
			backToappointment().click();
			excelRow++;
		}
	}
	
	public void Medicalreport_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {
		System.out.println("                                      ");
		System.out.println("Start validating medical report details for appointment ID"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow, 3));
		System.out.println("Patient ID :"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow, 0));
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
				  System.out.println("Appointment Date is :"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol));
				  break;
			  case 2:
				  String Zone = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol);
				  appointmentStepdefs.compare__date(requireddate, Zone);
			    break;
			  case 3: 
				  wait_pageLoad_complate();
				  appointmentStepdefs.find_appointmentID(integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol));
				  System.out.println("Appointment ID :"+" "+integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol));
				  break;	
			  case 4:
				  medicalReportname = integerConverter_excel(patientFile,"MedicalRecord",excelRow, excelCol).split(",");
				  System.out.println("Started downloading medical report"+" "+Arrays.asList(medicalReportname));
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
					assertTrue(reportName.replaceAll("\\s+","").equalsIgnoreCase(C_Admin_patientPageUtils.medicalReport_noRecord().getText().replace(" ","")));
					System.out.println("No Documents uploaded");
				}
				else if(reportName.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportName(j).getText().replaceAll("\\s+", ""))) {
					if(reportDescription.replaceAll("\\s+", "").equalsIgnoreCase(appointmentPageUtils.get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", ""))) {
						appointmentPageUtils.downloadAllreport();
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
		while(excelRow<=lastRow) {
			Medicalreport_ReadExcel(excelRow, lastCol);
			backToappointment().click();
			excelRow++;
		}
	}
}