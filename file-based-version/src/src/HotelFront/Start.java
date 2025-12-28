package HotelFront;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Start {

    @FXML
    private Button GuestsButton;

    @FXML
    private Button ReservationsButton;

    @FXML
    private Button RoomsButton;
    
    @FXML
    private Button ReportButton;

    @FXML
    private AnchorPane StartAnchorPan1;

    @FXML
    private AnchorPane StartAnchorPan2;

    @FXML
    private ImageView StartImage;

    @FXML
    private Label txtWelcome;
    
    @FXML
    void ReportPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)ReportButton.getScene().getWindow();
		stage.close();

		Stage primaryStage= new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("Report.fxml"));
		Scene scane= new Scene(root, 535, 330);
		primaryStage.setScene(scane);
		primaryStage.show();
    }

    @FXML
    void GuestsPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)GuestsButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestsAddSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void ReservationsPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)ReservationsButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationsAddSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void RoomsPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)RoomsButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("RoomsAddSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }
}
