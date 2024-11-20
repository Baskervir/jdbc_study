package org.newsystem.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidateInputKeys {
    private static final Map<String, String> EXPECTED_KEYS = new HashMap<>();
    static {
        EXPECTED_KEYS.put("pageNum", "pageNum");
        EXPECTED_KEYS.put("pageSize", "pageSize");
    }

    public Set<String> validateInputKeys(Map<String, String> args) {
        Set<String> validKeys = new HashSet<>();

        for (String key : args.keySet()) {
            if (!EXPECTED_KEYS.containsKey(key)) {
                System.out.println(key + "부분 오타 발생");
            } else {
                validKeys.add(key);
            }
        }
        return validKeys;
    }
}
