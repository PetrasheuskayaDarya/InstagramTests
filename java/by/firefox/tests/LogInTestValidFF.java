package by.firefox.tests;

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

public class LogInTestValidFF {
	public static WebDriver driverFF;
	MyInstaPropertyManager conf = new MyInstaPropertyManager();
	

	@BeforeClass
	public static void SetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:/Program Files/Drivers/geckodriver.exe");
		driverFF = new FirefoxDriver();
		driverFF.manage().window().maximize();
		driverFF.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverFF.get("https://www.instagram.com/accounts/login/");
	}

	@Test
	public void LogInWithRightCreds() {

	}

	@AfterClass
	public static void StopDriver() {
		driverFF.quit();
	}

}
