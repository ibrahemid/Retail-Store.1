



package JStore.Controllers.Other;

        import JStore.Controllers.ControlledScreen;
        import JStore.Controllers.ScreensController;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.stage.Stage;

        import static javafx.application.Application.launch;

public class AddProduct  extends Application implements ControlledScreen {
    ScreensController mainController;

    public static String name = "AddProduct";
    public static String file = "/JStore/Views/ProductF/AddProduct.fxml";



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
        mainController.setScreen(ManageProduct.name);
    }

    public void AddProduct(ActionEvent actionEvent) {
        System.out.println("Added");
    }
}


