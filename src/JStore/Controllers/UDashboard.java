package JStore.Controllers;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class UDashboard  extends Application implements ControlledScreen {

    ScreensController mainController;
    public static String name = "UDashboard";
    public static String file = "/JStore/Views/UDashboard.fxml";


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }
    @Override
    public void start(Stage primaryStage) {
        }

    public void start(){
        System.out.println(getClass().toString());
    }


    public void ManageOrder(ActionEvent actionEvent) {
        mainController.setScreen(OrderManagement.name);
    }

    public void BackButtomCustomer(ActionEvent actionEvent) {
        mainController.setScreen(Login.name);



    }


    public void LogOutUdash(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText(null);
        alert.setContentText("You have logged-out successfully   ");
        alert.showAndWait();


        mainController.setScreen(Login.name);


    }
}
