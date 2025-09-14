package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

	@Test
	public void verifyRegisterAccountWithoutFillFileds() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		// Click on my account drop menu
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		// click on register
		driver.findElement(By.linkText("Register")).click();

		// without filling any fields
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		//Expected Warning text
		String StringexpectedFirstname = "First Name must be between 1 and 32 characters!";
		String StringexpectedLastname = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephone = "Telephone must be between 3 and 32 characters!";
		String expectedPassword = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";

		//Validate the warning text
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),
				StringexpectedFirstname);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
				StringexpectedLastname);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
				expectedEmailWarning);

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephone);

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPassword);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				expectedPrivacyPolicyWarningMessage);
		
		driver.quit();



	}

}
