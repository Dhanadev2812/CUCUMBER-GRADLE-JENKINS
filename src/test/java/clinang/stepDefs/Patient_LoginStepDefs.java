package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import clinang.pageUtils.BrowserUtils;
import clinang.pageUtils.Patient_LoginPageUtils;

public class Patient_LoginStepDefs {

	Patient_LoginPageUtils loginPage = new Patient_LoginPageUtils();
	BrowserUtils browser = new BrowserUtils();
	
	@Given("^I open the app$")
	public void openTheApp() {
		browser.openApp();
	}

	@When("^Enter the email,password and clinic code$")
	public void login(DataTable inputs) {
		loginPage.passLoginDetails(inputs);	
	}
	
	@And("^click on login button$")
	public void clickLogin() {
		loginPage.clickLogInButton();
	}
	@Then("^Check i am logged in$")
	public void check_i_am_logged_in() throws InterruptedException {	
		System.out.println(loginPage.get_currenturl());
		assertTrue(loginPage.get_currenturl().equals("https://latlontech.com/portal/dashboard"));
		
	}
	@Then("^Check validation message for invalid email$")
	public void checkValidation_invalidEmail() {
		System.out.println(loginPage.get_emailAlert());
		assertTrue(loginPage.get_emailAlert().contains("First Name should be in alphabets"));
	}	
	
	
	@Then("^close the browser$")
	public void close() {
		browser.closeApp();
	}	
	
}
