



package JStore.Controllers.Other;

import JStore.Controllers.ControlledScreen;
import JStore.Controllers.ScreensController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AddCustomer  extends Application implements ControlledScreen {
    ScreensController mainController;

    public static String name = "AddCustomer";
    public static String file = "/JStore/Views/CustomerF/AddCustomer.fxml";



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }


    public void start(){
        System.out.println("System!!");
    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }

    public void backbuttomAddproduct(ActionEvent actionEvent) {
        mainController.setScreen(ManageCustomer.name);
    }

    public void AddCustomer(ActionEvent actionEvent) {
        System.out.println("Added");
    }
}


