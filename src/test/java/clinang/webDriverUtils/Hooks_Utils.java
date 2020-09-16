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
	 
	 }  
 
 @After(order=0)
    public void afterScenario(){	 
        System.out.println("----------End of Scenario----------");
    } 
 

@After(order=1)
 public void afterScenarioFinish(){
	 
	 //System.out.println("----------Deleting Browser Cookies----------");
	 //deleteAllCookies();	 
		
	 }  

/* @After(order=1)
public void getCookies() {	 
	 File file = new File("HCPCookies.data");							
    try		
    {	  
        // Delete old file if exists
   	 file.delete();		
        file.createNewFile();			
        FileWriter fileWrite = new FileWriter(file);							
        BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
        	
        // loop for getting the cookie information 		
        for(Cookie ck : InitiateDriver.driver.manage().getCookies())							
        {			
            Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
            Bwrite.newLine();             
        }			
        Bwrite.close();			
        fileWrite.close();	
        
    }
    catch(Exception ex)					
    {		
        ex.printStackTrace();			
    }		 }*/


/*@After(order=2)
    public void afterScenario(){
        System.out.println("----------------Close The Browser-----------------");
        quit();
    } */
 
}