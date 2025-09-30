package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utilities.CommanUtility;

public class TC_RF_019 {
	WebDriver driver;

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLeadingAndTrailingEnterigRegisterAccout() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		// Click on myaccount dropmenu
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		// click on register
		driver.findElement(By.linkText("Register")).click();

		// 1)fill mandatory field in register form
		String firstname = "      Dattatray    ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		String lastname = "      Sutar       ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		String email = "      " + CommanUtility.generateNewEmail() + "     ";
		driver.findElement(By.id("input-email")).sendKeys(email);
		String telephone = "      9145488096     ";
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);

		driver.findElement(By.id("input-password")).sendKeys("Sutar@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Sutar@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();

		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), firstname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), lastname.trim());
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), email.trim());
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), telephone.trim());

	}

}
