/**
 * 
 */
package org.Shopizer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
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
	
	//First item into container tables page
	@FindBy(xpath="//div[@id='productsContainer']/div[1]")
	WebElement itemFirstOnPage;
	
	//First item image
	@FindBy(xpath="//div[@id='productsContainer']/div[1]/div[1]")
	WebElement imgFirstItemOnPage;
	
	//First item name
	@FindBy(xpath="//div[@id='productsContainer']/div[1]//h3")
	WebElement nameFirstItemOnPage;
	
	//First item unit price with device
	@FindBy(xpath="//div[@id='productsContainer']/div[1]//span")
	WebElement unitPriceFirstItemOnPage;
	
	//First item button "Ajouter au panier"
	@FindBy(xpath="//div[@id='productsContainer']/div[1]///a[@class='addToCart']")
	WebElement btnAddToCarFirstItemOnPage;
	
	//Item name "Coffee table Accacia" on filter "Asian Wood"
	@FindBy(xpath="//div[@id='productsContainer']//a[@href]/h3")
	WebElement nameItemAccaciaOnFilterAsianWood;
	
	//Filter "Asian Wood" into tables page
	@FindBy(xpath="//a[contains(.,'Asian Wood')]")
	WebElement filterAsianWood;
	
	
	Map<String, String> imageItem = new HashMap<String, String>();
	Map<String, String> nameItem = new HashMap<String, String>();
	Map<String, String> unitPriceItem = new HashMap<String, String>();
	Map<String, String> btnAddToCartItem = new HashMap<String, String>();

	
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
	
	public void recoveryElements(WebDriver driver) {		
		for(int i=1; i<=4; i++) {
			imageItem.put("item"+i, driver.findElement(By.xpath("//div[@id='productsContainer']/div["+i+"]/div[1]")).getText());
			nameItem.put("item"+i, driver.findElement(By.xpath("//div[@id='productsContainer']/div["+i+"]//h3")).getText());
			unitPriceItem.put("item"+i, driver.findElement(By.xpath("//div[@id='productsContainer']/div["+i+"]//span")).getText());
			btnAddToCartItem.put("item"+i, driver.findElement(By.xpath("//div[@id='productsContainer']/div["+i+"]///a[@class='addToCart']")).getText());
		}
	}
	

}
