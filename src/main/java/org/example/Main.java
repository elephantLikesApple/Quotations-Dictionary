package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        String command;
        while(true) {
            System.out.printf("명령) ");
            command = sc.nextLine();
            if(command.equals("종료")) break;
        }
    }
}