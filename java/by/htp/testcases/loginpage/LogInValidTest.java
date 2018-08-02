package by.htp.testcases.loginpage;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.MyInstaPropertyManager;

public class LogInValidTest {
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
	public void LogInWithRightCreds() {
		loginPage.loginValid(conf.getLogin(), conf.getPass());
		mainPage.clickNotNowLink();
		mainPage.waitElementPresent();
		String NotNowButton = mainPage.getTextNotNowNotification();
		Assert.assertEquals("Not Now", NotNowButton);

	}

	@AfterClass
	public static void StopDriver() {
		mainPage.clickNotNowNotifications();
		mainPage.clickOnProfileUser();
		mainPage.clickOnParameters();
		driver.quit();
	}
}