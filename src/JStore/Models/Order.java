package JStore.Models;

import JStore.Models.Admin;
import JStore.Models.Customer;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    public int orderID;
    public Date OrderDate;
    public Double totalOrder;
    public Person OrderCustomer;
    public ArrayList<OrderProduct> products;

    public Order(int orderID, Date orderDate, Double totalOrder, Person orderCustomer, ArrayList<OrderProduct> products) {
        this.orderID = orderID;
        OrderDate = orderDate;
        this.totalOrder = totalOrder;
        OrderCustomer = orderCustomer;
        this.products = products;
    }

    public String getUserFullname() {
        return OrderCustomer.getFullname();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Person getOrderCustomer() {
        return OrderCustomer;
    }

    public void setOrderCustomer(Person orderCustomer) {
        OrderCustomer = orderCustomer;
    }

    public ArrayList<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<OrderProduct> products) {
        this.products = products;
    }





    //here
    public static ArrayList<Order> readOrders()  {
        /*
         *
         *   1.Check if file exists else create
         *   2.Read file into array ArrayList
         *   3.return it
         * */
        File file = new File("orders.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Order> Orders =  new ArrayList<Order>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.txt"));

            // read

            while (true){
                Order order =  (Order) ois.readObject();
                Orders.add(order);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Orders;
    }



    public static void writeOrders(ArrayList<Order> Orders){
        /*
         *
         *   1.Loop through each Object inside users
         *   2.writeObject
         *
         *
         *
         * */
        try {
            // create a new file with an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("orders.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file

            //looping in Orders and Write
            for (Order order : Orders){
                oout.writeObject(order);
            }
            // close the stream
            oout.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public static Integer nextID(){
        File file = new File("orders.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Order> Persons =  new ArrayList<Order>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.txt"));

            // read

            while (true){
                Order order =  (Order) ois.readObject();
                Persons.add(order);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Persons.size() > 0) {
            return Persons.get(Persons.size() - 1).getOrderID() + 1;
        }else{
            return 1000;
        }}
    public static ArrayList<Order> searchOrders(String keyword)  {
        /*
         *
         *   1.Check if file exists else create
         *   2.Read file into array ArrayList
         *   3. Create temp array and call results
         *   4. loop through the array you read from the file
         *   5. apply the condition of contain or equal to the corresponding object
         *   6. if you found somethign add to the results array
         *   7. finally return results
         *
         *
         * */
        File file = new File("orders.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Order> Orders =  new ArrayList<Order>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orders.txt"));

            while (true){
                Order order =  (Order) ois.readObject();
                Orders.add(order);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<Order> results = new ArrayList<>(); // temp Array
        for(Order o : Orders){
            if( String.format("%s", o.getOrderID()).contains(keyword)){
                results.add(o); //append if Found
            }
        }




        return results;
    }

}








