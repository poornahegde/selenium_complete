package test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextMatching {

	@Test
	public void testMAtch() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();
		action.moveToElement(driver.findElement(By.partialLinkText("Our Offices"))).perform();
		action.click(driver.findElement(By.partialLinkText("Bangalore"))).perform();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Set<String> windows = driver.getWindowHandles();
		Object[] objects = windows.toArray();
		driver.switchTo().window(objects[1].toString());
		driver.switchTo().frame("main_page");
		WebElement textAddress = driver.findElement(By.id("demo3"));
		String address = textAddress.getText();
		System.out.println(address);
		Assert.assertTrue(address.contains("Bangalore"));
		driver.quit();
	}
	
}
