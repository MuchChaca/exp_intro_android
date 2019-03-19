package com.example.tst.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    protected String lastName;
    protected String firstName;

    public static ArrayList<Client> clients = new ArrayList<Client>();

    public Client() {}

    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName ;
    }
}
