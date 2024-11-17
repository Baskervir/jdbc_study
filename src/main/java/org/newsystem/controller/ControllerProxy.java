package org.newsystem.controller;

import org.newsystem.parser.UserRequest;

public class ControllerProxy {

    private final UserController target;

    public ControllerProxy(UserController target) {
        this.target = target;
    }

    /**
     * @return view를 사용자에게 반환한다,
     * **/
    public String handle(UserRequest request) {
        if (request.path().equals("actors")) {
            return this.target.handleRequestForReadAll(request);
        } else if (request.path().equals("actor")) {
            return this.target.handleRequestForReadUserInfo(request);
        }
        throw new RuntimeException("unsupported path");
    }
}
// request 들어오면 알맞는 기능을 수행해주는 역할