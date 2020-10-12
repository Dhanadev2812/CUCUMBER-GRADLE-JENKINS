package clinang.stepDefs;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.BeforeClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import clinang.pageUtils.BrowserUtils;
import clinang.pageUtils.Patient_DashboardPageUtils;
import clinang.pageUtils.Patient_LoginPageUtils;
import clinang.webDriverUtils.RunTimeVariables;

public class Patient_LoginStepDefs {

	Patient_LoginPageUtils loginPage = new Patient_LoginPageUtils();
	Patient_DashboardPageUtils Dashboard = new Patient_DashboardPageUtils();
	BrowserUtils browser = new BrowserUtils();
	RunTimeVariables vars = new RunTimeVariables();
	
	@Given("^I open the app$")
	public void openTheApp() throws InterruptedException {
		browser.openApp();
	}

	@When("^Enter the email,password and clinic code$")
	public void login(DataTable inputs) throws InterruptedException {
		loginPage.passLoginDetails(inputs);	
	}
	
	@And("^click on login button$")
	public void clickLogin() throws InterruptedException {
		loginPage.get_usernameValue();
		loginPage.clickLogInButton();
	}
	
	@Then("^Check i am logged in$")
	public void check_i_am_logged_in() throws InterruptedException {		
		loginPage.wait_myProfileview();		
		assertTrue(loginPage.get_currenturl().equals(vars.getEnvironmentUrl()+"portal/dashboard"));
		//assertTrue(Arrays.asList(loginPage.loginarr).contains(Dashboard.profile_email().getText()));	
	}
	
	@But("^It display Username or Password is Wrong alert message$")
	public void checkValidation_invalidEmail() {		
		assertTrue(loginPage.get_emailAlert().contains("Username or Password is Wrong"));
	}	
	
	@But("^It display Clinic code is invalid alert message$")
	public void checkValidation_invalidCliniccode() {		
		assertTrue(loginPage.get_emailAlert().contains("Clinic code is invalid"));
	}	
	@Then("^close the browser$")
	public void close() {
		browser.closeApp();
	}	
	
}
