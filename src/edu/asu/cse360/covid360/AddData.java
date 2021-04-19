//package application;
package edu.asu.cse360.covid360;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.layout.GridPane; 

public class AddData extends VBox
{
	TextField mId = new TextField();
	TextField mLastName = new TextField();
	TextField mFirstName = new TextField();
	TextField mVaccineType = new TextField();
	TextField mVaccineDate = new TextField();
	TextField mVaccineLocation = new TextField();

	PatientModel mNewPatient =new PatientModel();

	public AddData()
	{
		GridPane gridPane = new GridPane();    

		//Setting size for the pane  
		gridPane.setMinSize(400, 200); 

		//Setting the padding  
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(10); 
		gridPane.setHgap(10);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.CENTER_LEFT); 

		Label id = new Label ("\tID:\t\t\t\t\t");
		Label lastName = new Label ("\tLast Name:\t\t\t");
		Label firstName = new Label ("\tFirst Name:\t\t\t");
		Label vaccineType = new Label ("\tVaccine Type:\t\t");
		Label vaccineDate = new Label ("\tVaccination Date:\t");
		Label vaccineLocation = new Label ("\tVaccination Location:\t");

		Button b1=new Button("Enter");
		Label successLabel = new Label("");
		
		//Arranging all the nodes in the grid 
		gridPane.add(id, 0, 0);
		gridPane.add(mId, 1, 0);

		gridPane.add(lastName, 0, 1);
		gridPane.add(mLastName, 1, 1);

		gridPane.add(firstName, 0, 2);
		gridPane.add(mFirstName, 1, 2);

		gridPane.add(vaccineType, 0, 3);
		gridPane.add(mVaccineType, 1, 3);

		gridPane.add(vaccineDate, 0, 4);
		gridPane.add(mVaccineDate, 1, 4);

		gridPane.add(vaccineLocation, 0, 5);
		gridPane.add(mVaccineLocation, 1, 5);

		gridPane.add(b1, 0, 6);
		gridPane.add(successLabel, 0, 7);

		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				successLabel.setText("Data Added");
				mNewPatient.setId(Integer.parseInt(mId.getText()));
				mNewPatient.setLastName(mLastName.getText());
				mNewPatient.setFirstName(mFirstName.getText());
				mNewPatient.setVaxType(mVaccineType.getText());
				mNewPatient.setVaxDate(mVaccineDate.getText());
				mNewPatient.setVaxLoc(mVaccineLocation.getText());

				PatientModel.somethingChanged("AddData");

				mId.setText("");
				mLastName.setText("");
				mFirstName.setText("");
				mVaccineType.setText("");
				mVaccineDate.setText("");
				mVaccineLocation.setText("");
			}
		};

		b1.setOnAction(event);
		this.getChildren().addAll(gridPane);
	}

	public PatientModel getPatient()
	{
		return mNewPatient;
	}
}
