/**
 * 
 */
package org.Shopizer;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
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
	String nameFirstItemOnTablesPage;
	String unitPriceFirstItemOnTablesPage;
	String btnAddToCartFirstItemOnTablesPage;
	
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
	// PT1 bis : Check tables button is displayed into the menu.
		assertTrue(home.btnTablesOnProductsMenu.isDisplayed());
		//log.info("[INFO] : TABLES BUTTON IS DISPLAYED ON THE PRODUCTS MENU");
		System.out.println("[INFO] : 'TABLES' BUTTON IS DISPLAYED ON THE PRODUCTS MENU");

		
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
		//Recovery elements on first item into PageTablesProducts before switch at PageProductDetail
		String nameFirstItemOnTablesPage = tables.nameFirstItemOnPage.getText();
		String unitPriceFirstItemOnTablesPage = tables.unitPriceFirstItemOnPage.getText();
		//String btnAddToCartFirstItemOnTablesPage = tables.btnAddToCarFirstItemOnPage.getText();
		
		//Check first item elements are displayed
		assertTrue(tables.imgFirstItemOnPage.isDisplayed());
		assertTrue(tables.nameFirstItemOnPage.isDisplayed());
		assertTrue(tables.unitPriceFirstItemOnPage.isDisplayed());
		assertTrue(tables.btnAddToCarFirstItemOnPage.isDisplayed());
		//log.info("[INFO] : FIRST ITEM'S ELEMENTS ARE DISPLAYED");
		System.out.println("[INFO] : FIRST ITEM'S ELEMENTS ARE DISPLAYED");
		
		//Check second item elements are displayed
		assertTrue(tables.imgSdItemOnPage.isDisplayed());
		assertTrue(tables.nameSdItemOnPage.isDisplayed());
		assertTrue(tables.unitPriceSdItemOnPage.isDisplayed());
		assertTrue(tables.btnAddToCarSdItemOnPage.isDisplayed());
		//log.info("[INFO] : SECOND ITEM'S ELEMENTS ARE DISPLAYED");
		System.out.println("[INFO] : SECOND ITEM'S ELEMENTS ARE DISPLAYED");
		
		//Check third item elements are displayed
		assertTrue(tables.imgThirdItemOnPage.isDisplayed());
		assertTrue(tables.nameThirdItemOnPage.isDisplayed());
		assertTrue(tables.unitPriceThirdItemOnPage.isDisplayed());
		assertTrue(tables.btnAddToCarThirdItemOnPage.isDisplayed());
		//log.info("[INFO] : THIRD ITEM'S ELEMENTS ARE DISPLAYED");
		System.out.println("[INFO] : THIRD ITEM'S ELEMENTS ARE DISPLAYED");
		
		//Check fourth item elements are displayed
		assertTrue(tables.imgFourthItemOnPage.isDisplayed());
		assertTrue(tables.nameFourthItemOnPage.isDisplayed());
		assertTrue(tables.unitPriceFourthItemOnPage.isDisplayed());
		assertTrue(tables.btnAddToCarFourthItemOnPage.isDisplayed());
		//log.info("[INFO] : FOURTH ITEM'S ELEMENTS ARE DISPLAYED");
		System.out.println("[INFO] : FOURTH ITEM'S ELEMENTS ARE DISPLAYED");
	
		
	// PT4 : Applying the filter and reducing the number of items on the page.
		tables.filterAsianWood.click();
		Thread.sleep(700);
		//log.info("[INFO] : FILTER IS APLLICATED");
		System.out.println("[INFO] : FILTER IS APLLICATED");
		
		//Check that the item present were already present on the initial page.
		String nameItemOnFilterPage = tables.nameItemAccaciaOnFilterAsianWood.getText();
		driver.navigate().refresh();
		Thread.sleep(700);
		assertEquals(tables.nameFourthItemOnPage.getText(), nameItemOnFilterPage);
		//log.info("[INFO] : ITEM IS PRESENT ON INITIAL PAGE");
		System.out.println("[INFO] : ITEM IS PRESENT ON INITIAL PAGE");
		

	// PT5 : Checking a product detail page	is open
		//PageProductDetail instantiation
		productDetail = new PageProductDetail(driver);
		Thread.sleep(700);
		
		assertTrue(productDetail.titleItem.isDisplayed());
		//log.info("[INFO] : PRODUCT DETAIL PAGE IS OPEN");
		System.out.println("[INFO] : PRODUCT DETAIL PAGE IS OPEN");
		
		
	// PT6 : Checking the presence of all these elements. These elements are the same as those on the previous page.	
		//Some elements are missing in this version of the application. The matching tests with the "Tables" page will focus on the name of the item, its price and the button "Add to cart".
		assertEquals(productDetail.titleItem.getText(), nameFirstItemOnTablesPage);
		//System.out.println(productDetail.btnAddToCartItem.getText());
		//assertEquals(productDetail.btnAddToCartItem.getText(), btnAddToCartFirstItemOnTablesPage);
		assertEquals(productDetail.unitPriceItem.getText(), unitPriceFirstItemOnTablesPage);
		//log.info("[INFO] : NAME, PRICE AND BUTTON 'ADD TO CART' ARE DISPLAYED");
		System.out.println("[INFO] : STARS AND DEVICE ARE DISPLAYED");
		
		System.out.println(productDetail.ratingItem);
		//assertTrue(productDetail.ratingItem.isDisplayed());
		String device = productDetail.unitPriceItem.getText().substring(0, 3);
		assertEquals(device, "US$");	
		//log.info("[INFO] : STARS AND DEVICE ARE DISPLAYED");
		System.out.println("[INFO] : STARS AND DEVICE ARE DISPLAYED");
		
	}
}
