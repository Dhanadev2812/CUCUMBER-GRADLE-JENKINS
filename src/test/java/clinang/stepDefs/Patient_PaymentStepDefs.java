package clinang.stepDefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clinang.pageUtils.Patient_PaymentPageUtils;
import io.cucumber.java.en.And;

public class Patient_PaymentStepDefs {
	
	Patient_PaymentPageUtils Payment_pageUtils = new Patient_PaymentPageUtils();
	
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
}