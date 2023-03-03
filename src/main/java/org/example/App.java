package org.example;

import org.example.build.controller.BuildController;
import org.example.quotation.controller.QuotationController;
import org.example.util.Parser;
import java.util.Map;

public class App {
    private final QuotationController quotationController = new QuotationController();
    private final BuildController buildController = new BuildController();
    public void run() {
        buildController.road();
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Map<String, String> commands = Parser.commandParser(command);
            if(commands.get("command").equals("종료")) {
                buildController.save();
                break;
            } else if(commands.get("command").equals("등록")) {
                quotationController.create();
            } else if(commands.get("command").equals("목록")) {
                quotationController.listUp();
            } else if(commands.get("command").startsWith("삭제")) {
                quotationController.delete(Integer.parseInt(commands.get("id")));
            } else if(commands.get("command").startsWith("수정")) {
                quotationController.modify(Integer.parseInt(commands.get("id")));
            } else if(commands.get("command").equals("빌드")) {
                buildController.build();
            }
        }
    }
}
