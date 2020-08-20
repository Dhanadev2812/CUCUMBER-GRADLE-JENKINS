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
	
	private WebElement registrationLink() {
		return findElement(By.xpath("//a[contains(@href,'/register')]"));
	}
	
	public void ClickregistrationLink() {		
		registrationLink().click();
	}
	
	private WebElement firstName() {
		//return findElement(By.id("mat-input-3"));
		return findElement(By.xpath("//input[contains(@formcontrolname,'firstname')]"));
	}
	
	private WebElement lastName() {
		return findElement(By.xpath("//input[contains(@formcontrolname,'lastname')]"));
	}
	
	private WebElement email() {
		return findElement(By.xpath("//input[contains(@formcontrolname,'email')]"));
	}
	
	private WebElement password() {
		return findElement(By.xpath("//input[contains(@formcontrolname,'password')]"));
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
	
	private WebElement registrationButton() {
		return findElement(By.xpath("//button[@class='form-subbtn mat-raised-button']"));
	}
	
	public void clickRegButton() {
		
		registrationButton().click();
	}
	
	private WebElement alertBox() {
		return findElement(By.xpath("//div[@class='msgtext']"));
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());			
	}
	
	private WebElement log_form() {
		return findElement(By.xpath("//div[@class='login-form']"));		
	}
	
	public String gettext_loginform() {
		return(log_form().getText());			
	}
	
	public void log_form_array() {
		String[] alert_list = {gettext_loginform()};
		System.out.println(alert_list);
		
	}
	
}
	
	