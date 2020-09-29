import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// --== CS400 File Header Information ==--
// Name: Frank Slavinsky
// Email: fslavinsky@wisc.edu
// Team: BB
// Role: Data Wrangler
// TA: Briana Cochran
// Lecturer: Gary Dahl
// Notes to Grader: N/A
/**
 * This class contains static methods to check and then put/get key-value pairs from the hash table
 * implemented in HashTableMap.java
 * 
 * @author Frank Slavinsky
 *
 */
public class Wrangle {
  private static CourseReading readingToPass; // the object/value added to HashTableMap

  /**
   * This method resets the readingToPass static variable and sets the now reset variable's isbn
   * field
   * 
   * @param isbn - the ISBN of the book to be added to CourseReading object which will in turn be
   *             the value of the key-value pair added to HashTableMap
   */
  public static void setISBN(String isbn) {
    resetReading();
    readingToPass.setISBN(isbn);
    // return true;
  }

  /**
   * This method reads a CSV file of the format: course subject, course number, course title, title,
   * ISBN and saves it to a HashTableMap object which is returned.
   * 
   * @param filePath - the path to the csv of the above listed format to be read.
   * @return the newly created HashTableObject containing data read from CSV file OR null if the
   *         file path passed to the method is invalid.
   * 
   * @author I modeled the following implementation from
   *         https://attacomsian.com/blog/read-write-csv-files-core-java
   */
  public static HashTableMap<String, CourseReading> readCSV(String filePath) {
    HashTableMap<String, CourseReading> hashTable = new HashTableMap<String, CourseReading>(2000);
    try {
      // CSV file delimiter
      String DELIMITER = ",";

      // create a reader
      BufferedReader br = Files.newBufferedReader(Paths.get(filePath));

      // read the file line by line
      String line = br.readLine(); // clears out the line with column titles

      while (line != null) {
        // convert line into tokens
        String[] tokens = line.split(DELIMITER);
        Wrangle.setISBN(tokens[4]);
        Wrangle.setCourse("" + tokens[0] + " " + tokens[1] + " " + tokens[2]);
        Wrangle.setTitle(tokens[3]);
        hashTable.put(Wrangle.key(), Wrangle.value()); // save the data to hash table
        line = br.readLine();
      }

      // close the reader
      br.close();

    } catch (IOException ex) {
      // ex.printStackTrace();
      return null; // this tells the front end that the file was not found
    }
    return hashTable;
  }

  /**
   * @param title - Title of the book to be added to CourseReading object which will in turn be the
   *              value of the key-value pair added to HashTableMap
   * @return true if valid book title, false if not
   */
  public static boolean setTitle(String title) {
    if (!(title instanceof String))
      return false;
    readingToPass.setBookTitle(title);
    return true;
  }

  /**
   * @param course - course associated with the book to be added to CourseReading object which will
   *               in turn be the value of the key-value pair added to HashTableMap
   * @return true if course was of correct form and added to CourseReading object to be put.
   */
  public static boolean setCourse(String course) {
    if (!(course instanceof String))
      return false;
    readingToPass.setCourse(course);
    return true;
  }

  /**
   * @return the CourseReading to be set as the value
   */
  public static CourseReading value() {
    return readingToPass;
  }

  /**
   * @return the ISBN to be set as the key
   */
  public static String key() {
    return readingToPass.getISBN();
  }

  /**
   * This is a private helper method to clear the static field readingToPass so that it is ready for
   * the next CourseReading to be added to the hash table.
   */
  private static void resetReading() {
    readingToPass = new CourseReading();
  }

//  /**
//   * I have included this method if you wish to see the functionality of Wrangle, CourseReading, and
//   * your HashTableMap.
//   */
//  public static void main(String[] args) {
//    HashTableMap<String, CourseReading> table = readCSV("src/updated_textbook_file.csv");
//    Wrangle.setISBN("898989899"); // in final product, the param would come from user input
//    Wrangle.setTitle("Harry Potter"); // *see above comment*
//    Wrangle.setCourse("English 345"); // *see above comment*
//    table.put(Wrangle.key(), Wrangle.value()); // use staic methods to get the key and value passed
//    Wrangle.setISBN("454545454"); // New CourseReading to add
//    Wrangle.setTitle("LOTR");
//    Wrangle.setCourse("English 745");
//    table.put(Wrangle.key(), Wrangle.value());
//    System.out.println(table.get("898989899").getBookTitle()); // should return "Harry Potter"
//    System.out.println(table.get("454545454").getInfo()); // should return "LOTR" and info
//    System.out.println(table.get("'9783319266527'").getInfo()); // should return "Differn. Geometry"
//  }
}
