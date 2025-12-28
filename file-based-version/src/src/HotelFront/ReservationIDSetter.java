package HotelFront;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HotelBack.ReservationSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReservationIDSetter implements Initializable {

	@FXML
	private Label LblReservationID;

	@FXML
	private Button OKButton;

	@FXML
	void OKButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)OKButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationsAddSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		LblReservationID.setText(ReservationSession.selectedReservationID);
	}



}
