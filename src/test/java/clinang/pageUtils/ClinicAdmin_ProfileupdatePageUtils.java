package clinang.pageUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_ProfileupdateLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class ClinicAdmin_ProfileupdatePageUtils extends CustomDriver {
	
	ClinicAdmin_ProfileupdateLocators C_Admin_profileUpdate_Locators = new ClinicAdmin_ProfileupdateLocators();
	public String[] given_clinicName;
	
	
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_profileUpdate_Locators.pageLoader);
	}
	private WebElement ClinicAdmin_module() {
		return findElement(C_Admin_profileUpdate_Locators.clinicAdmin_module);
	}
	
	public void Click_ClinicAdmin() {
		ClinicAdmin_module().click();
	}
	
	private WebElement edit() {
		return findElement(C_Admin_profileUpdate_Locators.edit);
	}
	public void click_edit() {
		edit().click();
	}
	private WebElement edit_imageUpload() {
		return findElement(C_Admin_profileUpdate_Locators.edit_imageUpload);
	}
	private WebElement clinicName() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicName);
	}
	private WebElement clinicAddress() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicAddress);
	}
	private WebElement clinicStreet() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicStreet);
	}
	private WebElement clinicCity() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicCity);
	}
	private WebElement clinicState() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicState);
	}
	private WebElement clinicPincode() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicPincode);
	}
	private WebElement clinicEmail() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicEmail);
	}
	private WebElement clinicPhone() {
		return findElement(C_Admin_profileUpdate_Locators.edit_clinicPhone);
	}
	
	private WebElement countryDropdown() {
		return findElement(C_Admin_profileUpdate_Locators.countryDropdown);
	}
	private WebElement select_countryField(String country) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+country+"'"+")]/ancestor::mat-option"));
	}
	private WebElement submit_clinicUpdate() {
		return findElement(C_Admin_profileUpdate_Locators.submit);
	}
	public void Click_submit_clinicUpdate() {
		submit_clinicUpdate().click();
	}
	public WebElement messageBox() {
		return findElement(C_Admin_profileUpdate_Locators.messagebox);
	}
	private WebElement close_messageBox() {
		return findElement(C_Admin_profileUpdate_Locators.close_messagebox);
	}
	public void click_closeMesagebox() {
		close_messageBox().click();
	}
	public void upload_Img(String File_path) {	
		wait_pageLoad_complate();
		File profileImage = new File(File_path);
		edit_imageUpload().sendKeys(profileImage.getAbsolutePath());
	}
	public WebElement grid_clinicName() {
		return findElement(C_Admin_profileUpdate_Locators.grid_clinicName);
	}
	public WebElement clinicName_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicName_alert);
	}
	public WebElement clinicAddress_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicAddress_alert);
	}
	public WebElement clinicStreet_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicStreet_alert);
	}
	public WebElement clinicCity_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicCity_alert);
	}
	public WebElement clinicState_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicState_alert);
	}
	public WebElement clinicPincode_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicPincode_alert);
	}
	public WebElement clinicEmail_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicEmail_alert);
	}
	public WebElement clinicPhone_alert() {
		return findElement(C_Admin_profileUpdate_Locators.clinicphone_alert);
	}
	public String passClinicdetails(DataTable inputs)   {
		List<Map<String, String>> clinicUpdate_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : clinicUpdate_input) {
			  wait_pageLoad_complate();
			  clinicName().clear();
			  clinicName().sendKeys(data.get("ClinicName"));
			  clinicAddress().clear();
			  clinicAddress().sendKeys(data.get("ClinicAddress"));
			  clinicStreet().clear();
			  clinicStreet().sendKeys(data.get("ClinicStreet"));
			  clinicCity().clear();
			  clinicCity().sendKeys(data.get("ClinicCity"));
			  clinicState().clear();
			  clinicState().sendKeys(data.get("ClinicState"));
			  countryDropdown().click();
			  select_countryField(data.get("ClinicCountry")).click();
			  clinicPincode().clear();
			  clinicPincode().sendKeys(data.get("ClinicPincode"));
			  clinicEmail().clear();
			  clinicEmail().sendKeys(data.get("ClinicEmail"));
			  clinicPhone().clear();
			  clinicPhone().sendKeys(data.get("ClinicPhone"));
			  
			  this.given_clinicName = new String[] {data.get("ClinicName")};
		  }
		return String.valueOf(clinicUpdate_input);
	}
	
	public void clear_mandatoryInputs() {
		wait_pageLoad_complate();
		clinicName().click();
		clinicName().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicAddress().click();
		clinicAddress().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicStreet().click();
		clinicStreet().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicCity().click();
		clinicCity().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicState().click();
		clinicState().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicPincode().click();
		clinicPincode().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicEmail().click();
		clinicEmail().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clinicPhone().click();
		clinicPhone().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	}
	
	public void invalidEmail(String invalidEmail) {
		clinicEmail().clear();
		clinicEmail().sendKeys(invalidEmail);
	}
		
		  
}
	
