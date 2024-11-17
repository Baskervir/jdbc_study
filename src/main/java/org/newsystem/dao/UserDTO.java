package org.newsystem.dao;

import org.newsystem.service.UserInfo;

//테이블 내에 칼럼값과 매칭이 되는 클래스
public class UserDTO {
    private final int actorId;
    private final String firstName;
    private final String lastName;
    private final long lastUpdate;

    public UserDTO(int actorId, String firstName, String lastName, long lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public UserInfo mapToInfo() {
        return new UserInfo(
                this.actorId,
                this.firstName,
                this.lastName,
                this.lastUpdate);
    }

    public int getActorId() {
        return actorId;
    }
}
