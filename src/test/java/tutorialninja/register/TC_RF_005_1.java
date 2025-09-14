package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005_1 {

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
		//driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
		
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
