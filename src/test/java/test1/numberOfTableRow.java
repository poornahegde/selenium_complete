package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class numberOfTableRow {

	@Test
	public void numberOfRows() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("lalitha");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		driver.findElement(By.linkText("OrderDetails")).click();
		WebElement table = driver.findElement(By.xpath("//table[class='table']/tbody"));
//		WebElement table = driver.findElement(By.className("table"));
		List<WebElement> cell = table.findElements(By.tagName("tr"));
		Assert.assertEquals(cell.size(), 9);
//		driver.navigate().to("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
//		driver.findElement(By.id("ul#menu3 li:nth-child(4)")).click();
		
	}
}
