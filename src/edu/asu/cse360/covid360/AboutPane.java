package edu.asu.cse360.covid360;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class AboutPane extends VBox 
{
	// constructor
	public AboutPane(About inAbout) 
	{
		mTeam = inAbout.getGroup();
		// initialize instance variables 

		ObservableList<String> aboutList = FXCollections.<String>observableArrayList(mTeam);
		mGroupListView = new ListView<>(aboutList);

		// set up the layout
		// ----
		mLabel = new Label(); 
		mLabel.setText("Group #3 Teammates:");

		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10); // Horizontal gap in pixels
		
		// ReviewPane is a VBox - add the components here
		// ----
		this.getChildren().addAll(mLabel, mGroupListView);

	} // end of constructor

	// --- Data Members ---
	// GUI list of music
	private ListView<String> 	mGroupListView;
	// Descriptive GUI text
	private Label 				mLabel;
	// Container of all valid music
	private String 				mTeam;

} // End of ReviewPane class
