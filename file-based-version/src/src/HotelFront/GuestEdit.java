package HotelFront;

import java.io.IOException;

import HotelBack.GuestManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuestEdit {

    @FXML
    private Button CancelButton;

    @FXML
    private Button OkButton;

    @FXML
    private TextField TextCodeMelli;

    @FXML
    private TextField TextDateOfBirth;

    @FXML
    private TextField TextDateOfRegistration;

    @FXML
    private TextField TextFLName;

    @FXML
    private TextField TextPhoneNumber;

    @FXML
    private TextField TextShShenasname;

    @FXML
    void CancelButtonPressing(ActionEvent event) throws IOException 
    {
    	Stage stage=(Stage)CancelButton.getScene().getWindow();
    	stage.close();
    	
    	Stage primaryStage= new Stage();
    	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestSearch.fxml"));
    	Scene scane= new Scene(root, 535, 330);
    	primaryStage.setScene(scane);
    	primaryStage.show();
    }

    @FXML
    void OkButtonPressing(ActionEvent event) throws IOException 
    {
    	int flag1=1;
    	int flag2=1;
    	int flag3=1;
    	int flag4=1;
    	int flag5=1;
    	int flag6=1;
    	GuestManager GuestEdit= new GuestManager();
    	if(TextCodeMelli!=null && !TextCodeMelli.getText().trim().isEmpty())
    		flag1=GuestEdit.Edit(GuestSearch.FileRow, 1, TextCodeMelli.getText());
    	
    	if(TextFLName!=null && !TextFLName.getText().trim().isEmpty())
    		flag2=GuestEdit.Edit(GuestSearch.FileRow, 2, TextFLName.getText());
    	
    	if(TextShShenasname!=null && !TextShShenasname.getText().trim().isEmpty())
    		flag3=GuestEdit.Edit(GuestSearch.FileRow, 3, TextShShenasname.getText());
    	
    	if(TextDateOfBirth!=null && !TextDateOfBirth.getText().trim().isEmpty())
    		flag4=GuestEdit.Edit(GuestSearch.FileRow, 4, TextDateOfBirth.getText());
    	
    	if(TextPhoneNumber!=null && !TextPhoneNumber.getText().trim().isEmpty())
    		flag5=GuestEdit.Edit(GuestSearch.FileRow, 5, TextPhoneNumber.getText());
    	
    	if(TextDateOfRegistration!=null && !TextDateOfRegistration.getText().trim().isEmpty())
    		flag6=GuestEdit.Edit(GuestSearch.FileRow, 6, TextDateOfRegistration.getText());
    	
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
        	AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("GuestSearch.fxml"));
        	Scene scane= new Scene(root, 535, 330);
        	primaryStage.setScene(scane);
        	primaryStage.show();
    	}
    }
}
