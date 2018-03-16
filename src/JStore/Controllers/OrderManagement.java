package JStore.Controllers;

import JStore.Models.Cart;
import JStore.Models.Order;
import JStore.Models.OrderProduct;
import JStore.Models.Product;
import com.jfoenix.controls.JFXButton;
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
import java.util.Date;

import static javafx.application.Application.launch;


public class OrderManagement  extends Application implements ControlledScreen {

    ScreensController mainController;
    public static String name = "OrderManagement";
    public static String file = "/JStore/Views/OrderManagement.fxml";


    public ObservableList<Product> products = FXCollections.observableArrayList(Product.readProducts());


    public static void main(String[] args) {
        launch(args);
    }

    public void start(){
        System.out.println("System!!");
        ViewProduct(null);


    }

    private void ViewProduct(Object o) {

        products = FXCollections.observableArrayList(Product.readProducts());
        tableViewProduct.setItems(products);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;

    }

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
    private TextField PriceField;

    @FXML
    private TextField ProductNameField;

    @FXML
    private JFXButton AddProductbuttom;

    @FXML
    private TextField searchField;
    // TODO: 3/7/2018 cart Table implementation

    @FXML
    private TableView<OrderProduct> TableViewCart;

    @FXML
    private TableColumn<OrderProduct, String> Cart_Item;

    @FXML
    private TableColumn<OrderProduct, String> CartQuantity;

    @FXML
    private TableColumn<OrderProduct, String> CartTotal;

    @FXML
    private JFXButton DeleteItemFromCart;

    @FXML
    private JFXButton CheckOut;






    @FXML private void initialize(){

        idColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productName"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("productDescription"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringRate"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("stringPrice"));

        Cart_Item.setCellValueFactory(new PropertyValueFactory<OrderProduct,String>("productName"));
        CartQuantity.setCellValueFactory(new PropertyValueFactory<OrderProduct,String>("stringQuantity"));
        CartTotal.setCellValueFactory(new PropertyValueFactory<OrderProduct,String>("stringTotalPrice"));




    }





    public void userClickedOnTable2(MouseEvent mouseEvent) {


        Product selected = tableViewProduct.getSelectionModel().getSelectedItem();

        if (selected != null) {
            PriceField.setText(selected.getStringPrice());
            ProductNameField.setText(selected.getProductName());
        }
    }















    public void userClickedOnTable(MouseEvent mouseEvent) {
    }

    public void AddTocart(ActionEvent actionEvent) {
        OrderProduct i = new OrderProduct(tableViewProduct.getSelectionModel().getSelectedItem(),null,1,tableViewProduct.getSelectionModel().getSelectedItem().getProductPrice());
        Cart.getInstance().cart.add(i);
        ObservableList<OrderProduct> cart = FXCollections.observableArrayList(Cart.getInstance().cart);

        TableViewCart.setItems(cart);


    }

    public void SearcProducts(ActionEvent actionEvent) {

        tableViewProduct.setItems(FXCollections.observableArrayList(Product.searchProducts(searchField.getText())));

    }

    public void backbuttomOrderManagement(ActionEvent actionEvent) {
        mainController.setScreen(UDashboard.name);
    }

    public void LogOutProductMan(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText(null);
        alert.setContentText("You have logged-out successfully   ");
        alert.showAndWait();


        mainController.setScreen(Login.name);
    }

    public void DeleteProduct(ActionEvent actionEvent) {
        OrderProduct p = TableViewCart.getSelectionModel().getSelectedItem();
        Cart.getInstance().cart.remove(p);
        ObservableList<OrderProduct> cart = FXCollections.observableArrayList(Cart.getInstance().cart);

        TableViewCart.setItems(cart);
    }

    public void CheckoutPressed(ActionEvent actionEvent) {
        Double total = 0.0;
        ArrayList<OrderProduct> orderProducts = Cart.getInstance().cart;
        Date orderDate = new Date();

        for(OrderProduct p: Cart.getInstance().cart){
            total += p.getTotalPrice();
        }


        ArrayList orders = Order.readOrders();
        Order newOrder = new Order(Order.nextID(),orderDate,total,null,orderProducts);
        orders.add(newOrder);
        Order.writeOrders(orders);

        Cart.getInstance().cart.clear();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Done !");
        alert.setHeaderText(null);
        alert.setContentText("Your total is " + String.valueOf(Math.floor(total)));

        alert.showAndWait();

        ObservableList<OrderProduct> cart = FXCollections.observableArrayList(Cart.getInstance().cart);

        TableViewCart.setItems(cart);

    }

    public void ViewAll(ActionEvent actionEvent) {
        ViewProduct(null);

    }
}