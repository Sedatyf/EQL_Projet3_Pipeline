/**
 * 
 */
package org.Shopizer;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	
	
	/**
	 * setUp() is the method to choose the Browser
	 * @author formation
	 *
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, 7000);
	}
	
	/**
	 * tearDown() is the method to quite the browser
	 * @author formation
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
	// PT1 : Open application on the Browser
		driver.get("http://176.160.193.39:25890/shopizer");
		//Thread.sleep(10000);
		//driver.navigate().refresh();
		//Thread.sleep(10000);
		
		assertTrue(driver.findElement(By.xpath("//p[contains(., 'test text')]")).isDisplayed());
		
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("SHOPIZER IS OPEN");

	// PT2 : Added object on Shopping cart
		driver.findElement(By.xpath("//a[@productid='150']")).click();
		assertEquals(driver.findElement(By.xpath("//strong[.='(1)']")).getText(), "(1)");
		
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("INFO : OBJECT IS ADDED ON SHOPING CART");
		
	// PT3 : Open the shopping cart overview
		WebElement shoppingCart = driver.findElement(By.xpath("//a[contains(., 'Panier ')]"));
		WebElement btn_paiement = driver.findElement(By.xpath("//a[contains(., 'Paiement')]"));
		Actions act = new Actions(driver);
		act.moveToElement(shoppingCart).build().perform();
		Thread.sleep(5000);
		btn_paiement.click();
		
		
		//driver.findElement(By.xpath("//a[contains(., 'Paiement')]")).click();
		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Revoir votre commande");
		//log.info("INFO : SHOPING CART IS OPEN");
		System.out.println("INFO : SHOPING CART IS OPEN");
		
	// PT4 : Verify if object is displayed
		// Image verification
		assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-4 hidden-xs']/img")).isDisplayed());
		// Name verification
		assertTrue(driver.findElement(By.xpath("//strong[contains(., 'Thai flat cussion')]")).isDisplayed());
		// Quantity verification
		assertTrue(driver.findElement(By.name("quantity")).isDisplayed());
		// Price verification
		assertTrue(driver.findElement(By.xpath("//td[@data-th='Prix']/strong[contains(., 'US$59.99')]")).isDisplayed());
		// Total verification
		assertTrue(driver.findElement(By.xpath("//td[@data-th='Total']/strong[contains(., 'US$59.99')]")).isDisplayed());
		
		//log.info("INFO : ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		System.out.println("ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		
	// PT5 : Update quantity on shopping cart
		//doubler la quantité du produit
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.xpath("//a[contains(., 'Recalculer')]")).click();
		assertTrue(driver.findElement(By.xpath("//input[@value='2']")).isDisplayed());
		
		//log.info("INFO : QUANTITY IS UPDATED");
		System.out.println("QUANTITY IS UPDATED");
		
	// PT6 : Verify total updated
		String unitPrice = driver.findElement(By.xpath("//strong[contains(.,'59.99')]")).getText().substring(3);
		String subtotal = driver.findElement(By.xpath("//tr[@class='cart-subtotal'][1]/td/span")).getText().substring(3);
		String total = driver.findElement(By.xpath("//tr[@class='cart-subtotal'][2]/td/span")).getText().substring(3);
		
		double unit = Double.parseDouble(unitPrice);
		double dSubtotal = Double.parseDouble(subtotal);
		double dTotal = Double.parseDouble(total);
		
		assertTrue(dSubtotal == unit*2);
		assertTrue(dTotal == dSubtotal);
		
		//log.info("INFO : SUBTOTAL AND TOTAL PRICE AR UPDATED");
		System.out.println("SUBTOTAL AND TOTAL PRICE AR UPDATED");
		
	// PT7 : Verify checkout page is open
		driver.findElement(By.xpath("//a[contains (., 'Effectuer le paiement')]")).click();
		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Paiement");
		
		//log.info("INFO : CHECKOUT PAGE IS OPEN");
		System.out.println("CHECKOUT PAGE IS OPEN");
	}
	

}
