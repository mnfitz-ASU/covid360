package edu.asu.cse360.covid360;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent; //**Need to import to handle event
import javafx.event.EventHandler; //**Need to import to handle event

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class ReviewPane extends VBox {

	// SelectionModel index for mRatingMenu
	private static int 	kNone 		= 	-1;
	private static int 	kPoor 		= 	0;
	private static int 	kFair 		= 	1;
	private static int 	kAverage 	= 	2;
	private static int 	kGood 		= 	3;
	private static int 	kExcellent	= 	4;
	
	// constructor
	public ReviewPane(ArrayList<Music> inList) 
	{
		// initialize instance variables
		mMusicList = inList;
		mLabel = new Label(); 
		mLabel.setText("Choose a music to give a review, and select a rating");
		mMusicListView = new ListView<Music>(FXCollections.<Music>observableArrayList(mMusicList));

		// Initialize choicebox with the specified options
		mRatingMenu = new ChoiceBox<String>();
		mRatingMenu.setItems(FXCollections.observableArrayList("Poor", "Fair", "Average", "Good", "Excellent"));

		// mRatingMenu will select average (index 2) by default, and mMusicListView will have none (index -1) selected
		mRatingMenu.getSelectionModel().select(kAverage);
		mMusicListView.getSelectionModel().select(kNone);

		mSubmit = new Button();
		mSubmit.setText("Submit");

		// set up the layout
		// ----

		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10); // Horizontal gap in pixels
		
		// ReviewPane is a VBox - add the components here
		// ----
		this.getChildren().addAll(mLabel, mMusicListView, mRatingMenu, mSubmit);

		// Step #3: Register the button with its handler class
		// ----
		mSubmit.setOnAction(new RatingHandler());

	} // end of constructor

	// This method appends to the ListView |inMusic| added in CreatePane.
	// You will need to update the underlying ObservableList object in order for ListView
	// object to show the updated music list

	public void updateMusicList(Music inMusic) 
	{
		mMusicListView.getItems().add(inMusic);
	}

	// Step 2: Create a RatingHandler class
	private class RatingHandler implements EventHandler<ActionEvent> 
	{
		// Override the abstract method handle()
		public void handle(ActionEvent inEvent)
        {

			//When "Submit Review" button is pressed and a piece of music is selected from
			//the list view, the piece of music's average rating is updated by adding an additional
			//rating specified by a choice box

			// This method uses a dummy loop to flatten the if statements onto the same line;
			// Using multiple nested if statements makes it harder to see all checks on screen
			do
			{
				// Check for button click
				final boolean isClicked = inEvent.getEventType().equals(ActionEvent.ACTION);
				if (!isClicked)
				{
					break;
				}

				// Ensure music has been selected
				final int musicIndex = mMusicListView.getSelectionModel().getSelectedIndex();
				final boolean isMusicSelected = (musicIndex != kNone);
				if (!isMusicSelected)
				{
					break;
				}

				// Ensure a rating has been selected
				final int ratingIndex = mRatingMenu.getSelectionModel().getSelectedIndex();
				final boolean isRatingSelected = (ratingIndex != kNone);
				if (!isRatingSelected)
				{
					break;
				}

				// The program can now begin work because all checks have been passed

				// Calculate rating based off of the index of the option chosen;
				// The index of "Poor" is 0 and the rating given from poor is 1.0, so rating is index + !
				final double newRating = ratingIndex + 1;
				mMusicList.get(musicIndex).addRating(newRating);

				// Sets the selection values back to default
				mRatingMenu.getSelectionModel().select(kAverage);
				mMusicListView.getSelectionModel().select(kNone);

				// Tricky: refresh() forces mMusicListView to display the current rating
				mMusicListView.refresh();

				// Tricky: This is necessary so the rating is added to the mMusic text area when ReviewPane passes a new review
				// This mimics how CreatePane tells ReviewPane how to update its list view
				mCreatePane.updateMusicList();

			} while (false);
        }
	} // end of RatingHandler

	// Getters and Setters
	public CreatePane getCreatePane()
	{
		return mCreatePane;
	}

	public void setCreatePane(CreatePane createPane)
	{
		mCreatePane = createPane;
	}

	// --- Data Members ---
	// GUI list of music
	private ListView<Music> 	mMusicListView;
	// Descriptive GUI text
	private Label 				mLabel;
	// GUI selector for rating
	private ChoiceBox<String> 	mRatingMenu;
	// GUI button to submit review
	private Button 				mSubmit;
	// Container of all valid music
	private ArrayList<Music> 	mMusicList;
	// Reference to CreatePane used to update the CreatePane GUI wehn review is added
	private CreatePane			mCreatePane;

} // End of ReviewPane class
