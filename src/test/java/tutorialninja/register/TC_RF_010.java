package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {
	@Test
	public void verifyRegisterAccountWithInvalidEmail() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
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
		driver.findElement(By.id("input-email")).sendKeys("1223444");
		driver.findElement(By.id("input-telephone")).sendKeys("9145488096");
		driver.findElement(By.id("input-password")).sendKeys("Sutar@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Sutar@123");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(5000);

		File srcfile1 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(srcfile1, new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));

		// used for compare two screenshots
		BufferedImage ActualBImage = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));

		BufferedImage ExpectedBImage = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Expected.png"));

		ImageDiffer imgdiffer = new ImageDiffer();
		ImageDiff imgDifference = imgdiffer.makeDiff(ExpectedBImage, ActualBImage);
		Assert.assertFalse(imgDifference.hasDiff());

		driver.quit();
	}

}
