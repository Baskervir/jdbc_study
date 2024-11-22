package org.newsystem.service;

public class OneUserInfo {
    private final int actorId;
    private final String firstName;
    private final String lastName;


    public OneUserInfo(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
