package org.readsystem.viewer;

import org.readsystem.service.UserInfo;

import java.util.List;

public class UserManageViewer {

    public String viewForReadAllUserInfo(int actorid, List<UserInfo> userInfos) {
        return userInfos.toString();
    }
}
