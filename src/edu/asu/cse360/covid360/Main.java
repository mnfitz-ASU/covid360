package edu.asu.cse360.covid360;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Main extends Application {
	// an object of TabPane. It will contain createPane and reviewPane under each
	// tab.
	private TabPane tabPane; // Container for the tabs

	private About about = new About();

	// an object of AboutPane.
	private AboutPane aboutPane; // Child of tabPane

	// an object of CreatePane.
	private CreatePane createPane; // Child of tabPane

	// an object of ReviewPane.
	private ReviewPane reviewPane; // Child of tabPane

	// a list of music objects. It will be used in both CreatePane and ReviewPane.
	private ArrayList<Music> musicList; // createPane lets you add to musicList, reviewPane lets you view

	private EmptyPane emptyPane1; // Skeleton example pane
	private EmptyPane emptyPane2; // Skeleton example pane
	private EmptyPane emptyPane3; // Skeleton example pane
	private EmptyPane emptyPane4; // Skeleton example pane

	public void start(Stage stage) {
		StackPane root = new StackPane();

		// musicList to be used in both createPane & reviewPane
		musicList = new ArrayList<Music>();

		aboutPane = new AboutPane(about);
		reviewPane = new ReviewPane(musicList);
		createPane = new CreatePane(musicList, reviewPane);
		emptyPane1 = new EmptyPane();
		emptyPane2 = new EmptyPane();
		emptyPane3 = new EmptyPane();
		emptyPane4 = new EmptyPane();

		tabPane = new TabPane();
		tabPane.setSide(Side.LEFT);

		Tab tab1 = new Tab();
		tab1.setText("About");
		tab1.setContent(aboutPane);

		Tab tab2 = new Tab();
		tab2.setText("Load Data");
		tab2.setContent(emptyPane1);

		Tab tab3 = new Tab();
		tab3.setText("Add Data");
		tab3.setContent(emptyPane2);

		Tab tab4 = new Tab();
		tab4.setText("Save Data");
		tab4.setContent(emptyPane3);

		Tab tab5 = new Tab();
		tab5.setText("Visualize Data");
		tab5.setContent(emptyPane4);

		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);

		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Remove closing option

		root.getChildren().add(tabPane);

		Scene scene = new Scene(root, 900, 400);
		stage.setTitle("Music Review Apps");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}