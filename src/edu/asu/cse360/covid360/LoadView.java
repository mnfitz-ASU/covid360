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