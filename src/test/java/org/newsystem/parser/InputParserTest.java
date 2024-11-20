package org.newsystem.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class InputParserTest {
    @Test
    @DisplayName("add /actors?firstName=cho&lastName=hyunil")
    public void t1() {
        String rawString = "add /actors?firstName=cho&lastName=hyunil";
        InputParser parser = new InputParser();
        UserRequest request = parser.parse(rawString);

        Assertions.assertEquals("add", request.method());
        Assertions.assertEquals("actors", request.path());
        Map<String, String> args = request.args();

        Assertions.assertEquals("cho", args.get("firstName"));
        Assertions.assertEquals("hyunil", args.get("lastName"));
    }

    @Test
    @DisplayName("read /actors?firstName=hwang&lastname=jungmin")
    public void t2() {
        String rawString  = "read /actors?firstName=hwang&lastName=jungmin";
        InputParser parser = new InputParser();
        UserRequest request = parser.parse(rawString);

        Assertions.assertEquals("read", request.method());
        Assertions.assertEquals("actors", request.path());
        Map<String, String> args = request.args();

        Assertions.assertEquals("hwang", args.get("firstName"));
        Assertions.assertEquals("jungmin", args.get("lastName"));
    }
}

// 리팩터링, 가독성으로 위한(기능은 그대로)