package HotelFront;

import java.io.IOException;

import HotelBack.GuestManager;
import HotelBack.ReservationManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReservationSearch {

	@FXML
	private Button BackButton;

	@FXML
	private MenuItem CheckInDateSearch;

	@FXML
	private MenuItem CheckOutDateSearch;

	@FXML
	private Button DeleteButton;

	@FXML
	private Button DoneButton;

	@FXML
	private Button EditButton;

	@FXML
	private MenuItem GuestCodeMelliSearch;

	@FXML
	private ListView<String> CompanionsCodeMelliList;

	@FXML
	private Label LblCheckInDate;

	@FXML
	private Label LblCheckOutDate;

	@FXML
	private Label LblCompanionsCodeMelli;

	@FXML
	private Label LblGuestCodeMelli;

	@FXML
	private Label LblReservationDate;

	@FXML
	private Label LblReservationID;

	@FXML
	private Label LblRoomNumber;

	@FXML
	private Label LblTotalAmount;

	@FXML
	private Button NaxtRButton;

	@FXML
	private Button NextLButton;

	@FXML
	private MenuItem ReservationIDSearch;

	@FXML
	private MenuButton SearchBy;

	@FXML
	private TextField TextSearch;

	private int selectedSearchType=0;

	public static int FileRow=0;

	private String ReservationInformation[]= new String[1000];

	private int CReservationInformation=0;

	private int CButton=0;

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationsAddSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void CheckInDateSearchPressing(ActionEvent event) 
	{
		selectedSearchType=3;
		SearchBy.setText("تاریخ ورود");
		TextSearch.setText("");
	}

	@FXML
	void CheckOutDateSearchPressing(ActionEvent event) 
	{
		selectedSearchType=4;
		SearchBy.setText("تاریخ خروج");
		TextSearch.setText("");
	}

	@FXML
	void DeleteButtonPressing(ActionEvent event)
	{
		if (FileRow!=0)
		{
			ReservationManager ReservationDelete= new ReservationManager();
			ReservationDelete.Delete(FileRow);
			TextSearch.setText("");
			LblCheckInDate.setText("");
			LblCheckOutDate.setText("");
			LblCompanionsCodeMelli.setText("");
			LblGuestCodeMelli.setText("");
			LblReservationDate.setText("");
			LblReservationID.setText("");
			LblRoomNumber.setText("");
			LblTotalAmount.setText("");

			Alert Delete= new Alert(Alert.AlertType.WARNING);
			Delete.setTitle("*_*");
			Delete.setHeaderText(null);
			Delete.setContentText("رزرو حذف شد");
			Delete.showAndWait();
		}
		else
		{
			Alert Aption= new Alert(Alert.AlertType.WARNING);
			Aption.setTitle("ERROR");
			Aption.setHeaderText(null);
			Aption.setContentText("لطفا ابتدا رزرو رو جست و جو کنین تا ویژگی های حذف و ویرایش فعال شود");
			Aption.showAndWait();
		}
	}

	@FXML
	void DoneButtonPressing(ActionEvent event) 
	{
		if(selectedSearchType!=0)
		{
			ReservationManager ReservationSearch= new ReservationManager();
			CReservationInformation=ReservationSearch.Search(TextSearch.getText(), selectedSearchType, ReservationInformation);

			if(CReservationInformation==0)
			{
				Alert SearchType= new Alert(Alert.AlertType.WARNING);
				SearchType.setTitle("ERROR");
				SearchType.setHeaderText(null);
				SearchType.setContentText("رزروی با این مشخصات پیدا نشد");
				SearchType.showAndWait();
			}
			else
			{
				String FileRowS="";
				for (int x=0; ReservationInformation[CButton].charAt(x)!=':'; x++)
				{
					FileRowS+=ReservationInformation[CButton].charAt(x);
				}
				FileRow=Integer.parseInt(FileRowS);
				TextSearch.setText("خط "+FileRow+"در فایل"+":");

				String ReservationID="";
				String GuestCodeMelli="";
				String CompanionsCodeMelli="";
				String RoomNumber="";
				String CheckInDate="";
				String CheckOutDate="";
				String TotalAmount="";
				String ReservationDate="";
				int K=0;
				for (int x=2; x<ReservationInformation[0].length();x++)
				{
					if (ReservationInformation[0].charAt(x)=='&')
					{
						K++;
						x++;
					}
					if(K==0)
						ReservationID+=ReservationInformation[0].charAt(x);
					else if(K==1)
						GuestCodeMelli+=ReservationInformation[0].charAt(x);
					else if(K==2)
						CompanionsCodeMelli+=ReservationInformation[0].charAt(x);
					else if(K==3)
						RoomNumber+=ReservationInformation[0].charAt(x);
					else if(K==4)
						CheckInDate+=ReservationInformation[0].charAt(x);
					else if(K==5)
						CheckOutDate+=ReservationInformation[0].charAt(x);
					else if(K==6)
						TotalAmount+=ReservationInformation[0].charAt(x);
					else if(K==7)
						ReservationDate+=ReservationInformation[0].charAt(x);
				}
				LblReservationID.setText(ReservationID);
				LblGuestCodeMelli.setText(GuestCodeMelli);
				SetCompanionsCodeMelliList(CompanionsCodeMelli);
				LblRoomNumber.setText(RoomNumber);
				LblCheckInDate.setText(CheckInDate);
				LblCheckOutDate.setText(CheckOutDate);
				LblTotalAmount.setText(TotalAmount);
				LblReservationDate.setText(ReservationDate);
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
	void EditButtonPressing(ActionEvent event) throws IOException 
	{
		if (FileRow!=0)
		{
			Stage stage=(Stage)EditButton.getScene().getWindow();
			stage.close();

			Stage primaryStage= new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationEdit.fxml"));
			Scene scane= new Scene(root, 535, 330);
			primaryStage.setScene(scane);
			primaryStage.show();
		}
		else
		{
			Alert Aption= new Alert(Alert.AlertType.WARNING);
			Aption.setTitle("ERROR");
			Aption.setHeaderText(null);
			Aption.setContentText("لطفا ابتدا رزرو رو جست و جو کنین تا ویژگی های حذف و ویرایش فعال شود");
			Aption.showAndWait();
		}
	}

	@FXML
	void GuestCodeMelliSearchPressing(ActionEvent event) 
	{
		selectedSearchType=2;
		SearchBy.setText("کدملی مهمان");
		TextSearch.setText("");
	}

	@FXML
	void NaxtRButtonPressing(ActionEvent event) 
	{
		if(CButton<CReservationInformation-1)
		{
			CButton++;
			String FileRowS="";
			for (int x=0; ReservationInformation[CButton].charAt(x)!=':'; x++)
			{
				FileRowS+=ReservationInformation[CButton].charAt(x);
			}
			FileRow=Integer.parseInt(FileRowS);
			TextSearch.setText("خط "+FileRow+"در فایل"+":");

			String ReservationID="";
			String GuestCodeMelli="";
			String CompanionsCodeMelli="";
			String RoomNumber="";
			String CheckInDate="";
			String CheckOutDate="";
			String TotalAmount="";
			String ReservationDate="";

			int K=0;
			for (int x=2; x<ReservationInformation[CButton].length();x++)
			{
				if (ReservationInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					ReservationID+=ReservationInformation[CButton].charAt(x);
				else if(K==1)
					GuestCodeMelli+=ReservationInformation[CButton].charAt(x);
				else if(K==2)
					CompanionsCodeMelli+=ReservationInformation[CButton].charAt(x);
				else if(K==3)
					RoomNumber+=ReservationInformation[CButton].charAt(x);
				else if(K==4)
					CheckInDate+=ReservationInformation[CButton].charAt(x);
				else if(K==5)
					CheckOutDate+=ReservationInformation[CButton].charAt(x);
				else if(K==6)
					TotalAmount+=ReservationInformation[CButton].charAt(x);
				else if(K==7)
					ReservationDate+=ReservationInformation[CButton].charAt(x);
			}
			LblReservationID.setText(ReservationID);
			LblGuestCodeMelli.setText(GuestCodeMelli);
			SetCompanionsCodeMelliList(CompanionsCodeMelli);
			LblRoomNumber.setText(RoomNumber);
			LblCheckInDate.setText(CheckInDate);
			LblCheckOutDate.setText(CheckOutDate);
			LblTotalAmount.setText(TotalAmount);
			LblReservationDate.setText(ReservationDate);
		}
	}

	@FXML
	void NextLButtonPressing(ActionEvent event) 
	{
		if(CButton>=1)
		{
			CButton--;
			String FileRowS="";
			for (int x=0; ReservationInformation[CButton].charAt(x)!=':'; x++)
			{
				FileRowS+=ReservationInformation[CButton].charAt(x);
			}
			FileRow=Integer.parseInt(FileRowS);
			TextSearch.setText("خط "+FileRow+"در فایل"+":");

			String ReservationID="";
			String GuestCodeMelli="";
			String CompanionsCodeMelli="";
			String RoomNumber="";
			String CheckInDate="";
			String CheckOutDate="";
			String TotalAmount="";
			String ReservationDate="";

			int K=0;
			for (int x=2; x<ReservationInformation[CButton].length();x++)
			{
				if (ReservationInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					ReservationID+=ReservationInformation[CButton].charAt(x);
				else if(K==1)
					GuestCodeMelli+=ReservationInformation[CButton].charAt(x);
				else if(K==2)
					CompanionsCodeMelli+=ReservationInformation[CButton].charAt(x);
				else if(K==3)
					RoomNumber+=ReservationInformation[CButton].charAt(x);
				else if(K==4)
					CheckInDate+=ReservationInformation[CButton].charAt(x);
				else if(K==5)
					CheckOutDate+=ReservationInformation[CButton].charAt(x);
				else if(K==6)
					TotalAmount+=ReservationInformation[CButton].charAt(x);
				else if(K==7)
					ReservationDate+=ReservationInformation[CButton].charAt(x);
			}
			LblReservationID.setText(ReservationID);
			LblGuestCodeMelli.setText(GuestCodeMelli);
			SetCompanionsCodeMelliList(CompanionsCodeMelli);
			LblRoomNumber.setText(RoomNumber);
			LblCheckInDate.setText(CheckInDate);
			LblCheckOutDate.setText(CheckOutDate);
			LblTotalAmount.setText(TotalAmount);
			LblReservationDate.setText(ReservationDate);
		}
	}

	@FXML
	void ReservationIDSearchPressing(ActionEvent event) 
	{
		selectedSearchType=1;
		SearchBy.setText("شماره رزرو");
		TextSearch.setText("");
	}

	@FXML
	void SearchByPressing(ActionEvent event) 
	{

	}

	private void SetCompanionsCodeMelliList(String DataString)
	{
		CompanionsCodeMelliList.getItems().clear();

		if(DataString != null)
		{
			String Data1="";
			String Data2="";
			String Data3="";
			String Data4="";
			String Data5="";
			String Data6="";
			String Data7="";
			int K=0;
			
			for(int x=0; x<DataString.length()-1; x++)
			{
				System.out.println("X= " + x);
				
				if (DataString.charAt(x)=='!')
				{
					K++;
					x++;
				}

				if(K==0)
					Data1+=DataString.charAt(x);
				else if(K==1)
					Data2+=DataString.charAt(x);
				else if(K==2)
					Data3+=DataString.charAt(x);
				else if(K==3)
					Data4+=DataString.charAt(x);
				else if(K==4)
					Data5+=DataString.charAt(x);
				else if(K==5)
					Data6+=DataString.charAt(x);
				else if(K==6)
					Data7+=DataString.charAt(x);
			}
			if (!Data1.isEmpty())
				CompanionsCodeMelliList.getItems().add(Data1);
			if (!Data2.isEmpty())
				CompanionsCodeMelliList.getItems().add(Data2);
			if (!Data3.isEmpty()) 
				CompanionsCodeMelliList.getItems().add(Data3);
			if (!Data4.isEmpty()) 
				CompanionsCodeMelliList.getItems().add(Data4);
			if (!Data5.isEmpty()) 
				CompanionsCodeMelliList.getItems().add(Data5);
			if (!Data6.isEmpty()) 
				CompanionsCodeMelliList.getItems().add(Data6);
			if (!Data7.isEmpty()) 
				CompanionsCodeMelliList.getItems().add(Data7);
		}
		else
			CompanionsCodeMelliList.getItems().add("خالی");
	}
	
}
