package edu.asu.cse360.covid360;
import java.util.ArrayList;

// 
// This class is responsible for the About page
public class PatientModel
{
	// Data Members
	private int mId = 0;
	private String mLName = "";
	private String mFName= "";
	private String mVaxType= "";
	private String mVaxDate= "";
	private String mVaxLoc= "";

	public PatientModel() 
	{
		// This space intentionally empty
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

	public String getLName()
	{
		return mLName;
	}
	
	public void setLName(String inLName)
	{
		mLName = inLName;
	}

	public String getFName()
	{
		return mFName;
	}
	
	public void setFName(String inFName)
	{
		mFName = inFName;
	}

	public String getVType()
	{
		return mVaxType;
	}
	
	public void setVType(String inVType)
	{
		mVaxType = inVType;
	}

	public String getVDate()
	{
		return mVaxDate;
	}
	
	public void setVDate(String inVDate)
	{
		mVaxDate = inVDate;
	}

	public String getVLoc()
	{
		return mVaxLoc;
	}
	
	public void setVLoc(String inVLoc)
	{
		mVaxLoc = inVLoc;
	}
}

