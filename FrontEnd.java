
// --== CS400 File Header Information ==--
// Name: Ryan Cope
// Email: rlcope@wisc.edu
// Team: BB
// Role: Front End Developer
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.Scanner;

/**
 * This class serves the purpose of acting as the interface that the user has
 * access to for our program.
 * 
 * @author rlcope
 *
 */
public class FrontEnd {
	public static String command = null; // the string that the input command is stored as
	public static Scanner scnr = new Scanner(System.in); // takes input from the user
	public static String prompt = "Please input a command. To see the commands, type c.";
	public static CourseReadingBackEnd2 backEndData = null; // the object that contains the hashtable and backend
															// commands

	/**
	 * This method initializes an instance of backEndData with either a new, empty
	 * hashtable, or a hashtable populated with values from a CSV.
	 */
	public static void initializeDatabase() {
		System.out.println("Now running Check Your Texts. Would you like create a new database or import a database?"
				+ " To create a new database, input n, and to import a database, input i.");
		command = scnr.nextLine().toLowerCase().trim();
		boolean pickedDatabase = false;

		// makes sure that backEndData is initialized with something that isn't null
		while (pickedDatabase == false) {

			// allows user to specify location of csv file to scan and import into
			// backEndData
			if (command.equals("i")) {
				System.out.println("Please input the file path of the csv file you would like to scan for data.");
				String filePath = scnr.nextLine().trim();
				backEndData = new CourseReadingBackEnd2(filePath);
				if (backEndData != null) {
					pickedDatabase = true;
				}
				if (backEndData == null) {
					System.out.println("Invalid file path. Please start over.");
				}
			}

			// initializes backEndData with an empty hashtable
			if (command.equals("n")) {
				backEndData = new CourseReadingBackEnd2();
				if (backEndData != null) {
					pickedDatabase = true;
				}
			}

			// user input an invalid command
			if ((!command.equals("n")) && (!command.equals("i"))) {
				System.out.println("Please input a valid command.");
				command = scnr.nextLine().toLowerCase().trim();
			}
		}
		System.out.println("Your database has been initialized.");
	}

	/**
	 * This method acts as the direct way that the user interacts with the program,
	 * allowing them to invoke commands on backEndData object they created.
	 */
	public static void runProgram() {
		boolean quit = false;
		while (quit == false) {
			System.out.println("\n" + prompt);
			command = scnr.nextLine().toLowerCase().trim();

			// outputs information corresponding to the "c" command
			if (command.equals("c")) {
				System.out.println("List of Commands:");
				System.out.println("g = get list of courses from ISBN");
				System.out.println("p = put or add a course to the specified ISBN ");
				System.out.println("r = check through a list of courses until the course to remove has been found");
				System.out.println("q = quit");
			}

			// outputs information corresponding to the "g" command
			if (command.equals("g")) {
				System.out.println("You have chosen to get a course from an ISBN. Please input a valid ISBN.");
				String inputISBN = scnr.nextLine().trim();
				System.out.println(backEndData.get(inputISBN));
			}

			// outputs information corresponding to the "p" command
			if (command.equals("p")) {
				System.out.println("You have chosen to put a course into the database. Please input a valid ISBN.");
				String inputISBN = scnr.nextLine().trim();
				System.out.println("Please input a valid book title.");
				String inputTitle = scnr.nextLine().trim();
				System.out.println("Please input a valid course name.");
				String inputCourseName = scnr.nextLine().trim();
				backEndData.put(inputISBN, inputTitle, inputCourseName);
			}

			// outputs information corresponding to the "r" command
			if (command.equals("r")) {
				System.out.println(
						"You have chosen to remove a course. Please input a valid ISBN to check for the course.");
				String inputISBN = scnr.nextLine().trim();
				backEndData.remove(inputISBN);
			}

			// outputs information corresponding to the "q" command
			if (command.equals("q")) {
				System.out.println("Quitting the program.");
				quit = true;
			}

			// check for valid command
			if ((!command.equals("c")) && (!command.equals("g")) && (!command.equals("p")) && (!command.equals("r"))
					&& (!command.equals("q"))) {
				System.out.println("Must use valid command.");
			}
		}
	}

	/**
	 * This method runs the method which initializes the backEndData object and runs
	 * the method that acts as the actual program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initializeDatabase();
		runProgram();
	}
}
