package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_InvoiceLocators {
	public By invoiceModule = By.xpath("//a[@href='/portal/admin-invoice']");
	public By invoiceTable =By.xpath("//table");
	public By targetRow = By.xpath("//table[@class='mat-table']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
	public By paginationNext = By.xpath("//button[@aria-label='Next page']");
	public By invoice_id = By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[1]");
	public By invoice_doctorName = By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[2]");
	public By invoice_fee =By.xpath("//div[@class='mat-elevation-z8']//child::tbody/tr/td[3]");
	public By downloadInvoice = By.xpath("//span[(normalize-space(text())='Download Invoice')]");
}