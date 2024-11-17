package org.newsystem.controller;

import org.newsystem.parser.UserRequest;
import org.newsystem.service.UserInfo;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;

import java.util.List;
import java.util.Map;

public class UserController {

    private final UserManageService service;
    private final UserManageViewer viewer;

    public UserController(UserManageService service, UserManageViewer viewer) {
        this.service = service;
        this.viewer = viewer;
    }

    public String handleRequestForReadAll(UserRequest req) {

        Map<String, String> args = req.args();

        int pageNum = Integer.parseInt(args.get("pageNum"));
        int pageSize = Integer.parseInt(args.get("pageSize"));

        List<UserInfo> allInfos = this.service.findByAll(pageNum, pageSize);

        return this.viewer.viewForReadAllUserInfo(allInfos);
    }

    public String handleRequestForReadUserInfo(UserRequest request) {
        return "";
    }

}

//mvc중 컨트롤러