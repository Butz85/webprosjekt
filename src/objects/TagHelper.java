package objects;

import java.util.Calendar;

/**
 * @author Magnus Brimsholm
 * @author Yen Nguyen
 * 
 * Methods to help servlets prepare tags for the webapplications view.
 */

public class TagHelper {

	/**
	 * @param text
	 * @param numbChars
	 * @return shortText
	 * 
	 * Method for shortening a given string 
	 * to a length of a given amount of chars 
	 */
	public String shortTextTag(String text, int numbChars){
		String shortText = text.substring(0,numbChars);
		return shortText;
	}
	
	/**
	 * @param since
	 * @return
	 * 
	 * Method that changes the copyright tag year numbers into roman numerals
	 */
	public String createTag(int since) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String romanSince = romanNumerals(since);
		String romanCurrent = romanNumerals(currentYear);
		String copyrightTag = romanSince + "-" + romanCurrent;
		return copyrightTag;
	}
	
	
	/**
	 * @param year
	 * @return
	 * Method that returns a given year int-value into roman numerals.
	 */
	public String romanNumerals(int year) {
		String romanNumber = "";

		while (year >= 1000) {
			romanNumber += "M";
			year -= 1000;
		}
		if (year >= 900) {
			romanNumber += "CM";
			year -= 900;
		}
		if (year >= 500) {
			romanNumber += "D";
			year -= 500;
		}
		if (year >= 400) {
			romanNumber += "CD";
			year -= 400;
		}
		if (year >= 100) {
			romanNumber += "C";
			year -= 100;
		}
		if (year >= 90) {
			romanNumber += "XC";
			year -= 90;
		}
		if (year >= 50) {
			romanNumber += "L";
			year -= 50;
		}
		if (year >= 40) {
			romanNumber += "XL";
			year -= 40;
		}
		if (year >= 10) {
			romanNumber += "X";
			year -= 10;
		}
		if (year >= 9) {
			romanNumber += "IX";
			year -= 9;
		}
		if (year >= 5) {
			romanNumber += "V";
			year -= 5;
		}
		if (year >= 4) {
			romanNumber += "IV";
			year -= 4;
		}
		while (year >= 1) {
			romanNumber += "I";
			year -= 1;
		}
		return romanNumber;
	}

}
