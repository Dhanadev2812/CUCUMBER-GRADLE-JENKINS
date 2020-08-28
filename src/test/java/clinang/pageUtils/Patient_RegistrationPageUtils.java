package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Patient_RegistrationPageUtils extends CustomDriver{
	
	private static final String registrationLink = "//a[contains(@href,'/register')]";
	private static final String firstName  ="//input[contains(@formcontrolname,'firstname')]";
	private static final String lastName = "//input[contains(@formcontrolname,'lastname')]";
	private static final String email = "//input[contains(@formcontrolname,'email')]";
	private static final String password ="//input[contains(@formcontrolname,'password')]";
	private static final String registrationButton ="//button[@class='form-subbtn mat-raised-button']";
	private static final String alertBox = "//div[@class='msgtext']";
	private static final String login_form = "//div[@class='login-form']";
	
	private WebElement registrationLink() {
		return findElement(By.xpath(registrationLink));
	}
	
	public void ClickregistrationLink() {		
		registrationLink().click();
	}
	
	private WebElement firstName() {
		return findElement(By.xpath(firstName));
	}
	
	private WebElement lastName() {
		return findElement(By.xpath(lastName));
	}
	
	private WebElement email() {
		return findElement(By.xpath(email));
	}
	
	private WebElement password() {
		return findElement(By.xpath(password));
	}
	
	private WebElement registrationButton() {
		return findElement(By.xpath(registrationButton));
	}
	
	private WebElement alertBox() {
		return findElement(By.xpath(alertBox));
	}
	
	private WebElement login_form() {
		return findElement(By.xpath(login_form));		
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
	
	