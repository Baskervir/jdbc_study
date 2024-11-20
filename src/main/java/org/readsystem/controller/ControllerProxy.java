package org.readsystem.controller;

import org.readsystem.parser.UserRequest;

public class ControllerProxy {
    private final UserController target;

    public ControllerProxy(UserController target) {
        this.target = target;
    }

    public String handle(UserRequest request) {
        if (request.path().equals("actors")) {
            return this.target.handleRequestForRead(request);
        } else if (request.path().equals("actor")) {
            return this.target.handleRequestForReadUserInfo(request);
        }
        throw new RuntimeException("unsupported path");
    }
}
