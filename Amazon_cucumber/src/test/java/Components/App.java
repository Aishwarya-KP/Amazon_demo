package Components;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
	WebDriver driver;
	/**
	 * initializing web elements with variables
	 */
	By price=By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span");
	By dropdown=By.id("native_dropdown_selected_size_name");
	By Original_Product_Price=By.id("priceblock_ourprice");
	By AddToCartButton=By.xpath("//*[@id=\"add-to-cart-button\"]");
	By CartNumber=By.id("nav-cart-count");
	By PriceOnCart=By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]");
	By BuyProductButton=By.id("hlb-ptc-btn-native");
	By EmailID_Textbox=By.id("ap_email");
	By Continue_Button=By.id("continue");
	By Password_Textbox=By.id("ap_password");
	By SignIn_Button=By.id("signInSubmit");
	
	/**
	 * constructor to carry the same driver from the invoked method
	 * @param driver
	 */
	public App(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * method to select any size of the product
	 * @author AISHU
	 * @param string
	 * @throws InterruptedException 
	 */
	public  void size(String string) 
	{  
		       ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		       driver.switchTo().window(newTb.get(1));
			   Select s=new Select(driver.findElement(dropdown));
			   s.selectByVisibleText(string);
			   try {
				   Thread.sleep(2000);
			   }
			   catch(InterruptedException ie) {
				   Thread.currentThread().interrupt();
			   }
	}
	
	/**
	 * @author AISHU
	 * method to read the price of the product
	 * @return the price of the product
	 */
	public String GetProductPrice() 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		String product_price=driver.findElement(Original_Product_Price).getText();
		System.out.println("Actual Product Price is"+product_price);
		return product_price;
	}
	
	/**
	 * @author AISHU
	 * method to add the product to the cart
	 */
	public void AddToCart() 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
		driver.findElement(AddToCartButton).click();
	}
	
	/**
	 * @author AISHU
	 * method to check whether the product is added to the cart or not
	 * @param expected_number
	 * @return whether car number is changed or not
	 */
	public boolean CheckCartNumber(String expected_number) 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		String cart_Item=driver.findElement(CartNumber).getText();
		boolean cart_check=cart_Item.equals(expected_number);
		System.out.println("Number of Items in cart"+cart_Item);
		System.out.println(cart_check);
		return cart_check;
	}
	
	/**
	 * @author AISHU
	 * method to check the price of the product on the cart page
	 * @param Expected_Price
	 * @return whether the product is same as the price on the cart
	 */
	public boolean CheckPriceOnCartPage(String Expected_Price) 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		String cost=driver.findElement(PriceOnCart).getText();
		boolean match=cost.equals(Expected_Price);
		System.out.println("Price of the Product on add to cart page is:"+cost);
		System.out.println("Result of product price Vs add to cart price"+match);
		return match; 
	}
	
	/**
	 * @author AISHU
	 * method to buy the product
	 */
	public void BuyProduct() 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		driver.findElement(BuyProductButton).click();
	}
	
	/**
	 * @author AISHU
	 * method to sign in to amazon in order to buy the product
	 */
	public void sign_in() 
	{
		ArrayList<String>newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		
		driver.findElement(EmailID_Textbox).sendKeys("8754222952");
		
		driver.findElement(Continue_Button).click();
		
		driver.findElement(Password_Textbox).sendKeys("aishuece");
		
		driver.findElement(SignIn_Button).click();
	}
}//end of app method

