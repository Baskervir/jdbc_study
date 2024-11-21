package org.newsystem.viewer;

import org.newsystem.service.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManageViewer {

    public String viewForReadAllUserInfo(int pageNum, int pageSize, List<UserInfo> userInfos) {
        String metadataView = String.format("pageSize is %d, and num is %d", pageSize, pageNum);

        StringBuilder userInfoViews = new StringBuilder();

        userInfoViews.append(metadataView).append("\n");

        for (int i = 0; i < userInfos.size(); i++) {
            userInfoViews.append(String.format("%2d 번째 유저 정보 : %s\n", i+1, userInfos.get(i)));
        }
        return userInfoViews.toString();
    }
}
