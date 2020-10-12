package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clinang.Patient_pageUtils.Patient_BookAppointmentPageUtils;
import clinang.Patient_pageUtils.Patient_PaymentPageUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Patient_PaymentStepDefs {
	
	Patient_PaymentPageUtils Payment_pageUtils = new Patient_PaymentPageUtils();
	Patient_BookAppointmentPageUtils bookAppointment = new Patient_BookAppointmentPageUtils();
	
@And("^Go to payment screen$")
public void moveTo_payment_module() {
	Payment_pageUtils.click_paymentModule();
}

@And("^Click on \"([^\"]*)\" tab$")
public void clickOn_tab(String tab) {
	switch (tab) {
	case "appointment":
		Payment_pageUtils.click_appointmentTab();
       break;  
    case "package":  
    	Payment_pageUtils.click_packageTab();
       break;
	}
}

@And("^Find the payment list based on appointment ID \"([^\"]*)\"$")
public void find_paymentList(String appointmentID) throws InterruptedException {
	List<String> List_appointmentID = new ArrayList<String>();
	List_appointmentID = Arrays.asList(appointmentID);
	Payment_pageUtils.detailsFromlistPage(List_appointmentID);
	}

@Then("^Validate the invoice details$")
public void validate_invoice() {
	Payment_pageUtils.get_invoiceDetails();
	assertTrue(Arrays.asList(Payment_pageUtils.listPage_doctor).equals(Payment_pageUtils.invoice_doctor));
	assertTrue(Arrays.asList(Payment_pageUtils.listPage_amount).equals(Payment_pageUtils.invoice_fees));
}

@Then("^Download the invoice$") 
public void downloadInvoice() {
	Payment_pageUtils.downloadInvoices();
}
}