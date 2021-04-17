package edu.asu.cse360.covid360;
import java.util.ArrayList;

//
// This class is responsible for the About page
public class ChartInfo
{
	private ArrayList<String> diffVaxType = new ArrayList<String>();
	private ArrayList<Integer> numVaxType = new ArrayList<Integer>();

	private ArrayList<String> diffVaxLoc = new ArrayList<String>();
	private ArrayList<Integer> numVaxLoc = new ArrayList<Integer>();

	ArrayList<PatientModel> inPatientList = new ArrayList<PatientModel>();

	//constructor
	public ChartInfo(ArrayList<PatientModel> inPatientList)
	{
		this.inPatientList = inPatientList;
		numVaxType.add(0);
		numVaxLoc.add(0);
	}

	//setters
	public void updateChartInfo(){

		String currVaxType;
		int patListLen = inPatientList.size();
		int vaxListLen = diffVaxType.size();
		int temp;

		if(numVaxType.get(0) == 0)
		{
			diffVaxType.add(inPatientList.get(0).getVType());
			temp = numVaxType.get(0) + 1;
			numVaxType.set(0,temp);
		}

		for(int i = 1; i < patListLen; i++)
		{
			vaxListLen = diffVaxType.size();

			currVaxType = inPatientList.get(i).getVType();

			for(int j = 0; j < vaxListLen; j++)
			{
				if(!((diffVaxType.get(j)).equals(currVaxType)) && (vaxListLen-1 == j))
				{
					diffVaxType.add(currVaxType);
					numVaxType.add(1);
				}
				else if((diffVaxType.get(j)).equals(currVaxType))
				{
					temp = numVaxType.get(j) + 1;
					numVaxType.set(j,temp);
					break;
				}
			}
		}

		String currVaxLoc;
		int locListLen = diffVaxLoc.size();

		if(numVaxLoc.get(0) == 0)
		{
			diffVaxLoc.add(inPatientList.get(0).getVLoc());
			temp = numVaxLoc.get(0) + 1;
			numVaxLoc.set(0,temp);
		}

		for(int i = 1; i < patListLen; i++)
		{
			locListLen = diffVaxLoc.size();

			currVaxLoc = inPatientList.get(i).getVLoc();

			for(int j = 0; j < locListLen; j++)
			{
				if(!((diffVaxLoc.get(j)).equals(currVaxLoc)) && (locListLen-1 == j))
				{
					diffVaxLoc.add(currVaxLoc);
					numVaxLoc.add(1);
				}
				else if((diffVaxLoc.get(j)).equals(currVaxLoc))
				{
					temp = numVaxLoc.get(j) + 1;
					numVaxLoc.set(j,temp);
					break;
				}
			}

		}

	}

	//Getters
	public ArrayList<String> getVaxTypes()
	{
		return diffVaxType;
	}

	public ArrayList<Integer> getVaxNum()
	{
		return numVaxType;
	}

	public ArrayList<String> getVaxLocs()
	{
		return diffVaxLoc;
	}

	public ArrayList<Integer> getLocNum()
	{
		return numVaxLoc;
	}

}