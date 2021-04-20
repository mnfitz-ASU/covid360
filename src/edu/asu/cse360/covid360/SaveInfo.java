package edu.asu.cse360.covid360;

import java.util.ArrayList;

public class SaveInfo {

    private ArrayList<Integer> ID =  new ArrayList<Integer>();
    private ArrayList<String> LastName = new ArrayList<String>();
    private ArrayList<String> FirstName = new ArrayList<String>();
    private ArrayList<String> Vaccine = new ArrayList<String>();
    private ArrayList<String> Date = new ArrayList<String>();
    private ArrayList<String> VaccineLocation = new ArrayList<String>();
    private int patListLen=0;
    private String flag = "";
    private Boolean flag1=true;
    
    ArrayList<PatientModel> inPatientList = new ArrayList<PatientModel>();
    
    public SaveInfo(ArrayList<PatientModel> inPatientList)
    {
	this.inPatientList = inPatientList;
	patListLen = inPatientList.size();
	updateSave(inPatientList);
	if(inPatientList.isEmpty())
	{
	    flag="No Data to Save. Please add data!";
	    flag1=false;
	}
    }
    
    public void updateSave(ArrayList<PatientModel> inPatientList2)
    {
	 patListLen = inPatientList.size();
	for(int i = 1; i < patListLen; i++)
	{
	    ID.add(inPatientList.get(1).getId()) ;
	    LastName.add(inPatientList.get(1).getLastName());
	    FirstName.add(inPatientList.get(1).getFirstName());
	    Vaccine.add(inPatientList.get(1).getVaxType());
	    Date.add(inPatientList.get(1).getVaxDate());
	    VaccineLocation.add(inPatientList.get(1).getVaxLoc());
	    
	    
	}
	
	
    }
    
    public ArrayList<Integer> getID(){
	return ID;
    }
    
    public ArrayList<String> getFirstName(){
	return FirstName;
    }
    
    public ArrayList<String> Vaccine(){
	return Vaccine;
    }
    
    public ArrayList<String> getLastName(){
	return LastName;
    }
    
    
    public ArrayList<String> getVaccineLocation(){
	return VaccineLocation;
    }
    
    public ArrayList<String> getDate(){
   	return Date;
       }
    
    public Boolean goal()
    {
	return flag1;
    }
    
    public int listSize()
    {
	return patListLen;
    }
    
    public String message()
    {
	return flag;
    }
}
