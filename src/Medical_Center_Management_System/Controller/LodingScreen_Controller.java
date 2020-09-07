package Medical_Center_Management_System.Controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;


public class LodingScreen_Controller implements Initializable {

    @FXML
    private Label progress;

    public static Label label;


    @FXML
    private ProgressBar progressBar;

    public static ProgressBar statProgressBar;

    @FXML
    private AnchorPane rootPane;


    @FXML
    private void handleButtonAction(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label = progress ;
        statProgressBar = progressBar;
    }

}
