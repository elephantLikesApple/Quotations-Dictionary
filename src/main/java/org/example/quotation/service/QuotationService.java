package org.example.quotation.service;

import org.example.Container;
import org.example.quotation.entity.Quotation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuotationService {
    public int create(String context, String author) {
        Container.setIndex(Container.getIndex()+1);

        Container.getQuotationList().add(new Quotation(context, author, Container.getIndex()));
        return Container.getIndex();
    }

    public List<Quotation> findAllDesc() {
        return Container.getQuotationList().stream()
                .sorted(Comparator.comparing(Quotation::getId).reversed())
                .collect(Collectors.toList());
    }

    public Quotation findTarget(int id) {
        return Container.getQuotationList().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteComplete(int id) {
        Quotation target = findTarget(id);
        if(target == null) return false;
        return Container.getQuotationList().remove(target);
    }

    public void modifyComplete(Quotation target, String context, String author) {
        target.setContext(context);
        target.setAuthor(author);
    }

}
