/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageCheckout is linked to the checkout page in the application.
 * @author formation
 *
 */
public class PageCheckout {
	WebDriver driver;

	//Title "h1" checkout Page
	@FindBy(xpath="//h1")
	WebElement titleCheckout;


	/**
	 * PageCheckout() is the super constructor of this class
	 * @author formation
	 * @param driver
	 *
	 */
	public PageCheckout(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
}
