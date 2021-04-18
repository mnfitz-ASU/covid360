//package application;
package edu.asu.cse360.covid360;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddData extends VBox
{
	PatientModel ob =new PatientModel();

	
	public AddData()
	{
		Label id = new Label ("\tID:\t\t\t\t\t");
		TextField ID = new TextField();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(id,ID);
		hb1.setSpacing(10);

		Label lastName = new Label ("\tLast Name:\t\t\t");
		TextField LASTNAME = new TextField();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(lastName,LASTNAME);
		hb2.setSpacing(10);

		Label firstName = new Label ("\tFirst Name:\t\t\t");
		TextField FIRSTNAME = new TextField();
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(firstName,FIRSTNAME);
		hb3.setSpacing(10);

		Label vaccineType = new Label ("\tVaccine Type:\t\t");
		TextField VACCINETYPE = new TextField();
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(vaccineType,VACCINETYPE);
		hb4.setSpacing(10);

		Label vaccineDate = new Label ("\tVaccination Date:\t");
		TextField VACCINEDATE = new TextField();
		HBox hb5 = new HBox();
		hb5.getChildren().addAll(vaccineDate,VACCINEDATE);
		hb5.setSpacing(10);

		Label vaccineLocation = new Label ("\tVaccination Location:\t");
		TextField VACCINELOCATION = new TextField();
		HBox hb6 = new HBox();
		hb6.getChildren().addAll(vaccineLocation,VACCINELOCATION);
		hb5.setSpacing(10);
		VBox vb=new VBox(8);
		vb.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6);
		VBox vb1 = new VBox(8);
		Button b1=new Button("Enter");
		vb1.getChildren().add(b1);
		Label l =new Label();
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				String s="";
				int i = Integer.parseInt(s);
				ob.setId(i);
				s=LASTNAME.getText();
				ob.setLastName(s);
				s=FIRSTNAME.getText();
				ob.setFirstName(s);
				s=VACCINETYPE.getText();
				ob.setVaxType(s);
				s=VACCINEDATE.getText();
				ob.setVaxDate(s);
				s=VACCINELOCATION.getText();
				ob.setVaxLoc(s);
				info.add(s);
				s=id.getText();
				info.add(s);
				s=LASTNAME.getText();
				info.add(s);
				s=FIRSTNAME.getText();
				info.add(s);
				s=VACCINETYPE.getText();
				info.add(s);
				s=VACCINEDATE.getText();
				info.add(s);
				s=VACCINELOCATION.getText();
				info.add(s);
				l.setText("Data Added");

			}
		};
		b1.setOnAction(event);
		vb1.getChildren().add(l);
		this.getChildren().addAll(vb,vb1);
	}

	public PatientModel getPatient()
	{
		return ob;
	}

	public ArrayList<String> getStringList()
	{
		return info;
	}

}
