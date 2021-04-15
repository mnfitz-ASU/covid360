package edu.asu.cse360.covid360;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	// an object of TabPane. It will contain createPane and reviewPane under each
	// tab.
	private TabPane tabPane; // Container for the tabs

	private AboutModel mAboutModel= new AboutModel();
	private ArrayList<PatientModel> mPatientList = new ArrayList<PatientModel>();

	// an object of AboutPane.
	private AboutView mAboutView; // Child of tabPane

	private PatientListView mPatientListView; // Skeleton example pane
	private EmptyView mEmptyView2; // Skeleton example pane
	private EmptyView mEmptyView3; // Skeleton example pane
	private EmptyView mEmptyView4; // Skeleton example pane
 
	public void start(Stage stage) 
	{
		StackPane root = new StackPane();

		mAboutView = new AboutView(mAboutModel);

		mPatientListView = new PatientListView(stage, mPatientList);
		mEmptyView2 = new EmptyView(stage, mPatientList);
		mEmptyView3 = new EmptyView(stage, mPatientList);
		mEmptyView4 = new EmptyView(stage, mPatientList);

		tabPane = new TabPane();
		tabPane.setSide(Side.LEFT);

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
		tab5.setContent(mEmptyView4);

		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);

		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Remove closing option

		root.getChildren().add(tabPane);

		Scene scene = new Scene(root, 900, 400);
		stage.setTitle("Covid Vaccination Information Application");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}