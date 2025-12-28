package HotelFront;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.github.mfathi91.time.PersianDate;

import HotelBack.GuestManager;
import HotelBack.ReservationManager;
import HotelBack.ReservationSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReservationEdit implements Initializable{

    @FXML
    private Button CancelButton;

    @FXML
    private Button OkButton;

    @FXML
    private TextField TextCheckInDate;

    @FXML
    private TextField TextCheckOutDate;

    @FXML
    private TextField TextCodeMelli;

    @FXML
    private TextField TextReservationDate;

    @FXML
    private TextField TextRoomNumber;

    @FXML
    private TextField TextTotalAmount;

    @FXML
    private Button addGuestButton;
    
    @FXML
    private VBox guestListVBox;
    
    private int K=0;

    @FXML
    void CancelButtonPressing(ActionEvent event) throws IOException {
    	Stage stage=(Stage)CancelButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void OkButtonPressing(ActionEvent event) throws IOException {
    	int flag1=1;
    	int flag2=1;
    	int flag3=1;
    	int flag4=1;
    	int flag5=1;
    	int flag6=1;
    	ReservationManager ReservationEdit= new ReservationManager();
    	if(TextCodeMelli!=null && !TextCodeMelli.getText().trim().isEmpty())
    		flag1=ReservationEdit.Edit(GuestSearch.FileRow, 2, TextCodeMelli.getText());
    	
    	if(CreateCompanionsCodeMelli()!=null && !CreateCompanionsCodeMelli().trim().isEmpty())
    		flag6=ReservationEdit.Edit(GuestSearch.FileRow, 3, CreateCompanionsCodeMelli());
    	
    	if(TextRoomNumber!=null && !TextRoomNumber.getText().trim().isEmpty())
    		flag5=ReservationEdit.Edit(GuestSearch.FileRow, 4, TextRoomNumber.getText());
    	
    	if(TextCheckInDate!=null && !TextCheckInDate.getText().trim().isEmpty())
    		flag2=ReservationEdit.Edit(GuestSearch.FileRow, 5, TextCheckInDate.getText());
    	
    	if(TextCheckOutDate!=null && !TextCheckOutDate.getText().trim().isEmpty())
    		flag3=ReservationEdit.Edit(GuestSearch.FileRow, 6, TextCheckOutDate.getText());
    	
    	if(TextTotalAmount!=null && !TextTotalAmount.getText().trim().isEmpty())
    		flag6=ReservationEdit.Edit(GuestSearch.FileRow, 7, TextTotalAmount.getText());
    	
    	if(TextReservationDate!=null && !TextReservationDate.getText().trim().isEmpty())
    		flag4=ReservationEdit.Edit(GuestSearch.FileRow, 8, TextReservationDate.getText());
 
    	System.out.println(flag1);
    	System.out.println(flag2);
    	System.out.println(flag3);
    	System.out.println(flag4);
    	System.out.println(flag5);
    	System.out.println(flag6);
    	
    	if(flag1==-1 || flag2==-1 || flag3==-1 || flag4==-1 || flag5==-1 || flag6==-1)
    	{
    		Alert Edit= new Alert(Alert.AlertType.WARNING);
    		Edit.setTitle("ERROR");
    		Edit.setHeaderText(null);
    		Edit.setContentText("لطفا ورودی معتبر برای ویرایش وارد کنید");
    		Edit.showAndWait();
    	}
    	else if(flag1==0 || flag2==0 || flag3==0 || flag4==0 || flag5==0 || flag6==0)
    	{
    		Alert Edit= new Alert(Alert.AlertType.WARNING);
    		Edit.setTitle("ERROR");
    		Edit.setHeaderText(null);
    		Edit.setContentText("مشکل در فرایند ویرایش");
    		Edit.showAndWait();
    	}
    	else
    	{
    		Alert Edit= new Alert(Alert.AlertType.WARNING);
    		Edit.setTitle("*__*");
    		Edit.setHeaderText(null);
    		Edit.setContentText("با موفقیت ویرایش شد");
    		Edit.showAndWait();
    		
    		Stage stage=(Stage)OkButton.getScene().getWindow();
        	stage.close();
        	
        	Stage primaryStage= new Stage();
        	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationSearch.fxml"));
        	Scene scane= new Scene(root, 535, 330);
        	primaryStage.setScene(scane);
        	primaryStage.show();
    	}
    }

    @FXML
    void addGuestButtonPressing(ActionEvent event) {
    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		addGuestButton.setOnAction(element -> addGuestField());
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
