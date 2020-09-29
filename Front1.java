package hashtableimplement;

import java.util.Scanner;

//--== CS400 File Header Information ==--
//Name: <Zijing Ma>
//Email: <zma253@wisc.edu>
//Team: <BB>
//TA: <Brianna Cochran>
//Lecturer: <Gary Dahl>
//Notes to Grader: <optional extra notes>
public class Front1 {

	public static void main(String[] args) {
		boolean quit = false;
		String command = null;
		Scanner sc = new Scanner(System.in);
		String help = "type h to see the help mannual.";
		ProjectOneBackEnd backend = null;
		// To choose whether you want to search or input
		System.out.println("To create a new data, input c; To enter the current file, input e");
		command = sc.nextLine().toLowerCase().trim();
		boolean pickedDatabase = false;
		while (pickedDatabase == false) {
			if (command.equals("e")) {
				backend = new ProjectOneBackEnd("src/hashtableimplement/textbook_file.csv");
				if (backend != null) {
					pickedDatabase = true;
				}
				if (backend == null) {
					System.out.println("Something went wrong. Try another command.");
					command = sc.nextLine().toLowerCase().trim();
				}
			}
			if (command.equals("c")) {
				backend = new ProjectOneBackEnd<String, CourseReading>(command);
				pickedDatabase = true;
			}
			if ((!command.equals("e")) && (!command.equals("c"))) {
				System.out.println("Please input a valid command.");
				command = sc.nextLine().toLowerCase().trim();
			}
		}
		System.out.println("Your database has been initialized.");
		// actual running of program
		while (quit == false) {
			System.out.println(help);
			command = sc.nextLine().toLowerCase().trim();
			// outputs information corresponding to the "c" command
			if (command.equals("h")) {
				System.out.print("\n\nMenu Selection:\n");
				System.out.print("\t 1.) Search course by ISBN.\n");
				System.out.print("\t 2.) Put a course.\n");
				System.out.print("\t 3.) Remove a course.\n");
				System.out.print("\t 4.) Quit.\n");
				System.out.print("Please enter selection: ");
				command = sc.nextLine().toLowerCase().trim();
			}
			// outputs information corresponding to the "g" command
			if (command.equals("1")) {
				System.out.println("You have chosen to get a course from an ISBN. Please input a valid ISBN.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("run the getHashIndex(inputISBN) command");
			}

			// outputs information corresponding to the "p" command
			if (command.equals("2")) {
				System.out.println("You have chosen to put a course into the database. Please input a valid ISBN.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("Please input a valid book title.");
				String inputTitle = sc.nextLine().trim();
				System.out.println("Please input a valid course name.");
				String inputCourseName = sc.nextLine().trim();
				System.out.println("run the put method");
			}
			// outputs information corresponding to the "r" command
			if (command.equals("3")) {
				System.out.println(
						"You have chosen to remove a course. Please input a valid ISBN to check for the course.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("run the remove(inputISBN)");
			}
			// outputs information corresponding to the "q" command
			if (command.equals("4")) {
				System.out.println("Quitting the program.");
				quit = true;
			}
			// check for valid command
			if ((!command.equals("1")) && (!command.equals("2")) && (!command.equals("3")) && (!command.equals("r"))
					&& (!command.equals("4"))) {
				System.out.println("Must use valid command.");
			}
		}

	}

}
