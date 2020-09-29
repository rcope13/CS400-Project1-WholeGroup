// --== CS400 File Header Information ==--
// Name: Jacob Revnew
// Email: revnew@wisc.edu
// Team: Team: BB
// TA: Bri Cochran
// Lecturer: Florian Heirmerl
// Notes to Grader: <optional extra notes>

/**This class uses HashTableMap.java, CourseReading.java, and Wrangle.java to allow for the the 
 * front end developer to be able to use the get, put, and remove methods for the hashTableMap
 * 
 * @author Jacob Revnew
 *
 */
public class CourseReadingBackEnd2 {
  private HashTableMap<String, CourseReading> hashTable; //hashTable
  
  /**Constructor class that sets up an empty hashTable
   * 
   */
  public CourseReadingBackEnd2() {
    this.hashTable = new HashTableMap<String, CourseReading>(2000);
  }
  
  /**Sets up a hashTable with all the courseReadings by using the Wrangle.readCSV class method
   * 
   * @param filePath - the path to the file of courseReadings
   */
  public CourseReadingBackEnd2 (String filePath) {
    this.hashTable = Wrangle.readCSV(filePath);
  }

  /**Removes a courseReading if it exists in the hashTable
   * 
   * @param iSBN - the ISBN of the courseReading, which is also the key
   * @return - the course and title if found otherwise null
   */
  public String remove(String iSBN) {
    return hashTable.remove(iSBN).getInfo();
  }
  
  /**Puts a courseReading into the hashTable if there is no existing ISBN 
   * 
   * @param iSBN - ISBN of the book, which will also be the key
   * @param title - book title
   * @param course - course the book is needed for
   * @return - whether the courseReading was added to the hashTable or not
   */
  public boolean put(String iSBN, String title, String course ) {
    CourseReading addedCourseReading = new CourseReading(); 
    addedCourseReading.setBookTitle(title);
    addedCourseReading.setCourse(course);
    addedCourseReading.setISBN(iSBN);
    return hashTable.put(iSBN, addedCourseReading);
  }
  
  /**Gets the value of an ISBN if it exists in the hashTable
   * 
   * @param iSBN - ISBN of the book, which is also the key
   * @return - returns the course and title in string format if found, otherwise tells the user
   * the course reading was not found with that ISBN
   */
  public String get(String iSBN) {
    try {
    return hashTable.get(iSBN).getInfo();
    } catch(Exception e) {
      return "Course reading not found for such ISBN!";
    }
  }
  
}