package Medical_Center_Management_System.Controller;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginOption_Controller implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button adminButton;

    @FXML
    private Button receptionistButton;

    @FXML
    private ImageView CloseButton;




    @FXML
    void aButtonClik(ActionEvent event) throws IOException {
        LoadAdminScreen();
    }

    @FXML
    void CloseButton(MouseEvent event) {
        if (event.getSource()==CloseButton){
            System.exit(0);
        }

    }

    @FXML
    void rButtonClik(ActionEvent event) {
        LoadReceptionScreen();
    }

    private void LoadReceptionScreen(){
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../View/RecepLoginPanel.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage;
            stage =(Stage)rootPane.getScene().getWindow();
            stage.resizableProperty().setValue(false);
            stage.setTitle("Receptionist Login");
            stage.setScene(new Scene(root1));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("Can't load new Window");
        }
    }

    private void LoadAdminScreen(){

        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../View/AdminLoginPanel.fxml"));
            Parent root1=(Parent) fxmlLoader.load();
            Stage stage;
            stage =(Stage)rootPane.getScene().getWindow();
            stage.resizableProperty().setValue(false);
            stage.setTitle("Admin Login");
            stage.setScene(new Scene(root1));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("Can't load new Window");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}