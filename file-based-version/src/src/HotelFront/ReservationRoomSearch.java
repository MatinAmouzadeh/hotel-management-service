package HotelFront;

import java.io.IOException;

import HotelBack.ReservationSession;
import HotelBack.RoomManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReservationRoomSearch
{

	@FXML
	private Button OkButton;
	
	@FXML
	private Button BackButton;

	@FXML
	private Button DeleteButton;

	@FXML
	private Button DoneButton;

	@FXML
	private Button EditButton;

	@FXML
	private Label LblNightlyPrice;

	@FXML
	private Label LblRoomNumber;

	@FXML
	private Label LblRoomType;

	@FXML
	private Button NaxtRButton;

	@FXML
	private Button NextLButton;

	@FXML
	private MenuItem NightlyPriceSearch;

	@FXML
	private MenuItem RoomNumberSearch;

	@FXML
	private Label LblRoomStatus;

	@FXML
	private MenuItem RoomStatusSearch;

	@FXML
	private MenuItem RoomTypeSearch;

	@FXML
	private MenuButton SearchBy;

	@FXML
	private TextField TextSearch;

	private int selectedSearchType=0;

	private String RoomInformation[]= new String[1000];

	private int CRoomInformation=0;

	private int CButton=0;
	
	private String RoomNumber="";
	
	@FXML
    void OkButtonPressing(ActionEvent event) throws IOException 
    {
    	ReservationSession.selectedRoom=RoomNumber;
    	
    	Stage stage=(Stage)OkButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationInformation.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
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

	@FXML
	void DoneButtonPressing(ActionEvent event) throws IOException 
	{
		if(selectedSearchType!=0)
		{
			RoomManager RoomSearch= new RoomManager();
			CRoomInformation=RoomSearch.Search(TextSearch.getText(), selectedSearchType, RoomInformation);

			if(CRoomInformation==0)
			{
				Alert SearchType= new Alert(Alert.AlertType.WARNING);
				SearchType.setTitle("ERROR");
				SearchType.setHeaderText(null);
				SearchType.setContentText("اتاقی با این مشخصات پیدا نشد");
				SearchType.showAndWait();
				Stage stage=(Stage)DoneButton.getScene().getWindow();
				stage.close();

				Stage primaryStage= new Stage();
				AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationRoomInformation.fxml"));
				Scene scane= new Scene(root, 535, 330);
				primaryStage.setScene(scane);
				primaryStage.show();
			}
			else
			{
				TextSearch.setText("خط "+RoomInformation[0].charAt(0)+"در فایل"+":");

				RoomNumber="";
				String RoomType="";
				String NightlyPrice="";
				String RoomStatus="";

				int K=0;
				for (int x=2; x<RoomInformation[0].length();x++)
				{
					if (RoomInformation[0].charAt(x)=='&')
					{
						K++;
						x++;
					}
					if(K==0)
						RoomNumber+=RoomInformation[0].charAt(x);
					else if(K==1)
						RoomType+=RoomInformation[0].charAt(x);
					else if(K==2)
						NightlyPrice+=RoomInformation[0].charAt(x);
					else if(K==3)
						RoomStatus+=RoomInformation[0].charAt(x);
				}
				LblRoomNumber.setText(RoomNumber);
				LblRoomType.setText(RoomType);
				LblNightlyPrice.setText(NightlyPrice);
				LblRoomStatus.setText(RoomStatus);

			}

		}
		else
		{
			Alert SearchType= new Alert(Alert.AlertType.WARNING);
			SearchType.setTitle("ERROR");
			SearchType.setHeaderText(null);
			SearchType.setContentText("لطفا بخش جست و جو بر اساس... را پر کنید");
			SearchType.showAndWait();
		}
	}

	@FXML

	void NaxtRButtonPressing(ActionEvent event) 
	{
		if(CButton<CRoomInformation-1)
		{
			CButton++;
			TextSearch.setText("خط "+RoomInformation[CButton].charAt(0)+"در فایل"+":");

			RoomNumber="";
			String RoomType="";
			String NightlyPrice="";
			String RoomStatus="";

			int K=0;
			for (int x=2; x<RoomInformation[CButton].length();x++)
			{
				if (RoomInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					RoomNumber+=RoomInformation[CButton].charAt(x);
				else if(K==1)
					RoomType+=RoomInformation[CButton].charAt(x);
				else if(K==2)
					NightlyPrice+=RoomInformation[CButton].charAt(x);
				else if(K==3)
					RoomStatus+=RoomInformation[CButton].charAt(x);
			}
			LblRoomNumber.setText(RoomNumber);
			LblRoomType.setText(RoomType);
			LblNightlyPrice.setText(NightlyPrice);
			LblRoomStatus.setText(RoomStatus);
		}
	}

	@FXML
	void NextLButtonPressing(ActionEvent event) 
	{
		if(CButton>=1)
		{
			CButton--;
			TextSearch.setText("خط "+RoomInformation[CButton].charAt(0)+"در فایل"+":");

			String RoomType="";
			String NightlyPrice="";
			String RoomStatus="";

			int K=0;
			for (int x=2; x<RoomInformation[CButton].length();x++)
			{
				if (RoomInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					RoomNumber+=RoomInformation[CButton].charAt(x);
				else if(K==1)
					RoomType+=RoomInformation[CButton].charAt(x);
				else if(K==2)
					NightlyPrice+=RoomInformation[CButton].charAt(x);
				else if(K==3)
					RoomStatus+=RoomInformation[CButton].charAt(x);
			}
			LblRoomNumber.setText(RoomNumber);
			LblRoomType.setText(RoomType);
			LblNightlyPrice.setText(NightlyPrice);
			LblRoomStatus.setText(RoomStatus);
		}
	}

	@FXML
	void NightlyPriceSearchPressing(ActionEvent event) 
	{
		selectedSearchType=3;
		SearchBy.setText("قیمت شبانه");
		TextSearch.setText("");
	}

	@FXML
	void RoomNumberSearchPressing(ActionEvent event) 
	{
		selectedSearchType=1;
		SearchBy.setText("شماره اتاق");
		TextSearch.setText("");
	}

	@FXML
	void RoomStatusSearchPressing(ActionEvent event) 
	{
		selectedSearchType=4;
		SearchBy.setText("وضعیت");
		TextSearch.setText("");
	}

	@FXML
	void RoomTypeSearchPressing(ActionEvent event) 
	{
		selectedSearchType=2;
		SearchBy.setText("نوع اتاق");
		TextSearch.setText("");
	}

	@FXML
	void SearchByPressing(ActionEvent event) 
	{

	}
}
