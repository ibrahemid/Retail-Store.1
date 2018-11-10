package JStore;

import JStore.Controllers.ADashboard;
import JStore.Controllers.OrderManagement;
import JStore.Controllers.CustomerManagement;
import JStore.Controllers.Login;
import JStore.Controllers.ProductManagement;
import JStore.Controllers.ScreensController;
import JStore.Controllers.UDashboard;
import JStore.Models.Admin;
import JStore.Models.Customer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage parentStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
            parentStage = primaryStage;

//        Navigator.navigateTo("/JStore/Views/Login.fxml",primaryStage,getClass());
        ScreensController mainContainer = new ScreensController();

        /// Load Views into the HashMap
        mainContainer.loadScreen(Login.name, Login.file);
        mainContainer.loadScreen(ADashboard.name, ADashboard.file);
        mainContainer.loadScreen(UDashboard.name, UDashboard.file);
        mainContainer.loadScreen(CustomerManagement.name,CustomerManagement.file);
        mainContainer.loadScreen(ProductManagement.name,ProductManagement.file);
        mainContainer.loadScreen(OrderManagement.name,OrderManagement.file);

        /// Set the main page
        mainContainer.setScreen(Login.name);
        primaryStage.getIcons().add(new Image("JStore/drawable/icon.png"));
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();



    }


    public static void main(String[] args) {
       launch(args);

}

public static void refreshViewSize(){
    parentStage.sizeToScene();
    parentStage.centerOnScreen();
}
}

