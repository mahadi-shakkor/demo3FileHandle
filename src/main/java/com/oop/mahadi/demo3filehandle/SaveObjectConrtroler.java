package com.oop.mahadi.demo3filehandle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;


public class SaveObjectConrtroler {
    ArrayList<User> uList =new ArrayList<User>();


    @FXML
    private TextField idFxid;

    @FXML
    private TextField passFxid;
    @FXML
    private TextArea textAreaFxid;

    @FXML
    void saveOnactionbutton(ActionEvent event) {
        uList.add(new User(idFxid.getText(),passFxid.getText()));
        idFxid.clear();
        passFxid.clear();


    }
    @javafx.fxml.FXML
    public void initialize() throws IOException, ClassNotFoundException {
        // Check if the file exists
        File file = new File("hello.ser");
        if (file.exists()) {
            // File exists, read from it
            try {
                // FileInputStream reads bytes from the file
                FileInputStream fileIn = new FileInputStream(file);

                // ObjectInputStream reads objects from the file
                ObjectInputStream in = new ObjectInputStream(fileIn);

                // Read the ArrayList<User> object from the file
                ArrayList<User> userList = (ArrayList<User>) in.readObject();

                // Close the streams
                in.close();
                fileIn.close();

                // Display the users
                for (User user : userList) {
                    textAreaFxid.appendText(user.toString() + "\n");
                }

                System.out.println("Data has been read from hello.ser");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Or handle the exception appropriately
            }
        } else {
            // File doesn't exist, create a new file
            System.out.println("File does not exist, creating a new file.");

            // Create an empty ArrayList<User>
            ArrayList<User> userList = new ArrayList<>();

            // Write the empty ArrayList<User> to the file
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(userList);
                out.close();
                fileOut.close();

                System.out.println("Empty ArrayList<User> has been written to hello.ser");
            } catch (IOException e) {
                e.printStackTrace(); // Or handle the exception appropriately
            }
        }





    }

    @FXML
    public void showOnactionbutton(ActionEvent actionEvent) {
        textAreaFxid.clear();
        for (int i=0;i<uList.size();i++){
            textAreaFxid.appendText(uList.get(i).toString()+"\n");
        }

    }

    @FXML
    public void saveToFileOnactionbutton(ActionEvent actionEvent) throws IOException {

        File file = new File("hello.ser");
        if (file.exists()) {
            // File exists, read from it
            try {
                // FileInputStream reads bytes from the file
                FileInputStream fileIn = new FileInputStream(file);

                // ObjectInputStream reads objects from the file
                ObjectInputStream in = new ObjectInputStream(fileIn);

                // Read the ArrayList<User> object from the file
                ArrayList<User> userList = (ArrayList<User>) in.readObject();

                // Close the streams
                in.close();
                fileIn.close();

                // Display the users
                userList.addAll(uList);
                try {
                    FileOutputStream fileOut = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);

                    out.writeObject(userList) ;
                    out.close();
                    fileOut.close();

                } catch (IOException e) {
                    e.printStackTrace(); // Or handle the exception appropriately
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(); // Or handle the exception appropriately
            }
        } else {

            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);

                out.writeObject(uList);
                out.close();
                fileOut.close();

            } catch (IOException e) {
                e.printStackTrace(); // Or handle the exception appropriately
            }
        }

    }
}
