package clinang.pageUtils;

import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

import clinang.patient_Locators.Patient_LoginLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_LoginPageUtils extends CustomDriver {
	
	Patient_LoginLocators Login_Locator = new Patient_LoginLocators();
	public static String[] loginarr=null;
			
	private WebElement usernameField() {
		return findElement(Login_Locator.usernameField);
	}
	
	public void get_usernameValue() {
		String get_username = usernameField().getAttribute("value");
		this.loginarr = new String[] {get_username};
	}
	private WebElement passwordField() {
		return findElement(Login_Locator.passwordField);
	}

	private WebElement cliniccode() {
		return findElement(Login_Locator.cliniccodeField);
	}
	
	private WebElement logInButton() {
		return findElement(Login_Locator.logInButton);
	}
	
	public WebElement wait_myProfileview() {
		return waitForElementDisplayed(Login_Locator.wait_myProfileview);
	}
	
	public String get_currenturl() throws InterruptedException {
		return getCurrentUrl();
	}
	
	private WebElement alertMessage_email() {
		return findElement(Login_Locator.alertMessage_email);
	}
	
	public void passLoginDetails(DataTable inputs) {
		List<Map<String, String>> registration_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : registration_input) {
			  usernameField().sendKeys(data.get("email"));  
			  passwordField().sendKeys(data.get("password")); 
			  cliniccode().sendKeys(data.get("clinic_code")); 
		  }	 
	}

	public void clickLogInButton() {
		logInButton().click();
	}
	
	public String get_emailAlert() {
		return alertMessage_email().getText();
	}
	
	/*public Boolean isNotLoggedIn() {
		try {
			return isElementDisplayed(usernameField());
		} catch (Exception e) {
			return false;
		}
	}*/				
}


