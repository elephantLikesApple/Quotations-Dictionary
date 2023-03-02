package org.example;

import org.example.quotation.entity.Quotation;
import org.example.quotation.controller.QuotationController;
import org.example.system.controller.SystemController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class App {
    public static void run() {
        int id = 0; String command;
        road();
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.printf("명령) ");
            command = Container.getScanner().nextLine().trim();
            if(command.equals("종료")) { save(); break; }

            if(command.length()>2) {
                String[] commands = SystemController.commandParsing(command);
                command = commands[0];
                id = Integer.parseInt(commands[1]);
            }
            switch(command) {
                case "등록":
                    QuotationController.create();
                    System.out.println(Container.getIndex() + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    QuotationController.listUp();
                    break;
                case "삭제":
                    if(!QuotationController.delete(id)){
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break;
                    }
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    break;
                case "수정":
                    if(!QuotationController.modify(id)){
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        break;
                    }
                    System.out.println(id + "번 명언이 수정되었습니다.");
                    break;
                case "빌드":
                    save();
                    System.out.println(Container.getSavedPath() + " 파일의 내용이 갱신되었습니다.");
                    break;
                default:
                    System.out.println("해결할 수 없는 명령입니다!");
            }
        }
    }

    public static void save() {
        try {
            Container.getMapper().writerWithDefaultPrettyPrinter().writeValue(new File(Container.getSavedPath()), Container.getQuotationList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void road() {
        try {
            Quotation[] q = Container.getMapper().readValue(new File(Container.getSavedPath()), Quotation[].class);
            Container.getQuotationList().addAll(Arrays.asList(q));
            Container.setIndex(Container.getQuotationList().size()); // index는 리스트 크기가 아니라, 마지막 리스트에 있는 number 받아와야함
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
