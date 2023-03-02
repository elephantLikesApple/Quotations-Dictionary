package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        String command;
        while(true) {
            System.out.printf("명령) ");
            command = sc.nextLine();
            if(command.equals("종료")) break;
            switch(command) {
                case "등록":
                    create();
                    System.out.println("1번 명언이 등록되었습니다.");
                    break;
                default:
                    System.out.println("해결할 수 없는 명령입니다!");
            }
        }
    }

    public static void create() {
        System.out.printf("명언 : ");
        sc.nextLine();
        System.out.printf("작가 : ");
        sc.nextLine();
    }
}