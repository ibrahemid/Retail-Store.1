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

    }


//    public Customer(String fname1 , String lname1 , LocalDate Birthday1) {
//        this.fname1=fname1;
//        this.lname1=lname1;
//        this.Birthday1=Birthday1;
//
//    }
}
//static void login (){
//    Scanner sc = new Scanner(System.in);
//    String user = sc.nextLine();
//    String pass = sc.nextLine();
//    Gson json = new Gson();
//
//   String fileName= "C:/Users/ibrah/IdeaProjects/Store_1/data.txt";
//String cus[]= null;
//
//    try (FileInputStream fis = new FileInputStream(fileName)) {
//        int content;
//        while ((content = fis.read()) != -1) {
//            // convert to char and display it
//            System.out.print((char) content);
//            cus.
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//Customer cusLog = new
//
//}

