package org.example.build.service;

import org.example.Container;
import org.example.quotation.entity.Quotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BuildService {
    public String save() {
        try {
            Container.getMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(Container.getSavedPath()), Container.getQuotationList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Container.getSavedPath();
    }

    public void road() {
        try {
            Quotation[] q = Container.getMapper().readValue(new File(Container.getSavedPath()), Quotation[].class);
            Container.getQuotationList().addAll(Arrays.asList(q));
            Comparator<Quotation> comparatorById = Comparator.comparingInt(Quotation::getId);
            Quotation maxIdValue = Container.getQuotationList().stream()
                    .max(comparatorById)
                    .orElse(new Quotation("","",0));
            Container.setIndex(maxIdValue.getId());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
