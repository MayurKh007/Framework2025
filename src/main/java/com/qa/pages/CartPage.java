package com.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;

public class CartPage extends BaseTest {

	public CartPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Your Cart']")
	WebElement cartPageHeader;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	WebElement cartProductName;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	WebElement expectedProductName;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartIcon;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutBtn;

	
	public String cartPageProductDetails() {
		String cartPageProductName = cartProductName.getText();
		return cartPageProductName;

	}

	
	public String productAddedToCart() {
		String expectedProductNames = expectedProductName.getText();
		return expectedProductNames;
	}

	
	public String navigateToCartPage() {
		cartIcon.click();
		return cartPageHeader.getText();

	}

	
	public boolean clickOnCheckoutBtn() 
	{		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutBtn.click();
		return true;
	}

}
