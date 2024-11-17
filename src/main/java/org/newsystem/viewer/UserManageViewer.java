package org.newsystem.viewer;

import org.newsystem.service.UserInfo;

import java.util.List;

public class UserManageViewer {

    public String viewForReadAllUserInfo(List<UserInfo> infos) {
        return "user 정보 : => " + infos.size();
    }

}
