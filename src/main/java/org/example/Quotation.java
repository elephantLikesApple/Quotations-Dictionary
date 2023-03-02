package org.example;

public class Quotation {
    private int number;
    private String context;
    private String author;

    public Quotation() {
    }

    public Quotation(String context, String author, int number) {
        this.context = context;
        this.author = author;
        this.number = number;
    }

    public String getContext() {
        return context;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumber() {
        return number;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
