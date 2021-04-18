//visualizer

package edu.asu.cse360.covid360;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



public class VisualizeView extends HBox
{
	private ArrayList<String> diffVaxType = new ArrayList<String>();
	private ArrayList<Integer> numVaxType = new ArrayList<Integer>();

	private ArrayList<String> diffVaxLoc = new ArrayList<String>();
	private ArrayList<Integer> numVaxLoc = new ArrayList<Integer>();


	// constructor
	public VisualizeView(Stage inStage, ArrayList<PatientModel> inPatientList)
	{
		errorLabel = new Label();
		update(inPatientList);
	} 

	public void update(ArrayList<PatientModel> inPatientList)
	{
		//ObservableList<String> aboutList = FXCollections.<String>observableArrayList(/*Displays Input*/);
		//mGroupListView = new ListView<>(aboutList);

		// set up the layout
		//mLabel = new Label();
		//mLabel.setText("Pie Chart");

		this.getChildren().clear();
		
		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(10); // Horizontal gap in pixels

		if(inPatientList.size() > 0)
		{
			ChartInfo chartInfo = new ChartInfo(inPatientList);
			chartInfo.updateChartInfo();
			diffVaxType = chartInfo.getVaxTypes();
			numVaxType = chartInfo.getVaxNum();
			diffVaxLoc = chartInfo.getVaxLocs();
			numVaxLoc = chartInfo.getLocNum();

			//Pie Chart
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

			for(int i = 0; i < diffVaxType.size(); i++)
			{
				pieChartData.add(new PieChart.Data(diffVaxType.get(i), numVaxType.get(i)));
			}

			PieChart chart = new PieChart(pieChartData);
			chart.setTitle("Vaccine Type");

			//Bar Graph
			CategoryAxis xAxis = new CategoryAxis();
			xAxis.setLabel("Locations");

			NumberAxis yAxis = new NumberAxis();
			yAxis.setLabel("Number of People");

			BarChart barChart = new BarChart(xAxis,yAxis);

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("Current Vaccinations");
			barChart.setTitle("Locations of Vaccination");

			for(int i = 0; i < diffVaxLoc.size(); i++)
			{
				dataSeries1.getData().add(new XYChart.Data(diffVaxLoc.get(i), numVaxLoc.get(i)));
			}

			barChart.getData().add(dataSeries1);

			this.getChildren().addAll(chart, barChart);
		}
		else
		{
			errorLabel.setText("No Patient Informtion avalible");
			this.getChildren().addAll(errorLabel);
		}
	}

	// --- Data Members ---
	private Label				errorLabel;

}
