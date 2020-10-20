package clinang.webDriverUtils;

import java.awt.image.AffineTransformOp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Utils extends CustomDriver {
 
 @Before(order=0)
 public void beforeScenarioStart(){
	 
     System.out.println("----------Start of Scenario----------"); 
     System.out.println("                                   ");
     }  
 
 @After(order=0)
    public void afterScenario(){	 
        System.out.println("                                   ");
    } 
 
 /*@After(order=1)
 public void afterScenarioFinish(){
	 
	 //System.out.println("----------Deleting Browser Cookies----------");
	 //deleteAllCookies();	 
		
	 }  

@After(order=2)
    public void afterScenario(){
        System.out.println("----------------Close The Browser-----------------");
        quit();
    } */
 
}