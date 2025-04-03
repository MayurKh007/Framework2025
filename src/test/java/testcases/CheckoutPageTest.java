package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.CartPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class CheckoutPageTest extends BaseTest {

	CheckoutPage checkoutpage;
	LoginPage loginpage;
	CartPage cartpage;
	HomePage homepage;

	
	
	public CheckoutPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		initializeBrowser();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		homepage.selectDropdown();
		cartpage=new CartPage();
		checkoutpage=new CheckoutPage();
	}

	@Test(priority = 1)
	public void verifyCheckoutPageTitleTest() {
		homepage.addProductToCart();
		cartpage.navigateToCartPage();
		cartpage.clickOnCheckoutBtn();
		Assert.assertTrue(checkoutpage.getCheckoutheaderText());
	}

	@Test(priority = 2)
	public void placeOrderTest() {
		homepage.addProductToCart();
		cartpage.navigateToCartPage();
		cartpage.clickOnCheckoutBtn();
		checkoutpage.enterCheckoutDetails(prop.getProperty("firstName"), prop.getProperty("lastname"),prop.getProperty("postalCode"));
		String orderdetails = checkoutpage.placeOrder();
		Assert.assertEquals("Thank you for your order!", orderdetails);
		Assert.assertTrue(checkoutpage.logOutUser());
	}
	

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
