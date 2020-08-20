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

	private WebElement usernameField() {
		return findElement(By.xpath("//input[@formcontrolname='email']"));
	}
	
	private WebElement passwordField() {
		return findElement(By.xpath("//input[@formcontrolname='password']"));
	}

	private WebElement cliniccode() {
		return findElement(By.xpath("//input[@formcontrolname='clinicid']"));
	}
	public void passLoginDetails(DataTable inputs) {
		List<Map<String, String>> registration_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : registration_input) {
			  usernameField().sendKeys(data.get("email"));  
			  passwordField().sendKeys(data.get("password")); 
			  cliniccode().sendKeys(data.get("clinic_code")); 
		  }	 
	}
	
	private WebElement logInButton() {
		return findElement(By.cssSelector("[class='form-subbtn mat-raised-button'][type='submit']"));
	}

	public void clickLogInButton() {
		logInButton().click();
	}
	public String get_currenturl() throws InterruptedException {
		Thread.sleep(9000);
		return getCurrentUrl();
	}
	
	public Boolean isNotLoggedIn() {
		try {
			return isElementDisplayed(usernameField());
		} catch (Exception e) {
			return false;
		}
	}
	
	private WebElement alertMessage_email() {
		return findElement(By.xpath("//*[@formcontrolname='email']//ancestor::div[2]"));
	}
	public String get_emailAlert() {
		return alertMessage_email().getText();
	}
	
			
}


