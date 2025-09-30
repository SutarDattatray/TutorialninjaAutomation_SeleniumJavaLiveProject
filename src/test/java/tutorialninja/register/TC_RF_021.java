package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommanUtility;

public class TC_RF_021 {

	@Test
	public void verifyRegisterAccountWithoutPrivacyPolicySelection() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Dattatray");
		driver.findElement(By.id("input-lastname")).sendKeys("Sutar");
		driver.findElement(By.id("input-email")).sendKeys(CommanUtility.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9145488096");
		driver.findElement(By.id("input-password")).sendKeys("Sutar@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Sutar@123");
		// driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedwaringmessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				expectedwaringmessage);

		driver.quit();
	}

}
