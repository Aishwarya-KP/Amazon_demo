																											package stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Components.App;
import Components.Homepage;
import Components.SearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition 
{
	WebDriver driver;
	Homepage homepage;
	SearchResultsPage searchpage;
	App app;
	String Price;
	/**
	 * @author AISHU
	 * Open chrome browser
	 * maximize the window
	 * clear all cookies
	 * and set wait time as 10 seconds
	 */
@Before
	public void initiate() 
{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	driver=new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	
}

/**
 * user navigates to the amazon home page
 * @author AISHU
 */
	@Given("User navigates to the homepage")
	public void user_navigates_to_the_homepage()
	{
	    driver.get("https://www.amazon.in/");
	    System.out.println("amazon website opened");
	}

	/**
	 * @author AISHU
	 * verify amazon logo is displayed on the top left corner of the amazon home page
	 */
	@Then("verify Amazon logo displayed")
	public void verify_Amazon_logo_displayed() 
	{
	    homepage=new Homepage(driver);
	    boolean out=homepage.verifyAmazonLogo();
	    Assert.assertTrue(out);
	    System.out.println("amazon logo displayed");
	    }

	/**
	 * @author AISHU
	 * verify that initially cart is 0
	 */
	@Then("verify cart has no items displayed")
	public void verify_cart_has_no_items_displayed() 
	{
	    boolean out=homepage.verifyCartnumber("0");
	    Assert.assertTrue(out);
	    System.out.println("Cart has no items");
	}

	/**
	 * @author AISHU
	 * user searches for a product
	 * @param string
	 */
	@When("user searches for {string}")
	public void user_searches_for(String string)
	{
	    homepage.search_product(string);
	    System.out.println("searching for red tshirt");
	}

	/**
	 * @author AISHU
	 * verify that the results page displayed adheres to the product searched
	 * @param string
	 */
	@Then("verify search results displayed for {string}")
	public void verify_search_results_displayed_for(String string) 
	{
		searchpage=new SearchResultsPage(driver);
	    boolean out=searchpage.verifySearchResults(string);
	    Assert.assertTrue(out);
	}
	
	/**
	 * @author AISHU
	 * select the sort option and select any one of the sort feature displayed
	 * @param string
	 */
	@When("choose the sort option {string}")
	public void choose_the_sort_option(String string)  
	{
		searchpage=new SearchResultsPage(driver);
		searchpage.selectSort(string);
		System.out.println("Sort-Low to High done");
	}

	/**
	 * @author AISHU
	 * select the product with the lowest cost displayed
	 */
	@Then("select the first item in the list")
	public void select_the_first_item_in_the_list()  
	{
	    searchpage.selectFirstItem();
	    System.out.println("Product with least price picked");
	}
	
	
	/**
	 * @author AISHU
	 * select the size of the product
	 * @param string
	 * @throws InterruptedException
	 */
	@Then("choose the size as {string}")
	public void choose_the_size_as(String string) throws InterruptedException 
	{
		app = new App(driver);
		app.size(string);
		System.out.println("Small size selected");
	}

	/**
	 * @author AISHU
	 * get the price of the product displayed
	 */
	@Then("Get the price of the product")
	public void get_the_price_of_the_product() 
	{
		Price=app.GetProductPrice();
	}

	/**
	 * @author AISHU
	 * add the product to cart
	 */
	@When("click add to cart")
	public void click_add_to_cart() 
	{
		app.AddToCart();
		System.out.println("Add to cart done");
	}
	
	/**
	 * @author AISHU
	 * when the product is added to the cart verify that the cart number has changed to 1
	 * @param string
	 */
	@Then("Check the cart number has changed to {string}")
	public void check_the_cart_number_has_changed_to(String string) {
		boolean out=app.CheckCartNumber(string);
	    Assert.assertTrue(out);
	    System.out.println("One product is added to the cart");
	}
	
/**
 * @author AISHU
 * verify the price of the product is same as the price displayed on the add to cart page
 */
	@Then("verify the price on cart page")
	public void verify_the_price_on_cart_page() 
	{
		boolean output=app.CheckPriceOnCartPage(Price);
	    Assert.assertTrue(output);
	    System.out.println("Price on cart is same as the price of the product");
	}
	
	/**
	 * @author AISHU
	 * click buy now option
	 */
	
	@Then("Click buy now option")
	public void click_buy_now_option()
	{
		app.BuyProduct();
	}

	/**
	 * @author AISHU
	 * sign in to amazon site in order to buy the product
	 */
	@Then("User signs in")
	public void user_signs_in() 
	{
		 app.sign_in();
		 System.out.println("signed in successfully");
	}

/**
 * @author AISHU
 * terminate browser	
 */
	
@After
public void Terminate() 
{
	driver.quit();
}
}
