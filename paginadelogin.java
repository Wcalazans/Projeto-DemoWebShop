package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paginadelogin {

	private static WebDriver driver = null;
	private WebElement emailInput;
	private WebElement passwordInput;
	private WebElement loginButton;
	private WebElement forgotPasswordLink;
	private WebElement registerLink;
	private WebElement logoutButton;

	public paginadelogin(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		emailInput = driver.findElement(By.id("Email"));
		return emailInput;

	}

	public WebElement getPasswordInput() {
		passwordInput = driver.findElement(By.id("Password"));
		return passwordInput;

	}

	public WebElement getLoginButton() {
		loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		return loginButton;

	}

	public WebElement getForgotPasswordLink() {
		forgotPasswordLink = driver.findElement(By.linkText("Forgot password?")); // Exemplo de localizador por link
																					// text
		return forgotPasswordLink;
	}

	public WebElement getRegisterLink() {
		registerLink = driver.findElement(By.linkText("Register")); // Exemplo de localizador por link text
		return registerLink;
	}

	public WebElement getLogoutButton() {
		logoutButton = driver.findElement(By.xpath("//a[@class='ico-logout']")); //
		return logoutButton;
	}

	public void clickLogoutButton() {
		getLogoutButton().click();
	}
}
