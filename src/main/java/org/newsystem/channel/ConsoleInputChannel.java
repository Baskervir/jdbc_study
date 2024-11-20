package org.newsystem.channel;

public class ConsoleInputChannel implements InputChannel {
    @Override
    public String listen() {
        return "readAll /actors?pageNum=1&pageSize=10";
    }

//    @Override
//    public String listen2() {
//        return "read /actors?actorId=2";
//    }
}
