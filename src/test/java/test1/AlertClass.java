package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertClass {

	@Test
	public void alertTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(ExpectedConditions.alertIsPresent() != null) {			
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			System.out.println(alertMessage);
			Assert.assertEquals(alertMessage, "Please enter some product name");
			alert.accept();
		}
	}
}
