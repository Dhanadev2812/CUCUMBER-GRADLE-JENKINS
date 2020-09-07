package clinang.webDriverUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks_Utils extends CustomDriver {
 
 @Before(order=0)
 public void beforeScenarioStart(){
	 
     System.out.println("---------------------------------------Start of Scenario-----------------------------------------");
	 
	 }  
 
 @After(order=0)
    public void afterScenarioFinish(){
	 
        System.out.println("---------------------------------------End of Scenario-----------------------------------------");
    } 
 
 @After(order=1)
 public void beforeScenario(){
	 
	 System.out.println("---------------------------------------Deleting Browser Cookies-----------------------------------------");
		InitiateDriver.driver.manage().deleteAllCookies();	 
		
	 }  
 
 /*@After(order=2)
    public void afterScenario(){
        System.out.println("---------------------------------------Close The Browser----------------------------------------------");
        quit();
    } */
 
}