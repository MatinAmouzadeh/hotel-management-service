package HotelFront;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RoomsAddSearch {

	@FXML
	private Button RoomSearchButton;

	@FXML
	private Button RoomsAddButton;

	@FXML
	private Button RoomsBackButton;

	@FXML
	void RoomsAddPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)RoomsAddButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomInformation.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void RoomsBackPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)RoomsBackButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("HotelStart.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void RoomsSearchPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)RoomSearchButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

}
