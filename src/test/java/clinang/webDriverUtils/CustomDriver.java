package clinang.webDriverUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class CustomDriver extends WebDriverImplemented {
	
	public void get(String url) {
		InitiateDriver.driver.get(url);
	}

	public String getCurrentUrl() {
		return InitiateDriver.driver.getCurrentUrl();
	}

	public void quit() {
		InitiateDriver.driver.quit();
	}

	public WebElement findElement(By by) {

		WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 30);
		WebElement element = wait.until(presenceOfElementLocated(by));
		return element;
	}

	protected Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
		return new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}

	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = InitiateDriver.driver.findElement(locator);
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}
	
	public WebElement waitForElementDisplayed(By by) {
		WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 50);
		WebElement element = wait.until(visibilityOfElementLocated(by));
		return element;
	}	

	public WebElement waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 30);
		WebElement element = wait.until(presenceOfElementLocated(by));
		return element;
	}
	protected Function<WebDriver, WebElement> elementToBeClickable(final By locator) {
		return new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}
	public WebElement waitForElementClick(By by) {
		WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 30);
		WebElement element = wait.until(elementToBeClickable(by));
		return element;
	}
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isTextPresent(WebElement element, String text) {
		return element.getText().contains(text);
	}
	
	public boolean isTextPresent(String text) {
		return InitiateDriver.driver.findElement(By.xpath("/html/body")).getText().contains(text);
	}

	public void deleteAllCookies() {
		InitiateDriver.driver.manage().deleteAllCookies();
	}

	public String getPageSource() {
		return InitiateDriver.driver.getPageSource();
	}

	public String getTitle() {
		return InitiateDriver.driver.getTitle();
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public String getDefaultSelectedText(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public List<WebElement> getAllSelectOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}

	public void doubleClick(WebElement element) {
		Actions doubleClickAction = new Actions(InitiateDriver.driver);
		doubleClickAction.doubleClick(element);
		doubleClickAction.perform();
	}
	
	public void maximiseWindow() {
		InitiateDriver.driver.manage().window().maximize();
	}
	
	public void mouseHover(WebElement element) {
		Actions action = new Actions(InitiateDriver.driver);
		action.moveToElement(element).perform();
	}
	
	public void switchToIframe(WebElement element) {
		InitiateDriver.driver.switchTo().frame(element);
	}
	
	public void switchOutOfIframe() {
		InitiateDriver.driver.switchTo().defaultContent();
	}

	public void doubleClickOnElement(WebElement element) {
	   Actions doubleClickAction = new Actions(InitiateDriver.driver);
	   doubleClickAction.doubleClick(element);
	   doubleClickAction.perform();
	}
	
	public boolean isElementPresent(String path) {
		   return InitiateDriver.driver.findElements(By.xpath(path)).size()!=0;
	}
	
	public void refreshPage() {
		InitiateDriver.driver.navigate().refresh();
	}
	
	public void scrollTofindElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)InitiateDriver.driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public boolean isElementPresent(By by) {
		try {
			InitiateDriver.driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public void mouseRightclick(WebElement element) {
		Actions action = new Actions(InitiateDriver.driver);
		action.contextClick(element).perform();
	}
	
	public WebElement fluentWait(By by) {
		
			Wait<WebDriver> w = new FluentWait<WebDriver>(InitiateDriver.driver)
					.withTimeout(Duration.ofMinutes(30))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(NoSuchElementException.class);
		
			Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver arg0) {
					WebElement element = arg0.findElement(by);
					if (element != null) {
						//System.out.println("A new dynamic object is found.");
					}
					return element;
				}
			};

			return w.until(function);
		}
	public List<WebElement> findElement_list(By by) {		
		WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 80);
		List<WebElement> element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return element;
	}
	
	public void switchTochildWindow() {
		
		ArrayList<String> tabs = new ArrayList<String>(InitiateDriver.driver.getWindowHandles());
		InitiateDriver.driver.switchTo().window(tabs.get(1));	
	}
	public void switchTomainWindow() {
		
		ArrayList<String> tabs = new ArrayList<String>(InitiateDriver.driver.getWindowHandles());
		InitiateDriver.driver.switchTo().window(tabs.get(0));	
	}
		
	public void clickEvent(By by) {
		WebElement element = InitiateDriver.driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor)InitiateDriver.driver;
		executor.executeScript("arguments[0].click()", element);
	}
	
	public void Click(By element) {
		Actions ClickAction = new Actions(InitiateDriver.driver);
		ClickAction.moveToElement(InitiateDriver.driver.findElement(element));
		
	}
	
	public static void Loader(By by)
	{
	    WebDriverWait wait = new WebDriverWait(InitiateDriver.driver, 5);
	    while (true)
	    {
	        try
	        {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	           
	        }
	        catch (Exception e)
	        {
	            break;
	        }
	    }
	}
	
}