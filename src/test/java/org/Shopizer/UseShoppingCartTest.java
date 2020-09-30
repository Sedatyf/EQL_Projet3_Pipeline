/**
 * 
 */
package org.Shopizer;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.Shopizer.EBrowser;
import org.Shopizer.ToolBox;

//import org.Shopizer.Connexion;

/**
 * UseShoppingCartTest is the class to test the use of the shopping cart
 * @author formation
 *
 */
public class UseShoppingCartTest {
	static Logger log = LoggerFactory.getLogger(UseShoppingCartTest.class);
	WebDriver driver;
	WebDriverWait wait;
	
	PageHome home;
	PageShoppingCart shoppingCart;
	PageCheckout checkout;
	
	String URL = "http://176.160.193.39:25890/shopizer";
	String qttModified = "2";
	
	
	/**
	 * setUp() is the method to choose the Browser
	 * @author formation
	 * @throws Exception 
	 *
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.f);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * tearDown() is the method to quite the browser
	 * @author formation
	 * @throws Exception 
	 *
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		//log.info("QUIT DRIVER");
		System.out.println("QUIT DRIVER");
	}
	
	/**
	 * shoppingCartTest() is the method to automate Squash testing 
	 * @author formation
	 * @throws InterruptedException 
	 *
	 */
	@Test
	public void shoppingcartTest() throws InterruptedException {
	// PT1 : Check the application is open on the Browser
		ToolBox.navToURL(driver, URL);
		//PageHome instantiation
		home = new PageHome(driver);
		
		assertTrue(home.textAssertHome.isDisplayed());
		//log.info("[INFO] : SHOPIZER IS OPEN");
		System.out.println("[INFO] : SHOPIZER IS OPEN");

	// PT2 : Added object on Shopping cart
		home.btnAddToCart1stProduct.click();
		
		assertEquals(home.textAssertCartNumber.getText(), "(1)");
		//log.info("[INFO] : SHOPIZER IS OPEN");
		System.out.println("[INFO] : OBJECT IS ADDED ON SHOPING CART");
		
	// PT3 : Open the shopping cart overview
		ToolBox.moveToElement(driver, home.menuPanierToOver);
		Thread.sleep(2000);
		home.btnPaiementOnRollOn.click();
		//PageShoppingCart instantiation
		shoppingCart = new PageShoppingCart(driver);
		
		assertEquals(shoppingCart.titleCartPage.getText(), "Revoir votre commande");
		//log.info("[INFO] : SHOPING CART IS OPEN");
		System.out.println("[INFO] : SHOPING CART IS OPEN");
		
	// PT4 : Check objects are displayed
		//Check image 
		assertTrue(shoppingCart.imgTableProductInCart.isDisplayed());
		//Check name
		assertTrue(shoppingCart.nameTableProductInCart.isDisplayed());
		//Check quantity
		assertTrue(shoppingCart.quantityTableProductInCart.isDisplayed());
		//Check unit price
		assertTrue(shoppingCart.unitPriceTableProductInCart.isDisplayed());
		//Check total
		assertTrue(shoppingCart.totalPriceTableProductInCart.isDisplayed());
		
		//log.info("[INFO] : ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		System.out.println("[INFO] : ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		
	// PT5 : Check quantity is update
		//Modify the quantity
		ToolBox.fillInField(shoppingCart.quantityTableProductInCart, qttModified);
		shoppingCart.btnRecalculerTableProductInCart.click();
		Thread.sleep(1000);
		
		assertEquals(shoppingCart.quantityTableProductInCart.getAttribute("value"), qttModified);
		//log.info("[INFO] : QUANTITY IS UPDATED");
		System.out.println("[INFO] : QUANTITY IS UPDATED");
		
	// PT6 : Check total is updated
		//Recover value without currency
		String unitPriceValue = shoppingCart.unitPriceTableProductInCart.getText().substring(3);
		String subtotalValue = shoppingCart.subTotalValueInCart.getText().substring(3);
		String totalValue = shoppingCart.totalPriceTableProductInCart.getText().substring(3);
		//Convert recovered string to double for assert
		double unitPrice = Double.parseDouble(unitPriceValue);
		double Subtotal = Double.parseDouble(subtotalValue);
		double Total = Double.parseDouble(totalValue);
		
		assertTrue(Subtotal == unitPrice*2);
		assertTrue(Total == Subtotal);
		//log.info("[INFO] : SUBTOTAL AND TOTAL PRICE ARE UPDATED");
		System.out.println("[INFO] : SUBTOTAL AND TOTAL PRICE ARE UPDATED");
		
	// PT7 : Check checkout page is open
		shoppingCart.btnProceedCheckout.click();
		//PageCheckout instantiation
		checkout = new PageCheckout(driver);
		Thread.sleep(200);
		
		assertEquals(checkout.titleCheckout.getText(), "Paiement");
		//log.info("[INFO] : CHECKOUT PAGE IS OPEN");
		System.out.println("INFO] : CHECKOUT PAGE IS OPEN");
	}
	

}
