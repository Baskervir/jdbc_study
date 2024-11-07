package org.example;

public interface Handler {
    void throwUncheckedException() throws RuntimeException;
    void throwCheckedException() throws Exception;
}
