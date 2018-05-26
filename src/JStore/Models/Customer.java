package JStore.Models;

import java.io.Serializable;
import java.time.LocalDate;
//
public class Customer extends Person implements Serializable {
    public static String Type = "Customer";


    public Customer(Integer PersonID, String fname, String lname, String username, String password, String phone, String address, String email, LocalDate dateOfBirth, String type) {
        super(PersonID, fname, lname, username, password, phone, address, email, dateOfBirth, type);
        this.PersonID=PersonID;
        this.fname=fname;
        this.lname=lname;
        this.username=username;
        this.password=password;
        this.address =address;
        this.email =email;
        this.joinDate =dateOfBirth;
        this.type=Type;

    }}


