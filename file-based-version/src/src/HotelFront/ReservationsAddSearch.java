package HotelFront;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReservationsAddSearch {

    @FXML
    private Button ReservationsAddButton;

    @FXML
    private Button ReservationsBackButton;

    @FXML
    private Button ReservationsSearchButton;

    @FXML
    void ReservationsAddPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)ReservationsAddButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationGuestSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void ReservationsBackPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)ReservationsBackButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("HotelStart.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void ReservationsSearchPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)ReservationsSearchButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ReservationSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

}
