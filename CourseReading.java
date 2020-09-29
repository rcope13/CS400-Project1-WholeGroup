// --== CS400 File Header Information ==--
// Name: <Shutong Lin>
// Email: <slin326@wisc.edu>
// Team: <BB>
// Role: <Data Wrangler 1>
// TA: <Brianna (Bri) Cochran>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>
//------------------------------------------------------------------------------------------------------------------------------------------------------------------


/**
 *	CourseReading Object
 */
class CourseReading {
	/**
	 * ISBN value
	 */
	private String ISBN;
	/**
	 * bookTitle value
	 */
	private String bookTitle;
	/**
	 * course value
	 */
	private String course;

	/**
	 * @param ISBN
	 * @param bookTitle
	 * @param course
	 */
	public CourseReading(String ISBN, String bookTitle, String course) {
		super();
		this.ISBN = ISBN;
		this.bookTitle = bookTitle;
		this.course = course;
	}

	/**
	 * @param csvLineContent : csvLineContent[0] is ISBN , csvLineContent[1] is bookTitle, csvLineContent[2] is course
	 */
	public CourseReading(String[] csvLineContent) {
		this(String.valueOf(csvLineContent[0]), csvLineContent[1], csvLineContent[2]);
	}

	
	/**
	 * ISBN,bookTitle,course  getter and setter
	 * */

	public String getBookTitle() {
		return bookTitle;
	}

	public String getIsbn() {
		return ISBN;
	}

	public void setIsbn(String isbn) {
		this.ISBN = ISBN;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * change to csv file style
	 * @return
	 */
	public String toCSVContent() {
		return String.join(",", String.valueOf(this.ISBN), this.bookTitle, this.course);
	}

}
