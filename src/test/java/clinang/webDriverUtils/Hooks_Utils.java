package clinang.webDriverUtils;

import clinang.pageUtils.Patient_DashboardPageUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Utils extends CustomDriver {
	Patient_DashboardPageUtils Dashboard = new Patient_DashboardPageUtils();
 
 @Before(order=0)
 public void beforeScenarioStart(){
     System.out.println("----------Start of Scenario----------"); 
     System.out.println("                                   ");
    }  
 
 @After(order=1)
 public void afterscenario(){	
	if((getCurrentUrl().contentEquals("https://latlontech.com/"))||(getCurrentUrl().contentEquals("https://latlontech.com/user-login"))) {
		System.out.println("Your are in login screen");
	} 
	else {
		Dashboard.clickLogout();
	}
 }
 
 @After(order=0)
 public void afterScenarioFinish(){	 
    System.out.println("                                   ");
} 
 
 /* 
@After(order=1)
 public void afterScenario_quitBrowser(){	 
	 close();
	 quit();
}
 
 @After(order=3)
 public void afterScenarioFinish(){
	 
	 //System.out.println("----------Deleting Browser Cookies----------");
	 //deleteAllCookies();	 
		
	}   */
 
}