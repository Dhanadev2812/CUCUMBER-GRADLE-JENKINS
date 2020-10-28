package clinang.pageUtils;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.Locators.Patient_AppointmentLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class Patient_AppointmentPageUtils extends CustomDriver{
	
	Patient_AppointmentLocators appointmentLocators = new Patient_AppointmentLocators();
	Patient_BookAppointmentPageUtils B_appointment = new Patient_BookAppointmentPageUtils();
	private String activeSlot;
	public String[] reschedule_appointmentDetails;
	public String[] appointmentViewpage_getDetails;
	private String appointmentDateTime;
	public String[] appointmentView_followupDetails;
	public String[] followUpcomment_viewPage_get;
	
	private WebElement appointmentModule() {
		return findElement(appointmentLocators.appointmentModule);
	}
	
	public void Click_appointmentModule() {
		appointmentModule().click();
	}
	
	private WebElement appointmentList_today() {
		return findElement(appointmentLocators.appointmentList_today);
	}
	
	public void Click_appointmentList_today() {
		appointmentList_today().click();
	}
	
	private WebElement appointmentList_upcoming() {
		return findElement(appointmentLocators.appointmentList_upcoming);
	}
	
	public void Click_appointmentList_upcoming() {
		appointmentList_upcoming().click();
	}
	
	private WebElement appointmentList_past() {
		return findElement(appointmentLocators.appointmentList_past);
	}
	
	public void Click_appointmentList_past() {
		appointmentList_past().click();
	}
	
	private WebElement appointmentList_cancelled() {
		return findElement(appointmentLocators.appointmentList_cancelled);
	}
	
	public void Click_appointmentList_cancelled() {
		appointmentList_cancelled().click();
	}
	
	private WebElement paginationNext() {
		return findElement(appointmentLocators.paginationNext);
	}
	
	public WebElement wait_appointmentTable() {
		return findElement(appointmentLocators.appointmentTable);
	}
	
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	public WebElement grid_appointmentID_single() {
		return findElement(By.xpath("//table/tbody/tr/td[1]"));
	}
	
	private WebElement grid_viewAppointment(String appointmentID) {
		return findElement(By.xpath("//td[contains(text(),'"+ appointmentID +"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View Appointment']"));
	}
	
	private WebElement reschedulebutton() {
		return findElement(appointmentLocators.rescheduleButton);
	}
	
	public void Click_reschedule() {
		reschedulebutton().click();
	}
	
	public WebElement slot(String slot) {
		return findElement(By.xpath("//span[(normalize-space(text())"+"="+"'"+slot+"'"+")]"));	
	}
	
	private WebElement comment() {
		return findElement(appointmentLocators.reschedule_comment);
	}
	
	public void enter_rescheduleComment(String comment) {
		comment().sendKeys(comment);
	}
	
	private WebElement submitReschedule_button() {
		return findElement(appointmentLocators.submitReschedule);
	}
	
	public void submit_Reschedule() {
		submitReschedule_button().click();
	}
	
	private WebElement messageBox() {
		return findElement(appointmentLocators.messageBox);
	}
	
	public String get_message() {
		return messageBox().getText();
	}
	
	public void wait_pageLoadercomplate() {
		 Loader(appointmentLocators.appointment_Loader);
	}
	
	private WebElement reschedule_dateOfappointment() {
		return findElement(appointmentLocators.reschedule_get_dateOfappointment);
	}
	
	private List<WebElement> slot_activeCheck() {
		return findElement_list(appointmentLocators.slotList_active_check);
	}
	
	private WebElement closeAlertbox() {
		return findElement(appointmentLocators.closeAlertbox);
	}
	
	public void click_closeOption() {
		closeAlertbox().click();
	}
	
	private WebElement appointmentView_getAppointmentID() {
		return findElement(appointmentLocators.appointmentView_getAppointmentID);
	}
	
	private WebElement appointmentView_getSpeciality() {
		return findElement(appointmentLocators.appointmentView_getSpeciality);
	}
	
	private WebElement appointmentView_getClinic() {
		return findElement(appointmentLocators.appointmentView_getClinic);
	}
	
	private WebElement appointmentView_getDatetime() {
		return findElement(appointmentLocators.appointmentView_getDatetime);
	}
	
	private WebElement appointmentView_getType() {
		return findElement(appointmentLocators.appointmentView_getType);
	}
	
	private WebElement appointmentView_getDoctor() {
		return findElement(appointmentLocators.appointmentView_getDoctor);
	}
	
	private WebElement appointmentView_comment() {
		return findElement(appointmentLocators.appointmentView_comment);
	}
	private WebElement appointmentView_folllowUpcomment() {
		return findElement(appointmentLocators.appointmentView_followUpcomment);
	}
	public WebElement wait_cancelConfirm_alertBox() {
		return waitForElementDisplayed(appointmentLocators.cancelConfirm_alertBox);
	}
	private WebElement cancelButton() {
		return findElement(appointmentLocators.cancelButton);
	}
	
	public void click_cancelButton() {
		cancelButton().click();
	}
	private WebElement confirmCancel_button() {
		return findElement(appointmentLocators.cancelConfirm_button);
	}
	public void click_confirmCancel( ) {
		confirmCancel_button().click();
	}
	
	private WebElement upload_medicalReport() {
		return findElement(appointmentLocators.upload_medicalReport);
	}
	private WebElement medicalReport_description() {
		return findElement(appointmentLocators.medicalReport_description);		
	}
	private WebElement submit_medicalReport() {
		return findElement(appointmentLocators.submit_medicalReport);
	}
	public WebElement get_medicalReport_reportName (int spanCount) {
		return findElement(By.xpath("//span/span["+spanCount+"]/div/div/div[1]//child::div[2]/p"));
	}
	public WebElement get_medicalReport_reportDescription(int spanCount) {
		return findElement(By.xpath("//span/span["+spanCount+"]/div/div/div[2]//child::p"));
	}
	
	private WebElement medicalReport_download(int spanCount) {
		return findElement(By.xpath("//span/span["+spanCount+"]/div/div/div[1]/div/div[2]//child::p/a/span[(normalize-space(text())='Download')]"));
	}
	
	private WebElement medicalReport_view(int spanCount) {
		return findElement(By.xpath("//span/span["+spanCount+"]/div/div/div[1]/div/div[2]//child::p/a/span[(normalize-space(text())='View')]"));
	}
	private WebElement medicalReport_delete(int spanCount) {
		return findElement(By.xpath("//span/span["+spanCount+"]/div/div/div[1]/div/div[2]//child::p/a/span[(normalize-space(text())='Delete')]"));
	}
	public WebElement get_span_medicalReports() {
		return findElement(appointmentLocators.get_medicalReports_spans);	
	}
	private WebElement deleteReport_confirm()  {
		return findElement(appointmentLocators.deleteReport_confirm);
	}
	private WebElement patientUploads() {
		return findElement(appointmentLocators.patientUploads);
	}
	public WebElement bookFollowup() {
		return findElement(appointmentLocators.bookFollowup_button);
	}
	public WebElement bookFollowup_fee() {
		return findElement(appointmentLocators.bookFollowup_fee);
	}
	public WebElement bookFollowup_comment() {
		return findElement(appointmentLocators.bookFollowup_comment);
	}
	private WebElement accept_bookFollowup_button() {
		return findElement(appointmentLocators.accept_bookFollowup);
	}
	public void accept_bookFollowup() {
		accept_bookFollowup_button().click();
	}
	private WebElement wait_viewappointmentPage() {
		return fluentWait(By.xpath("//*[(normalize-space(text())='Appointment ID')]"));
	}
	public void findAppointment(String appointmentID ) {
		
		wait_pageLoadercomplate();
		whileLoop:
		while(true) {
			
			if(wait_appointmentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(appointmentLocators.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {
						if(TotalRowsList.size()-1==1) {
							assertTrue(grid_appointmentID_single().getText().contentEquals(appointmentID));
							grid_viewAppointment(appointmentID).click();
							wait_pageLoadercomplate();
							break whileLoop;		
						}
						else if(appointmentID.contentEquals(grid_appointmentID(i).getText())) {
							grid_viewAppointment(appointmentID).click();
							wait_pageLoadercomplate();
							break whileLoop;															 			 
						} 
						else if((paginationNext().isEnabled()==false)&&(i==TotalRowsList.size()-1)){
							assert false;
						}
						else if(TotalRowsList.size()-1==0) {
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
		
	public void get_rescheduleDetails() throws ParseException {
		String dateOfappointment_reschedulePage = reschedule_dateOfappointment().getAttribute("value");		
		
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
	    SimpleDateFormat format2 = new SimpleDateFormat("MMM dd, yyyy");
	    Date date = format1.parse(dateOfappointment_reschedulePage);
	    String appointmentDate = format2.format(date);
	    
	    List<WebElement> spanList = slot_activeCheck();	
		for( WebElement slot: spanList){
			String getClass =slot.getAttribute("class");
			if(getClass.contains("activeslotbutton")) {
				activeSlot = slot.getText();				
				break;
			}						
		}
		
		String reschedule_comment = comment().getAttribute("value");
		String appointment = appointmentDate +" "+activeSlot;	
		this.reschedule_appointmentDetails = new String[] {appointment,reschedule_comment};
	}
	
	public void get_appointmentDetails_viewPage() throws ParseException {
		wait_viewappointmentPage();
		wait_pageLoadercomplate();
		String appointmentID = appointmentView_getAppointmentID().getText();
		String speciality = appointmentView_getSpeciality().getText();
		String clinic = appointmentView_getClinic().getText();
		String dateAndtime = appointmentView_getDatetime().getText();
		String type = appointmentView_getType().getText();
		String doctor = appointmentView_getDoctor().getText();
		String comment = appointmentView_comment().getText();
		
		String[] appointmentTime=appointmentView_getDatetime().getText().split(" ");
		
		if(appointmentTime[3].startsWith("0")) {
			String[] appointmentTime_hr = appointmentTime[3].split(":");
			String appointmentHr_replace = appointmentTime_hr[0].replace("0", " ");
			String newAppointmenttime = appointmentHr_replace+":"+appointmentTime_hr[1]+" "+appointmentTime[4];
			 appointmentDateTime = appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+newAppointmenttime;
		}	
		
		else {
			appointmentDateTime =  appointmentTime[0]+" " +appointmentTime[1]+" "+appointmentTime[2]+" "+" "+appointmentTime[3]+" "+appointmentTime[4];
		}
		
		this.appointmentViewpage_getDetails = new String[] {appointmentID,speciality,clinic,type,doctor,appointmentDateTime,comment};
		
	}
	public void get_followUpcomment_viewPage() {
		String followUpcomment = appointmentView_folllowUpcomment().getText();
		this.followUpcomment_viewPage_get = new String[] {followUpcomment};
	}
	public void check_patientUpload_empty() {
		wait_pageLoadercomplate();
		if(patientUploads().getText().contains("No documents uploaded")) {
			System.out.println("No documents uploaded");
			assert false;
		}
	}
	public void addFile_medicalRecord(DataTable medicalReport) {
		List<List<String>> data = medicalReport.asLists(String.class);	
		int fileCount = data.size();
		for (int i = 0; i<fileCount; i++) {
			String File_path = data.get(i).get(0);
			String description = data.get(i).get(1);
			File file = new File(File_path);
			upload_medicalReport().sendKeys(file.getAbsolutePath());		
			medicalReport_description().sendKeys(description);
			submit_medicalReport().click();
			wait_pageLoadercomplate();
			assertTrue(get_message().contains("Medical record uploaded successfully"));
			click_closeOption();
		}
	}
	
	public void validate_uploadedReport(DataTable uploaded_medicalReport) {	
		wait_pageLoadercomplate();
		List<List<String>> data = uploaded_medicalReport.asLists(String.class);
		int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount"));   
		int fileCount = data.size();
		
		for (int i = 0; i<fileCount; i++) {
			String reportName = data.get(i).get(0);
			String reportDescription = data.get(i).get(1);
			loop02:
			for(int j=1;j<numberOfrecord_medicalReport+1;j++) {	
				check_patientUpload_empty();			
				if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(j).getText().replaceAll("\\s+", ""))) {
					if(reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", ""))) {
						assert true;
						break loop02;
					}
				}	
				
				if(j==numberOfrecord_medicalReport) {
					if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(numberOfrecord_medicalReport).getText().replaceAll("\\s+", ""))) {
						if(reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", ""))) {
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
				}
				
			}				
		}
	}
	private void download_medicalReport(int report_id) {
		String substring = get_medicalReport_reportName(report_id).getText().length() > 3 ? get_medicalReport_reportName(report_id).getText().substring(get_medicalReport_reportName(report_id).getText().length() - 3) : get_medicalReport_reportName(report_id).getText();
		if(substring.equals("pdf")) {			
			medicalReport_download(report_id).click();
		}
		else if(substring.equals("jpg")||substring.equals("png")) {
			medicalReport_view(report_id).click();
		}
	}
	public void downloadAllreport() throws InterruptedException {
		int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount")); 
		for (int i = 1; i<numberOfrecord_medicalReport+1; i++) {
			check_patientUpload_empty();
			download_medicalReport(i);
			Thread.sleep(2000);
		}
	}
	
	public void download_duplicate_report(int report_id,int reportCount) {
		wait_pageLoadercomplate();
		int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount"));
		
        for (int i = report_id; i < reportCount+1; i++)
        {
            for (int j = report_id+1; j < numberOfrecord_medicalReport+1; j++)
            {           
                if (((get_medicalReport_reportName(i).getText().replaceAll("\\s+", "").equals(get_medicalReport_reportName(j).getText().replaceAll("\\s+", ""))) && (i != j)) 
                		&& get_medicalReport_reportDescription(i).getText().replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", "")))
                {
                	download_medicalReport(j);
                }
            }
           break;
        }
	}
	public void downloadSpecificreport(DataTable uploaded_medicalReport) {
		
			wait_pageLoadercomplate();
			List<List<String>> data = uploaded_medicalReport.asLists(String.class);
			int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount"));   
			int fileCount = data.size();
			
			for (int i = 0; i<fileCount; i++) {
				String reportName = data.get(i).get(0);
				String reportDescription = data.get(i).get(1);
				
				loop02:
				for(int j=1;j<numberOfrecord_medicalReport+1;j++) {	
					check_patientUpload_empty();
					if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(j).getText().replaceAll("\\s+", "")) 
							&& (reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", "")))) {
																	
							download_medicalReport(j);
							download_duplicate_report(j,fileCount);
							break loop02;
						}
					
					if(j==numberOfrecord_medicalReport+1) {
						if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(numberOfrecord_medicalReport).getText().replaceAll("\\s+", "")) 
								&& (reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", "")))) {
							 
							download_medicalReport(j);
							break loop02;
							}
							else {
								System.out.println("Invalid report name/report description");
								assert false;
							}
						}						
					}																			
			}
		}	
	public void deleteReport(int recordID) {
		medicalReport_delete(recordID).click();
		wait_pageLoadercomplate();
		deleteReport_confirm().click();
		wait_pageLoadercomplate();
		assertTrue(get_message().contains("Medical record deleted successfully."));
		click_closeOption();
		wait_pageLoadercomplate();
	}
	public void deleteAllreport() {
		wait_pageLoadercomplate();
		int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount")); 
		int i = 1;
		while(i<=numberOfrecord_medicalReport){			
			if(patientUploads().getText().contains("No documents uploaded")) {
				break;
			}
			deleteReport(i);
		}
	}
	
	public void deleteSpecificreport(DataTable uploaded_medicalReport) {
		wait_pageLoadercomplate();
		List<List<String>> data = uploaded_medicalReport.asLists(String.class);
		int numberOfrecord_medicalReport = Integer.parseInt(get_span_medicalReports().getAttribute("childElementCount"));   
		int fileCount = data.size();
		
		for (int i = 0; i<fileCount; i++) {
			String reportName = data.get(i).get(0);
			String reportDescription = data.get(i).get(1);
			
			loop02:
			for(int j=1;j<numberOfrecord_medicalReport+1;j++) {	
				check_patientUpload_empty();
				if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(j).getText().replaceAll("\\s+", "")) 
						&& (reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", "")))) {
					deleteReport(j);											
					break loop02;
					}
				
				if(j==numberOfrecord_medicalReport+1) {
					if(reportName.replaceAll("\\s+", "").equals(get_medicalReport_reportName(numberOfrecord_medicalReport).getText().replaceAll("\\s+", "")) 
							&& (reportDescription.replaceAll("\\s+", "").equals(get_medicalReport_reportDescription(j).getText().replaceAll("\\s+", "")))) {
						 
						deleteReport(j);
						break loop02;
						}
						else {
							System.out.println("Invalid report name/report description");
							System.out.println(reportName.replaceAll("\\s+", ""));
							System.out.println(get_medicalReport_reportName(numberOfrecord_medicalReport).getText().replaceAll("\\s+", ""));
							assert false;
						}
					}						
				}																			
		}
	}
	
	public void bookFollowup_Appointment() {
		bookFollowup().click();
		String followupFee = bookFollowup_fee().getText();
		String followupComment = bookFollowup_comment().getText();
		
		this.appointmentView_followupDetails = new String[] {followupFee,followupComment};
	}
	
	public String check_patient_followupFee(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>patientFollowupfee = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : patientFollowupfee) {
			  wait_pageLoadercomplate();
			  if((Arrays.asList(B_appointment.editProfile.patient_Country_Array)).contains(B_appointment.getCurrentcountry())) {
				  assertTrue(Arrays.asList(appointmentView_followupDetails[0]).contains(data.get("Domestic Followup Fee")));
			  }		 
			  else if((Arrays.asList(B_appointment.editProfile.patient_Country_Array)).contains(B_appointment.getCurrentcountryCode())) {
				  assertTrue(Arrays.asList(appointmentView_followupDetails[0]).contains(data.get("Domestic Followup Fee")));
			  }
			  else {
				  assertTrue(Arrays.asList(appointmentView_followupDetails[0]).contains(data.get("Overseas Followup Fee")));
			  }
		  }
		  return String.valueOf(patientFollowupfee);
			  
		  }
	public String passFollowupappointmentDetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>appointment_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : appointment_input) {
			  
			  B_appointment.mobile().click();
			  B_appointment.mobile().clear();
			  B_appointment.mobile().sendKeys(data.get("mobile"));
			  if(data.get("appointment_type").equals("Online Consultation")) {
				  B_appointment.online_radioButton().click();		  
			  }
			  else if (data.get("appointment_type").equals("Clinic Visit")) {
				  B_appointment.clinicVisit_radioButton().click();
			  }		  		  
			  B_appointment.chiefComment().sendKeys(data.get("chief_complaint"));
		  } 
		
		return String.valueOf(appointment_input);
		
		  }	 
	
	
 }
		
	
	
