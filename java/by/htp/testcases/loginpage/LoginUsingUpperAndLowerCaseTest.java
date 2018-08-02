package by.htp.testcases.loginpage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.MyInstaPropertyManager;

public class LoginUsingUpperAndLowerCaseTest {
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
	public void LogInCorrectLoginUsingDifferentCasesAndCorrectPass() {
		loginPage.loginValid("Daryaaa756", "12345qwert");
		mainPage.clickNotNowLink();
		mainPage.waitElementPresent();
		String NotNow = mainPage.getTextNotNowNotification();
		Assert.assertEquals("Not Now", NotNow);
	}

	@After
	public void LogOut() {
		mainPage.clickNotNowNotifications();
		mainPage.clickOnProfileUser();
		mainPage.clickOnParameters();
		mainPage.clickOnLogOutButton();
		driver.quit();

	}
}