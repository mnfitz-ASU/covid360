package edu.asu.cse360.covid360;
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
	
	public void setVaxType(String inVType)
	{
		mVaxType = inVType;
	}

	public String getVaxDate()
	{
		return mVaxDate;
	}
	
	public void setVaxDate(String inVDate)
	{
		mVaxDate = inVDate;
	}

	public String getVaxLoc()
	{
		return mVaxLoc;
	}
	
	public void setVaxLoc(String inVLoc)
	{
		mVaxLoc = inVLoc;
	}
}

