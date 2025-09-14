package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {

	@Test
	public void verifyRegisterAccountBySelecting_No_option() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		//Click on myaccount dropmenu
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		//click on register
		driver.findElement(By.linkText("Register")).click();
		
		//1)fill mandatory field in register form
		driver.findElement(By.id("input-firstname")).sendKeys("Dattatray");
		driver.findElement(By.id("input-lastname")).sendKeys("Sutar");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("9145488096");
		driver.findElement(By.id("input-password")).sendKeys("Sutar@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Sutar@123");
		driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//verify or validate logout is displayed or not
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		//Verify text present or not
		String actualString ="Your Account Has Been Created!";
		String expectedString = driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText();
		Assert.assertEquals(actualString,expectedString);
		
		String actualproperdetailone="Congratulations! Your new account has been successfully created!";
        String actaulproperdetailtwo ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String actaulproperdetailthree ="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String actualproperdetailfour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us."
		;
		String expectedproperdetails=driver.findElement(By.id("content")).getText();
		Assert.assertTrue(expectedproperdetails.contains(actualproperdetailone));
		Assert.assertTrue(expectedproperdetails.contains(actaulproperdetailtwo));
		Assert.assertTrue(expectedproperdetails.contains(actaulproperdetailthree));
		Assert.assertTrue(expectedproperdetails.contains(actualproperdetailfour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}

	@Test
	public String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
		/*Date date = new Date();
		String dateString = date.toString();
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceAndNoColonDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceAndNoColonDateString+"@gmail.com";
		return emailWithTimeStamp; */
	}

	}

