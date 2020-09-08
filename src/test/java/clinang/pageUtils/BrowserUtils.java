package clinang.pageUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import clinang.webDriverUtils.CustomDriver;
import clinang.webDriverUtils.InitiateDriver;
import clinang.webDriverUtils.RunTimeVariables;

public class BrowserUtils extends CustomDriver {
	
	RunTimeVariables vars = new RunTimeVariables();
	
	public void openApp() throws InterruptedException {
		InitiateDriver.setProfile();
		get(vars.getEnvironmentUrl());	
		maximiseWindow();
		System.out.println("Waiting for login screen");
		fluentWait(By.xpath("//input[@formcontrolname='email']"));
	}
	
	public void closeApp() {
		quit();
	}
	

}
