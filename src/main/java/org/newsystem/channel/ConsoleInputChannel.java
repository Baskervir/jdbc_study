package org.newsystem.channel;

public class ConsoleInputChannel implements InputChannel {
    @Override
    public String listen() {
        return "readAll /actors?pageNum=1&pageSize=10";
    }
}
