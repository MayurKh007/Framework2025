package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest
{	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	LoginPage login=new LoginPage();

	public LoginPageTest() throws IOException  {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		initializeBrowser();
		login = new LoginPage();	
	}
	
	@Test(priority = 1)
	public void loginPagetitleTest()
	{
	String loginpagetitle=	login.loginPageTitle();
      Assert.assertEquals("Swag Labs", loginpagetitle);
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException
	{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
