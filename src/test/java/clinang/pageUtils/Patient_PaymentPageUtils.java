package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import clinang.patient_Locators.Patient_PaymentLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_PaymentPageUtils extends CustomDriver{
	
	Patient_PaymentLocators  paymentLocators = new Patient_PaymentLocators();
	public String[] grid_paymentDetails;
	public String listPage_doctor;
	public String listPage_amount;
	public String listPage_clinic;
	private String[] invoiceDetails;
	public List<String> invoice_doctor;
	public List<String> invoice_fees;
	
	private WebElement paymentModule() {
		return findElement(paymentLocators.paymentModule);
	}
	
	public void click_paymentModule() {
		paymentModule().click();
	}
	
	private WebElement appointmentTab() {
		return findElement(paymentLocators.appointmentTab);
	}
	
	public void click_appointmentTab() {
		appointmentTab().click();
	}
	
	private WebElement packageTab() {
		return findElement(paymentLocators.packageTab);
	}
	
	public void click_packageTab() {
		packageTab().click();
	}
	
	private WebElement pagination_next() {
		return findElement(paymentLocators.paginationNext);
	}
	public void pageLoad() {
		Loader(paymentLocators.pageLoader);
	}
	
	private WebElement wait_paymentTable() {
		return waitForElementPresent(paymentLocators.paymentTable);
	}
	
	private WebElement grid_appointmentID(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
	}
	
	private WebElement grid_doctorName(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
	}
	
	private WebElement grid_amount(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
	}
	
	private WebElement grid_clinic(int i) {
		return findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]"));
	}
	
	private WebElement grid_viewInvoice(int i) {
		return findElement(By.xpath("//td[contains(text(),'" +i+"')]//following-sibling::td[contains(@class, 'mat-cell cdk-column-invoice mat-column-invoice ng-star-inserted')]//*[local-name()='svg']"));
	}
	
	private WebElement invoice_id() {
		return findElement(paymentLocators.invoice_id);
	}
	private WebElement invoice_doctorName() {
		return findElement(paymentLocators.invoice_doctorName);
	}
	private WebElement invoice_fee() {
		return findElement(paymentLocators.invoice_fee);
	}
	private WebElement downloadInvoice() {
		return findElement(paymentLocators.downloadInvoice);
	}
	
	public void detailsFromlistPage(List<String> appointmentId) throws InterruptedException {		
		wait_paymentTable();	
		whileloop:
		while(true) {
			
			if(wait_paymentTable().isDisplayed()==true) {
				WebElement TargetRows = findElement(paymentLocators.targetRow);
				List<WebElement>TotalRowsList = TargetRows.findElements(By.tagName("tr"));				
					int i = 1;					
					while(i<=TotalRowsList.size()-1) {			
						if(appointmentId.contains(grid_appointmentID(i).getText())) {
							String grid_doctor = grid_doctorName(i).getText();
							String paymentAmount =grid_amount(i).getText();
							String[] fee=paymentAmount.split(" ");
							String grid_paymentAmount = fee[1].replaceAll("[^0-9.]", "");
							String grid_clinic = grid_clinic(i).getText();
							
							this.grid_paymentDetails = new String[] {grid_doctor,grid_paymentAmount,grid_clinic};
							 listPage_doctor = grid_paymentDetails[0];
							 listPage_amount = grid_paymentDetails[1];
							 listPage_clinic =grid_paymentDetails[2];
							
							 grid_viewInvoice(i).click();		 					 
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
	
	public void get_invoiceDetails() {
		
		String invoice_appointmentID = invoice_id().getText();
		String invoice_doctorName = invoice_doctorName().getText();
		String invoice_fee =invoice_fee().getText();
		String[] fee=invoice_fee.split(" ");
		String table_invoiceFee = fee[1].replaceAll("[^0-9.]", "");
		
		this.invoiceDetails = new String[] {invoice_appointmentID,invoice_doctorName,table_invoiceFee};
		invoice_doctor = Arrays.asList(invoiceDetails[1]);
		invoice_fees = Arrays.asList(invoiceDetails[2]);
		System.out.println(Arrays.asList(invoiceDetails));
	}
	public void downloadInvoices() {
		pageLoad();
		downloadInvoice().click();
	}
}