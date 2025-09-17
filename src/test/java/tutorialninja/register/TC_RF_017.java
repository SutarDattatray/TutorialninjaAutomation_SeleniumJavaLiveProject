package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.CommanUtility;

public class TC_RF_017 {

	WebDriver driver;

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider="passwordsupplier")
	public void verifyRegisterAccoutEnteringAndChekingPasswordComplexityStandard(String password) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		// Click on myaccount dropmenu
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		// click on register
		driver.findElement(By.linkText("Register")).click();

		// 1)fill mandatory field in register form
		driver.findElement(By.id("input-firstname")).sendKeys("Dattatray");
		driver.findElement(By.id("input-lastname")).sendKeys("Sutar");
		driver.findElement(By.id("input-email")).sendKeys(CommanUtility.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9145488096");
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedwarningmessage = "Password entered is not matching the Complexity standards";
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedwarningmessage);
		Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text='Success']")).isDisplayed());

	}

	@DataProvider(name="passwordsupplier")
	public Object[][] supplyPassworddata() {
        Object [][] data= {{"12345"},{"abcde"},{"abcde123"},{"ABCDE123"},{"abcde123@"}};
        return data;
	}
}
