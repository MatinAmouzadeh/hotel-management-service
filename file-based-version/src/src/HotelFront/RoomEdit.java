package HotelFront;

import java.io.IOException;

import HotelBack.RoomManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RoomEdit {

    @FXML
    private Button CancelButton;

    @FXML
    private Button OkButton;

    @FXML
    private MenuItem RoomReserved;

    @FXML
    private MenuButton RoomStatus;

    @FXML
    private MenuButton RoomType;

    @FXML
    private MenuItem RoomTypeSuite;

    @FXML
    private MenuItem RoomTypeVIP;

    @FXML
    private MenuItem RoomTypeNormal;

    @FXML
    private MenuItem RoomUnderMaintenance;

    @FXML
    private MenuItem RoomVacant;

    @FXML
    private TextField TextNightlyPrice;

    @FXML
    private TextField TextRoomNumber;
        
    private String RoomStatusMenuButton;
    
    private String RoomTypeMenuButton;

    @FXML
    void CancelButtonPressing(ActionEvent event) throws IOException {
    	Stage stage=(Stage)CancelButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomSearch.fxml"));
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
    	RoomManager RoomEdit= new RoomManager();
    	System.out.println("FILEROW= " + RoomSearch.FileRowRoom);
    	
    	if(TextRoomNumber!=null && !TextRoomNumber.getText().trim().isEmpty())
    		flag1=RoomEdit.Edit(RoomSearch.FileRowRoom, 1, TextRoomNumber.getText());
    	
    	if(RoomTypeMenuButton!=null)
    		flag2=RoomEdit.Edit(RoomSearch.FileRowRoom, 2, RoomTypeMenuButton);
    	
    	if(TextNightlyPrice!=null && !TextNightlyPrice.getText().trim().isEmpty())
    		flag3=RoomEdit.Edit(RoomSearch.FileRowRoom, 3, TextNightlyPrice.getText());
    	
    	if(RoomStatusMenuButton!=null)
    		flag4=RoomEdit.Edit(RoomSearch.FileRowRoom, 4, RoomStatusMenuButton);
    	
    	
    	if(flag1==-1 || flag2==-1 || flag3==-1 || flag4==-1)
    	{
    		Alert Edit= new Alert(Alert.AlertType.WARNING);
    		Edit.setTitle("ERROR");
    		Edit.setHeaderText(null);
    		Edit.setContentText("لطفا ورودی معتبر برای ویرایش وارد کنید");
    		Edit.showAndWait();
    	}
    	else if(flag1==0 || flag2==0 || flag3==0 || flag4==0)
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
        	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomSearch.fxml"));
        	Scene scane= new Scene(root, 535, 330);
        	primaryStage.setScene(scane);
        	primaryStage.show();
    	}
    }

    @FXML
    void RoomReservedPressing(ActionEvent event) 
    {
    	RoomStatusMenuButton="Reserved";
    	RoomStatus.setText("رزرو شده");
    }

    @FXML
    void RoomStatusPressing(ActionEvent event) {

    }

    @FXML
    void RoomTypeNormalPressing(ActionEvent event) 
    {
    	RoomTypeMenuButton="Normal";
    	RoomType.setText("معمولی");
    }

    @FXML
    void RoomTypePressing(ActionEvent event) {

    }

    @FXML
    void RoomTypeSuitePressing(ActionEvent event) {
    	RoomTypeMenuButton="Suite";
    	RoomType.setText("سوئیت");
    }

    @FXML
    void RoomTypeVIPPressing(ActionEvent event) {
    	RoomTypeMenuButton="VIP";
    	RoomType.setText("ویژه");
    }

    @FXML
    void RoomUnderMaintenancePressing(ActionEvent event) {
    	RoomStatusMenuButton="Under Maintenance";
    	RoomStatus.setText("در دست تعمیر");
    }

    @FXML
    void RoomVacantPressing(ActionEvent event) {
    	RoomStatusMenuButton="Vacant";
    	RoomStatus.setText("خالی");
    }

}
