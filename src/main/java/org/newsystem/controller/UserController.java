package org.newsystem.controller;

import org.newsystem.parser.UserRequest;
import org.newsystem.service.OneUserInfo;
import org.newsystem.service.UserInfo;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserManageService service;

    private final UserManageViewer viewer;

    @Autowired
    public UserController(UserManageService service, UserManageViewer viewer) {
        this.service = service;
        this.viewer = viewer;
    }

    public String handleRequestForReadAll(UserRequest req) {
        Map<String, String> args = req.args();

        int pageNum = Integer.parseInt(args.get("pageNum"));
        int pageSize = Integer.parseInt(args.get("pageSize"));

        List<UserInfo> allInfos = this.service.findByAll(pageNum, pageSize);

        return this.viewer.viewForReadAllUserInfo(pageNum, pageSize, allInfos);
    }

    public String handleRequestForReadUserInfo(UserRequest req) {
        Map<String, String> args = req.args();

        String firstName = args.get("firstName");
        String lastName = args.get("lastName");
        //int actorId = Integer.parseInt(args.get("actorId"));


        List<OneUserInfo> oneInfo = this.service.findByOne(firstName, lastName);
        return this.viewer.viewForReadUserInfo(firstName, lastName, oneInfo);
    }

    public String handleRequestForAddUserInfo(UserRequest req) {
        Map<String, String> args = req.args();

        String firstName = args.get("firstName");
        String lastName = args.get("lastName");

        OneUserInfo addUserInfo = this.service.addUser(firstName, lastName);
        return this.viewer.viewForAddUserInfo(addUserInfo);
    }

}

//mvc중 컨트롤러