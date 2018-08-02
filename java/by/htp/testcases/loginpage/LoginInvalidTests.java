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
import by.htp.util.MyInstaPropertyManager;

public class LoginInvalidTests extends BaseTestCase {

	@Test
	public void LogInWithoutInputLoginAndPass() {
		loginPage.login("", "");
		String loginButtonDisabled = loginPage.getLoginButton().getAttribute("disabled");
		Assert.assertEquals("true", loginButtonDisabled);
	
	}

	@Test
	public void LogInWithoutLogin() {
		loginPage.loginInvalid("123", conf.getPass());
		String alertMessage = loginPage.getAlertMessage();
		Assert.assertEquals(alertIncorrectPass, alertMessage);

	}

//	@Test
//	public void LogInWithoutPassword() {
//		loginPage.loginInvalid(conf.getLogin(), "");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithWrongPassword() {
//		loginPage.loginInvalid(conf.getLogin(), "123");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithWrongLogin() {
//		loginPage.loginInvalid("123", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithWrongLoginAndPassword() {
//		loginPage.loginInvalid("123", "123");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInRightLoginInPasswordFieldAndPasswordInLoginField() {
//		loginPage.loginInvalid(conf.getPass(), conf.getLogin());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithScriptInLoginField() {
//		loginPage.loginInvalid("<script>alert(123)</script>", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithSQLInLoginField() {
//		loginPage.loginInvalid("SELECT * FROM blog WHERE code LIKE Ã¢â‚¬Ëœa%Ã¢â‚¬â„¢", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithTagInLoginField() {
//		loginPage.loginInvalid("<form action=Ã‚Â»http://live.hh.ruÃ‚Â»><inputtype=Ã‚Â»submitÃ‚Â»></form>",
//				conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithSpesialSimbolsInLoginField() {
//		loginPage.loginInvalid("Â«â™£ Â» , Â«Â»â€˜~!@#$%^&*()?>,./\\<][ /*<!â€”Â«Â»,Â«${code}Â»;â€”>", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LogInWithSpaceInLoginField() {
//		loginPage.loginInvalid(" ", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LogInSpaceBeforeCorrectLoginAndCorrectPassword() {
//		loginPage.loginInvalid(" daryaaa756", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//	}
//
//	@Test
//	public void CorrectLoginAndSpaceAfterCorrectPass() {
//		loginPage.loginInvalid(conf.getLogin(), "12345qwert ");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//
//	}
//
//	@Test
//	public void LogInCorrectLoginAndPassUsingDifferentCases() {
//		loginPage.loginInvalid("daryaaa756", "12345Qwert");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertIncorrectPass, alertMessage);
//	}
//
//	@Test
//	public void LongLoginAndPass() {
//		loginPage.loginInvalid("qqweqweqweqweqweqweqweqweqweqweqweqweqweqwe",
//				"qqweqweqweqweqweqweqweqweqweqweqweqweqweqwe");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//
//	}
//
//	@Test
//	public void LoginSurroundedTagsAndValidPass() {
//		loginPage.loginInvalid("<daryaaa756>", conf.getPass());
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//	}
//
//	@Test
//	public void LoginUsingDifferentSimbols() {
//		loginPage.loginInvalid("Aa!@#$%^&*()-_+=`~/\\,.?><|b", "/PaSSword!@#$%^&*()-_+=`~/\\,.?><|");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//	}
//
//	@Test
//	public void LoginUsingCyrillic() {
//		loginPage.loginInvalid("Иван", "Болван");
//		String alertMessage = loginPage.getAlertMessage();
//		Assert.assertEquals(alertWrongUser, alertMessage);
//	}

	@Test
	public void LogInUsingKeyboard() {
		loginPage.inputLogin(conf.getLogin());
		loginPage.pushTabButton();
		loginPage.inputPassword(conf.getPass());
		loginPage.pushTabButton();
		loginPage.pushEnterButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainPage.clickNotNowLink();
		mainPage.waitElementPresent();
		String NotNow = mainPage.getTextNotNowNotification();
		Assert.assertEquals("Not Now", NotNow);
		mainPage.clickNotNowNotifications();
		mainPage.clickOnProfileUser();
		mainPage.clickOnParameters();
		mainPage.clickOnLogOutButton();
		loginPage.clickLoginLink();
	}


}
