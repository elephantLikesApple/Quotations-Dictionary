package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static List<Quotation> quotationList = new ArrayList<>();
    private static int index = 0;
    public static void main(String[] args) {
        int id = 0;
        System.out.println("== 명언 앱 ==");
        String command;
        while(true) {
            System.out.printf("명령) ");
            command = sc.nextLine().trim();
            if(command.equals("종료")) break;
            if(command.length()>2) {
                String[] commands = commandParsing(command);
                command = commands[0];
                id = Integer.parseInt(commands[1]);
            }
            switch(command) {
                case "등록":
                    create();
                    System.out.println(index + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    listUp();
                    break;
                case "삭제":
                    if(!delete(id)){
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break;
                    }
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    break;
                case "수정":
                    if(!modify(id)){
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break;
                    }
                    System.out.println(id + "번 명언이 수정되었습니다.");
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

    public static boolean delete(int id) {
        Quotation target = null;
        for(Quotation quotation : quotationList) {
            if(quotation.getNumber() == id) target = quotation;
        }
        if(target == null) {return false;}

        return quotationList.remove(target);
    }


    private static boolean modify(int id) {
        Quotation target = null;
        for(Quotation quotation : quotationList) {
            if(quotation.getNumber() == id) target = quotation;
        }
        if(target == null) {return false;}
        try {
            System.out.println("명언(기존) : " + target.getContext());
            System.out.printf("명언 : ");
            target.setContext(sc.nextLine());
            System.out.println("작가(기존) : " + target.getAuthor());
            System.out.printf("작가 : ");
            target.setAuthor(sc.nextLine());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String[] commandParsing(String command) {
        return new String[] {command.substring(0,2), command.substring(6, command.length())};
    }
}