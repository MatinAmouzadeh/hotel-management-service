package HotelFront;

import java.io.IOException;

import HotelBack.GuestManager;
import HotelBack.ReservationSession;
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

public class ReservationGuestSearch {

    @FXML
    private Button BackButton;

    @FXML
    private MenuItem CodeMelliSearch;

    @FXML
    private MenuItem DateOfBirthSearch;

    @FXML
    private MenuItem DateOfRegistrationSearch;

    @FXML
    private Button DoneButton;

    @FXML
    private MenuItem FLNameSearch;

    @FXML
    private Label LblCodeMelli;

    @FXML
    private Label LblDateOfBirth;

    @FXML
    private Label LblDateOfRegistration;

    @FXML
    private Label LblFLName;

    @FXML
    private Label LblPhoneNumber;

    @FXML
    private Label LblShShenasname;

    @FXML
    private Button NaxtRButton;

    @FXML
    private Button NextLButton;

    @FXML
    private Button OkButton;

    @FXML
    private MenuItem PhoneNumberSearch;

    @FXML
    private MenuButton SearchBy;

    @FXML
    private MenuItem ShShenasnameSearch;

    @FXML
    private TextField TextSearch;
    
    private int selectedSearchType=0;

	private String GuestInformation[]= new String[1000];

	private int CGuestInformation=0;

	private int CButton=0;
	
