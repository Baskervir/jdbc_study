package org.newsystem;

import org.newsystem.channel.ConsoleInputChannel;
import org.newsystem.channel.InputChannel;
import org.newsystem.controller.ControllerProxy;
import org.newsystem.controller.UserController;
import org.newsystem.dao.JDBCUserManagerDao;
import org.newsystem.dao.UserManageDao;
import org.newsystem.parser.InputParser;
import org.newsystem.parser.UserRequest;
import org.newsystem.service.UserManageService;
import org.newsystem.viewer.UserManageViewer;

public class Main {
    public static void main(String[] args) {
//조립단계
        InputChannel channel = new ConsoleInputChannel();
        InputParser parser = new InputParser();

        UserManageDao dao = new JDBCUserManagerDao();

        UserManageViewer viewer = new UserManageViewer();
        UserManageService service = new UserManageService(dao);

        UserController controller = new UserController(service, viewer);
        ControllerProxy proxy = new ControllerProxy(controller);

        String userInput = channel.listen();
        UserRequest parseReault = parser.parse(userInput);
        String view = proxy.handle(parseReault);


        System.out.println(view);
    }
}
