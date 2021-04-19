package edu.asu.cse360.covid360;

import java.beans.*;

// 
// This class is responsible for the About page
public class PatientModel
{
	// Data Members
	private int mId = 0;
	private String mLastName = "";
	private String mFirstName = "";
	private String mVaxType = "";
	private String mVaxDate = "";
	private String mVaxLoc = "";
	
	//make nested so i don't have to put it in own .java file
	static class Support // crazy- Support must be static?
	{
		private int mValue;
		private PropertyChangeSupport mSupport;

		public Support() 
		{
			mValue = 0;
			
			// Yucky. I had to make this nested class because I couldn't figure out how
			// to use a raw, PropertyChangeSupport object because the ctor expects
			// a "this" argument.
			mSupport = new PropertyChangeSupport(this);
		}

		public void addPropertyChangeListener(PropertyChangeListener inListener) 
		{
			mSupport.addPropertyChangeListener(inListener);
		}

		public void removePropertyChangeListener(PropertyChangeListener inListener) 
		{
			mSupport.removePropertyChangeListener(inListener);
		}

		public void setChanged(String InOrigin)
		{
			// Yuck. Value must always be different, otherwise I'll never get a change notification.
			mSupport.firePropertyChange(InOrigin, mValue, mValue+1);
			mValue = mValue+1;
		}
	}

	// Static notifier 
	// I wanted to notify Main when Main.mPatientList has changed, I couldn't 
	// figure out how to do it. So instead, I used this static PropertyChangeSupport() 
	// as a notifier to say something, somewhere in the app has changed. 
	// Yucky, but I ran out of time.
	private static Support sSupport = new Support();

	public PatientModel(int inId, String inLastName, String inFirstName, 
						String inVaxType, String inVaxDate, String invacLoc) 
	{
		mId = inId;
		mLastName = inLastName;
		mFirstName = inFirstName;
		mVaxType = inVaxType;
		mVaxDate = inVaxDate;
		mVaxLoc = invacLoc;
	}

	public PatientModel() 
	{
		// This space intentionally empty

		mId = 0;
		mLastName = "Last Name";
		mFirstName = "First Name";
	}
	
	// Getters and Setters
	public int getId()
	{
		return mId;
	}

	public void setId(int inId)
	{
		mId = inId;
	}

	public String getLastName()
	{
		return mLastName;
	}
	
	public void setLastName(String inLastName)
	{
		mLastName = inLastName;
	}

	public String getFirstName()
	{
		return mFirstName;
	}
	
	public void setFirstName(String inFirstName)
	{
		mFirstName = inFirstName;
	}

	public String getVaxType()
	{
		return mVaxType;
	}
	
	public void setVaxType(String inVaxType)
	{
		mVaxType = inVaxType;
	}

	public String getVaxDate()
	{
		return mVaxDate;
	}
	
	public void setVaxDate(String inVaxDate)
	{
		mVaxDate = inVaxDate;
	}

	public String getVaxLoc()
	{
		return mVaxLoc;
	}
	
	public void setVaxLoc(String inVaxLoc)
	{
		mVaxLoc = inVaxLoc;
	}

	// getSupport() notifies for changes to any/all patientModel.
	public static Support getSupport()
	{
		return sSupport;
	}
	
	public static void somethingChanged(String inOrigin)
	{
		getSupport().setChanged(inOrigin);
	}
}

