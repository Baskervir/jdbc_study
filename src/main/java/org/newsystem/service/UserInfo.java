package org.newsystem.service;

public class UserInfo {
    private final int actorId;
    private final String firstName;
    private final String lastName;
    private final long lastUpdate;

    public UserInfo(int actorId, String firstName, String lastName, long lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
}
