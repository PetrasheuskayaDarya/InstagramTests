package by.htp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebDriver driver;

	@FindBy(xpath = "//button[text()='Not Now']")
	private WebElement NotNowNotifications;

	@FindBy(xpath = "//button[text()='Log Out']")
	private WebElement logOutButton;

	@FindBy(xpath = "//*[@id=\'react-root\']/div/div[2]/a[2]")
	private WebElement LinkNotNow;

	@FindBy(className = "coreSpriteDesktopNavProfile")
	private WebElement profileUser;

	@FindBy(className = "dCJp8")
	private WebElement parameters;

	public void clickOnParameters() {
		parameters.click();
	}

	public void clickNotNowNotifications() {
		NotNowNotifications.click();
	}

	public void clickOnLogOutButton() {
		logOutButton.click();
	}

	public void clickNotNowLink() {
		LinkNotNow.click();
	}

	public String getTextNotNowNotification() {
		String profile = NotNowNotifications.getText();
		return profile;
	}

	public void clickOnProfileUser() {
		profileUser.click();
	}

	public void waitElementPresent() {
		WebElement dinamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Not Now']")));
	}


}