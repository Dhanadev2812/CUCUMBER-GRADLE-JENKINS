package clinang.pageUtils;

import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

import clinang.patient_Locators.Patient_RegistrationLocators;
import clinang.webDriverUtils.CustomDriver;

public class Patient_RegistrationPageUtils extends CustomDriver{
	
	Patient_RegistrationLocators Registration_Locators = new Patient_RegistrationLocators();
	
	private WebElement registrationLink() {
		return findElement(Registration_Locators.registrationLink);
	}
	
	public void ClickregistrationLink() {		
		registrationLink().click();
	}
	
	private WebElement firstName() {
		return findElement(Registration_Locators.firstName_Field);
	}
	
	private WebElement lastName() {
		return findElement(Registration_Locators.lastName_Field);
	}
	
	private WebElement email() {
		return findElement(Registration_Locators.email_Field);
	}
	
	private WebElement password() {
		return findElement(Registration_Locators.password_Field);
	}
	
	private WebElement registrationButton() {
		return findElement(Registration_Locators.registrationButton);
	}
	
	private WebElement alertBox() {
		return findElement(Registration_Locators.alertBox);
	}
	
	private WebElement login_form() {
		return findElement(Registration_Locators.login_form);		
	}
	
	public void passInput(DataTable inputs) {
		List<Map<String, String>> registration_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : registration_input) {
			  firstName().sendKeys(data.get("firstname"));  
			  lastName().sendKeys(data.get("lastname")); 
			  email().sendKeys(data.get("email")); 
			  password().sendKeys(data.get("password")); 
		  }	 
	}
	
	public void clickRegButton() {	
		registrationButton().click();
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());			
	}	
	
	public String gettext_loginform() {
		return(login_form().getText());			
	}
	
	public void log_form_array() {
		String[] alert_list = {gettext_loginform()};
		//System.out.println(alert_list);
		
	}
	
}
	
	