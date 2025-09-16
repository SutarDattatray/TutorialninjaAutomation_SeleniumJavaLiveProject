package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_014 {
	@Test
	public void verifymandatoryFieldsSymbolAndColorInRegisterAccountPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedFNContent="\"* \"";
		String expectedFNColor="rgb(255, 0, 0)";
		String expectedFNFontweight="700";
		
		//Verify mandatory 
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		String fncontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameLabel);
        System.out.println(fncontent);
        
        String fncolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNameLabel);
        System.out.println(fncolor);
        
        String fontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", firstNameLabel);
        System.out.println(fontweight);
        
       Assert.assertEquals(fncontent, expectedFNContent);
        Assert.assertEquals(fncolor, expectedFNColor);
        Assert.assertEquals(fontweight, expectedFNFontweight);
		
        //Verify mandatory last name label 
        WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
        String lncontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", lastNameLabel);
        System.out.println(lncontent);
        
        String lncolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", lastNameLabel);
        System.out.println(lncolor);
        
        String lnfontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", lastNameLabel);
        System.out.println(lnfontweight);
        
        Assert.assertEquals(lncontent, expectedFNContent);
        Assert.assertEquals(lncolor, expectedFNColor);
        Assert.assertEquals(lnfontweight, expectedFNFontweight);
        
        //verify mandatory e-mail
        WebElement EmailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
        String Emcontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", EmailLabel);
        System.out.println(Emcontent);
        
        String Emcolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", EmailLabel);
        System.out.println(Emcolor);
        
        String Emfontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", EmailLabel);
        System.out.println(Emfontweight);
        
        Assert.assertEquals(Emcontent, expectedFNContent);
        Assert.assertEquals(Emcolor, expectedFNColor);
        Assert.assertEquals(Emfontweight, expectedFNFontweight);
        
        //verify mandatory telephone label
        WebElement TelephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
        
        String TPcontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", TelephoneLabel);
        System.out.println(Emcontent);
        
        String TPcolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", TelephoneLabel);
        System.out.println(Emcolor);
        
        String TPfontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", TelephoneLabel);
        System.out.println(Emfontweight);
        
        Assert.assertEquals(TPcontent, expectedFNContent);
        Assert.assertEquals(TPcolor, expectedFNColor);
        Assert.assertEquals(TPfontweight, expectedFNFontweight);
        
      //Verify mandatory password label 
        WebElement PasswordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
        String PWcontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", PasswordLabel);
        System.out.println(Emcontent);
        
        String PWcolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", PasswordLabel);
        System.out.println(Emcolor);
        
        String PWfontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", PasswordLabel);
        System.out.println(Emfontweight);
        
        Assert.assertEquals(PWcontent, expectedFNContent);
        Assert.assertEquals(PWcolor, expectedFNColor);
        Assert.assertEquals(PWfontweight, expectedFNFontweight);
        
      //Verify mandatory password confirm label 
        WebElement PasswordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
        String PWCcontent = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", PasswordConfirmLabel);
        System.out.println(Emcontent);
        
        String PWCcolor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", PasswordConfirmLabel);
        System.out.println(Emcolor);
        
        String PWCfontweight = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('font-weight');", PasswordConfirmLabel);
        System.out.println(Emfontweight);
        
        Assert.assertEquals(PWCcontent, expectedFNContent);
        Assert.assertEquals(PWCcolor, expectedFNColor);
        Assert.assertEquals(PWCfontweight, expectedFNFontweight);
        
        driver.quit();
	}

}
