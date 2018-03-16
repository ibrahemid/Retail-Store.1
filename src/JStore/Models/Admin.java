package JStore.Models;


import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Person  implements AutoCloseable , Serializable {
    public static String Type = "Admin";

    public Admin(Integer PersonID, String fname, String lname, String username, String password, String phone, String address, String email, LocalDate dateOfBirth, String type) {
        super(PersonID, fname, lname, username, password, phone, address, email, dateOfBirth, type);


    }



//
//
//    void print(String p){
//        System.out.print(p);
//    }
//   static void login(){
//        Scanner sc = new Scanner(System.in);
//        String user = sc.nextLine();
//        String pass = sc.nextLine();
//        if (user.equals("admin")&&pass.equals("1234") ){
//            System.out.println("true");
//            // TODO: 1/26/2018 adminFunctionality here
//           // Admin admin_= new Admin();
//          //  admin_.Add();
//        }
//        else {
//            System.out.println("somethingWentWrong");
//        }
//    }
//
//    void adminFunctions(int choice ){
//        if (choice==1){
//             Add();
//        }
//
//
//    }
//     void Add(){
//        System.out.print("<< ADDING CUSTOMER >>");
//        Scanner sc = new Scanner(System.in);
//        print("enter UserID: ");
//        String UserID=sc.nextLine();
//        print("enter User Password: ");
//        String userPS=sc.nextLine();
//        print("enter User First name: ");
//        String userFN=sc.nextLine();
//        print("enter User last name: ");
//        String userLN=sc.nextLine();
//        print("enter User address: ");
//        String userAD=sc.nextLine();
//        print("enter User phoneNumber: ");
//        String userPH=sc.nextLine();
////        Customer customer_ = new Customer(UserID,userPS,userFN,userLN,userPH,userAD);
//        String cusDate= new Gson().toJson(customer_);
//
//        try(PrintWriter pw = new PrintWriter("C:/Users/ibrah/IdeaProjects/Store_1/data.txt", "UTF-8");
//        ) {
//            pw.write(cusDate);
//
//        }
//        catch (Exception i){
//            i.printStackTrace();
//        }
//         }

    @Override
    public void close() throws Exception {
        close();
    }



    ////CRUD



}
//    private boolean LoginPAss(String U , int P ) {
//        if (U.equals(getUSERNAEM())) return true;
//        else if ()
//            return false;
//    }
//}
//
//
