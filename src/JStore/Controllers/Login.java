package JStore.Controllers;

import JStore.Models.Person;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.ietf.jgss.MessageProp;

import java.io.IOException;
import java.util.ArrayList;

public class Login extends Application implements ControlledScreen {


    public static String name = "login";
    public static String file = "/JStore/Views/Login.fxml";
    @FXML
    JFXTextField usernameTextfield;
    @FXML
    JFXPasswordField passwordTextfield;
    @FXML
    JFXButton loginButton;

    ScreensController mainController;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage _primaryStage) {
        Image icon = new Image("icon-signin.png");
        _primaryStage.getIcons().add(icon);

    }


    public void loginPressed()  {

        String username = usernameTextfield.getText();
        String password =passwordTextfield.getText();

        Boolean found =false;
        ArrayList<Person> Persons = new ArrayList<Person>(Person.readPersons());
        if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("123")){
            found = true   ;

            mainController.setScreen(ADashboard.name);
        }
        for(Person p: Persons){
            if (p.getUsername().equals(this.usernameTextfield.getText()) && (p.getPassword()).equals(this.passwordTextfield.getText())) {
                found = true   ;

                mainController.setScreen(UDashboard.name);
            }

            }
            if (found==true){


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText(null);
                alert.setContentText("welcome "+this.usernameTextfield.getText());
                alert.showAndWait();
            }
            else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("sign in");
            alert.setHeaderText(null);
                alert.setContentText("UserName or Password is not Correct");

            alert.showAndWait();

        }
            }




    @Override
    public void setScreenParent(ScreensController screenPage) {
        mainController = screenPage;

    }
}
