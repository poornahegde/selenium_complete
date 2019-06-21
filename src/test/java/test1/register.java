package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class register {
	@Test
	public void registerPage() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com");
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.getTitle().contains("Register"));
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Poorna");
		driver.findElement(By.id("LastName")).sendKeys("Hegde");
		driver.findElement(By.id("Email")).sendKeys("poorna1a@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("poorna11");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("poorna11");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.cssSelector("input[value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();
	}
}
