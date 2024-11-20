package org.readsystem.channel;

public class ConsoleInputChannel implements InputChannel {
    @Override
    public String listen() {
        return "read /actors?actorId=3";
    }
}
