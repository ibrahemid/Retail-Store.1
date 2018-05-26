package JStore.Models;


import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Person  implements AutoCloseable , Serializable {
    public static String Type = "Admin";

    public Admin(Integer PersonID, String fname, String lname, String username, String password, String phone, String address, String email, LocalDate dateOfBirth, String type) {
        super(PersonID, fname, lname, username, password, phone, address, email, dateOfBirth, type);


    }




    @Override
    public void close() throws Exception {
        close();
    }}

