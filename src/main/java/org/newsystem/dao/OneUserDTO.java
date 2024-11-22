package org.newsystem.dao;

import org.newsystem.service.OneUserInfo;

public class OneUserDTO {
    private final int actorId;
    private final String firstName;
    private final String lastName;

    public OneUserDTO(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public OneUserInfo mapToInfo() {
        return new OneUserInfo(
                this.actorId,
                this.firstName,
                this.lastName);
    }

    public int getActorId() {
        return actorId;
    }
}
