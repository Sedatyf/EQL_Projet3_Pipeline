/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;

import org.Shopizer.EBrowser;

/**
 * ToolBox() is the class which groups together all the methods useful for other classes
 * @author formation
 *
 */
public class ToolBox {
	static long chrono = 0;
	static WebDriver driver;
	
	/**
	 * chooseBrowser() is the method of choosing browser
	 * @param log browser
	 * 
	 */
	public static WebDriver chooseBrowser(Logger log, EBrowser browser) {
		switch (browser) {
		case f:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			return new FirefoxDriver();
		case c:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			return new ChromeDriver();
		case e:
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			return new EdgeDriver();
		case ie:
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			return new InternetExplorerDriver();
		default:
			log.warn("This web browser doesn't exist");
			return null;
		}
	}
	
	/**
	 * navToURL() is the method of navigating on URL
	 * @param driver URL
	 * 
	 */
	public static void navToURL(WebDriver driver, String URL) {
		driver.get(URL);
	}
	
	/**
	 * fillInField() is the method of cleaning and filling text fields
	 * @param we s
	 * 
	 */
	public static void fillInField(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	
	public static void moveToElement(WebDriver driver, WebElement we) {
		Actions act = new Actions(driver);
		act.moveToElement(we).build().perform();
	}
	
//	public static void recoveryElements(WebDriver driver) {
//		
//		
//	}

}
