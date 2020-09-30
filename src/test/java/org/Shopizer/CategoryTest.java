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

/**
 * CategoryTest is the class to test the use of category on the menu
 * @author formation
 *
 */
public class CategoryTest {
	static Logger log = LoggerFactory.getLogger(UseShoppingCartTest.class);
	WebDriver driver;
	WebDriverWait wait;
	
	PageHome home;
	PageTablesProducts tables;
	PageProductDetail productDetail;
	
	String URL = "http://176.160.193.39:25890/shopizer";
	
	/**
	 * setUp() is the method to choose the Browser
	 * @author formation
	 * @throws Exception
	 *
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
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
	 * tableCategoryTest() is the method to automate Squash testing 
	 * @author formation
	 * @throws InterruptedException 
	 *
	 */
	@Test
	public void tableCategoryTest() throws InterruptedException {
		ToolBox.navToURL(driver, URL);
		//PageHome instantiation
		home = new PageHome(driver);
		Thread.sleep(700);
		//log.info("[INFO] : SHOPIZER IS OPEN");
		System.out.println("[INFO] : SHOPIZER IS OPEN");
		
	// PT1 : Check a dropdown menu appears, and lets categories appear (not applicable with the tested version of the application)
	// PT1 bis : Check tables button is displayed
		assertTrue(home.btnTablesOnProductsMenu.isDisplayed());
		//log.info("[INFO] : TABLES BUTTON IS DISPLAYED ON THE PRODUCTS MENU");
		System.out.println("[INFO] : TABLES BUTTON IS DISPLAYED ON THE PRODUCTS MENU");
		
	// PT2 : Opening the "products tables" page and checking the presence of items in this category
		home.btnTablesOnProductsMenu.click();
		//PageTablesProducts instantiation
		tables = new PageTablesProducts(driver);
		Thread.sleep(700);
		
		assertEquals(tables.titleTables.getText(), "Tables");
		assertTrue(tables.ctnTablesProducts.isDisplayed());
		//log.info("[INFO] : TABLE PAGE IS OPEN AND PRODUCTS ARE DISPLAYED");
		System.out.println("[INFO] : TABLE PAGE IS OPEN AND PRODUCTS ARE DISPLAYED");
		
	// PT3 : Checking all elements of each product
		
		
	// PT4 : Applying the filter and reducing the number of items on the page. Check that the articles present were already present on the initial page.
		tables.filterAsianWood.click();
		
		
	// PT5 : Checking a product detail page	is open
		//PageProductDetail instantiation
		productDetail = new PageProductDetail(driver);
		Thread.sleep(700);
		
		assertTrue(productDetail.titleProduct.isDisplayed());
		//log.info("[INFO] : PRODUCT DETAIL PAGE IS OPEN");
		System.out.println("[INFO] : PRODUCT DETAIL PAGE IS OPEN");
		
	// PT6 : Checking the presence of all these elements. These elements are the same as those on the previous page.
		
		
		
		
		
		
		
		
	}
}
