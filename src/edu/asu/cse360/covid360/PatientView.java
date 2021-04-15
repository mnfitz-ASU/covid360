package edu.asu.cse360.covid360;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class PatientView extends VBox 
{
	// constructor
	public PatientView(Stage inStage,  PatientModel inPatient) 
	{
		ObservableList<String> aboutList = FXCollections.<String>observableArrayList(/*Displays Input*/);
		mGroupListView = new ListView<>(aboutList);

		// set up the layout
		mLabel = new Label(); 
		mLabel.setText("EMPTY");

		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10); // Horizontal gap in pixels
		
		this.getChildren().addAll(mLabel, mGroupListView);

	} // end of constructor

	// --- Data Members ---
	private ListView<String> 	mGroupListView;
	private Label 				mLabel;

}
