package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandlingDropdown;

public class Inventory_Page extends TestBase
   {
	//object repository
	@FindBy (xpath= "//span[@class='title']") private WebElement productTitleText  ;
	@FindBy (xpath= "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightProduct;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTishirtProduct;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy (xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTshirtProduct;
	@FindBy (xpath="//select[@class='product_sort_container']") private WebElement productSortDropDown;
	@FindBy (xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy (xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy (xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement  removebikelightProduct;
	
    //constructor
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	// method
	public String verifyProductLable()
	{
		return productTitleText.getText();
		
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	
		
	}
	public String add6Products() throws InterruptedException
	{
		HandlingDropdown.handleSelectClass(productSortDropDown, "Price (low to high)");
		backpackProduct.click();
		bikelightProduct.click();
		boltTishirtProduct.click();
		fleeceJacketProduct.click();
		onesieProduct.click();
		redTshirtProduct.click();
		return cartCount.getText();
		
	}
	
	public void ClickcartCount()
	{
		cartCount.click();
	}
	
	
   }
