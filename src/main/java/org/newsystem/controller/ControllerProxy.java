package org.newsystem.controller;

import org.newsystem.dao.JDBCUserManagerDao;
import org.newsystem.dao.UserManageDao;
import org.newsystem.parser.UserRequest;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ControllerProxy {

    private final UserController target;

    @Autowired //spring에게 이 생성자를 이용해서 만들어줘 라고 지정하는것.
    public ControllerProxy(UserController target) {
        this.target = target;
    }

    public static ControllerProxy create() {
        UserManageDao dao = new JDBCUserManagerDao();

        UserManageViewer viewer = new UserManageViewer();
        UserManageService service = new UserManageService(dao);

        UserController controller = new UserController(service, viewer);
        return new ControllerProxy(controller);
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