package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	// Page Actions
	public String loginPageTitle() {
		return driver.getTitle();
	}

	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	public String homePageTitle() {
		String homePageTile = driver.getTitle();
		return homePageTile;
	}

}
