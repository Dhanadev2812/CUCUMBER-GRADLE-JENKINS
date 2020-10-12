package clinang.testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:cucumber-html-reports","json: cucumber-html-reports/cucumber.json" },
features= {"src/test/resources/clinang_Feature_Patient/Patient_appointment.feature"},
glue= {"clinang.webDriverUtils","clinang.stepDefs"},
tags = {"@Cancel"},
monochrome = true,
strict=true)
public class LoginRunner {
	
}

  	
