package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommanUtility;

public class TC_RF_012 {
	@Test
	public void verifyRegisterAccountUsingTabKey() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		// Click on myaccount dropmenu
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		// click on register
		driver.findElement(By.linkText("Register")).click();

		Actions action = new Actions(driver);
		for (int i = 1; i <= 23; i++) {
			action.sendKeys(Keys.TAB).perform();
		}

		action.sendKeys("Dattatray").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("Sutar").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(CommanUtility.generateNewEmail()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("1234567890").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("Sutar@123").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("Sutar@123").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();

		// verify or validate logout is displayed or not
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		driver.quit();
	}
}
