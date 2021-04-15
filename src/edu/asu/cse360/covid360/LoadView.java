package edu.asu.cse360.covid360;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class LoadView extends VBox 
{
	// constructor
	public LoadView(Stage inStage, ArrayList<PatientModel> inPatientList) 
	{
		ObservableList<String> aboutList = FXCollections.<String>observableArrayList(/*Displays Input*/);
		mGroupListView = new ListView<>(aboutList);

		// set up the layout
		mLabel = new Label(); 
		mLabel.setText("Load Data");

		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10); // Horizontal gap in pixels
		
		this.getChildren().addAll(mLabel, mGroupListView);

	} // end of constructor

	// --- Data Members ---
	private ListView<String> 	mGroupListView;
	private Label 				mLabel;

}

/*
case 'U': // Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						{
							System.out.print("Please enter a string to write in the file:\n");
							String string = stdin.readLine();

							FileOutputStream fileOutput = null;
							ObjectOutputStream outstream = null;
							try
							{
								// Create a fileOutputStream
								fileOutput = new FileOutputStream(filename);
								outstream = new ObjectOutputStream(fileOutput);
								outstream.writeObject(string);
								System.out.print(filename + " was written\n");
							}
							catch (Exception e)
							{
								System.out.print(filename + " was not found\n");
							}
							finally
							{
								// Tricky: Only close the oject output stream if needed
								if (outstream != null)
								{
									outstream.close();
								}
							}
						}
						break;
					case 'V': // Read Text from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						{
							FileInputStream fileInput = null;
							ObjectInputStream inStream = null;
							try
							{
								// Create a fileInputStream
								fileInput = new FileInputStream(filename);
								inStream = new ObjectInputStream(fileInput);
								String string = (String) inStream.readObject();
								System.out.print(filename + " was read\n");
								System.out.print("The first line of the file is:\n" + string + "\n");
							}
							catch (Exception e)
							{
								System.out.print(filename + " was not found\n");
							}
							finally
							{
								// Tricky: Only close the oject output stream if needed
								if (inStream != null)
								{
									inStream.close();
								}
							}
						}
						break;

						*/