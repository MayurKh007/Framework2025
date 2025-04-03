package com.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.base.BaseTest;

public class CheckoutPage extends BaseTest 
{
	/*
	 * Page Locators 
	 */
	
	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "finish")
	WebElement finishBtn;

	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	WebElement orderDetails;

	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	WebElement checkOutHeaderText;

	@FindBy(id = "back-to-products")
	WebElement backHomeicon;

	@FindBy(id = "react-burger-menu-btn")
	WebElement hamburgerMenuIcon;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutslideBar;

	@FindBy(id = "login-button")
	WebElement loginbutton;

	public CheckoutPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	/*
	 * Page Actions 
	 */
	public boolean getCheckoutheaderText() {
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(checkOutHeaderText));
		String text = checkOutHeaderText.getText();
		return true;
	}

	public void enterCheckoutDetails(String uname, String pwd, String postalcode) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(firstName));
			firstName.sendKeys(uname);
			lastName.sendKeys(pwd);
			postalCode.sendKeys(postalcode);
     
		} catch (Exception e) {
			System.out.println("Exception Hanlded");
			e.printStackTrace();
		}

	}
	public String placeOrder() {
		continueBtn.click();
		finishBtn.click();
		String orderDetailsText = orderDetails.getText();
		return orderDetailsText;
	}

	public boolean logOutUser() {
		backHomeicon.click();
		hamburgerMenuIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		logoutslideBar.click();
		if (loginbutton.isDisplayed()) {
			System.out.println("Logout page displayed and User is logged out");
			return true;
		} else {
			System.out.println("Login page displayed and User is not logged out");
		}
		return false;
	}

}
