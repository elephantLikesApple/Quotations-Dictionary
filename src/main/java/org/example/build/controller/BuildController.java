package org.example.build.controller;

import org.example.Container;
import org.example.quotation.entity.Quotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BuildController {
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
