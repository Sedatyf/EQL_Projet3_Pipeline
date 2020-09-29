/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author formation
 *
 */
public abstract class Header {
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(., 'Panier ')]")
	WebElement tab_cart;
	@FindBy(xpath = "//a[contains(., 'Paiement')]")
	WebElement btn_paiement;

	
	public PageShoppingCart clickPaiement(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(tab_cart).build().perform();
		btn_paiement.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}

}
