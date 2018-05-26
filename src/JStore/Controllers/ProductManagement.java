package JStore.Controllers;

import JStore.Models.Person;
import JStore.Models.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.stage.Stage;


import java.util.ArrayList;

import static javafx.application.Application.launch;

public class ProductManagement extends Application implements ControlledScreen {
    ScreensController mainController;

    public static String name = "ProductManagement";
    public static String file = "/JStore/Views/ProductManagement.fxml";


    public ObservableList<Product> products = FXCollections.observableArrayList(Product.readProducts());


    @FXML
    private TextField ProductIDField;
    @FXML
    private TextField ProductNameField;

    @FXML
    private TextField ProdutDescField;

    @FXML
    private TextField ProductRateField;

    @FXML
    private TextField ProductPriceField;

    @FXML
    private TextField searchField;


    @FXML
    private TextField ProductQuantityField;

    @FXML
    private TableView<Product> tableViewProduct;

    @FXML
    private TableColumn<Product, String> idColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> descColumn;

    @FXML
    private TableColumn<Product, String> rateColumn;

    @FXML
    private TableColumn<Product, String> priceColumn;

    @FXML
    private TableColumn<Product, String> quantityColumn;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(){
        System.out.println("System!!");
        ViewProduct(null);
        ProductIDField.setDisable(true);

    }

    @Override
    public void start(Stage primaryStage) {

    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }

    @FXML private void initialize(){

        idColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productName"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productDescription"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringQuantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringPrice"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringRate"));



    }






    public void userClickedOnTable(MouseEvent mouseEvent) {


        Product selected = tableViewProduct.getSelectionModel().getSelectedItem();

        if (selected != null) {
            ProductIDField.setText(selected.getStringID());
            ProductNameField.setText(selected.getProductName());
            ProdutDescField.setText(selected.getProductDescription());
            ProductPriceField.setText(selected.getStringPrice());
            ProductQuantityField.setText(selected.getStringQuantity());
            ProductRateField.setText(selected.getStringRate());
        }
    }

    public void AddProduct(ActionEvent actionEvent) {

        products.add(new Product(Product.nextID(),ProductNameField.getText(),ProdutDescField.getText(),Float.valueOf(ProductRateField.getText()),Float.valueOf(ProductPriceField.getText()),Integer.valueOf(ProductQuantityField.getText())));

        tableViewProduct.setItems(products);

        Product.writeProducts(new ArrayList<Product>(products));

    }

    public void DeleteProduct(ActionEvent actionEvent) {

        int found = 0;
        for (Product p : products){

            if (String.valueOf(tableViewProduct.getSelectionModel().getSelectedItem().getProductID()).equals(p.getStringID()))
            {
                break;
            }
            found++;
        }

        products.remove(found);

        tableViewProduct.setItems(products);

        Product.writeProducts(new ArrayList<>(products));

    }

    public void ViewProduct(ActionEvent actionEvent) {

        products = FXCollections.observableArrayList(Product.readProducts());
        tableViewProduct.setItems(products);

    }

    public void UpdateProduct(ActionEvent actionEvent) {

        int found = 0;
        for (Product p : products){

            if (String.valueOf(tableViewProduct.getSelectionModel().getSelectedItem().getProductID()).equals(p.getStringID()))
            {
                break;
            }
            found++;
        }


        products.set(found,new Product(tableViewProduct.getSelectionModel().getSelectedItem().getProductID(),ProductNameField.getText(),ProdutDescField.getText(),Float.valueOf(ProductRateField.getText()),Float.valueOf(ProductPriceField.getText()),Integer.valueOf(ProductQuantityField.getText())));



        tableViewProduct.setItems(products);

        Product.writeProducts(new ArrayList<>(products));

    }

    public void SearcButtomProduct(ActionEvent actionEvent) {

        tableViewProduct.setItems(FXCollections.observableArrayList(Product.searchProducts(searchField.getText())));
    }

    public void backbuttomProductManage(ActionEvent actionEvent) {
        mainController.setScreen(ADashboard.name);
    }

    public void LogOutProductMan(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText(null);
        alert.setContentText("You have logged-out successfully   ");
        alert.showAndWait();


        mainController.setScreen(Login.name);
    }
}

