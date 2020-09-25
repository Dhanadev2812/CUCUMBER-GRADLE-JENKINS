package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import java.util.List;

import clinang.patient_Locators.Patient_PaymentLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_PaymentPageUtils extends CustomDriver{
	
	Patient_PaymentLocators  paymentLocators = new Patient_PaymentLocators();
	public String[] grid_paymentDetails;
	public String listPage_doctor;
	public String listPage_amount;
	public String listPage_clinic;
	
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
	
	/*private void grid_viewInvoice(int i) {
		 hoverOverElementAndClick(findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/div/table/tbody/tr["+i+"]/td[7]/svg")));
	}*/
	
	
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
							
							 Thread.sleep(6000);
							 //grid_viewInvoice(i);
							 					 
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