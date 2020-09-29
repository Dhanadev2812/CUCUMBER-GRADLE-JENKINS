package clinang.patient_Locators;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;

public class Patient_LoginLocators extends CustomDriver{
	
	  public By usernameField =By.xpath("//input[@formcontrolname='email']");
	  public By passwordField =By.xpath("//input[@formcontrolname='password']");
	  public By cliniccodeField =By.xpath("//input[@formcontrolname='clinicid']");
	  public By logInButton = By.xpath("//button[@class='form-subbtn mat-raised-button' and @type='submit']");
	  public By wait_myProfileview =By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']");
	  public By alertMessage_email =By.xpath("//form[@class='ng-invalid ng-dirty ng-touched']");
	
}