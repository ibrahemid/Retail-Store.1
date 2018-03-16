package JStore.Controllers.Other;

import JStore.Controllers.ADashboard;
import JStore.Controllers.ControlledScreen;
import JStore.Controllers.ScreensController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class ManageCustomer extends Application implements ControlledScreen {


    ScreensController mainController;
    public static String name="ManageCustomer";

    public static String file = "/JStore/Views/Trash/ManageCustomer.fxml";
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

    }


    public void start(){
        System.out.println("MangeCus start!!");
    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }



    public void BackButtom(ActionEvent actionEvent) {
        mainController.setScreen(ADashboard.name);
    }

    public void AddCustomer(ActionEvent actionEvent) {
        mainController.setScreen(AddCustomer.name);

    }


    public void DeleteCustomer(ActionEvent actionEvent) {
    }

    public void UpdateCustomer(ActionEvent actionEvent) {
    }

    public void ViewCustomer(ActionEvent actionEvent) {

    }


}
