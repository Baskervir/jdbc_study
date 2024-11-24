package org.newsystem.dao;

import org.newsystem.service.OneUserInfo;

public class OneUserDTO {
    private final String firstName;
    private final String lastName;

    public OneUserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public OneUserInfo mapToInfo() {
        return new OneUserInfo(
                this.firstName,
                this.lastName);
    }

}
