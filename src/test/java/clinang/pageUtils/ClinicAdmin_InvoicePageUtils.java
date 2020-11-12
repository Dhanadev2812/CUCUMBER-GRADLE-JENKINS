package clinang.pageUtils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_InvoiceLocators;
import clinang.webDriverUtils.CustomDriver;

public class ClinicAdmin_InvoicePageUtils extends CustomDriver {
	ClinicAdmin_InvoiceLocators C_Admin_invoiceLocator = new ClinicAdmin_InvoiceLocators();
	private String patientFile;
	private String appointmentId;
	private String doctorName;
	private String patientName;
	
	private WebElement invoiceModule() {
		return findElement(C_Admin_invoiceLocator.invoiceModule);
	}
	public void click_invoiceModule() {
		invoiceModule().click();
	}
	private WebElement grid_appointmentID_Single() {
		return findElement(By.xpath("//table/tbody/tr/td[1]"));
	}
	private WebElement wait_paymentTable() {
		return waitForElementPresent(C_Admin_invoiceLocator.invoiceTable);
	}
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_invoiceLocator.pageLoader);
	}
	private WebElement grid_doctorName_Single() {
		return findElement(By.xpath("//table/tbody/tr/td[3]"));
	}
	private WebElement grid_patientName_Single() {
		return findElement(By.xpath("//table/tbody/tr/td[4]"));
	}
	private WebElement grid_fees_Single() {
		return findElement(By.xpath("//table/tbody/tr/td[5]"));
	}
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	
	private WebElement grid_doctorName(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
	}
	private WebElement grid_patientName(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
	}
	
	private WebElement grid_amount(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]"));
	}
	private WebElement grid_viewInvoice(String appointmentId) {
		return findElement(By.xpath("//td[(normalize-space(text())="+"'"+appointmentId+"')]//following-sibling::td[contains(@role,'gridcell')]//*[@matTooltip='View Invoice']"));
	}
	private WebElement pagination_next() {
		return findElement(C_Admin_invoiceLocator.paginationNext);
	}
	private WebElement invoice_id() {
		return findElement(C_Admin_invoiceLocator.invoice_id);
	}
	private WebElement invoice_doctorName() {
		return findElement(C_Admin_invoiceLocator.invoice_doctorName);
	}
	private WebElement invoice_fee() {
		return findElement(C_Admin_invoiceLocator.invoice_fee);
	}
	private WebElement downloadInvoice() {
		return findElement(C_Admin_invoiceLocator.downloadInvoice);
	}
	public void get_patientFile(String patient_details_file) {
		patientFile = patient_details_file;	
	}
	public void invoice_ReadExcel(int excelRow,int lastCol ) throws IOException, ParseException, InterruptedException {	
		wait_pageLoad_complate();
		appointmentId = integerConverter_excel(patientFile,"Appointments",excelRow, 3);
		doctorName = integerConverter_excel(patientFile,"Appointments",excelRow, 7);
		patientName = integerConverter_excel(patientFile,"Appointments",excelRow, 8);
		String fees = integerConverter_excel(patientFile,"Appointments",excelRow, 12);
		detailsFromlistPage(appointmentId,doctorName,patientName,fees);
	}  			 
	public void detailsFromlistPage(String appointmentId,String doctorName,String patientName,String fees) throws InterruptedException {		
		wait_paymentTable();	
		whileloop:
		while(true) {	
			if(wait_paymentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(C_Admin_invoiceLocator.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));				
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {	
						if(TotalRowsList.size()-1==1) {
							//invoice list page validation
							assertTrue((appointmentId.replaceAll("/s+", "")).contentEquals(grid_appointmentID_Single().getText().replaceAll("\\s+", "")));	
							assertTrue((doctorName.replaceAll("\\s+", "")).contentEquals(grid_doctorName_Single().getText().replaceAll("\\s+", "")));
							assertTrue((patientName.replaceAll("\\s+", "")).contentEquals(grid_patientName_Single().getText().replaceAll("\\s+", "")));
							String paymentAmount =grid_fees_Single().getText();
							String[] fee=paymentAmount.split(" ");
							String grid_paymentAmount = fee[1].replaceAll("[^0-9.]", "");	
							assertTrue((fees.replaceAll("\\s+", "")).contentEquals((grid_paymentAmount.replaceAll("\\s+", ""))));
							grid_viewInvoice(appointmentId).click();
							wait_pageLoad_complate();
							//view invoice validation
							String invoice_appointmentID = invoice_id().getText().replaceAll("\\s+", "");
							String invoice_doctorName = invoice_doctorName().getText().replaceAll("\\s+", "");
							String invoice_fee =invoice_fee().getText();
							String[] In_fees=invoice_fee.split(" ");
							String table_invoiceFee = In_fees[1].replaceAll("[^0-9.]", "");
							assertTrue((appointmentId.replaceAll("\\s+", "")).contentEquals(invoice_appointmentID));	
							assertTrue((doctorName.replaceAll("\\s+", "")).contentEquals(invoice_doctorName));
							assertTrue((fees.replaceAll("\\s+", "")).contentEquals(table_invoiceFee.replaceAll("\\s+", "")));
							System.out.println("Successfully validated invoice details for ID:"+" "+appointmentId);
							System.out.println("Started downloading invoice"+invoice_appointmentID);
							downloadInvoice().click();
							wait_pageLoad_complate();
							click_invoiceModule();
							wait_pageLoad_complate();
							break whileloop;
						}
						else if(appointmentId.contains(grid_appointmentID(i).getText())) {
							//invoice list page validation
							assertTrue((appointmentId.replaceAll("\\s+", "")).contentEquals(grid_appointmentID(i).getText().replaceAll("\\s+", "")));	
							assertTrue((doctorName.replaceAll("\\s+", "")).contentEquals(grid_doctorName(i).getText().replaceAll("\\s+", "")));
							assertTrue((patientName.replaceAll("\\s+", "")).contentEquals(grid_patientName(i).getText().replaceAll("\\s+", "")));		
							String paymentAmount =grid_amount(i).getText();
							String[] fee=paymentAmount.split(" ");
							String grid_paymentAmount = fee[1].replaceAll("[^0-9.]", "");
							assertTrue((fees.replaceAll("\\s+", "")).contentEquals(grid_paymentAmount.replaceAll("\\s+", "")));
							grid_viewInvoice(appointmentId).click();
							wait_pageLoad_complate();
							//view invoice validation	
							String invoice_appointmentID = invoice_id().getText().replaceAll("\\s+", "");
							String invoice_doctorName = invoice_doctorName().getText().replaceAll("\\s+", "");
							String invoice_fee =invoice_fee().getText();
							String[] In_fees=invoice_fee.split(" ");
							String table_invoiceFee = In_fees[1].replaceAll("[^0-9.]", "");
							assertTrue((appointmentId.replaceAll("\\s+", "")).contentEquals(invoice_appointmentID));	
							assertTrue((doctorName.replaceAll("\\s+", "")).contentEquals(invoice_doctorName));
							assertTrue((fees.replaceAll("\\s+", "")).contentEquals(table_invoiceFee.replaceAll("\\s+", "")));
							System.out.println("Successfully validated invoice details for ID:"+" "+appointmentId);
							System.out.println("Started downloading invoice"+" "+invoice_appointmentID);
							downloadInvoice().click();
							wait_pageLoad_complate();
							click_invoiceModule();
							wait_pageLoad_complate();
							break whileloop;			 
						} 			
						else if((pagination_next().isEnabled()==false)&&(i==TotalRowsList.size()-1)){
							assert false;
						}	
						i++;					
					}
				if(pagination_next().isEnabled()==true) {
					pagination_next().click();
					}				
				}	
			}	
		}	
	public void validateAnddownloadInvoice() throws IOException, ParseException, InterruptedException {
		int lastRow =rowSize(patientFile,"Appointments");
		int lastCol = columnSize(patientFile, "Appointments");
		int excelRow=1;
		while(excelRow<=lastRow) {
			invoice_ReadExcel(excelRow, lastCol);
			excelRow++;
		}
	}
	
}