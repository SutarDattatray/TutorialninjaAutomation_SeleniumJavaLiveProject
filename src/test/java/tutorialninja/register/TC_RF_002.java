package tutorialninja.register;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jakarta.mail.BodyPart;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.search.FlagTerm;

public class TC_RF_002 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//click on sign in 
		driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
		 //click on Need Help
	    driver.findElement(By.xpath("//div[contains@text()='Need Help?']")).click();
		//click on forgot password
		driver.findElement(By.xpath("auth-fpp-link-button")).click();
		//verify email address
		driver.findElement(By.id("ap_email")).sendKeys("sutardattatray123@gmail.com");
		//clcik on continue
		driver.findElement(By.id("continue")).click();
		
		
		// Replace with your Gmail credentials
        String host = "imap.gmail.com";
        String mailStoreType="imap";
        String port="993";
        String username = "sutardattatray123@gamil.com";
        String appPassword = "gosd duiq gjoe bhqu"; // Generated from Google

        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", host);
        properties.put("mail.imaps.port", "993");
        properties.put("mail.imaps.ssl.enable", "true");

        try {
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect(host, username, appPassword);

            // Open the INBOX folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Fetch unseen messages
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            System.out.println("Found " + messages.length + " unread messages.");

             for (Message message : messages) {
                System.out.println("====================================");
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0].toString());
                System.out.println("Body: " + getTextFromMessage(message));
                break;
            }
        
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to extract plain text from message body
    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
       
    	if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
            
        } else if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart part = multipart.getBodyPart(i);
                if (part.isMimeType("text/plain")) {
                    return part.getContent().toString();
                }
            }
        }
        return "";
    }
}


