package org.readsystem.dao;

import org.readsystem.service.UserInfo;

public class UserDTO {
    private final String firstName;
    private final String lastName;

    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserInfo mapToInfo() {
        return new UserInfo(
                this.firstName,
                this.lastName);
    }

}
