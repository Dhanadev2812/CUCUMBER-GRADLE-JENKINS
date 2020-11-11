package clinang.webDriverUtils;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class InitiateDriver {

	private InitiateDriver() {
		throw new UnsupportedOperationException();
	}

	public static WebDriver driver = null;

	public static void setProfile() {
		if (driver == null) {
			RunTimeVariables var = new RunTimeVariables();

			if (var.getBrowser().contentEquals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver86.exe");
			       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			       chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
			       chromePrefs.put("download.default_directory",System.getProperty("user.dir")+ File.separator + "DownloadedFiles");
			       ChromeOptions options = new ChromeOptions();
			       options.setExperimentalOption("prefs", chromePrefs);
			       driver = new ChromeDriver(options);
				
			} else if (var.getBrowser().contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			}
		}
	}

}
