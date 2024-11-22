package org.newsystem.channel;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInputChannel implements InputChannel {
    @Override
    public String listen() {
        return "read /actor?firstName=NICK&lastName=WAHLBERG";
    }

//    @Override
//    public String listen2() {
//        return "read /actor?firstName=NICK&lastName=WAHLBERG";
//    }"readAll /actors?pageNum=1&pageSize=10"
}
