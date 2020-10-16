package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import clinang.Locators.Patient_MedicalHistoryLocators;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Patient_MedicalhistoryPageUtils extends CustomDriver{
	
	Patient_MedicalHistoryLocators MedicalHistory_Locators = new Patient_MedicalHistoryLocators();
	public static String[] charArr = null;
	String Y;
	String gender_get;
	String givenDOB;
	
	private WebElement wait_medicalHistoryField() {
		return waitForElementDisplayed(MedicalHistory_Locators.wait_medicalHistoryField);	
	}
	
	public void scrollTomedicalHistory() {
		 scrollTofindElement(wait_medicalHistoryField());		
	 }	
	
	public void click_medicalHistory() throws InterruptedException {
		wait_medicalHistoryField().click();
	}
	
	private WebElement form_medicalHistory() {
		return findElement(MedicalHistory_Locators.form_medicalHistory);
	}
	
	public String get_medicalHistoryform() {	
		return(form_medicalHistory().getText());
	}
	
	private WebElement male_radio() {
		return findElement(MedicalHistory_Locators.gender_male);
	}
	
	private WebElement female_radio() {
		return findElement(MedicalHistory_Locators.gender_female);
	}
	
	private WebElement gender_maleField() {
		return findElement((MedicalHistory_Locators.gender_maleField));
	}
	
	private WebElement gender_femaleField() {
		return findElement(MedicalHistory_Locators.gender_femaleField);
	}
	
	public void click_maleGender() {
		gender_maleField().click();
	}
	
	public void click_femaleGender() {
		gender_femaleField().click();
	}
	
	private WebElement select_bloodGroupdropDwon() {
		return findElement(MedicalHistory_Locators.select_bloodGroupdropDwon);
	}
	
	public void click_bloodGroupdropDwon() {
		select_bloodGroupdropDwon().click();
	}
	
	private WebElement bloodGroup(String BG) {	
		return waitForElementDisplayed(By.xpath("//*[(normalize-space(text())"+"="+"'"+BG+"'"+") and @class='mat-option-text']"));
	}
	
	private WebElement bloodGroupfield() {
		return findElement(MedicalHistory_Locators.bloodGroupfield);
	}
	
	public WebElement age() {
		return findElement(MedicalHistory_Locators.age);
	}
	
	private WebElement weight() {
		return findElement(MedicalHistory_Locators.weight);
	}
	private void weightClick() {
		clickEvent(MedicalHistory_Locators.weight);
	}
	
	private WebElement height() {
		return findElement(MedicalHistory_Locators.height);
	}
	
	private WebElement allergy() {
		return findElement(MedicalHistory_Locators.allergy); 
	}
	
	private WebElement medicalHistory() {
		return findElement(MedicalHistory_Locators.medicalHistory);
	}
	
	private WebElement datePickerField() {
		return findElement(MedicalHistory_Locators.dobField);
	}
	private void datePickerFieldClick() {
		clickEvent(MedicalHistory_Locators.dobField);
	}
	
	//datepicker
	private WebElement open_calenderField() {
		return findElement(MedicalHistory_Locators.open_calenderField);
	}
	
	public void openCalender() {
		open_calenderField().click();
	}
	
	 public WebElement CurrentPeriod() {
		 return findElement(MedicalHistory_Locators.CurrentPeriod);
	 }
	 
	public void view_yearTable() {
		CurrentPeriod().click();
	}
	private WebElement Currentyear() {
		return findElement(MedicalHistory_Locators.Currentyear);
	}
	
	private WebElement previousArrow() {
		return findElement(MedicalHistory_Locators.previousArrow);
	}
	
	private WebElement nextArrow() {
		return findElement(MedicalHistory_Locators.nextArrow);
	}
	
	private WebElement yearTable(String Y) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+Y+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectMonth(String M) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+M+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectDate(String D) {
		return findElement(By.xpath("//*[(normalize-space(text())"+"="+"'"+D+"'"+")]/ancestor::td"));
	}
	
	public WebElement clickSave() {
		return findElement(MedicalHistory_Locators.clickSave);
	 }
	 
	 private WebElement clickCancel() {
		  return findElement(MedicalHistory_Locators.clickCancel);
	 }
	 
	 private WebElement clickUpdate() {
		 return findElement(MedicalHistory_Locators.clickUpdate);
	 }
	 
	private WebElement alertBox() {
		return findElement(MedicalHistory_Locators.alertBox);		
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());
	}
	
	public WebElement closeAlert_field() {
		return findElement(MedicalHistory_Locators.closeAlert_field);
	}
	
	public void closeAlert()  {
		closeAlert_field().click();
	}
	private WebElement wait_header() {
		return fluentWait(MedicalHistory_Locators.header);
	}
	public void pageLoadercomplete() {
		 Loader(MedicalHistory_Locators.pageLoader);
	}
	public void selectDOB(String Y, String DOB) throws ParseException  {
				
		final String givenDateFormat = "dd/MM/yyyy";
		final String year = "yyyy";
		final String month = "MMM";
		final String date = "dd";
		 givenDOB = DOB;
		
		SimpleDateFormat year_format = new SimpleDateFormat(givenDateFormat);
		Date Year = year_format.parse(givenDOB);
		year_format.applyPattern(year);
		String requiredYear = year_format.format(Year);
		
		SimpleDateFormat month_format = new SimpleDateFormat(givenDateFormat);
		Date Month = month_format.parse(givenDOB);
		month_format.applyPattern(month);
		String requiredMonth = month_format.format(Month);
		
		SimpleDateFormat date_format = new SimpleDateFormat(givenDateFormat);
		Date Date = date_format.parse(givenDOB);
		date_format.applyPattern(date);
		String requiredDate = date_format.format(Date);
		
		int expectedYear=Integer.parseInt(requiredYear);
		String monthRequired = requiredMonth.toUpperCase();
				
		while(true)
			
			if(requiredYear!=null) {
				String years = Currentyear().getText();
				String[] yearList = years.split("–"); 	
				int strat_year=Integer.valueOf(yearList[0].replaceAll(" ", ""));
				int end_year = Integer.valueOf(yearList[1].replaceAll(" ", ""));
				
				if(expectedYear>=strat_year && expectedYear<=end_year) {
					 if(yearTable(requiredYear).isDisplayed()== true) {
					 yearTable(requiredYear).click();	
					 selectMonth(monthRequired).click();
					 selectDate(requiredDate).click();

				 } 	break;					
				} 
				else if(expectedYear<strat_year) {
					 previousArrow().click();	
			}		
				else if(expectedYear>end_year) {
						nextArrow().click();
					}	
				}
			else {
				break;
			}	
		
	}
	
	public String passMedicalhistoryDetails(DataTable inputs) throws InterruptedException, ParseException  {
		List<Map<String, String>> medicalHistory_input = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : medicalHistory_input) {
			  if(data.get("Gender").equals("Male")) {
				  click_maleGender();		  
			  }
			  else if (data.get("Gender").equals("Female")) {
				  click_femaleGender();
			  }	
			  click_bloodGroupdropDwon();
			  bloodGroup(data.get("Blood_group")).click();		
			  open_calenderField().click();
			  view_yearTable();	
			  selectDOB(Y, data.get("DOB"));
			  age().clear();
			  age().sendKeys(data.get("Age"));
			  weight().clear();
			  weight().sendKeys(data.get("Weight"));
			  height().clear();
			  height().sendKeys(data.get("Height"));
			  allergy().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			  allergy().sendKeys(data.get("Allergies"));
			  medicalHistory().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			  medicalHistory().sendKeys(data.get("Medical_history"));
		  } 
		
		return String.valueOf(medicalHistory_input);
		
		  }	 
	
	public void nullField_add() throws InterruptedException {
		wait_header();
		pageLoadercomplete();
		mouseRightclick(bloodGroupfield());
		weight().click();
		weight().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(500);
		datePickerField().click();
		Thread.sleep(500);
		height().click();
		height().clear();
		Thread.sleep(500);
		age().click();
		age().clear();	
		weight().click();
		Thread.sleep(500);	
		
	}
	
	public String nullField_allergy_medicalHistory(DataTable inputs) throws ParseException {
		List<Map<String, String>> medicalHistory_inputs = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : medicalHistory_inputs) {
			  
			  if(data.get("Gender").equals("Male")) {
				  click_maleGender();		  
			  }
			  
			  else if (data.get("Gender").equals("Female")) {
				  click_femaleGender();
			  }	
			  
			  click_bloodGroupdropDwon();
			  bloodGroup(data.get("Blood_group")).click();		
			  open_calenderField().click();
			  view_yearTable();	
			  selectDOB(Y, data.get("DOB"));
			  age().clear();
			  age().sendKeys(data.get("Age"));
			  weight().clear();
			  weight().sendKeys(data.get("Weight"));
			  height().clear();
			  height().sendKeys(data.get("Height"));
			  allergy().click();
			  allergy().clear();
			  medicalHistory().click();
			  medicalHistory().clear();
			  
		  } 
		
		return String.valueOf(medicalHistory_inputs);
	}
	 	
	public void nullField_edit() throws InterruptedException {		
			weight().click();
			weight().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			Thread.sleep(1000);
			height().click();
			height().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			Thread.sleep(1000);
			age().click();
			age().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));			
	}

	public void nullField_edit_allergy_medicalHistory() throws InterruptedException {	
		allergy().click();
		allergy().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
		medicalHistory().click();
		medicalHistory().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));	
}

	public String invalid_medicalHistory(DataTable inputs) {
		List<Map<String, String>> medicalHistory_invalidInputs = inputs.asMaps(String.class, String.class);
		  for (Map<String, String> data : medicalHistory_invalidInputs) {
			  
			  weight().clear();
			  weight().sendKeys(data.get("Weight"));
			  height().clear();
			  height().sendKeys(data.get("Height"));
			  
		  } 
		
		return String.valueOf(medicalHistory_invalidInputs);
	}

	public void select_option(String option) {
		if(option.equals("save")) {
		 clickSave().click();
		}
		else if(option.equals("cancel")) {
		 clickCancel().click();		 
		}
		else if(option.equals("update")) {
		 clickUpdate().click();
		}
	}
	
	public void get_medicalHistorydata() {
		
		 String age_get = age().getAttribute("value"); 
		 String Male_Class=male_radio().getAttribute("class");	
		 String Female_Class = female_radio().getAttribute("class");
		 String bloodgroup_get = bloodGroupfield().getText();
		 String dob_get = givenDOB;
		 
		 if(Male_Class.contains("radio-checked")) {
			  gender_get = male_radio().getText();
		 }
		 else if(Female_Class.contains("radio-checked")) {
			 System.out.println("female");
			  gender_get = female_radio().getText();
		 }
		 else {
			 System.out.println("No check box selected");
		 }		 
		
		 
		this.charArr = new String[] {age_get,gender_get,bloodgroup_get,dob_get};	
	}	
}