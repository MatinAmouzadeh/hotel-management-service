package HotelFront;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Report {

	@FXML
	private Button BackButton;

	@FXML
	private Button GuestsListButton;

	@FXML
	private Button HotelIncomeButton;

	@FXML
	private Button RoomsListButton;

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("HotelStart.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void GuestsListPressing(ActionEvent event) 
	{
		
	}

	@FXML
	void HotelIncomePressing(ActionEvent event) 
	{
		
	}

	@FXML
	void RoomsListButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)RoomsListButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReportRoomList.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

}
