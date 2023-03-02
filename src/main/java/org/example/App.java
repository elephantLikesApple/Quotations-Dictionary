package org.example;

import org.example.quotation.entity.Quotation;
import org.example.quotation.controller.QuotationController;
import org.example.system.controller.SystemController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;


public class App {
    public static void run() {
        road();
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Map<String, String> commands = SystemController.commandParser(command);
            if(commands.get("command").equals("종료")) {
                save();
                break;
            } else if(commands.get("command").equals("등록")) {
                QuotationController.create();
            } else if(commands.get("command").equals("목록")) {
                QuotationController.listUp();
            } else if(commands.get("command").startsWith("삭제")) {
                QuotationController.delete(Integer.parseInt(commands.get("id")));
            } else if(commands.get("command").startsWith("수정")) {
                QuotationController.modify(Integer.parseInt(commands.get("id")));
            } else if(commands.get("command").equals("빌드")) {
                build();
            }
        }
    }

    public static void build(){
        save();
        System.out.println(Container.getSavedPath() + " 파일의 내용이 갱신되었습니다.");
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
            Comparator<Quotation> comparatorById = Comparator.comparingInt(Quotation::getId);
            Quotation maxIdValue = Container.getQuotationList().stream().max(comparatorById).orElse(new Quotation("","",0));
            Container.setIndex(maxIdValue.getId());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
