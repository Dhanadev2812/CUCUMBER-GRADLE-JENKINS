package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import clinang.pageUtils.ClinicAdmin_DashboardPageUtils;
import clinang.pageUtils.ClinicAdmin_LoginPageUtils;
import clinang.webDriverUtils.RunTimeVariables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicAdmin_LoginStepDefs {
	
	ClinicAdmin_LoginPageUtils clinicAdmin_login = new ClinicAdmin_LoginPageUtils();
	ClinicAdmin_DashboardPageUtils ClinicAdmin_dashboard = new ClinicAdmin_DashboardPageUtils();
	RunTimeVariables vars = new RunTimeVariables();
	
	@And("^Move to admin login page$")
	public void admin_loginPage() {
		clinicAdmin_login.Click_clinicLogin();
		clinicAdmin_login.wait_pageLoad_complate();
		clinicAdmin_login.clinicTitle();
	}
	
	@When("^Enter clinic admin credentials$")
	public void enter_credentials(DataTable inputs) {
		clinicAdmin_login.passLoginDetails(inputs);
	}
	
	@And("^Click on Login button$")
	public void click_loginButton() {
		clinicAdmin_login.click_login();
		clinicAdmin_login.wait_pageLoad_complate();
	}
	
	@Then("^Check i am logged in as a clinic admin$")
	public void check_loggedIn_clinicAdmin() throws InterruptedException {
		clinicAdmin_login.wait_pageLoad_complate();
		ClinicAdmin_dashboard.wait_dashboard_calender();
		assertTrue(clinicAdmin_login.get_currenturl().equals(vars.getEnvironmentUrl()+"portal/admin-dashboard"));
		System.out.println("Clinic admin logged in successfully");
	}
}