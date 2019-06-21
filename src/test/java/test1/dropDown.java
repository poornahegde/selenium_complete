package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropDown {

	@Test
	public void selectCreditCard() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
		act.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']"))).perform();
		Assert.assertTrue(driver.getTitle().contains("Credit Cards"));
	}
}
