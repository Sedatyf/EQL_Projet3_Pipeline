/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageProductDetail is linked to the detail product page.
 * @author formation
 *
 */
public class PageProductDetail {
	WebDriver driver;
	
	//Title "h3" tables page
	@FindBy(xpath="//h3")
	WebElement titleProduct;
	
	/**
	 * PageProductDetail() is the super constructor of this class
	 * @author formation
	 * @param driver
	 *
	 */
	public PageProductDetail(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

}
