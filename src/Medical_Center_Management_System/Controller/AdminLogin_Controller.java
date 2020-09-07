package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Doctor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import javafx.scene.control.TableView;


import javax.management.Notification;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminLogin_Controller implements Initializable {


    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnSignin;

    @FXML
    private Label lblErrors;

    @FXML
    private ImageView CloseButton;

    @FXML
    void BackButton(MouseEvent event) {

        try {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../View/LoginOption.fxml"));
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





    Connection connection= DBconnection.GetInstance().getConnection();

    @FXML
    String handleButtonAction(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        String status = "Success";
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if(username.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {

        Connection connection = DBconnection.GetInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM User Where UserName = '" + username + "' and Password = '" + password + "' AND Role LIKE 'Owner%'");


        if (resultSet.next()) {
            setLblError(Color.GREEN, "Login Successful..Redirecting..");
            status = "Success";
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../View/DashBord.fxml")));
            stage.setScene(scene);
            stage.show();

            Image img=new Image("Medical_Center_Management_System/Image/AdminNotification.png");
            Notifications notificationsbar= Notifications.create()
                    .title("Notification")
                    .graphic(new ImageView(img))
                    .text("Welcome to Admin Portal").position(Pos.CENTER);
            notificationsbar.show();


        } else {

            setLblError(Color.TOMATO, "Enter Correct Email/Password");
        }


    }

        return status;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if ( connection== null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.LIGHTBLUE);
            lblErrors.setText("Server is up : Good to go");
        }

    }



    public AdminLogin_Controller() throws SQLException, ClassNotFoundException {

    }
    @FXML
    void ClickClose(MouseEvent event) {
        if (event.getSource()==CloseButton){
            System.exit(0);
        }
    }



    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }



    }


