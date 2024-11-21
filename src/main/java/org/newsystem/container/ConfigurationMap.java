package org.newsystem.container;

import org.newsystem.controller.ControllerProxy;
import org.newsystem.controller.UserController;
import org.newsystem.dao.JDBCUserManagerDao;
import org.newsystem.dao.UserManageDao;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationMap {

    public Map<String, IocBean> createContainer() {

        Map<String, IocBean> container = new HashMap<>();

        UserManageDao dao = new JDBCUserManagerDao();

        UserManageViewer viewer = new UserManageViewer();
        UserManageService service = new UserManageService(dao);

        UserController controller = new UserController(service, viewer);
        ControllerProxy proxy = new ControllerProxy(controller);

        container.put("controllerProxy", new IocBean(proxy));

        return container;
    }
}
