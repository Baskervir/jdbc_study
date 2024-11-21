package org.newsystem.parser;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @implSpec 
 *  => add /actors?firstName=cho&lastName=hyunil
 * **/

@Service
public class InputParser {
    public UserRequest parse(String rawString) {
        
        String method = getMethodFromRawString(rawString);
        String path = getPathFromRawString(rawString);
        Map<String, String> argsAsMap = getArgsFromRawString(rawString);

        return new UserRequest(method, path, argsAsMap);
    }

    private Map<String, String> getArgsFromRawString(String rawString) {
        int QuestionMarkIndex = rawString.indexOf("?");
        String args = rawString.substring(QuestionMarkIndex + 1);
        System.out.println("args = " + args);
        String[] splitedArgs = args.split("&");

        Map<String, String> argsAsMap = new HashMap<>();

        for (int i = 0; i < splitedArgs.length; i++) {
            String[] keyValuePair = splitedArgs[i].split("=");
            String key = keyValuePair[0];
            String value = keyValuePair[1];

            argsAsMap.put(key, value);
        }
        return argsAsMap;
    }

    private String getPathFromRawString(String rawString) {
        int firstSlashIndex = rawString.indexOf("/");
        int firstQuestionMarkIndex = rawString.indexOf("?");

        String path = rawString.substring(firstSlashIndex + 1, firstQuestionMarkIndex);
        System.out.println("path = " + path);
        return path;
    }

    private String getMethodFromRawString(String rawString) {
        int fitstEmptySpaceIndex = rawString.indexOf(" ");
        String method = rawString.substring(0, fitstEmptySpaceIndex);
        System.out.println("method = " + method);
        return method;
    }

}
