package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends BaseTest
{
	HomePage homepage;
	LoginPage login;
	
	public HomePageTest() throws IOException {
	    
		super();
	}
		
	@BeforeMethod
	public void setup() throws IOException
	{
		initializeBrowser();
		LoginPage loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
	}
	
	@Test(priority = 1)
	public void dropdownSelectTest() throws IOException
	{
		Assert.assertTrue(homepage.selectDropdown());
	}
	
	@Test(priority = 2)
	public void addToCartProductTest()
	{
		Assert.assertTrue(homepage.addProductToCart());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
