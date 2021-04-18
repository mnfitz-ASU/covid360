package edu.asu.cse360.covid360;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;

public class Main extends Application 
{
	// Models
	private AboutModel mAboutModel;
	private ArrayList<PatientModel> mPatientList;

	// Views
	private AboutView mAboutView; // Child of mTabPane
	private PatientListView mPatientListView; // Skeleton example pane
	private EmptyView mEmptyView2; // Skeleton example pane
	private EmptyView mEmptyView3; // Skeleton example pane
	private VisualizeView mVisualizeView; // Skeleton example pane
	private TabPane mTabPane; // Container for the tabs

 
	public void start(Stage stage) 
	{
		// Initialize the models
		mAboutModel= new AboutModel();
		mPatientList = new ArrayList<PatientModel>();

		// Initialize the views
		StackPane root = new StackPane();

		mAboutView = new AboutView(mAboutModel);
		mPatientListView = new PatientListView(stage, mPatientList);

		mEmptyView2 = new EmptyView(stage, mPatientList);
		mEmptyView3 = new EmptyView(stage, mPatientList);
		mVisualizeView = new VisualizeView(stage, mPatientList);

		mTabPane = new TabPane();
		mTabPane.setSide(Side.LEFT);

		Tab tab1 = new Tab();
		tab1.setText("About");
		tab1.setContent(mAboutView);

		Tab tab2 = new Tab();
		tab2.setText("Load Data");
		tab2.setContent(mPatientListView);

		Tab tab3 = new Tab();
		tab3.setText("Add Data");
		tab3.setContent(mEmptyView2);

		Tab tab4 = new Tab();
		tab4.setText("Save Data");
		tab4.setContent(mEmptyView3);

		Tab tab5 = new Tab();
		tab5.setText("Visualize Data");
		tab5.setContent(mVisualizeView);

		mTabPane.getSelectionModel().select(0);
		mTabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);

		mTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Remove closing option

		root.getChildren().add(mTabPane);

		// super googled hackery to allow the controller (Main) to 
		// recieve notification that the model (mPatientList) has changed
		PatientModel.getSupport().addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent inEvent)
			{
				mPatientList = mPatientListView.getPatientList();
				// ^^^DO THE SAME FOR ADD DATA^^^
				mVisualizeView.update(mPatientList);
			}
		});
		
		PatientModel testPatient1 = new PatientModel(123, "Ford", "Harrison", 
		"PharmaCorp", "4/18/2021", "Mayo Clinic");
		PatientModel testPatient2 = new PatientModel(456, "Solo", "Han", 
		"MegaVax", "4/19/2021", "Kaiser Permanente");
		PatientModel testPatient3 = new PatientModel(789, "Jones", "Indiana", 
		"UberShot", "4/17/2021", "CVS");

		mPatientList.add(testPatient1);
		mPatientList.add(testPatient2);
		mPatientList.add(testPatient3);
		PatientModel.somethingChanged();

		Scene scene = new Scene(root, 900, 400);
		stage.setTitle("Covid Vaccination Information Application");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
