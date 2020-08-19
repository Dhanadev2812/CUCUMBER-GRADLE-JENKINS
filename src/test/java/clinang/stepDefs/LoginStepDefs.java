package clinang.stepDefs;

import org.junit.BeforeClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import clinang.pageUtils.BrowserUtils;
import clinang.pageUtils.LoginPageUtils;

public class LoginStepDefs {

	LoginPageUtils loginPage = new LoginPageUtils();
	BrowserUtils browser = new BrowserUtils();
	
	@Given("^I open the app$")
	public void openTheApp() {
		browser.openApp();
	}

	@When("^I login to the app$")
	public void login() {
		loginPage.enterUsername();
		loginPage.enterPassword();
		loginPage.entercliniccode();
		loginPage.clickLoginInButton();
	}
	
	@Then("^close the browser$")
	public void close() {
		browser.closeApp();
	}	
	
}
