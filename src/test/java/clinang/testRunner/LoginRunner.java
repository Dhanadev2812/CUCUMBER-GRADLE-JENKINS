package clinang.testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
features= {"src/test/resources/clinang_Feature_Patient/ClinicAdmin_01_alogin.feature"},
glue= {"clinang.webDriverUtils","clinang.stepDefs"},
tags = {"@login_valid"},
monochrome = true,
strict=true)
public class LoginRunner {
	
}
