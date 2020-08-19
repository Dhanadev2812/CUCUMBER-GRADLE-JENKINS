package clinang.pageUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import clinang.webDriverUtils.CustomDriver;
import clinang.webDriverUtils.InitiateDriver;
import clinang.webDriverUtils.RunTimeVariables;

public class BrowserUtils extends CustomDriver {
	
	RunTimeVariables vars = new RunTimeVariables();
	
	public void openApp() {
		InitiateDriver.setProfile();
		get(vars.getEnvironmentUrl());	
		maximiseWindow();
		
	}
	
	public void closeApp() {
		quit();
	}
	

}
