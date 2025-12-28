package HotelFront;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HotelBack.ReservationSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReportRoomList implements Initializable{

    @FXML
    private CheckBox FullRoom;

    @FXML
    private Label LblFavoriteType;

    @FXML
    private Label LblList;

    @FXML
    private ListView<?> RoomList;

    @FXML
    private CheckBox VacantRoom;

    @FXML
    private Label txtWelcome;
    
    @FXML
    private Button BackButton;
    
    @FXML
    private CheckBox NeedServiceRoom;
    
    @FXML
    private CheckBox UnderRepairRoom;
    
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) 
	{
		
	}
    
    @FXML
    void FullRoomPressing(ActionEvent event) 
    {

    }

    @FXML
    void VacantRoomPressing(ActionEvent event) 
    {

    }
    
    @FXML
    void NeedServiceRoomPressing(ActionEvent event) 
    {

    }
    
    @FXML
    void UnderRepairRoomPressing(ActionEvent event) 
    {

    }
    
    @FXML
    void BackButtonPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)BackButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("Report.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
    }

}
