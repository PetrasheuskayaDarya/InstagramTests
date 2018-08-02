package by.htp.testcases.general;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.MyInstaPropertyManager;

public class CheckTitlesTests {
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static MainPage mainPage;
	MyInstaPropertyManager conf = new MyInstaPropertyManager();
	

	@BeforeClass
	public static void SetUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/accounts/login/");
	}

	@Test
	public void checkTitleLoginPage() {
		String loginPageTitle = loginPage.getTitle();
		Assert.assertEquals("Login • Instagram", loginPageTitle);

	}
	
	@Test
	public void checkTitleMainPage() {
		loginPage.loginValid(conf.getLogin(), conf.getPass());
		String mainPageTitle = mainPage.getTitle();
		Assert.assertEquals("Welcome • Instagram", mainPageTitle);
		
	}

	@AfterClass
	public static void StopDriver() {
		mainPage.clickNotNowLink();
		mainPage.clickNotNowNotifications();
		mainPage.clickOnProfileUser();
		mainPage.clickOnParameters();
		driver.quit();
	}
}
