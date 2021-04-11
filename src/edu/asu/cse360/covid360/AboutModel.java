package edu.asu.cse360.covid360;
import java.util.ArrayList;

// 
// This class is responsible for the About page
public class AboutModel
{
	// List of teammates
	private ArrayList<String> mGroupList = new ArrayList<String>();

	// Constructor to add all group members
	public AboutModel() 
	{
		mGroupList.add("Matthew Fitzgerald");
		mGroupList.add("Ian Bellerose");
		mGroupList.add("Samriddhi Agnihotri");
		mGroupList.add("Shruti Sunil Ugalmugale");
	}

	// toString() method returns a string containg all teammates
	public String getGroup() 
	{
		String result = "";
		for (String i : mGroupList)
		{
			result += i;
			result += "\n";
		}
		return result;
	}
}

