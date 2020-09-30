/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author formation
 *
 */
public class PageHome {
	WebDriver driver;

	//Text "test text" into home page
	@FindBy(xpath="//p[contains(., 'test text')]")
	WebElement textAssertHome;

	//Button add to cart 1st product
	@FindBy(xpath="//a[@productid='150']")
	WebElement btnAddToCart1stProduct;

	//Text "(1)" into cart
	@FindBy(xpath="	//strong[.='(1)']")
	WebElement textAssertCartNumber;


	//Over to roll-on shopping cart menu
	@FindBy(xpath="//a[contains(., 'Panier ')]")
	WebElement menuPanierToOver;


	//Button "Paiement" on roll on shopping cart menu
	@FindBy(xpath="//a[contains(., 'Paiement')]")
	WebElement btnPaiementOnRollOn;
	
	//Button "Tables" on products menu
	@FindBy(xpath="//div[@class='mainmenu hidden-xs']/nav/ul/li[2]")
	WebElement btnTablesOnProductsMenu;


	/**
	 * PageHome() is the super constructor of this class
	 * @author formation
	 * @param driver
	 *
	 */
	public PageHome(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
}
