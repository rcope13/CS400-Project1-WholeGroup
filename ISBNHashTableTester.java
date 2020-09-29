import java.util.NoSuchElementException;

// --== CS400 File Header Information ==--
// Name: Matthew Hillmer
// Email: mhillmer@wisc.edu, 
// Team: BB
// Role: Test Engineer
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: Test Engineer 
public class ISBNHashTableTester {
	/**
	 * Tester for ISBN hash table project for team BB project 1. Uses print
	 * statements to call boolean methods to check if the program works correctly.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Testing ISBN hash: ");
		System.out.println("-ISBNtest1: " + hashValueReturnTester());
		System.out.println("Testing Read CSV: ");
		System.out.println("-CSVinfoTester(): " + CSVinfoReturnTester());
		System.out.println("Testing hash table information: ");
		System.out.println("-valueReturnTester1: " + valueReturnTester());
		System.out.println("-valueReturnTester2: " + noSuchISBNTester());
		System.out.println("Testing Get/Remove functions: ");
		System.out.println("-removeISBNTester: " + removeISBNTester());
		System.out.println("-removeISBNTesterBlank: " + removeISBNTesterBlank());
		System.out.println("-createCourseReadingTester: " + createCourseReadingTester());
		System.out.println("-setISBNTester: " + setISBNTester());
		System.out.println("-setWrangleTester: " + setWrangleTester());
	}

	/**
	 * tests that the code properly hashes the ISBN number and stores the values
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean hashValueReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		Wrangle.setISBN("898989899"); // creates an ISBN
		Wrangle.setTitle("The Lorax");
		Wrangle.setCourse("Lit Trans 245");
		table.put(Wrangle.key(), Wrangle.value()); // adds key to table
		if (!table.get("898989899").getBookTitle().equals("The Lorax")) {// tests the program with if statement
			System.out.println("The prgoram should retrun (The Lorax) as the book title.");
			return false;
		}
		return true;

	}

	/**
	 * checks that the CSV file is imported with the correct data
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean CSVinfoReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		if (table.size() != 1628) {// checks that the size is correct
			System.out.println("The table should contain 1616 ISBNs and only contains " + table.size() + ".");
			return false;
		}
		if (!table.get("'0072467509'").getBookTitle()// checks that the title is correct
				.equalsIgnoreCase("Introduction to Computing Systems: from bits and gates to C and beyond")
				&& !table.get("'0130084514'").getBookTitle().equalsIgnoreCase("Linear Algebra")) {
			System.out.println(
					"The hashTable does not contain a ISBN with information for either 0072467509 or 0130084514.");
			return false;
		}
		return true;
	}

	/**
	 * checks that the program returns the correct information called with the ISBN
	 * key
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean valueReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		if (!table.get("'9780131103627'").getBookTitle().equalsIgnoreCase("The C Programming Language")// checks that
																										// all values
																										// return
																										// correctly
				&& !table.get("'9780131103627'").getCourse().equalsIgnoreCase("COMP SCI 537 Intro to Operating Systems")
				&& !table.get("'9780131103627'").getISBN().equalsIgnoreCase("'9780131103627'")) {
			System.out.println("The program does return the correct course info(Book, course, or ISBN)");// prints if
																											// false
			return false;
		}
		return true;

	}

	/**
	 * checks that the program returns with a statement saying that no class exists
	 * with that ISBN key
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean noSuchISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		try {
			table.get("0101010101");// tries to get ISBN
		} catch (NoSuchElementException e) {// spits out exception that it dosnt exist
			return true;
		}
		System.out.println("The program should have returned a NoSuchElementException");// prints if the ISBN returns
																						// when it shouldnt
		return false;

	}

	/**
	 * tests that the program remove an ISBN that has been hashed and is properly
	 * removed.
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean removeISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		table.remove("'0072467509'");// removes the ISBN
		try {
			table.get("'0072467509'");// trys to get the removed ISBN
		} catch (NoSuchElementException e) {
			return true;
		}
		System.out.println("The program did not remove the ISBN('0072467509') from the hashTable");// prints if false
		return false;
	}

	/**
	 * tests that the program does not remove a ISBN thats not in the hashTable.
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean removeISBNTesterBlank() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		if (table.remove("'123'") != null) {// tries to remove the ISBN that dosnt exist
			System.out.println("The program should not have removed the ISBN('123') from the hashTable");// prints if it
																											// removes
			return false;
		}
		return true;
	}

	/**
	 * tests that the program can create a courseReading and change its values and
	 * return it after being added to the table.
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean createCourseReadingTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		CourseReading temp = new CourseReading();// creates an object
		temp.setBookTitle("Always Sunny");// modifies the values
		temp.setCourse("LIT TRANS 111");// modifies the values
		temp.setISBN("'12345'");// modifies the values
		table.put("'12345'", temp);// modifies the values in the table
		if (!table.get("'12345'").getBookTitle().equalsIgnoreCase("Always Sunny")// tests the values were added
																					// correctly
				&& !table.get("'12345'").getCourse().equalsIgnoreCase("LIT TRANS 111")
				&& !table.get("'12345'").getISBN().equalsIgnoreCase("'12345'")) {
			System.out.println("The prgoram did not set/return the correct info from the courseReading");// prints if
																											// false
			return false;
		}
		return true;

	}

	/**
	 * tests that the program can add a new ISBN to the hashTable.
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean setISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");// creates hash table
		CourseReading temp = new CourseReading();// creates object
		temp.setBookTitle("Always Sunny");
		temp.setCourse("LIT TRANS 111");
		temp.setISBN("'12345'");
		table.put("'12345'", temp);
		try {
			table.get("'12345'");// tries to get ISBN
		} catch (NoSuchElementException e) {
			System.out.println("The System should have added and retried the ISBN(12345), but did not.");// prints if it
																											// throws an
																											// error
			return false;
		}
		return true;

	}

	/**
	 * tests that the program can create a new ISBN with wrangle.
	 * 
	 * @return true if it is correct and false otherwise
	 */
	public static boolean setWrangleTester() {
		Wrangle.setISBN("'12345'");// addes an ISBN in wrangler()
		if (!Wrangle.key().equals("'12345'")) {// tests that wrangler method worked
			System.out.println("The Wrangle class did not set a new ISBN properly");// prints if false
			return false;
		}
		return true;
	}
}

