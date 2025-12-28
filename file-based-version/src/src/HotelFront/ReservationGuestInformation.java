package HotelFront;

import java.io.IOException;

import HotelBack.Guest;
import HotelBack.GuestManager;
import HotelBack.ReservationSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReservationGuestInformation {
	@FXML
	private Button BackButton;

	@FXML
	private Button SaveButton;
	
	@FXML
	protected TextField TextCodeMelli;

	@FXML
	private TextField TextFLName;

	@FXML
	private TextField TextDateOfBirth;

	@FXML
	private TextField TextDateOfRegistration;
	
	@FXML
	private TextField TextPhoneNumber;

	@FXML
	private TextField TextShShenasname;
	
	private String CodeMelli="";

	@FXML
	void SaveButtonPressing(ActionEvent event) throws IOException 
	{
		Guest guest= new Guest();
		guest.SetCodeMelli(TextCodeMelli.getText());
		guest.SetFLName(TextFLName.getText());
		guest.SetDateOfBirth(TextDateOfBirth.getText());
		guest.SetDateOfRegistration(TextDateOfRegistration.getText());
		guest.SetPhoneNumber(TextPhoneNumber.getText());
		guest.SetShShenasname(TextShShenasname.getText());
		GuestManager InformationAdd= new GuestManager();
		int FlagAdd=InformationAdd.GuestAdd(guest);
		if(FlagAdd==-2)
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("ERROR");
			Save.setHeaderText(null);
			Save.setContentText("لطفا اطلاعات رو به درستی وارد کنید");
			Save.showAndWait();
		}
		else if(FlagAdd==0)
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("ERROR");
			Save.setHeaderText(null);
			Save.setContentText("به حداکثر تعداد کاربر رسیده اید");
			Save.showAndWait();
		}
		else
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("*_*");
			Save.setHeaderText(null);
			Save.setContentText("ثبت شد");
			Save.showAndWait();
			
	    	ReservationSession.selectedRoom=CodeMelli;
			
			Stage stage=(Stage)SaveButton.getScene().getWindow();
			stage.close();
			
			Stage primaryStage= new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationRoomSearch.fxml"));
			Scene scane= new Scene(root, 535, 330);
			primaryStage.setScene(scane);
			primaryStage.show();
		}
	}

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationGuestSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}
}