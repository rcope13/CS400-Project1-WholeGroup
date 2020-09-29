// --== CS400 File Header Information ==--
// Name: Rohan Nadgir
// Email: nadgir@wisc.edu
// Team: BB
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to Grader: Test Engineer 2
public class ISBNHashTableTester {
    
//----------If ISBNInsertTest1-ISBNInsertTest3 return true, the books have been successfully added to the record.----------//
    public static boolean ISBNInsertTest1() {
        
       CourseReadingBackEnd firstISBN = new CourseReadingBackEnd();
       return firstISBN.put("39632", "Hello World: In's and Out's of Java", "CS 101");
       
    }
  
    public static boolean ISBNInsertTest2() {
        
        CourseReadingBackEnd firstISBN = new CourseReadingBackEnd();
        return firstISBN.put("9834", "In's and Out's of Java: The Sequel", "CS 102");
        
    }

    public static boolean ISBNInsertTest3() {
        CourseReadingBackEnd firstISBN = new CourseReadingBackEnd();
        return firstISBN.put("079345", "The Prequel: In's and Out's of Java", "CS 100");
    }
//----------End of ISBNInserttest.----------//
    
//----------Remove Test Methods. Since HashTableMap class is called from BackEnd code, variables  are in relation to the HashTableMap class.----------//  
    public static boolean removeTest1() { //removing from an empty list
        
        HashTableMap<String, CourseReading> hashTable = new HashTableMap();
  
        if(hashTable.remove("354079") == null) {
            return true;
        }
        return false;
    }

    public static boolean removeTest2() { //Removing an unknown ISBN should return null (see CourseReading.remove()). Similar to removeTest1.
  
        HashTableMap hashTable = new HashTableMap(); 

        if(hashTable.remove("7409") == null) {
            return true;
        }
        return false;
        
    }
//----------End of Remove Test----------//
    
    public static boolean valueTest() { //Tests if the returned address matches that  of the CourseReading class's address. This ensures wrangle.value() has relation to HashTableMap.
        
        CourseReading courseReading = new CourseReading();
        Wrangle wrangle = new Wrangle();
        
        wrangle.setISBN("7964");
        wrangle.setTitle("Advanced Procastination");
        wrangle.setCourse("Procrastination 211");

        if(wrangle.value().toString().equals("CourseReading@76ed5528")) {
            return true;
        }
        return false;

    }
 
//----------The following 3 tests are to check whether the ISBN, Book Title, and Course Name are returned once they are set.----------//

    public static boolean testSetAndGetISBN() { //Testing with Wrangle Class
        
        Wrangle wrangle = new Wrangle();
        wrangle.setISBN("476");
        if(wrangle.key().equals("476")) {
            return true;
        }
        return false;
    }

    public static boolean testSetAndGetCourse() { //Testing with CourseReading Class
        CourseReading courseReading = new CourseReading();
        courseReading.setCourse("Psych 239");
        
        if(courseReading.getCourse().equals("Psych 239")) {
            return true;
        }
        return false;
        
    }
    
    public static boolean testSetAndGetBookTitle() { //Aso Testing with CourseReading Class
        CourseReading courseReading = new CourseReading();
        courseReading.setBookTitle("Introspectives Of Sociology");
        
        if(courseReading.getBookTitle().equals("Introspectives Of Sociology")) {
            return true;
        }
        return false;
    }
//----------End of testing ISBN, Book Title, and Course Name----------//
    
    
   public static boolean testReadCSV() { //Tests if the returned address when the CSV is called matches that of the HashTableMap class. This ensures the CSV has relation to HashTableMap.
       Wrangle wrangle = new Wrangle();

       if(wrangle.readCSV("src/textbook_file.csv").toString().equals("HashTableMap@1be6f5c3")) {
           return true;
       }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Testing Inserting ISBN hash: ");
        System.out.println("-ISBNInsertTest1: " + ISBNInsertTest1());
        System.out.println("-ISBNInsertTest2: " + ISBNInsertTest2());
        System.out.println("-ISBNInsertTest3: " + ISBNInsertTest3());
        System.out.println("");
        System.out.println("Testing removing ISBN Information: ");
        System.out.println("-removeTest1: " + removeTest1());
        System.out.println("-removeTest2: " + removeTest2());
        System.out.println("");
        System.out.println("Testing Value Method: ");
        System.out.println("-valueTest: " + valueTest());
        System.out.println("");
        System.out.println("Testing hash table ISBNs, Course Names, and Book Titles: ");
        System.out.println("-testSetAndGetISBN: " + testSetAndGetISBN());
        System.out.println("-testSetAndGetCourse: " + testSetAndGetCourse());
        System.out.println("-testSetAndGetBookTitle: " + testSetAndGetBookTitle());
        System.out.println("");
        System.out.println("Testing CSV: ");
        System.out.println("-testReadCSV: " + testReadCSV());
    }
}
