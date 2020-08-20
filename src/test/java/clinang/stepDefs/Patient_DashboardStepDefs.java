package clinang.stepDefs;

import clinang.pageUtils.Patient_DashboardPageUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Patient_DashboardStepDefs {
	
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	
	@Then("^click on logout button$")
	public void clickonLogout() throws InterruptedException {
		dashboard.clickLogout();
	}
	
	@And("^Click on edit profile option$")
	public void click_editProfile() {
		dashboard.clickEditProfile();
		
	}
	
	
	
}