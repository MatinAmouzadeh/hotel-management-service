package HotelFront;

import java.io.IOException;

import HotelBack.GuestManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuestsAddSearch {

	@FXML
	private Button GeustsBackButton;

	@FXML
	private Button GuestsAddButton;

	@FXML
	private Button GuestsSearchButton;

	@FXML
	void GuestsAddPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)GuestsAddButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestInformation.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void GuestsBackPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)GeustsBackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("HotelStart.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void GuestsSearchPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)GuestsSearchButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}
}
