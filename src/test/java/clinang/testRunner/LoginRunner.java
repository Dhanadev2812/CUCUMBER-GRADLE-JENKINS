package clinang.testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:cucumber-html-reports","json: JenkinsReport/cucumber.json" },
features= {"src/test/resources/clinang_Feature_Patient/ClinicAdmin_alogin.feature"},
glue= {"clinang.webDriverUtils","clinang.stepDefs"},
tags = {"@Create_new_appointment"},
monochrome = true,
strict=true)
public class LoginRunner {
	
}
