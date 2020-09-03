package clinang.webDriverUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RunTimeVariables {

	private String environmentUrl;
	
	private String browser;

	public String getEnvironmentUrl() {
		return environmentUrl;
	}

	public void setEnvironmentUrl(String environmentUrl) {
		this.environmentUrl = environmentUrl;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public RunTimeVariables() {
		setEnvironmentUrl("http://107.180.92.143:5060/");
		setBrowser("chrome");
		
		
//		InputStream input = this.getClass().getClassLoader().getResourceAsStream("RunTime.properties");
//		Properties prop = new Properties();
//		try {
//			prop.load(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		if (System.getProperty("EnvironmentUrl") != null)
//			setEnvironmentUrl(System.getProperty("EnvironmentUrl"));
//		else
//			setEnvironmentUrl(prop.getProperty("EnvironmentUrl"));
		
		
		
//		if (System.getProperty("Browser") != null)
//			setEnvironmentUrl(System.getProperty("Browser"));
//		else
//			setBrowser(prop.getProperty("Browser"));
		
		
	}

}
