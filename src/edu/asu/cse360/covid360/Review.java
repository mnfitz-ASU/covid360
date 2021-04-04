package edu.asu.cse360.covid360;

import java.text.DecimalFormat;

//this class describe a Music Review object
public class Review {
	
	//number of reviews
	private int numberOfReviews;
	
	//the sum of all ratings
	private double sumOfRatings;
	
	//the average of all ratings
	private double average;

	// Constructor to initialize all member variables
	public Review() {
		numberOfReviews = 0;
		sumOfRatings = 0.0;
		average = 0.0;
	}

	// This method updates the number of reviews and average based on 
	// an additional rating specified by the parameter
	public void updateRating(double rating) {
		numberOfReviews++;
		sumOfRatings += rating;
		if (numberOfReviews > 0) {
			average = sumOfRatings / numberOfReviews;
		} else {
			average = 0.0;
		}
	}

	// toString() method returns a string containg its review average
	// and te number of Reviews
	public String toString() {
		DecimalFormat fmt = new DecimalFormat("0.00");
		String result = "Reviews:\t" + fmt.format(average) + "(" + numberOfReviews + ")";
		return result;
	}
}

