package by.htp.testcases.loginpage;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.pages.LoginPage;
import by.htp.pages.MainPage;
import by.htp.util.Alerts;
import by.htp.util.MyInstaPropertyManager;

public class BaseTestCase extends Alerts {

	public static WebDriver driver;
	public static LoginPage loginPage;
	public static MainPage mainPage;
	public static MyInstaPropertyManager conf = new MyInstaPropertyManager();
	

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

	@Before
	public void OpenPage() {
		// driver.navigate().refresh();
		driver.get("https://www.instagram.com/accounts/login/");
	}

	@AfterClass
	public static void LogOut() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
}


