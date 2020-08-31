package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Patient_MedicalhistoryPageUtils extends CustomDriver{
	
	private static final String wait_medicalHistoryField = "//*[contains(text(),'Medical History')]";
	private static final String form_medicalHistory ="//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']";
	private static final String gender_maleField = "//*[contains(text(),'Male')]";
	private static final String gender_femaleField = "//*[contains(text(),'Female')]";
	private static final String select_bloodGroupdropDwon ="//div[@class='mat-select-arrow']";
	private static final String bloodGroupfield ="//div[@class='mat-select-value']";
	private static final String age ="//input[@formcontrolname='age']";
	private static final String weight ="//input[@formcontrolname='weight']";
	private static final String height ="//input[@formcontrolname='height']";
	private static final String allergy ="//div[7]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']";
	private static final String medicalHistory="//div[8]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']";
	private static final String open_calenderField ="//button[@aria-label='Open calendar']";
	private static final String CurrentPeriod = "//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]";
	private static final String Currentyear="//button[@aria-label='Choose date']";
	private static final String previousArrow = "//button[@aria-label='Previous 20 years']";
	private static final String nextArrow ="//button[@aria-label='Next 20 years']";
	private static final String clickSave = "//button[@class='reschedule-button mat-raised-button']";
	private static final String clickCancel ="//button[@class='cancel-button mat-raised-button']";
	private static final String clickUpdate = "//span[contains(text(),'Update')]";
	private static final String alertBox="//div[@class='msgtext']";
	private static final String closeAlert_field="//i[@class='mdi mdi-window-close mdi-18px']";
	public static String[] charArr = null;
	String Y;
	
	private WebElement wait_medicalHistoryField() {
		return waitForElementDisplayed(By.xpath(wait_medicalHistoryField));	
	}
	
	public void scrollTomedicalHistory() {
		 scrollTofindElement(wait_medicalHistoryField());		
	 }	
	
	public void click_medicalHistory() throws InterruptedException {
		wait_medicalHistoryField().click();
	}
	
	private WebElement form_medicalHistory() {
		return findElement(By.xpath(form_medicalHistory));
	}
	
	public String get_medicalHistoryform() {	
		return(form_medicalHistory().getText());
	}
	
	private WebElement gender_maleField() {
		return findElement(By.xpath(gender_maleField));
	}
	
	private WebElement gender_femaleField() {
		return findElement(By.xpath(gender_femaleField));
	}
	
	public void click_maleGender() {
		gender_maleField().click();
	}
	
	public void click_femaleGender() {
		gender_femaleField().click();
	}
	
	private WebElement select_bloodGroupdropDwon() {
		return findElement(By.xpath(select_bloodGroupdropDwon));
	}
	
	public void click_bloodGroupdropDwon() {
		select_bloodGroupdropDwon().click();
	}
	
	private WebElement bloodGroup(String BG) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+BG+"'"+")]/ancestor::mat-option"));
	}
	
	private WebElement bloodGroupfield() {
		return findElement(By.xpath(bloodGroupfield));
	}
	
	public WebElement age() {
		return findElement(By.xpath(age));
	}
	
	private WebElement weight() {
		return findElement(By.xpath(weight));
	}
	
	private WebElement height() {
		return findElement(By.xpath(height));
	}
	
	private WebElement allergy() {
		return findElement(By.xpath(allergy)); 
	}
	
	private WebElement medicalHistory() {
		return findElement(By.xpath(medicalHistory));
	}
	
	private WebElement datePickerField() {
		return findElement(By.name("dob"));
	}
	
	//datepicker
	private WebElement open_calenderField() {
		return findElement(By.xpath(open_calenderField));
	}
	
	public void openCalender() {
		open_calenderField().click();
	}
	
	 public WebElement CurrentPeriod() {
		 return findElement(By.xpath(CurrentPeriod));
	 }
	 
	public void view_yearTable() {
		CurrentPeriod().click();
	}
	private WebElement Currentyear() {
		return findElement(By.xpath(Currentyear));
	}
	
	private WebElement previousArrow() {
		return findElement(By.xpath(previousArrow));
	}
	
	private WebElement nextArrow() {
		return findElement(By.xpath(nextArrow));
	}
	
	private WebElement yearTable(String Y) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+Y+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectMonth(String M) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+M+"'"+")]/ancestor::td"));
	}
	
	private WebElement selectDate(String D) {
		return findElement(By.xpath("//*[contains(text()"+","+"'"+D+"'"+")]/ancestor::td"));
	}
	
	public WebElement clickSave() {
		 return findElement(By.xpath(clickSave));
	 }
	 
	 private WebElement clickCancel() {
		  return findElement(By.xpath(clickCancel));
	 }
	 
	 private WebElement clickUpdate() {
		 return findElement(By.xpath(clickUpdate));
	 }
	 
	private WebElement alertBox() {
		return findElement(By.xpath(alertBox));		
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());
	}
	
	public WebElement closeAlert_field() {
		return findElement(By.xpath(closeAlert_field));
	}
	
	public void closeAlert() {
		closeAlert_field().click();
	}
	public void selectDOB(String Y, String DOB) throws ParseException  {
				
		final String givenDateFormat = "dd/MM/yyyy";
		final String year = "yyyy";
		final String month = "MMM";
		final String date = "dd";
		String givenDOB = DOB;
		
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
			  allergy().clear();
			  allergy().sendKeys(data.get("Allergies"));
			  medicalHistory().clear();
			  medicalHistory().sendKeys(data.get("Medical_history"));
		  } 
		
		return String.valueOf(medicalHistory_input);
		
		  }	 
	
	public void nullField_add() throws InterruptedException {
		
		weight().click();
		weight().clear();
		Thread.sleep(1000);
		height().click();
		height().clear();
		Thread.sleep(1000);
		datePickerField().click();
		Thread.sleep(1000);
		age().click();
		age().clear();		
		Thread.sleep(1000);	
		mouseRightclick(bloodGroupfield());		
		Thread.sleep(1000);
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
	
	public void Patient_MedicalhistoryPageUtils() {
		String age_get = age().getAttribute("value"); 
		this.charArr = new String[] {age_get};	
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

	

	
}