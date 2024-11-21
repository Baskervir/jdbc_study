package org.newsystem;

import org.newsystem.channel.ConsoleInputChannel;
import org.newsystem.channel.InputChannel;
import org.newsystem.channel.InputChannelFactory;
import org.newsystem.container.ConfigurationMap;
import org.newsystem.container.IocContainer;
import org.newsystem.container.SimpleIocContainer;
import org.newsystem.controller.ControllerProxy;
import org.newsystem.parser.InputParser;
import org.newsystem.parser.UserRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//조립단계

        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        InputChannel inputChannel = ctx.getBean(InputChannel.class);
        InputParser parser = ctx.getBean(InputParser.class);
        ControllerProxy proxy = ctx.getBean(ControllerProxy.class);

        String userResquestString = inputChannel.listen();
        UserRequest request = parser.parse(userResquestString);

        String view = proxy.handle(request);
        System.out.println(view);

//        String listen = inputChannel.listen();
//        System.out.println(listen);

//        ControllerProxy bean = ctx.getBean(ControllerProxy.class);
//
//        System.out.println(bean);
    }

    private static InputParser getInputParser() {
        return new InputParser();
    }
}
