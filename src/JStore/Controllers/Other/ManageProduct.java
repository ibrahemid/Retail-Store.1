package JStore.Controllers.Other;

import JStore.Controllers.ADashboard;
import JStore.Controllers.ControlledScreen;
import JStore.Controllers.ScreensController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ManageProduct extends Application implements ControlledScreen {


    ScreensController mainController;

    public static String name = "ManageProduct";
    public static String file = "/JStore/Views/Trash/ManageProduct.fxml";
public static void main(String[] args){
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


    public void SearchProduct(ActionEvent actionEvent) {

        System.out.println("SearchClicked");
    }




    public void BackButtomManageProduct(ActionEvent actionEvent) {
        mainController.setScreen(ADashboard.name);

    }

    public void AddProduct(ActionEvent actionEvent) {
    mainController.setScreen(AddProduct.name);
    }

    public void DeleteProduct(ActionEvent actionEvent) {
    }

    public void ViewProduct(ActionEvent actionEvent) {
    }

    public void UpdateOrder(ActionEvent actionEvent) {
    }


}
