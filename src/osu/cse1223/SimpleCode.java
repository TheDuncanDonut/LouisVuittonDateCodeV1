/*
 * Project08.java
 * 
 *   A program that reads Louis Vuitton Date codes
 *   1980 and on. 
 * 
 * @author Laura Duncan
 * @version 20161022
 * 
 */

package osu.cse1223;

import java.util.Scanner;

public class SimpleCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean run = true;
		while (run) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter your bag's datecode: ");
			String dateCode = keyboard.nextLine();
			dateCode = dateCode.toUpperCase();
			if (dateCode.length() == 0) { run = false; }
			else if (dateCode.length() < 3 || dateCode.length() > 6) {
				System.out.println("Date code is not recognized as authentic.");
			}
			else { ReadCode(dateCode); }
		}
		
	}
	
	private static void ReadCode(String dateCode) { 
		int length = dateCode.length();
		char firstChar = dateCode.charAt(0);
		String month = "";
		String week = "";
		String year = "";
		String location = "";
		if (length == 3 || length == 4) { //manufactured early 1980s
			if (length == 3) {
				month = dateCode.substring(2,3);
				year = dateCode.substring(0,2);
				location = "XX";
			}
			else if (length == 4) {
				month = dateCode.substring(2,4);
				year = dateCode.substring(0,2);
				location = "XX";
			}
		}

		else if (firstChar == 'A' || firstChar == 'B' || firstChar == 'C' || firstChar == 'D' || firstChar == 'E' || firstChar == 'F' || firstChar == 'G' || 
				firstChar == 'H' || firstChar == 'I' || firstChar == 'J' || firstChar == 'K' || firstChar == 'L' || firstChar == 'M' || firstChar == 'N' || 
				firstChar == 'O' || firstChar == 'P' || firstChar == 'Q' || firstChar == 'R' || firstChar == 'S' || firstChar == 'T' || firstChar == 'U' || 
				firstChar == 'V' || firstChar == 'W' || firstChar == 'X' || firstChar == 'Y' || firstChar == 'Z') { //manufactured 1990 - present
			location = dateCode.substring(0,2);
			String testingOne = dateCode.substring(2,3) + dateCode.substring(4,5);
			String testingTwo = dateCode.substring(3,4) + dateCode.substring(5,6);
			int testingOneInt = Integer.parseInt(testingOne);
			int testingTwoInt = Integer.parseInt(testingTwo);

			if (testingTwoInt >= 90) { //manufactured 1990-2000
				month = testingOne;
				year = testingTwo;
			}
			else if (testingTwoInt <= 06) { //manufactured 2000-2006
				month = testingOne;
				year = testingTwo;
			}
			else if (testingTwoInt >= 07 && testingTwoInt <=16) {//manufactured 2007-2016
				week = testingOne;
				year = testingTwo;
			}
			else if (testingOneInt <= 12 && testingTwoInt <= 12) {
				System.out.print("Ambiguous date entry.");
			}
			else { 
				System.out.println("Date code is not recognized as authentic."); 
				System.exit(0);
			}
		}
		else { //manufactured early to late 1980s
			if (length == 5) {
				month = dateCode.substring(2,3);
				year = dateCode.substring(0,2);
				location = dateCode.substring(3,5);
			}
			else if (length == 6) {
				month = dateCode.substring(2,4);
				year = dateCode.substring(0,2);
				location = dateCode.substring(4,6);
			}
		}
		
		//assign details for print
		if (month != "") {
			int monthInt = Integer.parseInt(month);
			if (monthInt == 1) { month = "January"; }
			else if (monthInt == 2) { month = "February"; }
			else if (monthInt == 3) { month = "March"; }
			else if (monthInt == 4) { month = "April"; }
			else if (monthInt == 5) { month = "May"; }
			else if (monthInt == 6) { month = "June"; }
			else if (monthInt == 7) { month = "July"; }
			else if (monthInt == 8) { month = "August"; }
			else if (monthInt == 9) { month = "September"; }
			else if (monthInt == 10) { month = "October"; }
			else if (monthInt == 11) { month = "November"; }
			else if (monthInt == 12) { month = "December"; }
			else {
				System.out.println("Date code is not recognized as authentic.");
			}
		}
		int yearInt = Integer.parseInt(year);
			if (yearInt > 80) {
				year = "19" + year;
			}
			else if (yearInt < 17) {
				year = "20" + year;
			}
			else {
				System.out.println("Date code is not recognized as authentic.");
			}

		//assign location
		if (location.equals("AO") || location.equals("A1") || location.equals("A2") || location.equals("AA") || location.equals("AH") || location.equals("AN") || location.equals("AR") || location.equals("AS") || location.equals("BA")
				|| location.equals("BJ") || location.equals("BU") || location.equals("DR") || location.equals("DT") || location.equals("CO") || location.equals("CT") || location.equals("CX") || location.equals("ET")
				|| location.equals("FL") || location.equals("LW") || location.equals("MB") || location.equals("MI") || location.equals("NO") || location.equals("RA") || location.equals("RI") || location.equals("SD")
				|| location.equals("SF") || location.equals("SL") || location.equals("SN") || location.equals("SP") || location.equals("SR") || location.equals("TJ") || location.equals("TH") || location.equals("TR")
				|| location.equals("TS") || location.equals("VI") || location.equals("VX")) {
			location = "France";
		}
		else if ( location.equals("LP") || location.equals("OL")) {
			location = "Germany";
		}
		else if (location.equals("BC") || location.equals("BO") || location.equals("CE") || location.equals("FO") || location.equals("MA") || location.equals("OB") || location.equals("PL") || location.equals("RC")
				|| location.equals("RE") || location.equals("SA") || location.equals("TD") ) {
			location = "Italy";
		}
		else if (location.equals("BC") || location.equals("CA") || location.equals("LO") || location.equals("LB") || location.equals("LM") || location.equals("LW") || location.equals("GI") ) {
			location = "Spain";
		}
		else if ( location.equals("DI") || location.equals("FA")) {
			location = "Switzerland";
		}
		else if (location.equals("FC") || location.equals("FH") || location.equals("LA") || location.equals("OS") || location.equals("SD") || location.equals("FL") ) {
			location = "USA";
		}
		else if (location.equals("XX") ) {
			location = "a location not able to be determined";
		}
		
		
		//print information
		
		if (week != "") {
			System.out.println("Your date code indicates a manufacture date of Week " + week + " of " + year + " in " + location +".");
		}
		else {
			System.out.println("Your date code indicates a manufacture date of " + month + ", " + year + " in " + location +".");
		}
	}	
	}
