package testcases;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class CartPageTest extends BaseTest {

	CartPage cartpage;
	LoginPage loginpage;
	HomePage homepage;

	public CartPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initializeBrowser();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartpage = new CartPage();
		homepage = new HomePage();
		homepage.selectDropdown();
		
	}

	@Test(priority = 1)
	public void cartPageHeaderText() {
		String headertext = cartpage.navigateToCartPage();
		Assert.assertEquals("Your Cart", headertext);
	}

	@Test(priority = 2)
	public void verifyCartPageProductTest() {
		String cartpageproduct = cartpage.cartPageProductDetails();
		String expectedproduct = cartpage.productAddedToCart();

		if (cartpageproduct.equals(expectedproduct)) {
			System.out.println("Product added to cart page");
		} else {
			System.out.println("Product not added to cart page");
		}
	}

	@Test(priority = 3)
	public void verifyCheckoutPageTest() {
		cartpage.navigateToCartPage();
		homepage.addProductToCart();
		Assert.assertTrue(cartpage.clickOnCheckoutBtn());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
