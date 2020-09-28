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
	
	
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.f);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7000);
	}
	
	
//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//		log.info("QUIT DRIVER");
//	}
	
	
	@Ignore
	public void shoppingcartTest() {
		// PT1 : Open application on the Browser
		driver.get("http://demo.shopizer.com:8080/shop");
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();
		assertTrue(driver.findElement(By.xpath("//div[contains(@class,'bannerImage')]")).isDisplayed());
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("SHOPIZER IS OPEN");

		// PT2 : Added object on Shopping cart
		driver.findElement(By.xpath("//@productid[.='1200']")).click();
		assertEquals(driver.findElement(By.xpath("//span[@id='miniCartSummary']")).getText(), "1");
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("INFO : OBJECT IS ADDED ON SHOPING CART");
		
		// PT3 : Open the shopping cart overview
		
	}
	

}
