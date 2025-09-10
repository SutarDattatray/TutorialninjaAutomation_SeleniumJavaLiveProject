package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		Date date = new Date();
		//System.out.println(date); //show current day,date & time-->Wed Sep 10 11:16:58 IST 2025
		String dateString = date.toString();
		//String noSpaceDateString = dateString.replaceAll(" ", "");
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceAndNoColonDateString = noSpaceDateString.replaceAll("\\:", "");
		//System.out.println(noSpaceDateString); //WedSep1011:22:26IST2025 date without space
		//System.out.println(noSpaceAndNoColonDateString); //WedSep10112757IST2025
		String emailWithTimeStamp = noSpaceAndNoColonDateString+"@gmail.com";
		System.out.println(emailWithTimeStamp); //WedSep10113109IST2025@gmail.com
	}

}
