package org.newsystem.channel;

public class InputChannelFactory {
    public static InputChannel create() {
        return new ConsoleInputChannel();
    }
}
