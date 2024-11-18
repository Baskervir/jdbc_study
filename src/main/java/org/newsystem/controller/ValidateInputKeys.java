package org.newsystem.controller;

import java.util.HashMap;
import java.util.Map;

public class ValidateInputKeys {
    private static final Map<String, String> EXPECTED_KEYS = new HashMap<>();
    static {
        EXPECTED_KEYS.put("pageNum", "pageNum");
        EXPECTED_KEYS.put("pageSize", "pageSize");
    }

    public void validateInputKeys(Map<String, String> args) {
        for (String key : args.keySet()) {
            if (!EXPECTED_KEYS.containsKey(key)) {
                String errorMessage = "Invalid input key : " + key;
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
