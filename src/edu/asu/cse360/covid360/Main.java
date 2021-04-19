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
	private AddData mAddData = new AddData();
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
		mPatientListView = new PatientListView(stage, mPatientList, PatientListView.Style.LOAD);

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
		tab3.setContent(mAddData);

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
				if (inEvent.getPropertyName() == "PatientListView")
				{
					mPatientList = mPatientListView.getPatientList();
				}
				else if (inEvent.getPropertyName() == "AddData")
				{
					mPatientList.add(mAddData.getPatient());
				}
				else
				{
					//throw new Exception("Unknown Origin for mPatientList (Model) change.");
				}

				mVisualizeView.update(mPatientList);
				mPatientListView.update(mPatientList);
			}
		});
		
		Scene scene = new Scene(root, 900, 400);
		stage.setTitle("Covid Vaccination Information Application");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
