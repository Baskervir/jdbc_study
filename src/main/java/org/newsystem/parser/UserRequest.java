package org.newsystem.parser;

import java.util.Collections;
import java.util.Map;

public class UserRequest {

    private final String method;
    private final String path;
    private final Map<String, String> args;

    public UserRequest(String method, String path, Map<String, String> args) {
        this.method = method;
        this.path = path;
        this.args = args;
    }

    public String method() {
        return this.method;
    }

    public String path() {
        return this.path;
    }

    public Map<String, String> args() {
        return Collections.unmodifiableMap(this.args);
    }

}