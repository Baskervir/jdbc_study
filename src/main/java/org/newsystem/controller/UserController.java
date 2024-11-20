package org.newsystem.controller;

import org.newsystem.parser.UserRequest;
import org.newsystem.service.UserInfo;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;

import java.util.HashMap;
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
        ValidateInputKeys vk = new ValidateInputKeys();

        int pageNum = 0;
        int pageSize = 0;

        try {
            vk.validateInputKeys(args);
            pageNum = Integer.parseInt(args.get("pageNum"));
            pageSize = Integer.parseInt(args.get("pageSize"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<UserInfo> allInfos = this.service.findByAll(pageNum, pageSize);

        return this.viewer.viewForReadAllUserInfo(pageNum, pageSize, allInfos);
    }

    public String handleRequestForReadUserInfo(UserRequest request) {
        return "";
    }

}

//mvc중 컨트롤러