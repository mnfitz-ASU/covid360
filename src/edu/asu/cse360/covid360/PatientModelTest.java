package edu.asu.cse360.covid360;

import static org.junit.Assert.*;

import org.junit.Test;  
import java.beans.*;
public class PatientModelTest
{  
    @Test  
    public void testId()
	{  
		PatientModel patientModel = new PatientModel();

		patientModel.setId(12345);
		assertEquals(12345, patientModel.getId());
		patientModel.setId(67890);
		assertEquals(67890, patientModel.getId());
		patientModel.setId(-12345);
		assertEquals(-12345, patientModel.getId());

		patientModel = new PatientModel(12345,"","","","","");
		assertEquals(12345, patientModel.getId());
		patientModel = new PatientModel(67890,"","","","","");
		assertEquals(67890, patientModel.getId());
		patientModel = new PatientModel(-12345,"","","","","");
		assertEquals(-12345, patientModel.getId());
	}

	@Test
	public void testLastName()
	{  
		PatientModel patientModel = new PatientModel();

		patientModel.setLastName("Smith");
		assertEquals("Smith", patientModel.getLastName());
		patientModel.setLastName("Jones");
		assertEquals("Jones", patientModel.getLastName());
		patientModel.setLastName("Stark");
		assertEquals("Stark", patientModel.getLastName());

		patientModel = new PatientModel(0,"Smith","","","","");
		assertEquals("Smith", patientModel.getLastName());
		patientModel = new PatientModel(0,"Jones","","","","");
		assertEquals("Jones", patientModel.getLastName());
		patientModel = new PatientModel(0,"Stark","","","","");
		assertEquals("Stark", patientModel.getLastName());
	}

	@Test
	public void testFirstName()
	{
		PatientModel patientModel = new PatientModel();

		patientModel.setFirstName("Smith");
		assertEquals("Smith", patientModel.getFirstName());
		patientModel.setFirstName("Jones");
		assertEquals("Jones", patientModel.getFirstName());
		patientModel.setFirstName("Stark");
		assertEquals("Stark", patientModel.getFirstName());

		patientModel = new PatientModel(0,"","Smith","","","");
		assertEquals("Smith", patientModel.getFirstName());
		patientModel = new PatientModel(0,"","Jones","","","");
		assertEquals("Jones", patientModel.getFirstName());
		patientModel = new PatientModel(0,"","Stark","","","");
		assertEquals("Stark", patientModel.getFirstName());
    }  

	@Test
	public void testVaccineType()
	{
		PatientModel patientModel = new PatientModel();

		patientModel.setVaxType("MegaVax");
		assertEquals("MegaVax", patientModel.getVaxType());
		patientModel.setVaxType("UberShot");
		assertEquals("UberShot", patientModel.getVaxType());
		patientModel.setVaxType("BiggsPharma");
		assertEquals("BiggsPharma", patientModel.getVaxType());

		patientModel = new PatientModel(0,"","","MegaVax","","");
		assertEquals("MegaVax", patientModel.getVaxType());
		patientModel = new PatientModel(0,"","","UberShot","","");
		assertEquals("UberShot", patientModel.getVaxType());
		patientModel = new PatientModel(0,"","","BiggsPharma","","");
		assertEquals("BiggsPharma", patientModel.getVaxType());
	}

	@Test
	public void testVaccineDate()
	{
		PatientModel patientModel = new PatientModel();

		patientModel.setVaxDate("1/1/2001");
		assertEquals("1/1/2001", patientModel.getVaxDate());
		patientModel.setVaxDate("2/2/2002");
		assertEquals("2/2/2002", patientModel.getVaxDate());
		patientModel.setVaxDate("3/3/2003");
		assertEquals("3/3/2003", patientModel.getVaxDate());

		patientModel = new PatientModel(0,"","","","1/1/2001","");
		assertEquals("1/1/2001", patientModel.getVaxDate());
		patientModel = new PatientModel(0,"","","","2/2/2002","");
		assertEquals("2/2/2002", patientModel.getVaxDate());
		patientModel = new PatientModel(0,"","","","3/3/2003","");
		assertEquals("3/3/2003", patientModel.getVaxDate());
	}

	@Test
	public void testVaccineLocation()
	{
		PatientModel patientModel = new PatientModel();

		patientModel.setVaxLoc("CVS");
		assertEquals("CVS", patientModel.getVaxLoc());
		patientModel.setVaxLoc("Mayo Clinic");
		assertEquals("Mayo Clinic", patientModel.getVaxLoc());
		patientModel.setVaxLoc("Kaiser Permanente");
		assertEquals("Kaiser Permanente", patientModel.getVaxLoc());

		patientModel = new PatientModel(0,"","","","","CVS");
		assertEquals("CVS", patientModel.getVaxLoc());
		patientModel = new PatientModel(0,"","","","","Mayo Clinic");
		assertEquals("Mayo Clinic", patientModel.getVaxLoc());
		patientModel = new PatientModel(0,"","","","","Kaiser Permanente");
		assertEquals("Kaiser Permanente", patientModel.getVaxLoc());
	}

	@Test
	public void testSomethingChanged()
	{	
		// Notifier = PatientModel.getSupport()
		// Notifier.addPropertyChangeListener(new Listener)
		PatientModel.getSupport().addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent inEvent)
			{
				assertEquals("foobar", inEvent.getPropertyName());
			}
		});

		PatientModel.somethingChanged("foobar");
		
	}

}  