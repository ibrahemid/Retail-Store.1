package JStore.Service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {

    public static void navigateTo(String fileName, Stage primaryStage, Class cls) throws IOException {
        Parent root = FXMLLoader.load(cls.getResource(fileName));
        primaryStage.setTitle("jh");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


}
