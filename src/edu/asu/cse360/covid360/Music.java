package edu.asu.cse360.covid360;

public class Music {
	
	//the title of the music
	private String title;
	
	//the year of the music
	private int year;
	
	//the description of the music
	private String description;
	
	//the review of the music
	private Review review;

	// Constructor to initialize all member variables
	public Music()
    {
      title = "?";
      year = 0;
      description = "?";
      review = new Review();
    }

	// Accessor methods
	public String getxTitle() {
		return title;
	}


	public int getYear() {
		return year;
	}

	public String getDescription() {
		return description;
	}
	
	public Review getReview() {
		return review;
	}

	// Mutator methods
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int aYear) {
		this.year = aYear;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void addRating(double rate) {
		review.updateRating(rate);
	}

	// toString() method returns a string containg the information on the music
	public String toString() {
		String result = "\nMusic Title:\t\t" + title + "\nMusic Year:\t\t" + year + "\nMusic Description:\t\t" + description
				+ "\n" + review.toString() + "\n\n";
		return result;
	}
}
