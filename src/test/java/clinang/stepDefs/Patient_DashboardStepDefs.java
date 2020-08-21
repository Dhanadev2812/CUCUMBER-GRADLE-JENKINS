package clinang.stepDefs;

import static org.junit.Assert.assertTrue;

import clinang.pageUtils.Patient_DashboardPageUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_DashboardStepDefs {
	
	Patient_DashboardPageUtils dashboard = new Patient_DashboardPageUtils();
	
	@Then("^click on logout button$")
	public void clickonLogout()  {
		dashboard.clickLogout();
	}
	
	@And("^Click on edit profile option$")
	public void click_editProfile() {
		dashboard.clickEditProfile();		
	}
	
	@And("^Enter mobile_number,address,street,city,state,country and pincode$")
	public void enter_profiledetails(DataTable inputs) throws InterruptedException {
		dashboard.passProfiledetails(inputs);
	}
	
	@Then("^Click on \"([^\"]*)\"$") 
	public void click_option(String get_option) {
		//System.out.println(get_option);
		dashboard.select_option(get_option);
		
	}
	@Then("^check the data stored on DB$")
	public void checkData_DB() throws InterruptedException {
		dashboard.scrollTodashboard();
		dashboard.clickDashboard();
		dashboard.get_profile_mob();
	}
	
}