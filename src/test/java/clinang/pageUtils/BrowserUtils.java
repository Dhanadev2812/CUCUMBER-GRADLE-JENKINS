package clinang.pageUtils;

import org.openqa.selenium.By;

import clinang.webDriverUtils.CustomDriver;
import clinang.webDriverUtils.InitiateDriver;
import clinang.webDriverUtils.RunTimeVariables;

public class BrowserUtils extends CustomDriver {
	
	RunTimeVariables vars = new RunTimeVariables();
	
	public void openApp() throws InterruptedException {
		System.out.println("Launching Chrome Browser");
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
