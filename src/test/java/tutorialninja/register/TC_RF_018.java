package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_018 {
	@Test
	public void verifyRegisterAccountWithWidthAndHeightOfTextField() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		// Verify Firstname fields width and height
		String firstnamewidth = driver.findElement(By.xpath("//input[@id='input-firstname']")).getCssValue("width");
		String firstnameheight = driver.findElement(By.xpath("//input[@id='input-firstname']")).getCssValue("height");

		System.out.println(firstnamewidth); // 701.25px
		System.out.println(firstnameheight); // 34px

		// verify warninng messaga

		String expectedfstnamewarningmsg = "First Name must be between 1 and 32 characters!";
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualwarningmsg = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
				.getText();
		Assert.assertEquals(actualwarningmsg, expectedfstnamewarningmsg);

		WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstname.clear();
		firstname.sendKeys("DattatraySutarDattatraySutarDattaSutar");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());
		driver.quit();
	}
}
