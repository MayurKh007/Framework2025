package com.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement dropdown;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
	WebElement removeBtn;

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	WebElement allproducts;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean selectDropdown() {
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Price (high to low)");
		return true;
	}

	public boolean addProductToCart() {

		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

		for (WebElement ele : allproducts) {
			if (ele.getText().equals("Sauce Labs Bike Light")) {
				addToCartBtn.click();
				return true;
			}
		}
		return false;

	}

}
