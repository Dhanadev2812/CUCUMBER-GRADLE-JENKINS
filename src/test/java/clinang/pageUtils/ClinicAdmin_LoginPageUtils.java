package clinang.pageUtils;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_LoginLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class ClinicAdmin_LoginPageUtils extends CustomDriver {
	
	ClinicAdmin_LoginLocators Admin_loginLocator = new ClinicAdmin_LoginLocators();
	
	private WebElement clinicLogin_button() {
		return findElement(Admin_loginLocator.clinicLogin_button);
	}
	
	public void Click_clinicLogin() {
		clinicLogin_button().click();
	}
	private WebElement usernameField() {
		return findElement(Admin_loginLocator.clinicAdmin_usernameField);
	}
	private WebElement passwordField() {
		return findElement(Admin_loginLocator.clinicAdmin_passwordField);
	}
	private WebElement loginButton() {
		return findElement(Admin_loginLocator.clinicAdmin_loginButton);
	}
	public void click_login() {
		wait_pageLoad_complate();
		loginButton().click();	
	}
	public void wait_pageLoad_complate() {
		 Loader(Admin_loginLocator.pageLoader);
	}
	public String get_currenturl()  {
		return getCurrentUrl();
	}
	public void passLoginDetails(DataTable inputs) {
		List<Map<String, String>> clinicAdmin_credentials = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : clinicAdmin_credentials) {
			  wait_pageLoad_complate();
			  usernameField().click();
			  usernameField().sendKeys(data.get("UserName"));  
			  passwordField().click();
			  passwordField().sendKeys(data.get("Password")); 
		  }	 
	}
}