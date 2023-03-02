package org.example.system.controller;

import java.util.HashMap;
import java.util.Map;

public class SystemController {
    public static Map<String, String> commandParser(String command) {
        Map<String, String> commandMap = new HashMap<>();
        String[] str = command.split("\\?", 2);
        commandMap.put("command", str[0]);
        if(str.length == 1) return commandMap;
        int paramCount = (int)str[1].chars().filter(e -> e == '&').count();
        while(paramCount >= 0) {
            if(--paramCount > -1) str = str[1].split("&", 2);
            else str[0] = str[1];
            String[] temp = str[0].split("=", 2);
            commandMap.put(temp[0], temp[1]);
        }
        return commandMap;
    }
}
