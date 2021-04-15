package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
/**
 * webelements present in home page
 * @author AISHU
 */
By amazon_logo=By.id("nav-logo-sprites");
By cart_number_icon=By.id("nav-cart-count");
By Search_box=By.id("twotabsearchtextbox"); 
WebDriver driver;

/**
 * @author AISHU
 * @param driver
 * constructor to maintain the driver from the invoked method
 */
public Homepage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

/** 
 * method to check whether amazon Logo is present on the page
 * @author AISHU
 */

public boolean verifyAmazonLogo() 
{
	boolean isDisplayed=driver.findElement(amazon_logo).isDisplayed();
	return isDisplayed;
}

/**
 * method to check whether the cart is initially zero
 * @author AISHU
 */
 public boolean verifyCartnumber(String expected_count) 
 {
	 boolean match=driver.findElement(cart_number_icon).getText().equals(expected_count);
	 return match;
}
 
 /**
  * @author AISHU
  * method to click search box and search for products
  */
 public void search_product(String ProductName) 
 {
	 driver.findElement(Search_box).sendKeys(ProductName);
	 driver.findElement(Search_box).sendKeys(Keys.ENTER);
 }
}//end of Homepage method
