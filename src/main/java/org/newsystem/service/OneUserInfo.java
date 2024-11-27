package org.newsystem.service;

public class OneUserInfo {
    private String firstName;
    private String lastName;


    public OneUserInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
