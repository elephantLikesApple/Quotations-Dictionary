package org.example.quotation.controller;

import org.example.Container;
import org.example.quotation.entity.Quotation;

public class QuotationController {
    public static void create() {
        Container.setIndex(Container.getIndex()+1);
        String context, author;
        System.out.printf("명언 : ");
        context = Container.getScanner().nextLine();
        System.out.printf("작가 : ");
        author = Container.getScanner().nextLine();

        Container.getQuotationList().add(new Quotation(context, author, Container.getIndex()));
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

    public static boolean delete(int id) {
        Quotation target = null;
        for(Quotation quotation : Container.getQuotationList()) {
            if(quotation.getId() == id) target = quotation;
        }
        if(target == null) {return false;}

        return Container.getQuotationList().remove(target);
    }


    public static boolean modify(int id) {
        Quotation target = null;
        for(Quotation quotation : Container.getQuotationList()) {
            if(quotation.getId() == id) target = quotation;
        }
        if(target == null) {return false;}
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
