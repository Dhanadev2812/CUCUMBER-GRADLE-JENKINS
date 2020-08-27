package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Patient_MedicalhistoryPageUtils extends CustomDriver{
	
	private static final String wait_medicalHistoryField = "//*[contains(text(),' Medical History ')]";
	private static final String gender_maleField = "//*[contains(text(),'Male')]";
	private static final String gender_femaleField = "//*[contains(text(),'Female')]";
	private static final String select_bloodGroupdropDwon ="//div[@class='mat-select-arrow']";
	private static final String open_calenderField ="//button[@aria-label='Open calendar']";
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy");
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
		return findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12']"));
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
		return findElement(By.xpath("//div[@class='mat-select-value']"));
	}
	private WebElement age() {
		return findElement(By.xpath("//input[@formcontrolname='age']"));
	}
	
	private WebElement weight() {
		return findElement(By.xpath("//input[@formcontrolname='weight']"));
	}
	
	private WebElement height() {
		return findElement(By.xpath("//input[@formcontrolname='height']"));
	}
	
	private WebElement allergy() {
		return findElement(By.xpath("//div[7]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']")); 
	}
	
	private WebElement medicalHistory() {
		return findElement(By.xpath("//div[8]/div/ckeditor/div[2]/div[2]/div[@aria-label='Rich Text Editor, main']"));
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
		 return findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[1]"));
	 }
	 
	public void view_yearTable() {
		CurrentPeriod().click();
	}
	private WebElement Currentyear() {
		return findElement(By.xpath("//button[@aria-label='Choose date']"));
	}
	
	private WebElement previousArrow() {
		return findElement(By.xpath("//button[@aria-label='Previous 20 years']"));
	}
	
	private WebElement nextArrow() {
		return findElement(By.xpath("//button[@aria-label='Next 20 years']"));
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
		 return findElement(By.xpath("//button[@class='reschedule-button mat-raised-button']"));
	 }
	 
	 private WebElement clickCancel() {
		  return findElement(By.xpath("//button[@class='cancel-button mat-raised-button']"));
	  }
	 
	 private WebElement clickUpdate() {
		 return findElement(By.xpath("//span[contains(text(),'Update')]"));
	 }
	 
	private WebElement alertBox() {
		return findElement(By.xpath("//div[@class='msgtext']"));		
	}
	
	public String get_alertMessage() {
		return(alertBox().getText());
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
	
	public void nullField() throws InterruptedException {
		
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
	
	
}