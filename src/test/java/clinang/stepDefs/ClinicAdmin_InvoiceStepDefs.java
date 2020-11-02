package clinang.stepDefs;

import java.io.IOException;
import java.text.ParseException;

import clinang.pageUtils.ClinicAdmin_InvoicePageUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_InvoiceStepDefs {
	ClinicAdmin_InvoicePageUtils C_Admin_invoicePageUtils = new ClinicAdmin_InvoicePageUtils();
	
	@And("^Go to invoice module$")
	public void goTo_invoice_module() {
		C_Admin_invoicePageUtils.click_invoiceModule();
	}
	@When("^Get the invoice details from \"([^\"]*)\"$")
	public void get_invoice_details(String patient_details_file) throws IOException {
		C_Admin_invoicePageUtils.get_patientFile(patient_details_file);	
	}
	@Then("^Validate and download invoice details$")
	public void validate_download_invoice() throws IOException, ParseException, InterruptedException {
		C_Admin_invoicePageUtils.validateAnddownloadInvoice();
	}
	
	
}