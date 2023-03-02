package org.example.quotation.entity;

public class Quotation {
    private int id;
    private String context;
    private String author;

    public Quotation() {
    }

    public Quotation(String context, String author, int number) {
        this.context = context;
        this.author = author;
        this.id = number;
    }

    public String getContext() {
        return context;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
