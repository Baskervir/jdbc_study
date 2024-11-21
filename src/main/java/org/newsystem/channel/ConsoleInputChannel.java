package org.newsystem.channel;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInputChannel implements InputChannel {
    @Override
    public String listen() {
        return "readAll /actors?pageNum=1&pageSize=10";
    }
}
