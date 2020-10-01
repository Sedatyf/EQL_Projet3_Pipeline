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
	
	//Title "h3" into item page
	@FindBy(xpath="//h3")
	WebElement titleItem;
	
	//Unit price into item page
	@FindBy(xpath="//span[@itemprop='price']")
	WebElement unitPriceItem;
	
	//Button "Ajouter au panier" into item page
	@FindBy(xpath="//button[.='Ajouter au panier']")
	WebElement btnAddToCartItem;
	
	//Image stars into item page
	@FindBy(xpath="//img[@alt='5'][contains(@src, 'img/stars/star-off.png')]")
	WebElement imgStarsItem;
	
	//Rating item into item page
	@FindBy(id="productRating")
	WebElement ratingItem;
	
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
