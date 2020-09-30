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
	
	//Title "h2" tables page
	@FindBy(xpath="//h2")
	WebElement titleTables;
	
	//Container products into tables page
	@FindBy(id="productsContainer")
	WebElement ctnTablesProducts;
	
	//Items products into container tables page
	@FindBy(xpath="//div[@id='productsContainer']/div")
	WebElement itemsOnContainerProducts;
	
	//Item name "Coffee table Accacia" on filter "Asian Wood"
	@FindBy(xpath="//div[@id='productsContainer']//a[@href]/h3")
	WebElement itemNameAccaciaOnFilterAsianWood;
	
	//Filter "Asian Wood" into tables page
	@FindBy(xpath="//a[contains(.,'Asian Wood')]")
	WebElement filterAsianWood;
	
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
