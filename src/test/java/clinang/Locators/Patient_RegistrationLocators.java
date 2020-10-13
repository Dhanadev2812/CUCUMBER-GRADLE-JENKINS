package clinang.Locators;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;

public class Patient_RegistrationLocators extends CustomDriver{

	public By registrationLink = By.xpath("//a[contains(@href,'/register')]");
	public By firstName_Field  =By.xpath("//input[contains(@formcontrolname,'firstname')]");
	public By lastName_Field = By.xpath("//input[contains(@formcontrolname,'lastname')]");
	public By email_Field = By.xpath("//input[contains(@formcontrolname,'email')]");
	public By password_Field =By.xpath("//input[contains(@formcontrolname,'password')]");
	public By registrationButton =By.xpath("//button[@class='form-subbtn mat-raised-button']");
	public By alertBox =By.xpath("//div[@class='msgtext']");
	public By login_form = By.xpath("//div[@class='login-form']");
}