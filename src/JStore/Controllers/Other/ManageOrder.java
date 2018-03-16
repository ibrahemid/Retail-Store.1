package JStore.Controllers.Other;

import JStore.Controllers.ADashboard;
import JStore.Controllers.ControlledScreen;
import JStore.Controllers.ScreensController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

    public class ManageOrder  extends Application implements ControlledScreen {
        ScreensController mainController;

        public static String name = "ManageOrder";
        public static String file = "/JStore/Views/Trash/ManageOrder.fxml";



        public static void main(String[] args) {
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


        public void AddOrder(ActionEvent actionEvent) {
        }

        public void SearchOrder(ActionEvent actionEvent) {
        }

        public void DeleteOrder(ActionEvent actionEvent) {
        }

        public void UpdateOrder(ActionEvent actionEvent) {
        }

        public void ViewOrder(ActionEvent actionEvent) {
        }

        public void BackButtomMO(ActionEvent actionEvent) {
            mainController.setScreen(ADashboard.name);
        }




}


