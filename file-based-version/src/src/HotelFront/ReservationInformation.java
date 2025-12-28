package HotelFront;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HotelBack.Reservation;
import HotelBack.ReservationManager;
import HotelBack.ReservationSession;
import com.github.mfathi91.time.PersianDate;

public class ReservationInformation implements Initializable{

	@FXML
	private Button addGuestButton;

	@FXML
	private VBox guestListVBox;

	@FXML
	private CheckBox ShowInformation;

	@FXML
	private Button BackButton;

	@FXML
	private Label LblGuestCodeMelli;

	@FXML
	private Label LblRoomNumber;

	@FXML
	private Button SaveButton;

	@FXML
	private TextField TextCheckInDate;

	@FXML
	private TextField TextCheckOutDate;

	@FXML
	private TextField TextReservationDate;

	@FXML
	private TextField TextTotalAmount;

	private int K=0;

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		LblGuestCodeMelli.setText(ReservationSession.selectedGuest);
		LblRoomNumber.setText(ReservationSession.selectedRoom);
		addGuestButton.setOnAction(element -> addGuestField());
		PersianDate Today= PersianDate.now();
		String Month=""+Today.getMonthValue();
		if(Today.getMonthValue()/10==0)
		{
			Month=("0"+Today.getMonthValue());
		}
		
		String Day=""+Today.getDayOfMonth();
		if(Today.getDayOfMonth()/10==0)
		{
			Day=("0"+Today.getDayOfMonth());
		}
		
		TextReservationDate.setText(Today.getYear()+"/"+Month+"/"+Day);
	}

	private void addGuestField() //برای ایجاد کدملی های مهمانان با تعداد نامشخص
	{
		if(K<=6)
		{
			TextField nationalCodeField = new TextField();
			nationalCodeField.setPromptText("کدملی مهمان");
			guestListVBox.getChildren().add(nationalCodeField);
			K++;
		}
		else
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("ERROR");
			Save.setHeaderText(null);
			Save.setContentText("به حداکثر تعداد رسیده اید");
			Save.showAndWait();
		}
	}

	@FXML
	void addGuestButtonPressing(ActionEvent event) 
	{

	}

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationRoomSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();   
	}

	@FXML
	void SaveButtonPressing(ActionEvent event) throws IOException 
	{
		if(TextCheckInDate.getText()==""||TextCheckOutDate.getText()==""
				|| TextReservationDate.getText()==""||TextTotalAmount.getText()=="")
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("ERROR");
			Save.setHeaderText(null);
			Save.setContentText("لطفا اطلاعات خواسته شده رو وارد کنید");
			Save.showAndWait();
		}
		else
		{
			Reservation Reservation= new Reservation();
			Reservation.SetCheckInDate(TextCheckInDate.getText());
			System.out.println(Reservation.GetCheckInDate());
			Reservation.SetCheckOutDate(TextCheckOutDate.getText());
			System.out.println(Reservation.GetCheckOutDate());
			Reservation.SetCompanionsCodeMelli(CreateCompanionsCodeMelli());
			System.out.println(Reservation.GetCompanionsCodeMelli());
			Reservation.SetreservationDate(TextReservationDate.getText());
			System.out.println(Reservation.GetReservationDate());
			Reservation.SetTotalAmount(TextTotalAmount.getText());
			System.out.println(Reservation.GetTotalAmount());
			Reservation.SetRoomNumber(ReservationSession.selectedRoom);
			System.out.println(Reservation.GetRoomNumber());
			Reservation.SetGuestCodeMelli(ReservationSession.selectedGuest);
			System.out.println(Reservation.GetGuestCodeMelli());
			ReservationSession.selectedReservationID=CreateReservationID(ReservationSession.selectedGuest, TextReservationDate.getText(), ReservationSession.selectedRoom);
			Reservation.SetReservationID(ReservationSession.selectedReservationID);
			System.out.println(Reservation.GetReservationID());
			
			ReservationManager InformationAdd= new ReservationManager();
			int FlagAdd=InformationAdd.ReservationAdd(Reservation);
			if(FlagAdd==-2)
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("لطفا اطلاعات رو به درستی وارد کنید");
				Save.showAndWait();
			}
			else if(FlagAdd==-1)
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("رزرو تکراری");
				Save.showAndWait();
			}
			else if(FlagAdd==0)
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("به حداکثر تعداد رزرو رسیده اید");
				Save.showAndWait();
			}
			else if(FlagAdd==1)
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("*_*");
				Save.setHeaderText(null);
				Save.setContentText("ثبت شد");
				Save.showAndWait();
				Stage stage=(Stage)SaveButton.getScene().getWindow();
				stage.close();

				Stage primaryStage= new Stage();
				AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationIDSetter.fxml"));
				Scene scane= new Scene(root, 535, 330);
				primaryStage.setScene(scane);
				primaryStage.show();
			}
			else
			{
				System.out.println("FlagAdd= "+ FlagAdd);
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("مشکل در انجام عملیات");
				Save.showAndWait();
			}
		}
	}
	private String CreateReservationID(String CodeMelli, String ReservationDate, String RoomNumber)
	{
		String Return="";
		Return+=CodeMelli.charAt(8);
		Return+=ReservationDate.charAt(2);
		Return+=CodeMelli.charAt(5);
		Return+=ReservationDate.charAt(5);
		Return+=CodeMelli.charAt(7);
		Return+=ReservationDate.charAt(9);
		Return+=CodeMelli.charAt(2);
		Return+=ReservationDate.charAt(0);
		Return+=CodeMelli.charAt(9);
		Return+=RoomNumber;
		Return+=CodeMelli.charAt(6);
		Return+=ReservationDate.charAt(8);
		Return+=CodeMelli.charAt(0);
		Return+=CodeMelli.charAt(4);
		Return+=ReservationDate.charAt(1);
		Return+=CodeMelli.charAt(3);
		Return+=ReservationDate.charAt(6);
		Return+=CodeMelli.charAt(1);
		Return+=ReservationDate.charAt(3);

		return Return;
	}
	
	private String CreateCompanionsCodeMelli()
	{
		String TextFieldS;
		String Return="";
		for (int x=0; x<K; x++)
		{
			TextFieldS=((TextField) guestListVBox.getChildren().get(x)).getText();
			if(TextFieldS!=null && !TextFieldS.equals(""))
				if(x!=K-1)
					Return+=TextFieldS+"!";
				else if(x==K-1)
					Return+=TextFieldS;
		}
		if (Return.equals(""))
			Return="null";
		return Return;
	}
}
