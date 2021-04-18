package edu.asu.cse360.covid360;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveData extends VBox {
    
    private ObservableList<PatientModel> 	mData;
  //Delimiter used in CSV file
    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    final String FILE_HEADER = "ID ,Last Name, First Name,Vaccine,Type Vaccinatior,Vaccine Location";
   
   // private ArrayList<PatientModel> list= new ArrayList<PatientModel>();
    //PatientModel newPatient;
    private FileWriter fileWriter;
	
    //constructor 
    public SaveData(Stage inStage)
    {
	LoadView loadView = new LoadView(inStage);
	ArrayList<PatientModel> mPatientList = new ArrayList<PatientModel>();

	mPatientList = loadView.getPatientList();
	mData = FXCollections.observableArrayList(mPatientList);
	 VBox vb1 = new VBox(8);
	 Button b1 = new Button("Save");
	 Label l1=new Label();
	 
	 b1.setOnAction(e-> {
	    
	     
		
	 l1.setText("Data Saved!");  
          writeCSV("output.csv");
	 });
	
	
	
	 
	 
	 
	 
	

	vb1.getChildren().addAll(b1,l1);
	this.getChildren().addAll(vb1);
    }
    

    
    private void writeCSV(String f)
    {
	
	
	
	   
	   // PatientModel newPatient = new PatientModel();
	    fileWriter = null;
	    try {
		
	    
	    //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            
            for(int i=0; i<mData.size();i++)
            {
        	 //newPatient = obj.getPatientList().get(i);
        	
        	fileWriter.append(String.valueOf(mData.get(i).getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mData.get(i).getLastName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mData.get(i).getFirstName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mData.get(i).getVaxType()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mData.get(i).getVaxDate()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(mData.get(i).getVaxLoc()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            
	    }catch (Exception e) {
	            System.out.println("Error in Csv");
	            e.printStackTrace();
	        } finally {
	             
	            try {
	                fileWriter.flush();
	                fileWriter.close();
	            } catch (IOException e) {
	                System.out.println("Error while flushing/closing");
	                e.printStackTrace();
	            }
	             
	    
	
	
    }
    
   

}
    
    
    
}