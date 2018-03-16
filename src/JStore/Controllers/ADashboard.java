package JStore.Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ADashboard extends Application implements ControlledScreen{

    ScreensController mainController;

    public static String name = "ADashboard";
    public static String file = "/JStore/Views/ADashboard.fxml";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }

    public void start(){
        System.out.println("System!!");
    }

    public void ManageOrder(){

        mainController.setScreen(OrderManagement.name);
    }
    public void ManageProduct(){

        mainController.setScreen(ProductManagement.name);

    }
    public void ManageCustomer(){
        mainController.setScreen(CustomerManagement.name);
    }

    public void BackButtom(){

        mainController.setScreen(Login.name);
    }


    public void LogOutADashB(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText(null);
        alert.setContentText("You have logged-out successfully   ");
        alert.showAndWait();


        mainController.setScreen(Login.name);

    }
}
