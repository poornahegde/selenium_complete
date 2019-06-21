package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Program to count the number of links in the google page, particular to 1 div
 */

public class GoogleLangLink {
	@Test
	public void testGoogleLinks() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		
		WebElement div = driver.findElement(By.id("SIvCob"));
		List<WebElement> linkNo = div.findElements(By.tagName("a"));
		Assert.assertEquals(linkNo.size(), 9);
	}
}
