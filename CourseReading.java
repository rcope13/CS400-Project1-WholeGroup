// --== CS400 File Header Information ==--
// Name: Frank Slavinsky
// Email: fslavinsky@wisc.edu
// Team: BB
// Role: Data Wrangler
// TA: Briana Cochran
// Lecturer: Gary Dahl
// Notes to Grader: N/A
/**
 * This class models a required reading for a course offered at UW-Madison for the Fall 2020 term,
 * and is the ValueType in the implementation of HashTableMap.java. This class contains relavent
 * fields and getters and setters. There is also a getInfo() method which returns as a string the
 * title and course associated with the book.
 * 
 * @author Frank Slavinsky
 */
public class CourseReading {
  // fields
  private String ISBN;
  private String bookTitle;
  private String course;

  /**
   * Constructor for CourseReading. Values are assigned via calls to static methods in Wrangler.java
   * 
   */
  CourseReading() {
    this.ISBN = null;
    this.bookTitle = null;
    this.course = null;
  }

  /**
   * @return the ISBN
   */
  public String getISBN() {
    return ISBN;
  }

  /**
   * @param ISBN
   */
  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  /**
   * @return the bookTitle
   */
  public String getBookTitle() {
    return bookTitle;
  }

  /**
   * @param bookTitle
   */
  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  /**
   * @return the course
   */
  public String getCourse() {
    return course;
  }

  /**
   * @param course
   */
  public void setCourse(String course) {
    this.course = course;
  }
  
  /**
   * @return the title of the book, new line, the class associated with the book
   */
  public String getInfo() {
    return "Title: " + bookTitle + "\nClass: " + course;
  }
}
