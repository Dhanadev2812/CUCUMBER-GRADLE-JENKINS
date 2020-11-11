package clinang.webDriverUtils;

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
		setEnvironmentUrl("https://latlontech.com/");
		setBrowser("chrome");
	
	}

}
