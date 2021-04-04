package edu.asu.cse360.covid360;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CreatePane extends HBox 
{
	
	// Utility method returns current date as string
	private static String Date() 
	{
		final String kDateFormat = "yyyy/MM/dd";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(kDateFormat);
		return sdf.format(cal.getTime());
	}

	// constructor
	public CreatePane(ArrayList<Music> inList, ReviewPane inReviewPane) 
	{
		// Step #1: initialize each instance variable and set up the layout
		// ----
		mMusicList = inList;
	
		mReviewPane = inReviewPane;
		// Tricky: ReviewPane cannot see where CreatePane is; this method lets it access CreatePane
		// This is necessary so the rating is added to the mMusic text area when ReviewPane passes a new review.
		// This mimics how CreatePane tells ReviewPane how to update its list view
		CreatePane me = this;
		mReviewPane.setCreatePane(me);

		// Initialize all visual elements that will be displayed in the CreatePane Tab
		// InfoLabel by default should display the date in black
		mInfoLabel = new Label();
		mInfoLabel.setTextFill(Color.BLACK);
		mInfoLabel.setText(Date());

		mTitleLabel = new Label();
		mTitleLabel.setText("Title");

		mYearLabel = new Label();
		mYearLabel.setText("Year");

		mDescriptionLabel = new Label();
		mDescriptionLabel.setText("Description");

		mTitleText = new TextField();

		mYearText = new TextField();

		mDescriptionText = new TextArea();

		mCreateButton = new Button();
		mCreateButton.setText("Create a Music Record");

		// When there is no music created, mMusic will show "No Music"
		mMusic = new TextArea();
		mMusic.setText("No Music");
		
		// create a GridPane hold those labels & text fields
		// consider using .setPadding() or setHgap(), setVgap()
		// to control the spacing and gap, etc.
		// ----

		mGrid = new GridPane();

		mGrid.setHgap(10); // Horizontal gap in pixels
		mGrid.setVgap(10); // Vertical gap in pixels
		mGrid.setPadding(new Insets(10, 10, 10, 10)); // Margins around the whole grid

		// Set up the layout for the left half of the CreatePane.
		// ---
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		mGrid.getColumnConstraints().addAll(column1, column2);

		// the right half of this pane is simply a TextArea object
		// Note: a ScrollPane will be added to it automatically when there are no
		// enough space

		// Add the left half and right half to the CreatePane
		// Note: CreatePane extends from HBox
		// ----

		mGrid.add(mInfoLabel, 1, 0);
		mGrid.add(mTitleLabel, 0, 1);
		mGrid.add(mYearLabel, 0, 2);
		mGrid.add(mDescriptionLabel, 0, 3);
		mGrid.add(mTitleText, 1, 1);
		mGrid.add(mYearText, 1, 2);
		mGrid.add(mDescriptionText, 1, 3);
		mGrid.add(mCreateButton, 1, 4);

		// Step #3: register source object with event handler
		// ----
		
		mCreateButton.setOnAction(new ButtonHandler());

		// Adds all elements onto the grid
		this.getChildren().addAll(mGrid, mMusic);

	} // end of constructor

	// isEmpty method tests if the data members have information added
	private boolean IsEmpty(String inString)
	{
		boolean isEmpty = (inString == null || inString.trim().isEmpty());
		return isEmpty;
	}

	// Step 2: Create a ButtonHandler class
	// ButtonHandler listens to see if the button "Create a Music Record" is pushed or not,
	// When the event occurs, it get a music's Title, Year, and Description
	// information from the relevant text fields, then create a new movie and add it
	// inside
	// the musicList. Meanwhile it will display the music's information inside the
	// text area.
	// It also does error checking in case any of the textfields are empty or
	// non-numeric string is typed
	private class ButtonHandler implements EventHandler<ActionEvent> 
	{
		// Override the abstact method handle()
		public void handle (ActionEvent inEvent) 
		{
			// This method uses a dummy loop to flatten the if statements onto the same line;
			// Using multiple nested if statements makes it harder to see all checks on screen
			do
			{
				final boolean isClicked = inEvent.getEventType().equals(ActionEvent.ACTION);
				// Checks for button click
				if (!isClicked)
				{
					break;
				}

				final boolean isTitleEmpty = IsEmpty(mTitleText.getText());
				final boolean isYearEmpty = IsEmpty(mYearText.getText());
				final boolean isDescriptionEmpty = IsEmpty(mDescriptionText.getText());
				final boolean isFieldMissing = (isTitleEmpty || isYearEmpty || isDescriptionEmpty);
				// Checks to see if there is a missing text field
				if (isFieldMissing)
				{
					// InfoLabel displays an empty field error in red
					mInfoLabel.setTextFill(Color.RED);
					mInfoLabel.setText("Please fill in all fields");
					break;
				}
				
				int year = 2019;

				// Checks to see in the year is in the correct format
				// (Stolen code from Assignment 4)
				try 
				{
					year = Integer.parseInt(mYearText.getText());
				} 
				catch (java.lang.NumberFormatException e) 
				{
					// InfoLabel displays incorrect year error in red
					mInfoLabel.setTextFill(Color.RED);
					mInfoLabel.setText("Incorrect year format");
					break;
				}

				// At this point, the program passes all the checks, and can perform the work

				// InfoLabel displays that the music was successfully added to the list in blue
				mInfoLabel.setTextFill(Color.BLUE);
				mInfoLabel.setText("Music Added");

				// New music element takes on the properties of the inputs and is added to mMusicList
				Music music = new Music();
				music.setTitle(mTitleText.getText());
				music.setYear(year);
				music.setDescription(mDescriptionText.getText());

				// at the end, don't forget to update the new arrayList
				// information on the ListView of the ReviewPane
				// ----
				mMusicList.add(music);
				mReviewPane.updateMusicList(music);
				
				// Update the GUI text area
				updateMusicList();
				
			} while (false);
		}
	}
		
	 // end of handle() method
	 // end of ButtonHandler class

	 // Updates GUI text area using mMusicList.
	 // Called after new music has been added and 
	 // after a new review has been added
	 public void updateMusicList()
	 {
		String result = "";
		for (int i = 0; i < mMusicList.size(); i++)
		{
			result += mMusicList.get(i).toString();
		}

		mMusic.setText(result);
	 }

	// ---Data Members---
	// Labels used for descriptive GUI text
	private Label 				mInfoLabel; 
	private Label 				mTitleLabel; 
	private Label 				mYearLabel; 
	private Label 				mDescriptionLabel;
	// GUI used for user text input
	private TextField 			mTitleText;
	private TextField 			mYearText;
	private TextArea 			mDescriptionText;
	// GUI used to submit input
	private Button 				mCreateButton;
	// GUI displays inputted information as music
	private TextArea 			mMusic;
	// The relationship between CreatePane and ReviewPane is Aggregation
	private ReviewPane 			mReviewPane; 
	// Contains list of valid  music
	private ArrayList<Music> 	mMusicList;
	// Container GUI element
	private GridPane 			mGrid;
}