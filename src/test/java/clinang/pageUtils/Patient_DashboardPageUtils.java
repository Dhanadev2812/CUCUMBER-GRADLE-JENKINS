package clinang.pageUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import java.util.List;

public class Patient_DashboardPageUtils extends CustomDriver{
	
	private WebElement logoutButton() {
		return findElement(By.xpath("//img[@class='user-logout']"));
	}
	public void clickLogout() throws InterruptedException {
		Thread.sleep(6000);
		logoutButton().click();
	}
	
	private WebElement editProfile() {
		return findElement(By.xpath("//button[@class='mat-raised-button']"));
	} 
	
	public void clickEditProfile() {		
		editProfile().click();
	}
	
	private WebElement todayAppointment() {
		return findElement(By.xpath("//h3[@class='tot-appointment']"));
		
	}
	public void clickTodayappointment() {		
		todayAppointment().click();
	}
	
	public void getCounttodayApp() {		
		todayAppointment().getText();
		System.out.println(todayAppointment().getText());
	}
	
}