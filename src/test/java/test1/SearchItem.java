package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItem {

	@Test
	public void dragNdrop() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		WebElement search = driver.findElement(By.id("myInput"));    
		Actions action = new Actions(driver);
		action.keyDown(search, Keys.SHIFT);
		action.sendKeys("b").keyUp(Keys.SHIFT).pause(300).sendKeys("a").pause(300).sendKeys("g").perform();
		action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		Assert.assertEquals(driver.getTitle(), "Search");
	}
}
