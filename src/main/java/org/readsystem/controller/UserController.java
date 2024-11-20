package org.readsystem.controller;

import org.readsystem.parser.UserRequest;
import org.readsystem.service.UserInfo;
import org.readsystem.service.UserManageService;
import org.readsystem.viewer.UserManageViewer;

import java.util.List;
import java.util.Map;

public class UserController {
    private final UserManageService service;
    private final UserManageViewer viewer;

    public UserController(UserManageService service, UserManageViewer viewer) {
        this.service = service;
        this.viewer = viewer;
    }

    public String handleRequestForRead(UserRequest req) {
        Map<String, String> args = req.args();

        int actorId = Integer.parseInt(args.get("actorId"));

        List<UserInfo> allInfos = this.service.findBySelected(actorId);

        return this.viewer.viewForReadAllUserInfo(actorId, allInfos);
    }

    public String handleRequestForReadUserInfo(UserRequest request) {
        return "";
    }
}
