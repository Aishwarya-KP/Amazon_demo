package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage {
WebDriver driver;

/**
 * @author AISHU
 * constructor to maintain the driver from the invoked method
 */

public SearchResultsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

/**
 * @author AISHU
 * initializing web elements with variables
 */

By SearchResults=By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]");
By sort_feature=By.id("s-result-sort-select");
By first_item=By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]");

/**
 * @author AISHU
 * method to verify that the results page is displayed is same as the searched item
 */
public boolean verifySearchResults(String searchtext)
{
  String search=driver.findElement(SearchResults).getText().trim().replace("\"", "");
  boolean match=search.equals(searchtext);
  return match;
	}

/**
 *@author AISHU
 *method to select the sort feature
 */

public void selectSort(String string)  
{
	 Select s=new Select(driver.findElement(sort_feature));
	 s.selectByVisibleText(string);
}

/**
 * method to select the product with lowest price
 * @author AISHU
 */
public void selectFirstItem() 
{
	driver.findElement(first_item).click();
}

}
