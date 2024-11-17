package org.newsystem.viewer;

import org.newsystem.service.UserInfo;

import java.util.List;

public class UserManageViewer {

    public String viewForReadAllUserInfo(List<UserInfo> infos) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < infos.size(); i++) {
            b.append("next user info : " + )
        }
        return "user 정보 : => " + infos.size();
    }

}
