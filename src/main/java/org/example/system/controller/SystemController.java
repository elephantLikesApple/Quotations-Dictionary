package org.example.system.controller;

public class SystemController {
    public static String[] commandParsing(String command) {
        return new String[] {command.substring(0,2), command.substring(6)};
    }
}
