package org.readsystem;


import org.readsystem.channel.ConsoleInputChannel;
import org.readsystem.channel.InputChannel;
import org.readsystem.controller.ControllerProxy;
import org.readsystem.controller.UserController;
import org.readsystem.dao.JDBCUserManagerDao;
import org.readsystem.dao.UserManageDao;
import org.readsystem.parser.InputParser;
import org.readsystem.parser.UserRequest;
import org.readsystem.service.UserManageService;
import org.readsystem.viewer.UserManageViewer;

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
        UserRequest parseResult = parser.parse(userInput);
        String view = proxy.handle(parseResult);

        System.out.println(view);
    }
}