	private String CodeMelli="";

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
    void CodeMelliSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=1;
		SearchBy.setText("کدملی");
		TextSearch.setText("");
    }

    @FXML
    void DateOfBirthSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=4;
		SearchBy.setText("تاریخ تولد");
		TextSearch.setText("");
    }

    @FXML
    void DateOfRegistrationSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=6;
		SearchBy.setText("تاریخ ثبت نام");
		TextSearch.setText("");
    }

    @FXML
    void DoneButtonPressing(ActionEvent event) throws IOException 
    {
    	if(selectedSearchType!=0)
		{
			GuestManager GuestSearch= new GuestManager();
			CGuestInformation=GuestSearch.Search(TextSearch.getText(), selectedSearchType, GuestInformation);

			if(CGuestInformation==0)
			{
				Alert SearchType= new Alert(Alert.AlertType.WARNING);
				SearchType.setTitle("ERROR");
				SearchType.setHeaderText(null);
				SearchType.setContentText("کاربری با این مشخصات پیدا نشد");
				SearchType.showAndWait();
				
				Stage stage=(Stage)DoneButton.getScene().getWindow();
				stage.close();

				Stage primaryStage= new Stage();
				AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationGuestInformation.fxml"));
				Scene scane= new Scene(root, 535, 330);
				primaryStage.setScene(scane);
				primaryStage.show();
			}
			else
			{
				TextSearch.setText("خط "+GuestInformation[0].charAt(0)+"در فایل"+":");

				CodeMelli="";
				String FLName="";
				String ShShenasname="";
				String DateOfBirth="";
				String PhoneNumber="";
				String DateOfRegistration="";
				int K=0;
				for (int x=2; x<GuestInformation[0].length();x++)
				{
					if (GuestInformation[0].charAt(x)=='&')
					{
						K++;
						x++;
					}
					if(K==0)
						CodeMelli+=GuestInformation[0].charAt(x);
					else if(K==1)
						FLName+=GuestInformation[0].charAt(x);
					else if(K==2)
						ShShenasname+=GuestInformation[0].charAt(x);
					else if(K==3)
						DateOfBirth+=GuestInformation[0].charAt(x);
					else if(K==4)
						PhoneNumber+=GuestInformation[0].charAt(x);
					else 
						DateOfRegistration+=GuestInformation[0].charAt(x);
				}
				LblCodeMelli.setText(CodeMelli);
				LblFLName.setText(FLName);
				LblShShenasname.setText(ShShenasname);
				LblDateOfBirth.setText(DateOfBirth);
				LblPhoneNumber.setText(PhoneNumber);
				LblDateOfRegistration.setText(DateOfRegistration);
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
    void FLNameSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=2;
		SearchBy.setText("نام و نام خانوادگی");
		TextSearch.setText("");
    }

    @FXML
    void NaxtRButtonPressing(ActionEvent event) 
    {
    	if(CButton<CGuestInformation-1)
		{
			CButton++;
			TextSearch.setText("خط "+GuestInformation[CButton].charAt(0)+"در فایل"+":");

			CodeMelli="";
			String FLName="";
			String ShShenasname="";
			String DateOfBirth="";
			String PhoneNumber="";
			String DateOfRegistration="";

			int K=0;
			for (int x=2; x<GuestInformation[CButton].length();x++)
			{
				if (GuestInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					CodeMelli+=GuestInformation[CButton].charAt(x);
				else if(K==1)
					FLName+=GuestInformation[CButton].charAt(x);
				else if(K==2)
					ShShenasname+=GuestInformation[CButton].charAt(x);
				else if(K==3)
					DateOfBirth+=GuestInformation[CButton].charAt(x);
				else if(K==4)
					PhoneNumber+=GuestInformation[CButton].charAt(x);
				else 
					DateOfRegistration+=GuestInformation[CButton].charAt(x);
			}
			LblCodeMelli.setText(CodeMelli);
			LblFLName.setText(FLName);
			LblShShenasname.setText(ShShenasname);
			LblDateOfBirth.setText(DateOfBirth);
			LblPhoneNumber.setText(PhoneNumber);
			LblDateOfRegistration.setText(DateOfRegistration);
		}
    }

    @FXML
    void NextLButtonPressing(ActionEvent event) 
    {
    	if(CButton>=1)
		{
			CButton--;
			TextSearch.setText("خط "+GuestInformation[CButton].charAt(0)+"در فایل"+":");

			CodeMelli="";
			String FLName="";
			String ShShenasname="";
			String DateOfBirth="";
			String PhoneNumber="";
			String DateOfRegistration="";

			int K=0;
			for (int x=2; x<GuestInformation[CButton].length();x++)
			{
				if (GuestInformation[CButton].charAt(x)=='&')
				{
					K++;
					x++;
				}
				if(K==0)
					CodeMelli+=GuestInformation[CButton].charAt(x);
				else if(K==1)
					FLName+=GuestInformation[CButton].charAt(x);
				else if(K==2)
					ShShenasname+=GuestInformation[CButton].charAt(x);
				else if(K==3)
					DateOfBirth+=GuestInformation[CButton].charAt(x);
				else if(K==4)
					PhoneNumber+=GuestInformation[CButton].charAt(x);
				else 
					DateOfRegistration+=GuestInformation[CButton].charAt(x);
			}
			LblCodeMelli.setText(CodeMelli);
			LblFLName.setText(FLName);
			LblShShenasname.setText(ShShenasname);
			LblDateOfBirth.setText(DateOfBirth);
			LblPhoneNumber.setText(PhoneNumber);
			LblDateOfRegistration.setText(DateOfRegistration);
		}
    }

    @FXML
    void OkButtonPressing(ActionEvent event) throws IOException 
    {
    	ReservationSession.clearSession();
    	ReservationSession.selectedGuest=CodeMelli;
    	
    	Stage stage=(Stage)OkButton.getScene().getWindow();
		stage.close();
		
		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationRoomSearch.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
    }

    @FXML
    void PhoneNumberSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=5;
		SearchBy.setText("شماره تلفن");
		TextSearch.setText("");
    }

    @FXML
    void SearchByPressing(ActionEvent event) 
    {

    }

    @FXML
    void ShShenasnameSearchPressing(ActionEvent event) 
    {
    	selectedSearchType=3;
		SearchBy.setText("شماره شناسنامه");
		TextSearch.setText("");
    }

}
