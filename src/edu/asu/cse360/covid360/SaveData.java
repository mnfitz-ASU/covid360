package edu.asu.cse360.covid360;

import java.util.ArrayList;
import java.io.*;

import javafx.stage.FileChooser;
import java.nio.charset.StandardCharsets;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveData extends VBox {

	// Delimiter used in CSV file
	final String COMMA_DELIMITER = ",";
	final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	final String FILE_HEADER = "ID ,Last Name, First Name,Vaccine,Vaccine Location";

	// private ArrayList<PatientModel> list= new ArrayList<PatientModel>();
	// PatientModel newPatient;

	FileChooser mFileChooser = new FileChooser();

	// constructor
	public SaveData(Stage inStage, ArrayList<PatientModel> mPatientList) 
	{
		SaveInfo sPatientList = new SaveInfo(mPatientList);
		sPatientList.updateSave(mPatientList);

		mFileChooser.getExtensionFilters().addAll
		(
			new FileChooser.ExtensionFilter(".csv File", "*.csv")
		);

		File selectedFile = mFileChooser.showSaveDialog(inStage);
		writeCSV(selectedFile, sPatientList);

		// // LoadView loadView = new LoadView(inStage);
		
		// // mPatientList = loadView.getPatientList();
		// // mData = FXCollections.observableArrayList(mPatientList);
		// VBox vb1 = new VBox(8);
		// Button b1 = new Button("Save");
		// Label l1 = new Label();

		// b1.setOnAction(e -> {

		// 	if (sPatientList.goal() == false) {
		// 		l1.setText(sPatientList.message());

		// 	} else {
		// 		l1.setText("Data Saved!");
		// 		writeCSV("output.csv", sPatientList);
		// 	}

		// });

		// vb1.getChildren().addAll(b1, l1);
		// this.getChildren().addAll(vb1);
	}

	private void writeCSV(File inFile, SaveInfo fm) 
	{
		// PatientModel newPatient = new PatientModel();
		FileWriter fileWriter = null;
		try 
		{
			fileWriter = new FileWriter(inFile, StandardCharsets.UTF_8);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (int i = 0; i < fm.listSize(); i++) 
			{
				// newPatient = obj.getPatientList().get(i);

				fileWriter.append(String.valueOf(fm.getID().get(i)));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(fm.getLastName().get(i)));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(fm.getFirstName().get(i)));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(fm.Vaccine().get(i)));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(fm.getDate().get(i)));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(fm.getVaccineLocation().get(i)));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error in Csv");
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				fileWriter.flush();
				fileWriter.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Error while flushing/closing");
				e.printStackTrace();
			}
		}
	}
}