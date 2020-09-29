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
	 * @return
	 */
	public static boolean hashValueReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		Wrangle.setISBN("898989899"); // in final product, the param would come from user input
		Wrangle.setTitle("The Lorax"); // *see above comment*
		Wrangle.setCourse("Lit Trans 245"); // *see above comment*
		table.put(Wrangle.key(), Wrangle.value()); // use staic methods to get the key and value passed
		if (!table.get("898989899").getBookTitle().equals("The Lorax")) {
			System.out.println("The prgoram should retrun (The Lorax) as the book title.");
			return false;
		}
		return true;

	}

	/**
	 * checks that the CSV file is imported with the correct data
	 * 
	 * @return
	 */
	public static boolean CSVinfoReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		if (table.size() != 1628) {
			System.out.println("The table should contain 1616 ISBNs and only contains " + table.size() + ".");
			return false;
		}
		if (!table.get("'0072467509'").getBookTitle()
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
	 * @return
	 */
	public static boolean valueReturnTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		if (!table.get("'9780131103627'").getBookTitle().equalsIgnoreCase("The C Programming Language")
				&& !table.get("'9780131103627'").getCourse().equalsIgnoreCase("COMP SCI 537 Intro to Operating Systems")
				&& !table.get("'9780131103627'").getISBN().equalsIgnoreCase("'9780131103627'")) {
			System.out.println("The program does return the correct course info(Book, course, or ISBN)");
			return false;
		}
		return true;

	}

	/**
	 * checks that the program returns with a statement saying that no class exists
	 * with that ISBN key
	 * 
	 * @return
	 */
	public static boolean noSuchISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		try {
			table.get("0101010101");
		} catch (NoSuchElementException e) {
			return true;
		}
		System.out.println("The program should have returned a NoSuchElementException");
		return false;

	}

	/**
	 * tests that the program remove an ISBN that has been hashed and is properly
	 * removed.
	 * 
	 * @return
	 */
	public static boolean removeISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		table.remove("'0072467509'");
		try {
			table.get("'0072467509'");
		} catch (NoSuchElementException e) {
			return true;
		}
		System.out.println("The program did not remove the ISBN('0072467509') from the hashTable");
		return false;
	}

	/**
	 * tests that the program does not remove a ISBN thats not in the hashTable.
	 * 
	 * @return
	 */
	public static boolean removeISBNTesterBlank() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		if (table.remove("'123'") != null) {
			System.out.println("The program should not have removed the ISBN('123') from the hashTable");
			return false;
		}
		return true;
	}

	/**
	 * tests that the program can create a courseReading and change its values and return it after being added to the table.
	 * 
	 * @return
	 */
	public static boolean createCourseReadingTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		CourseReading temp = new CourseReading();
		temp.setBookTitle("Always Sunny");
		temp.setCourse("LIT TRANS 111");
		temp.setISBN("'12345'");
		table.put("'12345'", temp);
		if (!table.get("'12345'").getBookTitle().equalsIgnoreCase("Always Sunny")
				&& !table.get("'12345'").getCourse().equalsIgnoreCase("LIT TRANS 111")
				&& !table.get("'12345'").getISBN().equalsIgnoreCase("'12345'")) {
			System.out.println("The prgoram did not set/return the correct info from the courseReading");
			return false;
		}
		return true;

	}

	/**
	 * tests that the program can add a new ISBN to the hashTable.
	 * 
	 * @return
	 */
	public static boolean setISBNTester() {
		HashTableMap<String, CourseReading> table = Wrangle.readCSV("src/textbook_file.csv");
		CourseReading temp = new CourseReading();
		temp.setBookTitle("Always Sunny");
		temp.setCourse("LIT TRANS 111");
		temp.setISBN("'12345'");
		table.put("'12345'", temp);
		try {
			table.get("'12345'");
		} catch (NoSuchElementException e) {
			System.out.println("The System should have added and retried the ISBN(12345), but did not.");
			return false;
		}
		return true;

	}
	/**
	 * tests that the program can create a new ISBN with wrangle.
	 * 
	 * @return
	 */
	public static boolean setWrangleTester() {
        Wrangle.setISBN("'12345'");
        if(!Wrangle.key().equals("'12345'")) {
        	System.out.println("The Wrangle class did not set a new ISBN properly");
            return false;
        }
        return true;
    }
}
