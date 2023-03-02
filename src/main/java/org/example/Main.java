package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static List<Quotation> quotationList = new ArrayList<>();
    private static int index = 0;
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
                    System.out.println(index + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    listUp();
                    break;
                default:
                    System.out.println("해결할 수 없는 명령입니다!");
            }
        }
    }

    public static void create() {
        index++;
        String context, author;
        System.out.printf("명언 : ");
        context = sc.nextLine();
        System.out.printf("작가 : ");
        author = sc.nextLine();

        quotationList.add(new Quotation(context, author, index));
    }

    public static void listUp() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = quotationList.size() - 1; i>=0 ; i--) {
            System.out.printf("%d / %s / %s\n",
                    quotationList.get(i).getNumber(),
                    quotationList.get(i).getAuthor(),
                    quotationList.get(i).getContext()
            );
        }
    }
}