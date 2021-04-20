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
    

  //Delimiter used in CSV file
    final String COMMA_DELIMITER = ",";
    final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    final String FILE_HEADER = "ID ,Last Name, First Name,Vaccine,Vaccine Location";
   
   // private ArrayList<PatientModel> list= new ArrayList<PatientModel>();
    //PatientModel newPatient;
    private FileWriter fileWriter;
	
    //constructor 
    public SaveData(Stage inStage, ArrayList<PatientModel> mPatientList )
    {
	//LoadView loadView = new LoadView(inStage);
	SaveInfo sPatientList = new SaveInfo(mPatientList);
	sPatientList.updateSave(mPatientList);
	//mPatientList = loadView.getPatientList();
	//mData = FXCollections.observableArrayList(mPatientList);
	 VBox vb1 = new VBox(8);
	 Button b1 = new Button("Save");
	 Label l1=new Label();
	 
	 
	 b1.setOnAction(e-> {
	    
	     
	     if(sPatientList.goal()==false)
		 {
		     l1.setText(sPatientList.message());
		     
		 }
	     else 
	     {
		 l1.setText("Data Saved!");  
		 writeCSV("output.csv", sPatientList);
	     }
	     
	    
         
	 });
	
	
	
	 
	 
	 
	 
	

	vb1.getChildren().addAll(b1,l1);
	this.getChildren().addAll(vb1);
    }
    

    
    private void writeCSV(String f, SaveInfo fm)
    {
	
	
	
	   
	   // PatientModel newPatient = new PatientModel();
	    fileWriter = null;
	    try {
		
	    
	    //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            
            for(int i=1; i< fm.listSize();i++)
            {
        	 //newPatient = obj.getPatientList().get(i);
        	
        	fileWriter.append(String.valueOf( fm.getID().get(i)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf( fm.getLastName().get(i)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf( fm.getFirstName().get(i)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf( fm.Vaccine().get(i)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf( fm.getDate().get(i)));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf( fm.getVaccineLocation().get(i)));
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