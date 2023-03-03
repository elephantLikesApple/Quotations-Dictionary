package org.example;

import org.example.build.controller.BuildController;
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
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Map<String, String> commands = SystemController.commandParser(command);
            if(commands.get("command").equals("종료")) {
                BuildController.save();
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
                BuildController.build();
            }
        }
    }
}
