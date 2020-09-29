package clinang.webDriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class InitiateDriver {

	private InitiateDriver() {
		throw new UnsupportedOperationException();
	}

	static WebDriver driver = null;

	public static void setProfile() {
		if (driver == null) {
			RunTimeVariables var = new RunTimeVariables();

			if (var.getBrowser().contentEquals("chrome")) {
				System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver84.exe");
				driver = new ChromeDriver();
				
			} else if (var.getBrowser().contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			}
		}
	}

}
