package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.paginadelogin;

public class LoginTests {

	WebDriver driver;
	paginadelogin loginPage;

	@BeforeEach
	void inicializarNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/login");
		loginPage = new paginadelogin(driver);
	}

	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	void testLoginComSucesso() {
		loginPage.getEmail().sendKeys("w_calazans@hotmail.com");
		loginPage.getPasswordInput().sendKeys("Gs91722*");
		loginPage.getLoginButton().click();

		try {
			Thread.sleep(3000); // Espera por 3 segundos (3000 milissegundos)
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	@Test
	void testLoginComEmailInvalido() {
		loginPage.getEmail().sendKeys("w_calazanshotmail.com");
		loginPage.getPasswordInput().sendKeys("Gs91722*");
		loginPage.getLoginButton().click();

		try {
			Thread.sleep(3000); // Espera por 3 segundos (3000 milissegundos)
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	@Test
	void testLogout() {
		loginPage.getEmail().sendKeys("w_calazans@hotmail.com");
		loginPage.getPasswordInput().sendKeys("Gs91722*");
		loginPage.getLoginButton().click();
		loginPage.getLogoutButton();

		try {
			Thread.sleep(10000); // Espera por 3 segundos (3000 milissegundos)
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		loginPage.clickLogoutButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		Assertions.assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/"),
				"O logout não redirecionou para a página de login.");
	}
}
