package utilities;

import java.util.Date;

public class CommanUtility {

	public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
		/*Date date = new Date();
		String dateString = date.toString();
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceAndNoColonDateString = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceAndNoColonDateString+"@gmail.com";
		return emailWithTimeStamp; */
	}
}
