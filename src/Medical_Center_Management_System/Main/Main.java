package Medical_Center_Management_System.Main;

import Medical_Center_Management_System.View.MyPreloader;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private static final int COUNT_LIMIT = 10;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginOption.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
}
    @Override
    public void init() throws Exception {

        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/10;
            System.out.println("progress: " +  progress);
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(450);
        }

    }
    public static void main(String[] args) {
        LauncherImpl.launchApplication( Main.class, MyPreloader.class, args);
    }
}
