package JStore.Models;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Person implements Serializable {
    Integer PersonID;

    String fname;
    String lname;
    String username;
    String password;
    String phone;
    String address;
    String email;
  LocalDate joinDate;
   String type;

    public Person(Integer PersonID, String fname, String lname, String username, String password, String phone, String address, String email, LocalDate joinDate, String type) {
        this.PersonID = PersonID;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.joinDate = joinDate;
        this.type = type;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getStringID(){
        return String.valueOf(PersonID); }

    public String getStringDateOfBirth(){
        return String.valueOf(joinDate); }
    public String getStringPassword(){
        return String.valueOf(password); }

    public String getFullname() {
        return fname+" "+lname;
    }

//here
    public static ArrayList<Person> readPersons()  {

        File file = new File("persons.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Person> Persons =  new ArrayList<Person>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.txt"));

            // read

            while (true){
                Person person =  (Person) ois.readObject();
                Persons.add(person);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Persons;
    }


    public static Integer nextID(){
        File file = new File("persons.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Person> Persons =  new ArrayList<Person>();
        try {

            // create an ObjectInputStream for the file we created before

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.txt"));

            // read

            while (true){
                Person person =  (Person) ois.readObject();
                Persons.add(person);
            }
        } catch (EOFException ex){

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Persons.size() > 0) {
            return Persons.get(Persons.size() - 1).getPersonID() + 1;
        }else{
            return 1000;
        }
    }




    public static void writePersons(ArrayList<Person> Persons){

        try {
            // create a new file with an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("persons.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file

            //looping in Persons and Write
            for (Person person : Persons){
                oout.writeObject(person);
            }
            // close the stream
            oout.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Person> searchPersons(String keyword)  {


        File file = new File("persons.txt");
        try {
            file.createNewFile(); //will atomically checks the existence of the file else will create one
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Person> Persons =  new ArrayList<Person>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.txt"));

        while (true){
            Person person =  (Person) ois.readObject();
            Persons.add(person);
        }
    } catch (EOFException ex){

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    ArrayList<Person> results = new ArrayList<>(); // temp Array
        for(Person p : Persons){
            if( String.format("%s", p.getFullname()).contains(keyword)){
                results.add(p); //append if Found
            }
        }




        return results;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s",fname+lname+email+PersonID+phone+address+ joinDate);
    }
}


