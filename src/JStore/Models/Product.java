package JStore.Models;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

// product is Product
public class Product implements Serializable {

    private Integer ProductID;
    private String ProductName;
    private String ProductDescription;
    private Float ProductRate;
    private Float ProductPrice;
    private Integer ProductQuantity;


    public Product(int productID, String productName, String productDescription, Float productRate, Float productPrice, int productQuantity) {
        ProductID = productID;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductRate = productRate;
        ProductPrice = productPrice;
        ProductQuantity = productQuantity;
    }


    public String getStringID(){
        return String.valueOf(ProductID); }
    public String getStringQuantity(){
        return String.valueOf(ProductQuantity); }
    public String getStringRate(){
        return String.valueOf(ProductRate);
    } public String getStringPrice(){
        return String.valueOf(ProductPrice);

    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }


    public Float getProductPrice() {
        return ProductPrice;
    }
    public Float getProductRate() {
        return ProductRate;
    }

    public void setProductRate(Float productRate) {
        ProductRate = productRate;
    }
    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }


    public void setProductPrice(Float productPrice) {
        ProductPrice = productPrice;
    }

//Start
    public static ArrayList<Product> readProducts() {

        File file = new File("products.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Product> Products =  new ArrayList<Product>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.txt"));

            // read

            while (true){
                Product product =  (Product) ois.readObject();
                Products.add(product);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Products;
    }

    public static void writeProducts(ArrayList<Product> Products){

        try {

            // create a new file with an ObjectOutputStream

            FileOutputStream out = new FileOutputStream("products.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file

            //looping in Products and Write
            for (Product product : Products){
                oout.writeObject(product);
            }
            // close the stream
            oout.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Product> searchProducts(String keyword) {


        File file = new File("products.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Product> Products =  new ArrayList<Product>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.txt"));

            while (true){
                Product product =  (Product) ois.readObject();
                Products.add(product);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<Product> results = new ArrayList<>(); // temp Array
        for(Product p : Products){
            if(String.format("%s", p.getProductName()).contains(keyword)){
                results.add(p); //append if Found
            }
        }




        return results;
    }

    public static Integer nextID(){
        File file = new File("products.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Product> Products =  new ArrayList<Product>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.txt"));

            // read

            while (true){
                Product product =  (Product) ois.readObject();
                Products.add(product);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Products.size() > 0) {
            return Products.get(Products.size() - 1).getProductID() + 1;
        }else{
            return 1000;
        }
    }

}
