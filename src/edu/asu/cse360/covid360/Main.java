package edu.asu.cse360.covid360;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Main extends Application {
	// an object of TabPane. It will contain createPane and reviewPane under each
	// tab.
	private TabPane tabPane; // Container for the tabs

	// an object of CreatePane.
	private CreatePane createPane; // Child of tabPane

	// an object of ReviewPane.
	private ReviewPane reviewPane; // Child of tabPane

	// a list of music objects. It will be used in both CreatePane and ReviewPane.
	private ArrayList<Music> musicList; // createPane lets you add to musicList, reviewPane lets you view

	public void start(Stage stage) {
		StackPane root = new StackPane();

		// musicList to be used in both createPane & reviewPane
		musicList = new ArrayList<Music>();

		reviewPane = new ReviewPane(musicList);
		createPane = new CreatePane(musicList, reviewPane);

		tabPane = new TabPane();

		Tab tab1 = new Tab();
		tab1.setText("Music Creation");
		tab1.setContent(createPane);

		Tab tab2 = new Tab();
		tab2.setText("Music Review");
		tab2.setContent(reviewPane);

		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(tab1, tab2);

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