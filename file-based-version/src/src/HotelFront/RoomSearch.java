package HotelFront;

import java.io.IOException;

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

public class RoomSearch {

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

	public static int FileRowRoom=0;

	private String RoomInformation[]= new String[1000];

	private int CRoomInformation=0;

	private int CButton=0;

	@FXML
	void BackButtonPressing(ActionEvent event) throws IOException 
	{
		Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomsAddSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
	}

	@FXML
	void DeleteButtonPressing(ActionEvent event) 
	{
		if (FileRowRoom!=0)
		{
			RoomManager RoomDelete= new RoomManager();
			RoomDelete.Delete(FileRowRoom);
			TextSearch.setText("");
			LblRoomNumber.setText("");
			LblRoomType.setText("");
			LblNightlyPrice.setText("");
			LblRoomStatus.setText("");

			Alert Delete= new Alert(Alert.AlertType.WARNING);
			Delete.setTitle("*_*");
			Delete.setHeaderText(null);
			Delete.setContentText("کاربر حذف شد");
			Delete.showAndWait();
		}
		else
		{
			Alert Aption= new Alert(Alert.AlertType.WARNING);
			Aption.setTitle("ERROR");
			Aption.setHeaderText(null);
			Aption.setContentText("لطفا ابتدا عضو رو جست و جو کنین تا ویژگی های حذف و ویرایش فعال شود");
			Aption.showAndWait();
		}
	}

	@FXML
	void DoneButtonPressing(ActionEvent event) 
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
			}
			else
			{
				String FileRowS="";
				for (int x=0; RoomInformation[CButton].charAt(x)!=':'; x++)
				{
					FileRowS+=RoomInformation[CButton].charAt(x);
				}
				FileRowRoom=Integer.parseInt(FileRowS);
				TextSearch.setText("خط "+FileRowRoom+"در فایل"+":");
				
				String RoomNumber="";
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
	void EditButtonPressing(ActionEvent event) throws IOException 
	{
		if (FileRowRoom!=0)
		{	
			Stage stage=(Stage)EditButton.getScene().getWindow();
			stage.close();

			Stage primaryStage= new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomEdit.fxml"));
			Scene scane= new Scene(root, 535, 330);
			primaryStage.setScene(scane);
			primaryStage.show();
		}
		else
		{
			Alert Aption= new Alert(Alert.AlertType.WARNING);
			Aption.setTitle("ERROR");
			Aption.setHeaderText(null);
			Aption.setContentText("لطفا ابتدا عضو رو جست و جو کنین تا ویژگی های حذف و ویرایش فعال شود");
			Aption.showAndWait();
		}
	}

	@FXML
	void NaxtRButtonPressing(ActionEvent event) 
	{
		if(CButton<CRoomInformation-1)
		{
			CButton++;
			String FileRowS="";
			for (int x=0; RoomInformation[CButton].charAt(x)!=':'; x++)
			{
				FileRowS+=RoomInformation[CButton].charAt(x);
			}
			FileRowRoom=Integer.parseInt(FileRowS);
			TextSearch.setText("خط "+FileRowRoom+"در فایل"+":");

			String RoomNumber="";
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
			String FileRowS="";
			for (int x=0; RoomInformation[CButton].charAt(x)!=':'; x++)
			{
				FileRowS+=RoomInformation[CButton].charAt(x);
			}
			FileRowRoom=Integer.parseInt(FileRowS);
			TextSearch.setText("خط "+FileRowRoom+"در فایل"+":");

			String RoomNumber="";
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
