package org.example.quotation.controller;

import org.example.Container;
import org.example.quotation.entity.Quotation;

public class QuotationController {
    public static void create() {
        Container.setIndex(Container.getIndex()+1);
        String context, author;
        System.out.print("명언 : ");
        context = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        author = Container.getScanner().nextLine();

        Container.getQuotationList().add(new Quotation(context, author, Container.getIndex()));
        System.out.println(Container.getIndex() + "번 명언이 등록되었습니다.");
    }

    public static void listUp() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = Container.getQuotationList().size() - 1; i>=0 ; i--) {
            System.out.printf("%d / %s / %s\n",
                    Container.getQuotationList().get(i).getId(),
                    Container.getQuotationList().get(i).getAuthor(),
                    Container.getQuotationList().get(i).getContext()
            );
        }
    }

    public static Quotation findTarget(int id) {
        return Container.getQuotationList().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public static void delete(int id) {
        if(deleteComplete(id)) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
        else System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public static boolean deleteComplete(int id) {
        Quotation target = findTarget(id);
        if(target == null) return false;
        return Container.getQuotationList().remove(target);
    }

    public static void modify(int id) {
        if(modifyComplete(id)) {
            System.out.println(id + "번 명언이 수정되었습니다.");
        }
        else System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public static boolean modifyComplete(int id) {
        Quotation target = findTarget(id);
        if(target == null) {
            return false;
        }
        return modifyInput(target);
    }

    public static boolean modifyInput(Quotation target) {
        try {
            System.out.println("명언(기존) : " + target.getContext());
            System.out.print("명언 : ");
            target.setContext(Container.getScanner().nextLine());
            System.out.println("작가(기존) : " + target.getAuthor());
            System.out.print("작가 : ");
            target.setAuthor(Container.getScanner().nextLine());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
