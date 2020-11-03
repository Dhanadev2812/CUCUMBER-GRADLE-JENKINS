package clinang.pageUtils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import clinang.Locators.ClinicAdmin_DoctorLocator;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

public class ClinicAdmin_DoctorPageUtils extends CustomDriver {
	ClinicAdmin_DoctorLocator C_Admin_doctorLocator = new ClinicAdmin_DoctorLocator();
	public String[] latestDoctor_withoutProfile;
	
	private WebElement doctorModule() {
		return findElement(C_Admin_doctorLocator.doctorModule);
	}
	public void click_doctorModule() {
		doctorModule().click();
	}
	public void wait_pageLoad_complate() {
		 Loader(C_Admin_doctorLocator.pageLoader);
	}
	private WebElement createDoctor() {
		return findElement(C_Admin_doctorLocator.createDoctor);
	}
	public void click_createDoctor() {
		createDoctor().click();
	}
	private WebElement doctorFirstname() {
		return findElement(C_Admin_doctorLocator.doctorFirstname);
	}
	private WebElement doctorLastname() {
		return findElement(C_Admin_doctorLocator.doctorLastname);
	}
	private WebElement doctorEmailid() {
		return findElement(C_Admin_doctorLocator.doctorEmail);
	}
	private WebElement specialityField() {
		return findElement(C_Admin_doctorLocator.speciality_field);
	}
	private WebElement speciality_dropDown() {
		return waitForElementClick(C_Admin_doctorLocator.speciality_dropDown);
	}
	private void moveTospeciality_dropDown() {
		 scrollTofindElement(speciality_dropDown());
	}
	private WebElement selectSpeciality(String speciality) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+speciality+"'"+")]/ancestor::mat-option"));
	}
	private WebElement doctor_domesticConsultationFee() {
		return findElement(C_Admin_doctorLocator.doctorDomesticconsultationFee);
	}
	private WebElement doctor_overseasConsultationFee() {
		return findElement(C_Admin_doctorLocator.doctorOverseasconsultationFee);
	}
	private WebElement doctor_domesticFollowupfee() {
		return findElement(C_Admin_doctorLocator.doctorDomesticfollowupFee);
	}
	private WebElement doctor_overseasFollowfee() {
		return findElement(C_Admin_doctorLocator.doctorOverseasfollowupFee);
	}
	private WebElement doctor_password() {
		return findElement(C_Admin_doctorLocator.doctorPassword);
	}
	public WebElement register() {
		return findElement(C_Admin_doctorLocator.register);
	}
	public WebElement alertBox() {
		return findElement(C_Admin_doctorLocator.alertBox);
	}
	public WebElement close_alertBox() {
		return findElement(C_Admin_doctorLocator.closeAlertbox);
	}
	public WebElement newDoctor_latest() {
		return findElement(C_Admin_doctorLocator.newDoctor_latest);
	}
	public WebElement doctorWithoutprofile_tab() {
		return findElement(C_Admin_doctorLocator.doctorWithoutprofile);
	}
	private WebElement doctorWithprofile_tab() {
		return findElement(C_Admin_doctorLocator.doctorWithprofile);
	}
	public void getLatestdoctorID() {
		doctorWithoutprofile_tab().click();
		wait_pageLoad_complate();
		this.latestDoctor_withoutProfile = new String[] {newDoctor_latest().getText()};
		doctorWithprofile_tab().click();
		System.out.println(Arrays.asList(latestDoctor_withoutProfile));
	}
	public String passDoctordetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>>doctor_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : doctor_input) {
			  doctorFirstname().sendKeys(data.get("FirstName"));
			  doctorLastname().sendKeys(data.get("LastName"));
			  doctorEmailid().sendKeys(data.get("EmailID"));
			  moveTospeciality_dropDown();
			  Thread.sleep(5000);
			  speciality_dropDown().click();
			  selectSpeciality(data.get("Speciality")).click();
			  doctor_domesticConsultationFee().sendKeys(data.get("DomesticConsultingFee"));
			  doctor_overseasConsultationFee().sendKeys(data.get("OverseasConsultingFee"));
			  doctor_domesticFollowupfee().sendKeys(data.get("DomesticFollowupFee"));
			  doctor_overseasFollowfee().sendKeys(data.get("OverseasFollowupFee"));
			  doctor_password().sendKeys(data.get("Password"));	  
		  } 
		
		return String.valueOf(doctor_input);
		
		  }	 
}