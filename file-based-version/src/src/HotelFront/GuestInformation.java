package HotelFront;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.github.mfathi91.time.PersianDate;

import HotelBack.Guest;
import HotelBack.GuestManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuestInformation implements Initializable{
	@FXML
	private Button BackButton;

	@FXML
	private Button SaveButton;

	@FXML
	private TextField TextCodeMelli;

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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
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
		
		TextDateOfRegistration.setText(Today.getYear()+"/"+Month+"/"+Day);
	}

	@FXML
	void SaveButtonPressing(ActionEvent event) throws IOException 
	{
		if(TextCodeMelli.getText()==""||TextFLName.getText()==""
				|| TextDateOfBirth.getText()==""||TextDateOfRegistration.getText()==""
				|| TextPhoneNumber.getText()==""|| TextShShenasname.getText()=="")
		{
			Alert Save= new Alert(Alert.AlertType.WARNING);
			Save.setTitle("ERROR");
			Save.setHeaderText(null);
			Save.setContentText("لطفا اطلاعات خواسته شده رو وارد کنید");
			Save.showAndWait();
		}
		else
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
			else if(FlagAdd==-1)
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("کاربر(کدملی) تکراری");
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
				AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestsAddSearch.fxml"));
				Scene scane= new Scene(root, 535, 330);
				primaryStage.setScene(scane);
				primaryStage.show();
			}
			else
			{
				Alert Save= new Alert(Alert.AlertType.WARNING);
				Save.setTitle("ERROR");
				Save.setHeaderText(null);
				Save.setContentText("مشکل در انجام عملیات");
				Save.showAndWait();
			}
		}
	}

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestsAddSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}



}
