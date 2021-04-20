package edu.asu.cse360.covid360;

import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.*;


public class LoadView extends VBox 
{
	// constructor
	public LoadView(Stage inStage) 
	{
		mFileChooser.getExtensionFilters().addAll
		(
			new FileChooser.ExtensionFilter(".csv Files", "*.csv")
		);

		File selectedFile = mFileChooser.showOpenDialog(inStage);
		parseCSV(selectedFile);

	} // end of constructor

	private void parseCSV(File inFile)
	{
		String line = null;
		BufferedReader bufferedReader = null;
	
		try 
		{
			FileReader fileReader = new FileReader(inFile, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(fileReader);

			// Skip the first line, as it holds Header; not Data
			bufferedReader.readLine();

			while ((line = bufferedReader.readLine()) != null) 
			{
				String[] csvElements = line.split(",");
				
				PatientModel newPatient = new PatientModel();
				for (int i = 0; i < csvElements.length; i++) 
				{
					switch (i)
					{
						case 0:
							newPatient.setId(Integer.valueOf(csvElements[i]));
							break;

						case 1:
							newPatient.setLastName(csvElements[i]);
							break;

						case 2:
							newPatient.setFirstName(csvElements[i]);
							break;

						case 3:
							newPatient.setVaxType(csvElements[i]);
							break;
							
						case 4:
							newPatient.setVaxDate(csvElements[i]);
							break;
							
						case 5:
							newPatient.setVaxLoc(csvElements[i]);
							break;

						default:
							throw new IOException();
							//break;
					}
				}
				mLoadList.add(newPatient);
			}
		}
	
		catch (IOException e) 
		{
			System.out.println("Error Occured while parsing csv file.");
			e.printStackTrace();
		} 

		finally 
		{
			if (bufferedReader != null) 
			{
				try 
				{
					bufferedReader.close();
				} 

				catch (Exception ignore) 
				{
					// Nothing to do
				}
			}
		}
	}

	public ArrayList<PatientModel> getPatientList()
	{
		return mLoadList;
	}

	// --- Data Members ---
	FileChooser mFileChooser = new FileChooser();
	ArrayList<PatientModel> mLoadList = new ArrayList<PatientModel>();
}
