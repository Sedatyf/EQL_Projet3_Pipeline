/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageTablesProducts is linked to the table products page in the application.
 * @author formation
 *
 */
public class PageTablesProducts {
	WebDriver driver;
	
	//Title "h1" tables page
	@FindBy(xpath="//h2")
	WebElement titleTables;
	
	//Container tables products on page
	@FindBy(id="productsContainer")
	WebElement ctnTablesProducts;
	
	/**
	 * PageTablesProducts() is the super constructor of this class
	 * @author formation
	 * @param driver
	 *
	 */
	public PageTablesProducts(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

}
