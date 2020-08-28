package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class Patient_LoginPageUtils extends CustomDriver {
	
	private static final String usernameField ="//input[@formcontrolname='email']";
	private static final String passwordField ="//input[@formcontrolname='password']";
	private static final String cliniccode ="//input[@formcontrolname='clinicid']";
	private static final String logInButton = "//button[@class='form-subbtn mat-raised-button' and @type='submit']";
	private static final String wait_myProfileview ="//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']";
	private static final String alertMessage_email ="//form[@class='ng-invalid ng-dirty ng-touched']";
	
			
	private WebElement usernameField() {
		return findElement(By.xpath(usernameField));
	}
	
	private WebElement passwordField() {
		return findElement(By.xpath(passwordField));
	}

	private WebElement cliniccode() {
		return findElement(By.xpath(cliniccode));
	}
	
	private WebElement logInButton() {
		return findElement(By.xpath(logInButton));
	}
	
	public WebElement wait_myProfileview() {
		return waitForElementDisplayed(By.xpath(wait_myProfileview));
	}
	
	public String get_currenturl() throws InterruptedException {
		return getCurrentUrl();
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
	
	public Boolean isNotLoggedIn() {
		try {
			return isElementDisplayed(usernameField());
		} catch (Exception e) {
			return false;
		}
	}
	
	private WebElement alertMessage_email() {
		return findElement(By.xpath(alertMessage_email));
	}
	
	public String get_emailAlert() {
		return alertMessage_email().getText();
	}
	
			
}


