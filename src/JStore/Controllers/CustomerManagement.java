package JStore.Controllers;

import JStore.Models.Person;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class CustomerManagement  extends Application implements ControlledScreen {
    ScreensController mainController;
    public static String name = "CustomerManagement";
    public static String file = "/JStore/Views/CustomerManagement.fxml";


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void setScreenParent(ScreensController screenPage) {
        start();
        mainController = screenPage;
    }

    public void start(){
        System.out.println(getClass().toString());
        ViewCustomer(null);
        IDField.setDisable(true);

    }


    @Override
    public void start(Stage primaryStage) {

    }

    /**
     * @Fxml Deceleration
     *
     * CustomerManagement
     */
    public ObservableList<Person> persons = FXCollections.observableArrayList(Person.readPersons());




    @FXML
    private TableView<Person> tableViewCustomer;

    @FXML
    private TableColumn<Person,String> ColcustomerID;

    @FXML
    private TableColumn<Person,String> ColcustomerFirstName;

    @FXML
    private TableColumn<Person,String> ColcustomerLastname;

    @FXML
    private TableColumn<Person,String> ColcustomerUserName;

    @FXML
    private TableColumn<Person,String> ColcustomerPassword;

    @FXML
    private TableColumn<Person,String> ColcustomerPhone;

    @FXML
    private TableColumn<Person, String> ColcustomerEmail;

    @FXML
    private TableColumn<Person, String> ColcustomerAddress;
    @FXML
    private TableColumn<Person, String> ColcustomerBirthday;

    @FXML
    private TextField IDField;

    @FXML
    private TextField FnameField;

    @FXML
    private TextField LnameField;

    @FXML
    private TextField usernamField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField AddressField;

    @FXML
    private TextField SearchField;


    @FXML
    private JFXDatePicker birthdayField;

//    @FXML
//    private JFXButton AddCustomerbuttom;
//
//    @FXML
//    private JFXButton DeleteCustomerButtom;
//
//    @FXML
//    private JFXButton ViewCustomerButtom;
//
//    @FXML
//    private JFXButton UpdateCustomerButtom;

    @FXML private void initialize(){

        ColcustomerID.setCellValueFactory(new PropertyValueFactory<Person,String>("personID"));
        ColcustomerFirstName.setCellValueFactory(new PropertyValueFactory<Person,String>("fname"));
        ColcustomerLastname.setCellValueFactory(new PropertyValueFactory<Person,String>("lname"));
        ColcustomerUserName.setCellValueFactory(new PropertyValueFactory<Person,String>("username"));
        ColcustomerPassword.setCellValueFactory(new PropertyValueFactory<Person,String>("stringPassword"));
        ColcustomerPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));
        ColcustomerAddress.setCellValueFactory(new PropertyValueFactory<Person,String>("address"));
        ColcustomerEmail.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        ColcustomerBirthday.setCellValueFactory(new PropertyValueFactory<Person,String>("stringDateOfBirth"));



    }




    public void userClickedOnTableCustomer(MouseEvent mouseEvent) {


        Person selected = tableViewCustomer.getSelectionModel().getSelectedItem();

        if (selected != null) {
            IDField.setText(selected.getStringID());
            FnameField.setText(selected.getFname());
            LnameField.setText(selected.getLname());
            usernamField.setText(selected.getUsername());
            passwordField.setText(selected.getStringPassword());
            phoneField.setText(selected.getPhone());
            emailField.setText(selected.getEmail());
            AddressField.setText(selected.getAddress());
//            birthdayField.setText(selected.getStringDateOfBirth());
            phoneField.setText(selected.getPhone());
        }
    }










    public void AddCustomer(ActionEvent actionEvent) {
        birthdayField.disabledProperty();
        birthdayField.setDisable(false);

        persons.add(new Person(Person.nextID(),FnameField.getText(),LnameField.getText(),usernamField.getText(),passwordField.getText(),phoneField.getText(),AddressField.getText(),emailField.getText(), LocalDate.now(),"Customer"));

        tableViewCustomer.setItems(persons);

        Person.writePersons(new ArrayList<Person>(persons));

    }


    public void DeleteCustomer(ActionEvent actionEvent) {
        birthdayField.disabledProperty();
        birthdayField.setDisable(false);

        int found = 0;
        for (Person p : persons){

            if (String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getPersonID()).equals(p.getStringID()))
            {
                break;
            }
            found++;
        }

        persons.remove(found);

        tableViewCustomer.setItems(persons);

        Person.writePersons(new ArrayList<>(persons));

    }





    public void SearcButtomCustomer(ActionEvent actionEvent) {
        birthdayField.disabledProperty();
        birthdayField.setDisable(false);
        tableViewCustomer.setItems(FXCollections.observableArrayList(Person.searchPersons(SearchField.getText())));


    }

    public void UpdateCustomer(ActionEvent actionEvent) {
        birthdayField.disabledProperty();
        birthdayField.setDisable(false);
        int found = 0;
        for (Person p : persons){

            if (String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getPersonID()).equals(p.getStringID()))
            {
                break;
            }
            found++;
        }


        persons.set(found,new Person(tableViewCustomer.getSelectionModel().getSelectedItem().getPersonID(),FnameField.getText(),LnameField.getText(),usernamField.getText(),passwordField.getText(),phoneField.getText(),AddressField.getText(),emailField.getText(), LocalDate.now(),"Customer"));



        tableViewCustomer.setItems(persons);

        Person.writePersons(new ArrayList<>(persons));




    }

    public void ViewCustomer(ActionEvent actionEvent) {
        birthdayField.disabledProperty();
        birthdayField.setDisable(false);
        persons = FXCollections.observableArrayList(Person.readPersons());
        tableViewCustomer.setItems(persons);

    }


    public void backbuttomCustomerManage(ActionEvent actionEvent) {

        mainController.setScreen(ADashboard.name);
    }

    public void userClickedOnTable(MouseEvent mouseEvent) {
    }

    public void LogOutCustomerMan(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log out");
        alert.setHeaderText(null);
        alert.setContentText("You have logged-out successfully   ");
        alert.showAndWait();


        mainController.setScreen(Login.name);

    }
}
