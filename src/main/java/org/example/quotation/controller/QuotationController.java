package org.example.quotation.controller;

import org.example.Container;
import org.example.quotation.entity.Quotation;
import org.example.quotation.service.QuotationService;

public class QuotationController {
    private final QuotationService quotationService = new QuotationService();

    public void create() {
        String context, author;
        System.out.print("명언 : ");
        context = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        author = Container.getScanner().nextLine();

        int index = quotationService.create(context, author);
        System.out.println(index + "번 명언이 등록되었습니다.");
    }

    public void listUp() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(Quotation quotation : quotationService.findAllDesc()) {
            System.out.printf("%d / %s / %s\n",
                    quotation.getId(),
                    quotation.getAuthor(),
                    quotation.getContext()
            );
        }
    }

    public void delete(int id) {
        if(quotationService.deleteComplete(id)) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
        else System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public void modify(int id) {
        Quotation target = quotationService.findTarget(id);
        if (target == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        String context, author;

        System.out.println("명언(기존) : " + target.getContext());
        System.out.print("명언 : ");
        context = Container.getScanner().nextLine();
        System.out.println("작가(기존) : " + target.getAuthor());
        System.out.print("작가 : ");
        author = Container.getScanner().nextLine();


        quotationService.modifyComplete(target, context, author);
        System.out.println(id + "번 명언이 수정되었습니다.");
    }


}
