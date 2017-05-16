package blueOcean;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterSDAndSearchBanPage {
	
	protected WebDriver driver;
	
	public EnterSDAndSearchBanPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(id = "IDToken1")
	protected WebElement habitatUsernameField;

	protected void enterHabitatUsername() {
		habitatUsernameField.sendKeys("Thivieda");
		}
	
	@FindBy(id = "IDToken2")
	protected WebElement habitatPasswordField;

	protected void enterHabitatPassword() {
		habitatPasswordField.sendKeys("Passw0rd");
		}
	
	@FindBy(css = "img[alt='enter / entrez']")
	protected WebElement enterButton;

	protected void clickEnterButton() {
		enterButton.click();
	}
	
	public void loginHabitat() {
		enterHabitatUsername();
		enterHabitatPassword();
		clickEnterButton();
	}
	
	@FindBy(xpath = "//select[@name='searchMethod']")
	protected WebElement searchTypeMethod;

	protected void selectSearchType()

	{
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(searchTypeMethod));
		new Select(searchTypeMethod).selectByVisibleText("Account Number");
	}
	
	
	@FindBy(xpath = "//input[@name='phoneNumberSearch_PhoneNumber']")
	protected WebElement phoneNumberField;

	protected void enterPhoneNumber() {
		phoneNumberField.sendKeys("");
	}

	
	@FindBy(xpath = "//input[@name='accountNumberSearch_AccountNumber']")
	protected WebElement accountNumberField;

	protected void enterAccountNumber() {
		accountNumberField.sendKeys("70759764");
	}
	
	
	@FindBy(linkText = "submit")
	protected WebElement submitButton;

	protected void clickOnSubmitButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(submitButton));
		submitButton.click();
	}
	
	public void enterSD() {
		selectSearchType();
		enterAccountNumber();
		clickOnSubmitButton();
	}
	
}
