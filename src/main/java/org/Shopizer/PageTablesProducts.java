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
	@FindBy(xpath="//div[@id='productsContainer']/div[1]//a[@class='addToCart']")
	WebElement btnAddToCarFirstItemOnPage;
	
	//Second item image
	@FindBy(xpath="//div[@id='productsContainer']/div[2]/div[1]")
	WebElement imgSdItemOnPage;
	//Second item name
	@FindBy(xpath="//div[@id='productsContainer']/div[2]//h3")
	WebElement nameSdItemOnPage;
	//Second item unit price with device
	@FindBy(xpath="//div[@id='productsContainer']/div[2]//span")
	WebElement unitPriceSdItemOnPage;
	//Second item button "Ajouter au panier"
	@FindBy(xpath="//div[@id='productsContainer']/div[2]//a[@class='addToCart']")
	WebElement btnAddToCarSdItemOnPage;
	
	//Third item image
	@FindBy(xpath="//div[@id='productsContainer']/div[3]/div[1]")
	WebElement imgThirdItemOnPage;
	//Third item name
	@FindBy(xpath="//div[@id='productsContainer']/div[3]//h3")
	WebElement nameThirdItemOnPage;
	//Third item unit price with device
	@FindBy(xpath="//div[@id='productsContainer']/div[3]//span")
	WebElement unitPriceThirdItemOnPage;
	//Second item button "Ajouter au panier"
	@FindBy(xpath="//div[@id='productsContainer']/div[3]//a[@class='addToCart']")
	WebElement btnAddToCarThirdItemOnPage;
	
	//Fourth item image
	@FindBy(xpath="//div[@id='productsContainer']/div[4]/div[1]")
	WebElement imgFourthItemOnPage;
	//Fourth item name
	@FindBy(xpath="//div[@id='productsContainer']/div[4]//h3")
	WebElement nameFourthItemOnPage;
	//Fourth item unit price with device
	@FindBy(xpath="//div[@id='productsContainer']/div[4]//span")
	WebElement unitPriceFourthItemOnPage;
	//Fourth item button "Ajouter au panier"
	@FindBy(xpath="//div[@id='productsContainer']/div[4]//a[@class='addToCart']")
	WebElement btnAddToCarFourthItemOnPage;

	//Item name "Coffee table Accacia" on filter "Asian Wood"
	@FindBy(xpath="//div[@id='productsContainer']//a[@href]/h3")
	WebElement nameItemAccaciaOnFilterAsianWood;
	
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
