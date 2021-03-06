package clinang.Locators;

import org.openqa.selenium.By;

public class Patient_PaymentLocators {
	
	public By paymentModule = By.xpath("//a[@href='/portal/payments']");
	public By appointmentTab = By.xpath("//div[@tabindex='0']");
	public By packageTab =  By.xpath("//div[@tabindex='-1']");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
	public By paymentTable = By.xpath("//table");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By grid_doctorName = By.xpath("//td[@class='mat-cell cdk-column-drname mat-column-drname ng-star-inserted']");
	public By grid_amount =By.xpath("//td[@class='mat-cell cdk-column-amount mat-column-amount ng-star-inserted']");
	public By grid_clinicName = By.xpath("//td[@class='mat-cell cdk-column-clinicname mat-column-clinicname ng-star-inserted']");
	public By pageLoader =By.xpath("//img[class='pl-3 loader']");
	public By invoice_id = By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[1]");
	public By invoice_doctorName = By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[2]");
	public By invoice_fee =By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[3]");
	public By downloadInvoice = By.xpath("//span[(normalize-space(text())='Download Invoice')]");
}
