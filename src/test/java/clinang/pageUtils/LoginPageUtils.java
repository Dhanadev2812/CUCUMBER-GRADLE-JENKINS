package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import clinang.webDriverUtils.CustomDriver;
import java.util.List;

public class LoginPageUtils extends CustomDriver {

	private WebElement usernameField() {
		return findElement(By.id("mat-input-0"));
	}
	
	public void enterUsername() {
		usernameField().sendKeys("banu@latlon.com");
	}

	private WebElement passwordField() {
		return findElement(By.id("mat-input-1"));
	}

	public void enterPassword() {
	
		passwordField().sendKeys("Password12#");
	}

	private WebElement cliniccode() {
		return findElement(By.id("mat-input-2"));
	}

	public void entercliniccode() {
	
		cliniccode().sendKeys("ABC025");
	}
	
	private WebElement loginInButton() {
		return findElement(By.cssSelector("[class='form-subbtn mat-raised-button'][type='submit']"));
	}

	public void clickLoginInButton() {
		loginInButton().click();
	}
}


