package clinang.Locators;

import org.openqa.selenium.By;

public class ClinicAdmin_LoginLocators {
	
	public By clinicLogin_button = By.xpath("//button[@class='signup-btn mat-raised-button']");
	public By clinicAdmin_usernameField = By.xpath("//input[@formcontrolname='email']");
	public By clinicAdmin_passwordField = By.xpath("//input[@formcontrolname='password']");
	public By clinicAdmin_loginButton = By.cssSelector("[class='form-subbtn mat-raised-button'][type='submit']");
	public By pageLoader = By.xpath("//img[class='pl-3 loader']");
			
}