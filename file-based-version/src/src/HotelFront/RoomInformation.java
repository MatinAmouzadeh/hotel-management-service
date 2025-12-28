package HotelFront;

import java.io.IOException;

import HotelBack.Room;
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

public class RoomInformation {

	@FXML
	private Button BackButton;

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
	private MenuItem RoomTypenNormal;

	@FXML
	private MenuItem RoomUnderMaintenance;

	@FXML
	private MenuItem RoomVacant;

	@FXML
	private Button SaveButton;

	@FXML
	private TextField TextNightlyPrice;

	@FXML
	private TextField TextRoomNumber;

	private String SRoomType="";

	private String SRoomStatus="";

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
	void RoomReservedPressing(ActionEvent event) 
	{
		SRoomStatus="Reserved";
		RoomStatus.setText("رزرو شده");
	}

	@FXML
	void RoomStatusPressing(ActionEvent event) 
	{

	}

	@FXML
	void RoomTypeNormalPressing(ActionEvent event) 
	{
		SRoomType="Normal";
		RoomType.setText("معمولی");
	}

	@FXML
	void RoomTypePressing(ActionEvent event) 
	{

	}

	@FXML
	void RoomTypeSuitePressing(ActionEvent event) 
	{
		SRoomType="Suite";
		RoomType.setText("سوئیت");
	}

	@FXML
	void RoomTypeVIPPressing(ActionEvent event) 
	{
		SRoomType="VIP";
		RoomType.setText("VIP");
	}

	@FXML
	void RoomUnderMaintenancePressing(ActionEvent event) 
	{
		SRoomStatus="Under Maintenance";
		RoomStatus.setText("در حال تعمیر");
	}

	@FXML
	void RoomVacantPressing(ActionEvent event) 
	{
		SRoomStatus="Vacant";
		RoomStatus.setText("خالی");
	}

	@FXML
	void SaveButtonPressing(ActionEvent event) throws IOException 
	{
		if(TextRoomNumber.getText()==""||SRoomType==null || TextNightlyPrice.getText()==""||SRoomStatus==null)
		{
			Alert Delete= new Alert(Alert.AlertType.WARNING);
			Delete.setTitle("ERROR");
			Delete.setHeaderText(null);
			Delete.setContentText("لطفا اطلاعات خواسته شده رو وارد کنید");
			Delete.showAndWait();
		}
		else
		{
			Room room= new Room();
			room.setRoomNumber(TextRoomNumber.getText());
			room.setRoomType(SRoomType);
			room.setNightlyPrice(TextNightlyPrice.getText());
			room.setRoomStatus(SRoomStatus);

			RoomManager RoomInformation= new RoomManager();
			int FlagAdd=RoomInformation.AddRoom(room);
			if(FlagAdd==-2)
			{
				Alert Delete= new Alert(Alert.AlertType.WARNING);
				Delete.setTitle("ERROR");
				Delete.setHeaderText(null);
				Delete.setContentText("لطفا اطلاعات رو به درستی وارد کنید");
				Delete.showAndWait();
			}
			else if(FlagAdd==-1)
			{
				Alert Delete= new Alert(Alert.AlertType.WARNING);
				Delete.setTitle("ERROR");
				Delete.setHeaderText(null);
				Delete.setContentText("اتاق تکراری");
				Delete.showAndWait();
			}
			else if(FlagAdd==0)
			{
				Alert Delete= new Alert(Alert.AlertType.WARNING);
				Delete.setTitle("ERROR");
				Delete.setHeaderText(null);
				Delete.setContentText("به حداکثر تعداد اتاق رسیده اید");
				Delete.showAndWait();
			}
			else if(FlagAdd==1)
			{
				Alert Delete= new Alert(Alert.AlertType.WARNING);
				Delete.setTitle("*_*");
				Delete.setHeaderText(null);
				Delete.setContentText("ثبت شد");
				Delete.showAndWait();
				Stage stage=(Stage)SaveButton.getScene().getWindow();
				stage.close();

				Stage primaryStage= new Stage();
				AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomsAddSearch.fxml"));
				Scene scane= new Scene(root, 535, 330);
				primaryStage.setScene(scane);
				primaryStage.show();
			}
			else
				System.out.println("مشکل");
		}
	}
}
