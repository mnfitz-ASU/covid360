package edu.asu.cse360.covid360;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class PatientListView extends VBox 
{
	// constructor
	public PatientListView(Stage inStage,  ArrayList<PatientModel> inPatient) 
	{
		mTable = new TableView<PatientModel>();
		mTable.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
		mTable.setMaxWidth(Double.MAX_VALUE);
		mTable.setMaxHeight(Double.MAX_VALUE);
		mTable.setPlaceholder(new Label("Empty Placeholder"));

		TableColumn idColumn = new TableColumn<>("ID");
		TableColumn lastNameCol = new TableColumn<>("Last Name");
		TableColumn firstNameCol = new TableColumn<>("First Name");
		TableColumn vaxTypeCol = new TableColumn<>("Vaccine Type");
		TableColumn vaxDateCol = new TableColumn<>("Vaccine Date");
		TableColumn vaxLocCol = new TableColumn<>("Vaccine Location");

		idColumn.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width
		lastNameCol.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width
		firstNameCol.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width
		vaxTypeCol.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width
		vaxDateCol.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width
		vaxLocCol.setMaxWidth( 1f * Integer.MAX_VALUE * 15 ); // 15% width

		final ObservableList<PatientModel> data =
        FXCollections.observableArrayList(
            new PatientModel(), new PatientModel());

		// This is bogus. Property value factory will attempt to call get() or is() method names
		// if they exist. So in the case of PatientModel, "Id" refers to PatientModel.getId().
		idColumn.setCellValueFactory(new PropertyValueFactory<PatientModel, Integer>("Id"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<PatientModel, String>("LastName"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<PatientModel, String>("FirstName"));
		vaxTypeCol.setCellValueFactory(new PropertyValueFactory<PatientModel, String>("VaxType"));
		vaxDateCol.setCellValueFactory(new PropertyValueFactory<PatientModel, String>("VaxDate"));
		vaxLocCol.setCellValueFactory(new PropertyValueFactory<PatientModel, String>("VaxLoc"));

		mTable.getColumns().addAll(idColumn, lastNameCol, firstNameCol, vaxTypeCol, vaxDateCol, vaxLocCol);

		mTable.setItems(data);

		// set up the layout

		setPadding(new Insets(10, 10, 10, 100));
		setSpacing(10); // Horizontal gap in pixels

		mScroll = new ScrollPane();

		mScroll.fitToWidthProperty().set(true);
		mScroll.fitToHeightProperty().set(true);

		//Setting content to the scroll pane
		mScroll.setContent(mTable);

		this.getChildren().addAll(mScroll);

	} // end of constructor

	// --- Data Members ---
	private TableView<PatientModel>	mTable;
	private ScrollPane 				mScroll;

}
