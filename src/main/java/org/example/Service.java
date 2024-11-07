package org.example;

public class Service {
    Handler handler;
    public void testWithUncheckedException() {
        this.handler.throwUncheckedException();
    }

    public void testWithCheckedCheckedException() {
        try {
            this.testWithCheckedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testWithCheckedException() throws Exception {
        this.handler.throwCheckedException();
    }
}
