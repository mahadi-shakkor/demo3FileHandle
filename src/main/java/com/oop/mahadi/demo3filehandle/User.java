package com.oop.mahadi.demo3filehandle;
import java.io.Serializable;



public class User implements Serializable {
    private String id;
    private String pass;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User(String pass, String id) {
        this.pass = pass;
        this.id = id;
    }
}
